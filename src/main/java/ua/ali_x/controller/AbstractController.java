package ua.ali_x.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractController {

    public abstract void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
