package ru.kpfu.itis.solopov.net.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/ajax/setbirthdate")
public class AjaxSetBirthDateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);

        String birthDate = req.getParameter("birth_date");
        if (birthDate != null) {
            httpSession.setAttribute("dateOfBirth", birthDate);
        }
    }
}
