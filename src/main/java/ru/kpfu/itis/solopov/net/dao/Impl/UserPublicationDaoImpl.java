package ru.kpfu.itis.solopov.net.dao.Impl;

import ru.kpfu.itis.solopov.net.dao.Dao;
import ru.kpfu.itis.solopov.net.model.Publication;
import ru.kpfu.itis.solopov.net.model.UserPublication;
import ru.kpfu.itis.solopov.net.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserPublicationDaoImpl implements Dao<UserPublication> {

    private final Connection connection;

    public UserPublicationDaoImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public UserPublication get(long id) {
       return null;
    }

    @Override
    public UserPublication get(String login) {
        return null;
    }

    @Override
    public List<UserPublication> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from userpublication";
            ResultSet resultSet = statement.executeQuery(sql);
            List<UserPublication> userPublications = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    userPublications.add(
                            new UserPublication(
                                    resultSet.getLong("id"),
                                    resultSet.getLong("user_id"),
                                    resultSet.getLong("publication_id")
                            )
                    );
                }
            }
            return userPublications;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<UserPublication> getAllByUserID(long userID) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from userpublication WHERE user_id = " + "\'" + userID + "\'";
            ResultSet resultSet = statement.executeQuery(sql);
            List<UserPublication> userPublications = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    userPublications.add(
                            new UserPublication(
                                    resultSet.getLong("id"),
                                    resultSet.getLong("user_id"),
                                    resultSet.getLong("publication_id")
                            )
                    );
                }
            }
            return userPublications;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(UserPublication userPublication) {
        String sql = "insert into userpublication (user_id, publication_id) values (?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, userPublication.getUserID());
            preparedStatement.setLong(2, userPublication.getPublicationID());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(UserPublication userPublication) {
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM userpublication WHERE id = " + "\'" + id + "\'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteByIDs(long userID, long publicationID) {
        String sql = "DELETE FROM userpublication WHERE user_id = " + "\'" + userID + "\'" + "AND publication_id = " + "\'" + publicationID + "\'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
