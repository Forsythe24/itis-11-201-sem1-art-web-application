package ru.kpfu.itis.solopov.net.dao.Impl;

import ru.kpfu.itis.solopov.net.dao.Dao;
import ru.kpfu.itis.solopov.net.model.User;
import ru.kpfu.itis.solopov.net.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements Dao<User> {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

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
                    resultSet.getLong("id")
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
                                    resultSet.getLong("id")
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
        String sql = "insert into users (username, email, gender, login, password, birth_date) values (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setDate(6, Date.valueOf(user.getBirthDate()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users set username = ?, email = ?, gender = ?, login = ?, password = ?, birth_date = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setDate(6, Date.valueOf(user.getBirthDate()));
            preparedStatement.setLong(7, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
