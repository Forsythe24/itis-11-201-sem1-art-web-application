package ru.kpfu.itis.solopov.net.dao.Impl;

import ru.kpfu.itis.solopov.net.dao.Dao;
import ru.kpfu.itis.solopov.net.model.Comment;
import ru.kpfu.itis.solopov.net.model.Publication;
import ru.kpfu.itis.solopov.net.model.User;
import ru.kpfu.itis.solopov.net.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl implements Dao<Comment> {

    private final Connection connection;

    public CommentDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Comment get(long id) {
        return null;
    }

    @Override
    public Comment get(String login) {
        return null;
    }

    @Override
    public List<Comment> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from comment";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Comment> comments = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    comments.add(
                            new Comment(
                                    resultSet.getLong("id"),
                                    resultSet.getLong("publ_id"),
                                    resultSet.getLong("user_id"),
                                    resultSet.getString("comment_text"),
                                    resultSet.getDate("comment_date").toLocalDate(),
                                    resultSet.getTime("comment_time").toLocalTime()
                            )
                    );
                }
            }
            return comments;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Comment> getAllByPublicationID(Long publId) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from comment WHERE publ_id = " + "\'" + publId + "\'";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Comment> comments = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    comments.add(
                            new Comment(
                                    resultSet.getLong("id"),
                                    resultSet.getLong("publ_id"),
                                    resultSet.getLong("user_id"),
                                    resultSet.getString("comment_text"),
                                    resultSet.getDate("comment_date").toLocalDate(),
                                    resultSet.getTime("comment_time").toLocalTime()
                            )
                    );
                }
            }
            return comments;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void save(Comment comment) {
        String sql = "insert into comment (publ_id, user_id, comment_text, comment_date, comment_time) values (?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,comment.getPublID());
            preparedStatement.setLong(2, comment.getUserID());
            preparedStatement.setString(3, comment.getText());
            preparedStatement.setDate(4, Date.valueOf(comment.getDate()));
            preparedStatement.setTime(5, Time.valueOf(comment.getTime()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Comment comment) {

    }

    @Override
    public void delete(long id) {

    }
}
