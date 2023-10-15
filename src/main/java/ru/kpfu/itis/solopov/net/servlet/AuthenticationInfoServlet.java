package ru.kpfu.itis.solopov.net.servlet;

import ru.kpfu.itis.solopov.net.dto.UserDto;
import ru.kpfu.itis.solopov.net.model.User;
import ru.kpfu.itis.solopov.net.service.Impl.UserServiceImpl;
import ru.kpfu.itis.solopov.net.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "authInfoServlet", urlPatterns = "/authinfo")
public class AuthenticationInfoServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("signup/authenticationinfo.ftl").forward(req, resp);
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
        LocalDate birthDate = LocalDate.parse((CharSequence)httpSession.getAttribute("birth_date"));


        UserDto userDto = new UserDto(username, email, gender, login, password, birthDate, genre);

        httpSession.setAttribute("user", userDto);
        httpSession.setAttribute("dateOfBirth", birthDate.toString());
        httpSession.setAttribute("userAuthorized", true);

        userService.save(new User(username, email, gender, login, password, birthDate, genre));

        resp.sendRedirect("/profile");
    }
}
