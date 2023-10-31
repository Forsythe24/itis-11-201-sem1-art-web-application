package ru.kpfu.itis.solopov.net.servlet;

import ru.kpfu.itis.solopov.net.dto.UserDto;
import ru.kpfu.itis.solopov.net.service.Impl.UserServiceImpl;
import ru.kpfu.itis.solopov.net.service.UserService;
import ru.kpfu.itis.solopov.net.util.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "signInServlet", urlPatterns = "/signin")
public class SignInServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("signin.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String rememberMe = req.getParameter("remember_me");

        UserDto userDto = authenticate(login, password);

        HttpSession httpSession = req.getSession();


        if (userDto != null) {
            httpSession.setAttribute("user", userDto);
            httpSession.setAttribute("dateOfBirth", userDto.getBirthDate().toString());

            if (rememberMe != null) {
                setAutoAuthCookie(resp, login);
            }

            resp.sendRedirect("/profile");
        } else {
            httpSession.setAttribute("failed_authentication_message", "Incorrect login or password");
            req.getRequestDispatcher("signin.ftl").forward(req, resp);
            httpSession.removeAttribute("failed_authentication_message");
        }
    }

    private void setAutoAuthCookie(HttpServletResponse resp, String login) {
        Cookie cookie = new Cookie("login", login);
        cookie.setMaxAge(60 * 60 * 24 * 365 * 10);
        resp.addCookie(cookie);
    }


    private UserDto authenticate(String login, String password) {
        try {
            UserDto userDto = userService.get(login);
            String encrPassword = PasswordUtil.encrypt(password);
            if(userDto.getPassword().equals(encrPassword)) {
                return userDto;
            }
        } catch (RuntimeException e) {
            return null;
        }

        return null;
    }
}

