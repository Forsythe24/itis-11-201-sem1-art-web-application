package ru.kpfu.itis.solopov.net.servlet;

import ru.kpfu.itis.solopov.net.dto.UserDto;
import ru.kpfu.itis.solopov.net.dto.UserPublicationDto;
import ru.kpfu.itis.solopov.net.service.Impl.UserPublicationServiceImpl;
import ru.kpfu.itis.solopov.net.service.UserPublicationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/ajax/check")
public class AjaxCheckIfOnReadingListServlet extends HttpServlet {
    private final UserPublicationService userPublicationService = new UserPublicationServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        long userID = ((UserDto) httpSession.getAttribute("user")).getId();

        long publicationID = Long.parseLong(req.getParameter("publ_id"));
        
        List<UserPublicationDto> readingList = userPublicationService.getAllByUserID(userID);

        if (isAlreadyOnList(readingList, publicationID)) {
            resp.setContentType("plain/text");
            resp.getWriter().write("yes");
        }

    }

    private boolean isAlreadyOnList(List<UserPublicationDto> readingList, long publicationID) {
        for (UserPublicationDto userPublication : readingList) {
            if (userPublication.getPublicationID() == publicationID) {
                return true;
            }
        }
        return false;
    }
}
