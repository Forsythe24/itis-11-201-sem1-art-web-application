package ru.kpfu.itis.solopov.net.servlet;

import com.cloudinary.Cloudinary;
import ru.kpfu.itis.solopov.net.util.CloudinaryUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.HashMap;

@WebServlet(name = "userInfoServlet", urlPatterns = "/userinfo")
@MultipartConfig(
        maxFileSize = 5 * 1024 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024 * 1024
)
public class UserInfoServlet extends HttpServlet {
    private final Cloudinary cloudinary = CloudinaryUtil.getInstance();
    public static final String FILE_PATH_PREFIX = "/tmp";
    public static final int DIRECTORIES_COUNT = 100;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            req.getRequestDispatcher("userinfo.ftl").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String birthDate = req.getParameter("birth_date");
        String genre = req.getParameter("genre");



        HttpSession httpSession = req.getSession();

        httpSession.setAttribute("username", username);
        httpSession.setAttribute("email", email);
        httpSession.setAttribute("gender", gender);
        httpSession.setAttribute("birth_date", birthDate);
        httpSession.setAttribute("genre", genre);
        httpSession.setAttribute("image", uploadFile(req));

        req.getRequestDispatcher("authenticationinfo.ftl").forward(req, resp);
    }

    private String uploadFile(HttpServletRequest req) throws ServletException, IOException {
        Part part = req.getPart("file");

        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        File file = new File(FILE_PATH_PREFIX + File.separator
                + filename.hashCode() % DIRECTORIES_COUNT + File.separator + filename);

        InputStream content = part.getInputStream();
        file.getParentFile().mkdirs();
        file.createNewFile();

        FileOutputStream outputStream = new FileOutputStream(file);
        byte[] buffer = new byte[content.available()];

        content.read(buffer);

        outputStream.write(buffer);
        outputStream.close();

        return cloudinary.uploader().upload(file, new HashMap<>()).get("url").toString();
    }

}
