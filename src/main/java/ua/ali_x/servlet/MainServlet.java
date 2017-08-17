package ua.ali_x.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ua.ali_x.controller.Controller;
import ua.ali_x.factory.Factory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class MainServlet extends HttpServlet {
    private Map<Request, Controller> controllerMap;

    public void init() {
        controllerMap = Factory.getControllerMap();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
        Request request;
        if (!ServletFileUpload.isMultipartContent(httpRequest)) {
            request = new Request(httpRequest.getMethod(), httpRequest.getRequestURI(), httpRequest.getParameterMap());
        } else {
            final long serialVersionUID = 1L;
            final String UPLOAD_DIRECTORY = "upload";
            final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
            final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
            final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
            request = new Request(httpRequest.getMethod(), httpRequest.getRequestURI());
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(MEMORY_THRESHOLD);
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(MAX_FILE_SIZE);
            upload.setSizeMax(MAX_REQUEST_SIZE);
            Path currentRelativePath = Paths.get("images");
            String uploadPath = currentRelativePath.toAbsolutePath().toString();

            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            try {
                String userName = "unnamed user";
                List<FileItem> formItems = upload.parseRequest(httpRequest);
                if (formItems != null && formItems.size() > 0) {
                    for (FileItem item : formItems) {
                        if (!item.isFormField()) {
                            String fileName = userName + ".png";
                            String filePath = uploadPath + File.separator + fileName;
                            File storeFile = new File(filePath);
                            item.write(storeFile);
                        } else {
                            String fieldName = item.getFieldName();
                            String value = item.getString();
                            if (fieldName.equals("userName")) {
                                userName = value;
                            }
                            request.setAttribute(fieldName, value.split(" "));
                        }
                    }
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            }
        }
        try {
            Controller controller = controllerMap.get(request);
            if (controller == null) {
                throw new RuntimeException("Can't handle " + request.getUri());
            }
            ViewModel vm = controller.process(request);
            Cookie cookie = vm.getCookie();
            if (cookie != null) {
                httpResponse.addCookie(cookie);
            }
            setAttributes(httpRequest, vm);
            forward(httpRequest, httpResponse, vm);
        } catch (Throwable e) {
            throw new RuntimeException("The error is " + e);
        }
    }

    private void forward(HttpServletRequest request, HttpServletResponse response, ViewModel vm) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(getView(vm));
        requestDispatcher.forward(request, response);
    }

    private String getView(ViewModel vm) {
        String prefix = "/WEB-INF/views/";
        String suffix = ".jsp";
        return prefix + vm.getView() + suffix;

    }

    private void setAttributes(HttpServletRequest request, ViewModel vm) {
        Map<String, Object> model = vm.getAttributes();
        for (Map.Entry<String, Object> entry : model.entrySet()) {
            request.setAttribute(entry.getKey(), entry.getValue());
        }
    }
}