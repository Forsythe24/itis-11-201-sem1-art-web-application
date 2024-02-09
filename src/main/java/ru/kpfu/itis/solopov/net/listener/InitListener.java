package ru.kpfu.itis.solopov.net.listener;

import ru.kpfu.itis.solopov.net.dao.Impl.*;
import ru.kpfu.itis.solopov.net.model.Quote;
import ru.kpfu.itis.solopov.net.service.Impl.*;
import ru.kpfu.itis.solopov.net.util.DatabaseConnectionUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import java.sql.Connection;


@WebListener
public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Connection connection = DatabaseConnectionUtil.getConnection();
            ServletContext sc = sce.getServletContext();
            CommentDaoImpl commentDao = new CommentDaoImpl(connection);
            PublicationDaoImpl publicationDao = new PublicationDaoImpl(connection);
            QuoteDaoImpl quoteDao = new QuoteDaoImpl(connection);
            UserDaoImpl userDao = new UserDaoImpl(connection);
            UserPublicationDaoImpl userPublicationDao = new UserPublicationDaoImpl(connection);

            sc.setAttribute("commentDao", commentDao);
            sc.setAttribute("publicationDao", publicationDao);
            sc.setAttribute("quoteDao", quoteDao);
            sc.setAttribute("userDao", userDao);
            sc.setAttribute("userPublicationDao", userPublicationDao);

            sc.setAttribute("commentService", new CommentServiceImpl(commentDao));
            sc.setAttribute("publicationService", new PublicationServiceImpl(publicationDao));
            sc.setAttribute("quoteService", new QuoteServiceImpl(quoteDao));
            sc.setAttribute("userPublicationService", new UserPublicationServiceImpl(userPublicationDao));
            sc.setAttribute("UserService", new UserServiceImpl(userDao));

        } catch (RuntimeException e){
            throw new RuntimeException("Database connection failed");
        }
    }
}
