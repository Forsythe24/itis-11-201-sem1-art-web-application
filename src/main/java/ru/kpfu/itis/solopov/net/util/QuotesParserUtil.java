package ru.kpfu.itis.solopov.net.util;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.kpfu.itis.solopov.net.dto.QuoteDto;
import ru.kpfu.itis.solopov.net.model.Quote;
import ru.kpfu.itis.solopov.net.service.Impl.QuoteServiceImpl;
import ru.kpfu.itis.solopov.net.service.QuoteService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class QuotesParserUtil {

    private static final QuoteService quoteService = new QuoteServiceImpl();

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://zenquotes.io/api/quotes ");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");

        String response  = readResponse(connection);

        saveAllQuotes(response);
    }

    private static String readResponse(HttpURLConnection connection) throws IOException {
        if (connection != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder content = new StringBuilder();
                String input;
                while ((input = reader.readLine()) != null) {
                    content.append(input);
                }
                return content.toString();
            }
        }
        return null;
    }

    private static void saveAllQuotes(String response) {
        JSONArray jsonArray = new JSONArray(response);
        for (Object obj : jsonArray) {
            JSONObject jsonObj = new JSONObject(obj.toString());
            Quote quote = new Quote(jsonObj.getString("q"), jsonObj.getString("a"));
            quoteService.save(quote);

        }
    }
}
