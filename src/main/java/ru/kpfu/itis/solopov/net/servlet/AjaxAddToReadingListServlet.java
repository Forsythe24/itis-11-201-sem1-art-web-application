package ru.kpfu.itis.solopov.net.servlet;

import ru.kpfu.itis.solopov.net.dto.UserDto;
import ru.kpfu.itis.solopov.net.model.UserPublication;
import ru.kpfu.itis.solopov.net.service.Impl.UserPublicationServiceImpl;
import ru.kpfu.itis.solopov.net.service.UserPublicationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/ajax/addtoreadinglist")
public class AjaxAddToReadingListServlet extends HttpServlet {
    private final UserPublicationService userPublicationService = new UserPublicationServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        long userID = ((UserDto) httpSession.getAttribute("user")).getId();

        long publicationID = Long.parseLong(req.getParameter("publ_id"));

        System.out.println(userID + " " + publicationID);

        userPublicationService.save(new UserPublication(userID, publicationID));
    }
}
