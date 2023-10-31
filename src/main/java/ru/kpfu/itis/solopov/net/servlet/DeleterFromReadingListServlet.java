package ru.kpfu.itis.solopov.net.servlet;

import ru.kpfu.itis.solopov.net.dto.UserDto;
import ru.kpfu.itis.solopov.net.service.Impl.UserPublicationServiceImpl;
import ru.kpfu.itis.solopov.net.service.Impl.UserServiceImpl;
import ru.kpfu.itis.solopov.net.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deletefromreadinglist")
public class DeleterFromReadingListServlet extends HttpServlet {
    private final UserPublicationServiceImpl userPublicationService = new UserPublicationServiceImpl();
    private final UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long publId = Long.parseLong(req.getParameter("publ_id"));

        UserDto currentUser = (UserDto) req.getSession(false).getAttribute("user");

        UserDto userWithID = userService.get(currentUser.getLogin());

        userPublicationService.deleteByIDs(userWithID.getId(), publId);

        req.getRequestDispatcher("readinglist.ftl").forward(req, resp);
    }



}
