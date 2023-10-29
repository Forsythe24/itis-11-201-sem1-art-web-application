package ru.kpfu.itis.solopov.net.dao.Impl;

import ru.kpfu.itis.solopov.net.dao.Dao;
import ru.kpfu.itis.solopov.net.model.Quote;
import ru.kpfu.itis.solopov.net.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuoteDaoImpl implements Dao<Quote> {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    public Quote get(long id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from quote WHERE id = " + "\'" + id + "\'";
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            Quote quote = new Quote(
                    resultSet.getString("quote_text"),
                    resultSet.getString("author"),
                    resultSet.getLong("id")
            );
            return quote;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Quote get(String login) {
        return null;
    }

    @Override
    public List<Quote> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from quote";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Quote> publications = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    publications.add(
                            new Quote(
                                    resultSet.getString("quote_text"),
                                    resultSet.getString("author"),
                                    resultSet.getLong("id")
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
    public void save(Quote quote) {
        String sql = "insert into quote (author, quote_text) values (?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, quote.getAuthor());
            preparedStatement.setString(2, quote.getText());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Quote publication) {

    }
}
