package ua.ali_x.controller;

import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public interface Controller {

    ViewModel process(Request request);

}
