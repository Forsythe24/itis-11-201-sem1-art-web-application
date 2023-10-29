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
public class AjaxGetJSONPublicationsServlet extends HttpServlet {
    private final PublicationService publicationService = new PublicationServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String genre = req.getParameter("genre");

        JSONArray jArray = new JSONArray();

        System.out.println(title + " " + genre);

        List<PublicationDto> publications;

        if ((title == null || title.length() == 0) && (genre == null || genre.length() == 0 || genre.equals("Recent Publications"))) {
            publications = publicationService.getAll();

            publications.forEach(
                    p -> jArray.put(getJSONPublication(p))
            );
        } else {
            if (title != null && title.length() != 0 && genre != null && genre.length() != 0 && !genre.equals("Recent Publications")) {
                publications = publicationService.getAllByTitle(title);

                publications.forEach(
                        p -> {
                            if (p.getGenre().equals(genre)) {
                                jArray.put(getJSONPublication(p));
                            }
                        }
                );
            } else {
                if (title != null && title.length() != 0) {
                    publications = publicationService.getAllByTitle(title);

                    publications.forEach(
                            p -> jArray.put(getJSONPublication(p))
                    );
                } else {
                    publications = publicationService.getAll();

                    publications.forEach(
                            p -> {
                                if (p.getGenre().equals(genre)) {
                                    jArray.put(getJSONPublication(p));
                                }
                            }
                    );
                }
            }

        }
        resp.setContentType("text/plain");
        resp.getWriter().write(jArray.toString());
    }
    
    private static JSONObject getJSONPublication(PublicationDto publication) {
        return new JSONObject()
                .put("id", publication.getId())
                .put("user_id", publication.getUserID())
                .put("title", publication.getTitle())
                .put("text", publication.getText())
                .put("date", publication.getDate())
                .put("time", publication.getTime())
                .put("genre", publication.getGenre())
                .put("description", publication.getDescription())
                .put("image", publication.getImage());
        
    }
}
