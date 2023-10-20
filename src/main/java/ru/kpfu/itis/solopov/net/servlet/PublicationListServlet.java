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

@WebServlet(name="publicationListServlet", urlPatterns="/publications")
public class PublicationListServlet extends HttpServlet {
    private final PublicationService publicationService = new PublicationServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("publicationlist.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("publicationlist.ftl").forward(req, resp);
    }
}
