package ru.kpfu.itis.solopov.net.servlet;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.kpfu.itis.solopov.net.dto.QuoteDto;
import ru.kpfu.itis.solopov.net.service.QuoteService;
import ru.kpfu.itis.solopov.net.service.Impl.QuoteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@WebServlet(urlPatterns = "/ajax/getquotes")
public class AjaxGetJSONQuotesServlet extends HttpServlet {
    private final QuoteService quoteService = new QuoteServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numberOfQuotes = req.getParameter("number");

        List<QuoteDto> quotes = quoteService.getAll();

        JSONArray jsonArray = new JSONArray();
        if (numberOfQuotes.equals("all")) {

            quotes.forEach(
                    q -> jsonArray.put(new JSONObject()
                            .put("id", q.getId())
                            .put("text", q.getText())
                            .put("author", q.getAuthor())
                    )
            );
        } else {
            Random random = new Random();
            int id = random.nextInt(1, 201);
            QuoteDto quote = quoteService.get(id);

            jsonArray.put(new JSONObject()
                    .put("id", quote.getId())
                    .put("text", quote.getText())
                    .put("author", quote.getAuthor()));
        }

        resp.setContentType("text/plain");
        resp.getWriter().write(jsonArray.toString());
    }
}
