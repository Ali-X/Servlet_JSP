package ua.ali_x.servlet;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String username = request.getParameter("name");
        Path currentRelativePath = Paths.get("images");
        String uploadPath = currentRelativePath.toAbsolutePath().toString();
        String fileName = username + ".png";
        String filePath = uploadPath + File.separator + fileName;

        response.setContentType("image/png");
        ServletOutputStream out;
        out = response.getOutputStream();
        FileInputStream fin = new FileInputStream(filePath);

        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(out);
        int ch = 0;

        while ((ch = bin.read()) != -1) {
            bout.write(ch);
        }

        bin.close();
        fin.close();
        bout.close();
        out.close();
    }

}
