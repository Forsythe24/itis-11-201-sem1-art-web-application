package ru.kpfu.itis.solopov.net.servlet;

import ru.kpfu.itis.solopov.net.dto.PublicationDto;
import ru.kpfu.itis.solopov.net.dto.UserDto;
import ru.kpfu.itis.solopov.net.service.Impl.PublicationServiceImpl;
import ru.kpfu.itis.solopov.net.service.PublicationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static ru.kpfu.itis.solopov.net.util.CloudinaryUploaderUtil.uploadFile;


@WebServlet(urlPatterns = "/editpublication")
@MultipartConfig(
        maxFileSize = 5 * 1024 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024 * 1024
)
public class EditPublicationServlet extends HttpServlet {

    private final PublicationService publicationService = new PublicationServiceImpl();
    private final String NEW_LINE = "<br>";
    private final String HYPHEN = "&#8208;";
    private final String DASH = "&#8211;";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("editpublication.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        PublicationDto publication = (PublicationDto) httpSession.getAttribute("publication");

        String text = req.getParameter("text");
        String description = req.getParameter("description");
        String genre = req.getParameter("genre");
        String title = req.getParameter("title");
        String image = uploadFile(req);

        publication.setText(text);
        publication.setDescription(description);
        publication.setGenre(genre);
        publication.setTitle(title);
        publication.setImage(image);

        publicationService.update(publication);

        resp.sendRedirect("/publication?publ_id=" + publication.getId());
    }
}
