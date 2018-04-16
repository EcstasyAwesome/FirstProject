package com.github.firstproject.dao.impl;

import com.github.firstproject.dao.model.UserDao;
import com.github.firstproject.dao.entity.User;
import com.github.firstproject.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserImpl implements UserDao {

    private UserImpl() {
    }

    private static UserImpl instance;

    public static UserImpl getInstance() {
        if (instance == null) return instance = new UserImpl();
        return instance;
    }

    private User getFromResultSet(ResultSet resultSet) throws SQLException {
        User result = new User();
        result.setId(resultSet.getLong("id"));
        result.setSurname(resultSet.getString("surname"));
        result.setFirstName(resultSet.getString("firstName"));
        result.setMiddleName(resultSet.getString("middleName"));
        result.setPhone(resultSet.getLong("phone"));
        result.setPosition(resultSet.getLong("position"));
        result.setDate(resultSet.getDate("date"));
        return result;
    }

    @Override
    public List<User> getList() {
        List<User> result = new ArrayList<>();
        String request = "SELECT * FROM users";
        try (Connection connection = DBConnection.getConnection()) {
            try (ResultSet resultSet = connection.createStatement().executeQuery(request)) {
                while (resultSet.next()) {
                    result.add(getFromResultSet(resultSet));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void create(User instance) {
        String request = "INSERT INTO users VALUES(NULL,?,?,?,?,?,?)";
        try (Connection connection = DBConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(request)) {
                preparedStatement.setString(1, instance.getSurname());
                preparedStatement.setString(2, instance.getFirstName());
                preparedStatement.setString(3, instance.getMiddleName());
                preparedStatement.setLong(4, instance.getPhone());
                preparedStatement.setLong(5, instance.getPosition());
                preparedStatement.setDate(6, new Date(instance.getDate().getTime()));
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User read(Long id) {
        User user = null;
        String request = "SELECT * FROM users WHERE id='" + id + "'";
        try (Connection connection = DBConnection.getConnection()) {
            try (ResultSet resultSet = connection.createStatement().executeQuery(request)) {
                resultSet.next();
                user = getFromResultSet(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(User instance) {
        String request = "UPDATE users " +
                "SET surname=?, firstName=?, middleName=?, phone=?, position=? " +
                "WHERE id=?";
        try (Connection connection = DBConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(request)) {
                preparedStatement.setString(1, instance.getSurname());
                preparedStatement.setString(2, instance.getFirstName());
                preparedStatement.setString(3, instance.getMiddleName());
                preparedStatement.setLong(4, instance.getPhone());
                preparedStatement.setLong(5, instance.getPosition());
                preparedStatement.setLong(6, instance.getId());
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String request = "DELETE FROM users WHERE id=?";
        try (Connection connection = DBConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(request)) {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}