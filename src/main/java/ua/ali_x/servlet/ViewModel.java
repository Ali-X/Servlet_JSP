package ua.ali_x.servlet;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;

public class ViewModel {

    private String view;
    private Map<String, Object> model = new HashMap<>();
    private Cookie cookie;

    public Map<String, Object> getModel() {
        return model;
    }

    public void setAttribute(String attrName, Object value) {
        model.put(attrName, value);
    }

    public Object getAttribute(String attrName) {
        Object value = model.get(attrName);
        return value;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public Cookie getCookie() {
        return cookie;
    }

    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }
}
