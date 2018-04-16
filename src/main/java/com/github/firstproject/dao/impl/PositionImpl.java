package com.github.firstproject.dao.impl;

import com.github.firstproject.dao.model.PositionDao;
import com.github.firstproject.dao.entity.Position;
import com.github.firstproject.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionImpl implements PositionDao {

    private PositionImpl(){
    }

    private static PositionImpl instance;

    public static PositionImpl getInstance() {
        if (instance == null) return instance = new PositionImpl();
        return instance;
    }

    private Position getFromResultSet(ResultSet resultSet) throws SQLException {
        Position position = new Position();
        position.setId(resultSet.getLong("id"));
        position.setName(resultSet.getString("name"));
        position.setDescription(resultSet.getString("description"));
        return position;
    }

    @Override
    public List<Position> getList() {
        List<Position> result = new ArrayList<>();
        String request = "SELECT * FROM positions";
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
    public void create(Position instance) {
        String request = "INSERT INTO positions VALUES(NULL,?,?)";
        try (Connection connection = DBConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(request)) {
                preparedStatement.setString(1, instance.getName());
                preparedStatement.setString(2, instance.getDescription());
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Position read(Long id) {
        Position position = null;
        String request = "SELECT * FROM positions WHERE id='" + id + "'";
        try (Connection connection = DBConnection.getConnection()) {
            try (ResultSet resultSet = connection.createStatement().executeQuery(request)) {
                resultSet.next();
                position = getFromResultSet(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return position;
    }

    @Override
    public void update(Position instance) {
        String request = "UPDATE positions SET name=?, description=? WHERE id=?";
        try (Connection connection = DBConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(request)) {
                preparedStatement.setString(1, instance.getName());
                preparedStatement.setString(2, instance.getDescription());
                preparedStatement.setLong(3, instance.getId());
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String request = "DELETE FROM positions WHERE id=?";
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