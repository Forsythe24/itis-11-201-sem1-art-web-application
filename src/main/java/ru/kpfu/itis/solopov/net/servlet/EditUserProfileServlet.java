package ru.kpfu.itis.solopov.net.servlet;

import ru.kpfu.itis.solopov.net.dto.UserDto;
import ru.kpfu.itis.solopov.net.service.Impl.UserServiceImpl;
import ru.kpfu.itis.solopov.net.service.UserService;
import ru.kpfu.itis.solopov.net.util.CloudinaryUploaderUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;



@WebServlet(name = "editUserProfileServlet", urlPatterns = "/editprofile")
@MultipartConfig(
        maxFileSize = 5 * 1024 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024 * 1024
)

public class EditUserProfileServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("edituserprofile.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        updateProfileInfo(req, resp);

        req.getRequestDispatcher("userprofile.ftl").forward(req, resp);
    }

    private void updateProfileInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        UserDto userDto = (UserDto) httpSession.getAttribute("user");

        userDto.setUsername(req.getParameter("username"));
        userDto.setEmail(req.getParameter("email"));
        userDto.setGender(req.getParameter("gender"));
        userDto.setGenre(req.getParameter("genre"));

        LocalDate birthDate = LocalDate.parse(req.getParameter("birth_date"));
        userDto.setBirthDate(birthDate);

        httpSession.setAttribute("dateOfBirth", userDto.getBirthDate().toString());

        String imageURL = CloudinaryUploaderUtil.uploadFile(req);
        setImageCookie(resp, imageURL);
        httpSession.setAttribute("image", imageURL);

        userService.update(userDto);
    }

    private void setImageCookie(HttpServletResponse resp, String imageURL) {
        Cookie cookie = new Cookie("image", imageURL);
        cookie.setMaxAge(60 * 60 * 24 * 365 * 10);
        resp.addCookie(cookie);
    }
}
