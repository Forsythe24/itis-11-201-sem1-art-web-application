package ru.kpfu.itis.solopov.net.servlet;

import ru.kpfu.itis.solopov.net.dto.UserDto;
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

@WebServlet(name = "editUserProfileServlet", urlPatterns = "/editprofile")
public class EditUserProfileServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("edituserprofile.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        changeProfileInfo(req);

        req.getRequestDispatcher("userprofile.ftl").forward(req, resp);
    }

    private void changeProfileInfo(HttpServletRequest req) {
        HttpSession httpSession = req.getSession();
        UserDto userDto = (UserDto) httpSession.getAttribute("user");

        userDto.setUsername(req.getParameter("username"));
        userDto.setEmail(req.getParameter("email"));
        userDto.setGender(req.getParameter("gender"));
        userDto.setGenre(req.getParameter("genre"));

        LocalDate birthDate = LocalDate.parse(req.getParameter("birth_date"));
        userDto.setBirthDate(birthDate);

        httpSession.setAttribute("dateOfBirth", userDto.getBirthDate().toString());

        userService.update(userDto);
    }
}
