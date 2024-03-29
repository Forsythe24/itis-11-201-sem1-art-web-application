package ru.kpfu.itis.solopov.net.dao.Impl;

import ru.kpfu.itis.solopov.net.dao.Dao;
import ru.kpfu.itis.solopov.net.model.Publication;
import ru.kpfu.itis.solopov.net.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublicationDaoImpl implements Dao<Publication> {
    private final Connection connection;

    public PublicationDaoImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public Publication get(long id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from publication WHERE id = " + "\'" + id + "\'";
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            Publication publication = new Publication(
                    resultSet.getLong("id"),
                    resultSet.getLong("user_id"),
                    resultSet.getString("title"),
                    resultSet.getString("publ_text"),
                    resultSet.getDate("publ_date").toLocalDate(),
                    resultSet.getTime("publ_time").toLocalTime(),
                    resultSet.getString("genre"),
                    resultSet.getString("description"),
                    resultSet.getString("image")
            );
            return publication;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Publication> getAllByTitle(String title) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from publication WHERE title = " + "\'" + title + "\'";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Publication> publications = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    publications.add(
                            new Publication(
                                    resultSet.getLong("id"),
                                    resultSet.getLong("user_id"),
                                    resultSet.getString("title"),
                                    resultSet.getString("publ_text"),
                                    resultSet.getDate("publ_date").toLocalDate(),
                                    resultSet.getTime("publ_time").toLocalTime(),
                                    resultSet.getString("genre"),
                                    resultSet.getString("description"),
                                    resultSet.getString("image")
                            )
                    );
                }
            }
            return publications;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Publication get(String login) {
        return null;
    }

    @Override
    public List<Publication> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from publication";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Publication> publications = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    publications.add(
                            new Publication(
                                    resultSet.getLong("id"),
                                    resultSet.getLong("user_id"),
                                    resultSet.getString("title"),
                                    resultSet.getString("publ_text"),
                                    resultSet.getDate("publ_date").toLocalDate(),
                                    resultSet.getTime("publ_time").toLocalTime(),
                                    resultSet.getString("genre"),
                                    resultSet.getString("description"),
                                    resultSet.getString("image")
                            )
                    );
                }
            }
            return publications;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Publication publication) {
        String sql = "insert into publication (user_id, title, publ_text, publ_date, publ_time, genre, description, image) values (?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, publication.getUserID());
            preparedStatement.setString(2, publication.getTitle());
            preparedStatement.setString(3, publication.getText());
            preparedStatement.setDate(4, Date.valueOf(publication.getDate()));
            preparedStatement.setTime(5, Time.valueOf(publication.getTime()));
            preparedStatement.setString(6, publication.getGenre());
            preparedStatement.setString(7, publication.getDescription());
            preparedStatement.setString(8, publication.getImage());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {String sql = "DELETE FROM publication WHERE id = " + "\'" + id + "\'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Publication publication) {
        String sql = "UPDATE publication set user_id = ?, title = ?, publ_text = ?, publ_date = ?, publ_time = ?, genre = ?, description = ?, image = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, publication.getUserID());
            preparedStatement.setString(2, publication.getTitle());
            preparedStatement.setString(3, publication.getText());
            preparedStatement.setDate(4, Date.valueOf(publication.getDate()));
            preparedStatement.setTime(5, Time.valueOf(publication.getTime()));
            preparedStatement.setString(6, publication.getGenre());
            preparedStatement.setString(7, publication.getDescription());
            preparedStatement.setString(8, publication.getImage());
            preparedStatement.setLong(9, publication.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
