package ru.kpfu.itis.solopov.net.servlet;

import ru.kpfu.itis.solopov.net.dto.UserDto;
import ru.kpfu.itis.solopov.net.service.Impl.UserServiceImpl;
import ru.kpfu.itis.solopov.net.service.UserPublicationService;
import ru.kpfu.itis.solopov.net.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/ajax/checklogin")
public class AjaxCheckLoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute("userPublicationService");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String possibleLogin = req.getParameter("login");
        List<UserDto> users =  userService.getAll();
        resp.setContentType("plain/text");
        for (UserDto u : users) {
            if (u.getLogin().equals(possibleLogin)) {
                resp.getWriter().write("taken");
            }
        }

    }
}
