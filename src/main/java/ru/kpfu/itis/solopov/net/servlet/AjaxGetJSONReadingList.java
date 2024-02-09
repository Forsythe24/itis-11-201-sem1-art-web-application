package ru.kpfu.itis.solopov.net.servlet;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.kpfu.itis.solopov.net.dto.PublicationDto;
import ru.kpfu.itis.solopov.net.dto.UserDto;
import ru.kpfu.itis.solopov.net.dto.UserPublicationDto;
import ru.kpfu.itis.solopov.net.service.Impl.PublicationServiceImpl;
import ru.kpfu.itis.solopov.net.service.Impl.UserPublicationServiceImpl;
import ru.kpfu.itis.solopov.net.service.Impl.UserServiceImpl;
import ru.kpfu.itis.solopov.net.service.PublicationService;
import ru.kpfu.itis.solopov.net.service.UserPublicationService;
import ru.kpfu.itis.solopov.net.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/ajax/getreadinglist")
public class AjaxGetJSONReadingList extends HttpServlet {
    private UserPublicationService userPublicationService;
    private PublicationService publicationService;

    private UserService userService;
    @Override
    public void init() throws ServletException {
        userPublicationService = (UserPublicationService) getServletContext().getAttribute("userPublicationService");
        publicationService = (PublicationService) getServletContext().getAttribute("publicationService");
        userService = (UserService) getServletContext().getAttribute("userService");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        long userID = ((UserDto) httpSession.getAttribute("user")).getId();
        List<UserPublicationDto> readingList = userPublicationService.getAllByUserID(userID);
        JSONArray jsonArray = new JSONArray();

        for (UserPublicationDto userPublicationDto : readingList) {
            PublicationDto publication = publicationService.get(userPublicationDto.getPublicationID());
            UserDto author = userService.get(publication.getUserID());

            jsonArray.put(new JSONObject()
                    .put("title", publication.getTitle())
                    .put("genre", publication.getGenre())
                    .put("author", author.getUsername())
                    .put("image", publication.getImage())
                    .put("publId", publication.getId()));
        }

        resp.setContentType("plain/text");
        resp.getWriter().write(String.valueOf(jsonArray));

    }
}

