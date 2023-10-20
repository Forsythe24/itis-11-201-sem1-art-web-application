package ru.kpfu.itis.solopov.net.servlet;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.kpfu.itis.solopov.net.dto.PublicationDto;
import ru.kpfu.itis.solopov.net.service.Impl.PublicationServiceImpl;
import ru.kpfu.itis.solopov.net.service.PublicationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/ajax/getpublications")
public class AjaxGetJSONPublications extends HttpServlet {
    private final PublicationService publicationService = new PublicationServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PublicationDto> publications = publicationService.getAll();
        JSONArray jArray = new JSONArray();
        publications.forEach(
                p -> jArray.put(new JSONObject()
                        .put("id", p.getId())
                        .put("user_id", p.getUserID())
                        .put("title", p.getTitle())
                        .put("text", p.getText())
                        .put("date", p.getDate())
                        .put("time", p.getTime())
                        .put("genre", p.getGenre())
                        .put("description", p.getDescription())
                        .put("image", p.getImage())
                )
        );
        resp.setContentType("text/plain");
        resp.getWriter().write(jArray.toString());
    }
}
