package ua.ali_x.servlet;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private String uri;
    private String requestMethod;
    private Map<String, String[]> attributes;

    public Request(String requestMethod, String uri, Map<String, String[]> attributes) {
        this.uri = uri;
        this.requestMethod = requestMethod;
        this.attributes = attributes;
    }

    public Request(String requestMethod, String uri) {
        this.uri = uri;
        this.requestMethod = requestMethod;
        this.attributes = new HashMap<>();
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {

        this.uri = uri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        if (uri != null ? !uri.equals(request.uri) : request.uri != null) return false;
        return requestMethod != null ? requestMethod.equals(request.requestMethod) : request.requestMethod == null;
    }

    @Override
    public int hashCode() {
        int result = uri != null ? uri.hashCode() : 0;
        result = 31 * result + (requestMethod != null ? requestMethod.hashCode() : 0);
        return result;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public void setAttribute(String name, String[] value) {
        attributes.put(name, value);
    }

    public String getAttribute(String name) {
        return attributes.get(name)[0];
    }
}
