package ru.kpfu.itis.solopov.net.servlet;

import ru.kpfu.itis.solopov.net.util.CloudinaryUploaderUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "userInfoServlet", urlPatterns = "/userinfo")
@MultipartConfig(
        maxFileSize = 5 * 1024 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024 * 1024
)
public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            req.getRequestDispatcher("userinfo.ftl").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String birthDate = req.getParameter("birth_date");
        String genre = req.getParameter("genre");



        HttpSession httpSession = req.getSession();

        httpSession.setAttribute("username", username);
        httpSession.setAttribute("email", email);
        httpSession.setAttribute("gender", gender);
        httpSession.setAttribute("birth_date", birthDate);
        httpSession.setAttribute("genre", genre);
        httpSession.setAttribute("image", CloudinaryUploaderUtil.uploadFile(req));

        req.getRequestDispatcher("authenticationinfo.ftl").forward(req, resp);
    }
}
