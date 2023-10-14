package ru.kpfu.itis.solopov.net.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "homePageServlet", urlPatterns = "/homepage")
public class HomePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession httpSession = req.getSession(false);
//        if (httpSession != null) {
//            Boolean isUserAuthorized = (Boolean) httpSession.getAttribute("userAuthorized");
//            if (isUserAuthorized == null) {
//                httpSession.setAttribute("userAuthorized", false);
//            }
//        }
        resp.sendRedirect("homepage.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
