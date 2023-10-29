package ru.kpfu.itis.solopov.net.servlet;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.kpfu.itis.solopov.net.dto.CommentDto;
import ru.kpfu.itis.solopov.net.dto.PublicationDto;
import ru.kpfu.itis.solopov.net.dto.UserDto;
import ru.kpfu.itis.solopov.net.model.Comment;
import ru.kpfu.itis.solopov.net.service.Impl.CommentServiceImpl;
import ru.kpfu.itis.solopov.net.service.Impl.PublicationServiceImpl;
import ru.kpfu.itis.solopov.net.service.Impl.UserServiceImpl;
import ru.kpfu.itis.solopov.net.service.PublicationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@WebServlet(name="publicationServlet", urlPatterns="/publication")
public class PublicationServlet extends HttpServlet {
    private final PublicationService publicationService = new PublicationServiceImpl();

    private final CommentServiceImpl commentService = new CommentServiceImpl();

    private final UserServiceImpl userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long publId = Long.parseLong(req.getParameter("publ_id"));
        PublicationDto publicationDto = publicationService.get(publId);

        Long userId = publicationDto.getUserID();
        UserDto user = userService.get(userId);

        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("author_name", user.getUsername());
        httpSession.setAttribute("author_email", user.getEmail());
        httpSession.setAttribute("author_image", user.getImage());
        httpSession.setAttribute("publication", publicationDto);

//        req.setAttribute("from_publication", true);
//        req.setAttribute("user_id", publicationDto.getUserID());



        req.getRequestDispatcher("publication.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long publId = Long.parseLong(req.getParameter("publ_id"));
        String text = req.getParameter("text");

        HttpSession httpSession = req.getSession(false);

        UserDto user = (UserDto) httpSession.getAttribute("user");
        Long userId = user.getId();

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        commentService.save(new Comment(publId, userId, text, date, time));

        List<CommentDto> comments = commentService.getAllByPublicationID(publId);
        JSONArray jArray = new JSONArray();

        comments.forEach(
                c -> jArray.put(new JSONObject()
                        .put("id", c.getId())
                        .put("publ_id", c.getPublID())
                        .put("user_id", c.getUserID())
                        .put("text", c.getText())
                        .put("date", c.getDate())
                        .put("time", c.getTime())
                        .put("image", userId)
                        .put("username", user.getUsername())

                )
        );
        req.getRequestDispatcher("publication.ftl").forward(req, resp);
    }
}

