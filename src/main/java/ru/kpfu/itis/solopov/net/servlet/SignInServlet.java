package ru.kpfu.itis.solopov.net.servlet;

import ru.kpfu.itis.solopov.net.dto.UserDto;
import ru.kpfu.itis.solopov.net.service.Impl.UserServiceImpl;
import ru.kpfu.itis.solopov.net.service.UserService;
import ru.kpfu.itis.solopov.net.util.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "signInServlet", urlPatterns = "/signin")
public class SignInServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("signin.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession httpSession = req.getSession();
        UserDto userDto = authenticate(login, password);
        if (userDto != null) {
            httpSession.setAttribute("user", userDto);
            resp.sendRedirect("/profile");
        }
    }

    private UserDto authenticate(String login, String password) {
        UserDto userDto = userService.get(login);
        String encrPassword = PasswordUtil.encrypt(password);
        if(userDto.getPassword().equals(encrPassword)) {
            return userDto;
        }
        return null;
    }
}

