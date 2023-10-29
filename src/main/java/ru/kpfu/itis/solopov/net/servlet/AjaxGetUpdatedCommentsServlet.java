package ru.kpfu.itis.solopov.net.servlet;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.kpfu.itis.solopov.net.dto.CommentDto;
import ru.kpfu.itis.solopov.net.dto.UserDto;
import ru.kpfu.itis.solopov.net.service.CommentService;
import ru.kpfu.itis.solopov.net.service.Impl.CommentServiceImpl;
import ru.kpfu.itis.solopov.net.service.Impl.UserServiceImpl;
import ru.kpfu.itis.solopov.net.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/ajax/comments")
public class AjaxGetUpdatedCommentsServlet extends HttpServlet {
    private final CommentService commentService = new CommentServiceImpl();
    private final UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long publId = Long.parseLong(req.getParameter("publ_id"));


        List<CommentDto> comments = commentService.getAllByPublicationID(publId);
        JSONArray jArray = new JSONArray();

        comments.forEach(
                c -> {
                    UserDto user = userService.get(c.getUserID());

                    jArray.put(new JSONObject()
                            .put("id", c.getId())
                            .put("publ_id", c.getPublID())
                            .put("user_id", c.getUserID())
                            .put("text", c.getText())
                            .put("date", c.getDate())
                            .put("time", c.getTime())
                            .put("image", user.getImage())
                            .put("username", user.getUsername())

                    );
                }
        );
        resp.setContentType("text/plain");
        resp.getWriter().write(jArray.toString());
    }
}
