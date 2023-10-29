package ru.kpfu.itis.solopov.net.dao.Impl;

import ru.kpfu.itis.solopov.net.dao.Dao;
import ru.kpfu.itis.solopov.net.model.User;
import ru.kpfu.itis.solopov.net.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements Dao<User> {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    public User get(long id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from users WHERE id = " + "\'" + id + "\'";
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            User user = new User(
                    resultSet.getString("username"),
                    resultSet.getString("email"),
                    resultSet.getString("gender"),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getDate("birth_date").toLocalDate(),
                    resultSet.getString("genre"),
                    resultSet.getLong("id"),
                    resultSet.getString("image")
            );
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User get(String login) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from users WHERE login = " + "\'" + login + "\'";
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            User user = new User(
                    resultSet.getString("username"),
                    resultSet.getString("email"),
                    resultSet.getString("gender"),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getDate("birth_date").toLocalDate(),
                    resultSet.getString("genre"),
                    resultSet.getLong("id"),
                    resultSet.getString("image")
            );
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from users";
            ResultSet resultSet = statement.executeQuery(sql);
            List<User> users = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    users.add(
                            new User(
                                    resultSet.getString("username"),
                                    resultSet.getString("email"),
                                    resultSet.getString("gender"),
                                    resultSet.getString("login"),
                                    resultSet.getString("password"),
                                    resultSet.getDate("birth_date").toLocalDate(),
                                    resultSet.getString("genre"),
                                    resultSet.getLong("id"),
                                    resultSet.getString("image")
                            )
                    );
                }
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(User user) {
        String sql = "insert into users (username, email, gender, login, password, genre, birth_date, image) values (?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getGenre());
            preparedStatement.setDate(7, Date.valueOf(user.getBirthDate()));
            preparedStatement.setString(8, user.getImage());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users set username = ?, email = ?, gender = ?, login = ?, password = ?, birth_date = ?, genre = ?, image = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setDate(6, Date.valueOf(user.getBirthDate()));
            preparedStatement.setString(7, user.getGenre());
            preparedStatement.setLong(8, user.getId());
            preparedStatement.setString(9, user.getImage());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
