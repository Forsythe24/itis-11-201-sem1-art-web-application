package ru.kpfu.itis.solopov.net.servlet;

import ru.kpfu.itis.solopov.net.dto.UserPublicationDto;
import ru.kpfu.itis.solopov.net.service.Impl.PublicationServiceImpl;
import ru.kpfu.itis.solopov.net.service.Impl.UserPublicationServiceImpl;
import ru.kpfu.itis.solopov.net.service.PublicationService;
import ru.kpfu.itis.solopov.net.service.UserPublicationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/ajax/deletepublication")
public class AjaxDeletePublicationServlet extends HttpServlet {
    private final PublicationService publicationService = new PublicationServiceImpl();
    private final UserPublicationService userPublicationService = new UserPublicationServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("publ_id"));
        publicationService.delete(id);

        List<UserPublicationDto> userPublicationDtos = userPublicationService.getAll();
        for (UserPublicationDto up : userPublicationDtos) {
            if (up.getPublicationID() == id) {
                userPublicationService.delete(up.getId());
            }
        }
    }
}
