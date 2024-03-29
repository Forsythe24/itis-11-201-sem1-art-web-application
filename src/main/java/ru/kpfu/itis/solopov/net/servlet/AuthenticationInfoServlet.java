package ru.kpfu.itis.solopov.net.servlet;

import ru.kpfu.itis.solopov.net.dto.UserDto;
import ru.kpfu.itis.solopov.net.model.User;
import ru.kpfu.itis.solopov.net.service.CommentService;
import ru.kpfu.itis.solopov.net.service.Impl.UserServiceImpl;
import ru.kpfu.itis.solopov.net.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "authInfoServlet", urlPatterns = "/authinfo")
public class AuthenticationInfoServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute("userService");
    }    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("authenticationinfo.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        String username = (String) httpSession.getAttribute("username");
        String email = (String) httpSession.getAttribute("email");
        String gender = (String) httpSession.getAttribute("gender");
        String genre = (String) httpSession.getAttribute("genre");
        String image = (String) httpSession.getAttribute("image");
        LocalDate birthDate = LocalDate.parse((CharSequence)httpSession.getAttribute("birth_date"));


        userService.save(new User(username, email, gender, login, password, birthDate, genre, image));

        httpSession.setAttribute("user", userService.get(login));
        httpSession.setAttribute("dateOfBirth", birthDate.toString());

        resp.sendRedirect("/profile");
    }
}
