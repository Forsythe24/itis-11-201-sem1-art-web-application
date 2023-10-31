package ru.kpfu.itis.solopov.net.servlet;

import org.jsoup.Jsoup;
import ru.kpfu.itis.solopov.net.dto.UserDto;
import ru.kpfu.itis.solopov.net.model.Publication;
import ru.kpfu.itis.solopov.net.service.Impl.PublicationServiceImpl;
import ru.kpfu.itis.solopov.net.service.Impl.UserServiceImpl;
import ru.kpfu.itis.solopov.net.service.PublicationService;
import ru.kpfu.itis.solopov.net.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;

import static ru.kpfu.itis.solopov.net.util.CloudinaryUploaderUtil.uploadFile;

@WebServlet(name="makePublicationServlet", urlPatterns="/makepublication")
@MultipartConfig(
        maxFileSize = 5 * 1024 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024 * 1024
)

public class MakePublicationServlet extends HttpServlet {
    private final String NEW_LINE = "<br>";
    private final String HYPHEN = "&#8208;";
    private final String DASH = "&#8211;";
    private final String QUOTE = "<q>";

    private final UserService userService = new UserServiceImpl();
    private final PublicationService publicationService = new PublicationServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("makepublication.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String text = req.getParameter("text")
                .replace("\n", NEW_LINE)
                .replace("-", HYPHEN)
                .replace("–", DASH)
                .replace("—", DASH)
                .replace("“", QUOTE)
                .replace("”", QUOTE);
        String description = req.getParameter("description");
        String genre = req.getParameter("genre");
        String title = req.getParameter("title");

        HttpSession httpSession = req.getSession(false);
        UserDto userDto = (UserDto) httpSession.getAttribute("user");
        Long userID = userService.get(userDto.getLogin()).getId();

        String image = uploadFile(req);

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        publicationService.save(new Publication(userID, title, text, date, time, genre, description, image));

        req.getRequestDispatcher("makepublication.ftl").forward(req, resp);
    }
}

