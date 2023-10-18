package ru.kpfu.itis.solopov.net.servlet;

import ru.kpfu.itis.solopov.net.dto.UserDto;
import ru.kpfu.itis.solopov.net.model.User;
import ru.kpfu.itis.solopov.net.service.Impl.UserServiceImpl;
import ru.kpfu.itis.solopov.net.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "authInfoServlet", urlPatterns = "/authinfo")
public class AuthenticationInfoServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    @Override
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
        String imageURL = (String) httpSession.getAttribute("image");
        LocalDate birthDate = LocalDate.parse((CharSequence)httpSession.getAttribute("birth_date"));


        UserDto userDto = new UserDto(username, email, gender, login, password, birthDate, genre);

        httpSession.setAttribute("user", userDto);
        httpSession.setAttribute("dateOfBirth", birthDate.toString());
        httpSession.setAttribute("userAuthorized", true);
        httpSession.setAttribute("image", imageURL);

        setImageCookie(resp, imageURL);

        userService.save(new User(username, email, gender, login, password, birthDate, genre));

        resp.sendRedirect("/profile");
    }

    private void setImageCookie(HttpServletResponse resp, String imageURL) {
        Cookie cookie = new Cookie("image", imageURL);
        cookie.setMaxAge(60 * 60 * 24 * 365 * 10);
        resp.addCookie(cookie);
    }
}
