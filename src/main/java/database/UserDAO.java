package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private final Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        User result = new User();
        result.setId(resultSet.getInt("user_id"));
        result.setSurname(resultSet.getString("user_surname"));
        result.setFirstName(resultSet.getString("user_firstName"));
        result.setSecondName(resultSet.getString("user_secondName"));
        result.setPhoneNumber(resultSet.getLong("user_phoneNumber"));
        result.setPosition(resultSet.getInt("position_id"));
        result.setLogin(resultSet.getString("user_login"));
        result.setPassword(resultSet.getString("user_password"));
        result.setRegisterDate(resultSet.getDate("user_registerDate"));
        result.setAdmin(resultSet.getBoolean("user_isAdmin"));
        return result;
    }

    public List<User> getUsersList(String key, String value) {
        List<User> result = new ArrayList<>();
        String request = "SELECT u.user_id, u.user_surname, u.user_firstName, u.user_secondName, u.user_phoneNumber, " +
                "p.position_id, u.user_login, u.user_password, u.user_registerDate, u.user_isAdmin " +
                "FROM users u " +
                "LEFT JOIN positions p " +
                "USING (position_id)";
        String requestWithParam = "SELECT u.user_id, u.user_surname, u.user_firstName, u.user_secondName, u.user_phoneNumber, " +
                "p.position_id, u.user_login, u.user_password, u.user_registerDate, u.user_isAdmin " +
                "FROM users u " +
                "LEFT JOIN positions p " +
                "USING (position_id) " +
                "WHERE " + key + "='" + value + "'";
        try (ResultSet resultSet = connection.createStatement().executeQuery(key == null ? request : requestWithParam)) {
            while (resultSet.next()) {
                result.add(getUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public User checkUser(String login) throws SQLException {
        String request = "SELECT * FROM users WHERE user_login='" + login + "'";
        ResultSet resultSet = connection.createStatement().executeQuery(request);
        resultSet.next();
        User result = getUserFromResultSet(resultSet);
        resultSet.close();
        return result;
    }

    public void addUser(String surname, String firstName, String secondName, long phoneNumber, int position, String login, String password, boolean admin) {
        String request = "INSERT INTO users VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(request)) {
            preparedStatement.setString(1, surname);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, secondName);
            preparedStatement.setLong(4, phoneNumber);
            preparedStatement.setInt(5, position);
            preparedStatement.setString(6, login);
            preparedStatement.setString(7, password);
            preparedStatement.setDate(8, new Date(new java.util.Date().getTime()));
            preparedStatement.setBoolean(9, admin);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateUser(int id, String surname, String firstName, String secondName, long phoneNumber, int position, String password, boolean admin) {
        String request = "UPDATE users " +
                "SET user_surname=?, user_firstName=?, user_secondName=?, user_phoneNumber=?, position_id=?, user_password=?, user_isAdmin=? " +
                "WHERE user_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(request)) {
            preparedStatement.setString(1, surname);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, secondName);
            preparedStatement.setLong(4, phoneNumber);
            preparedStatement.setInt(5, position);
            preparedStatement.setString(6, password);
            preparedStatement.setBoolean(7, admin);
            preparedStatement.setInt(8, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteUser(int id) {
        String request = "DELETE FROM users WHERE user_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(request)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
