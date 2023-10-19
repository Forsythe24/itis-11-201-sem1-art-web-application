package ru.kpfu.itis.solopov.net.dao.Impl;

import ru.kpfu.itis.solopov.net.dao.Dao;
import ru.kpfu.itis.solopov.net.model.Publication;
import ru.kpfu.itis.solopov.net.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.List;

public class PublicationDaoImpl implements Dao<Publication> {
    private final Connection connection = DatabaseConnectionUtil.getConnection();
    @Override
    public Publication get(String login) {
        return null;
    }

    @Override
    public List<Publication> getAll() {
        return null;
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
    public void update(Publication publication) {

    }
}
