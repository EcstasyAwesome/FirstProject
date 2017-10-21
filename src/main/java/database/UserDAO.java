package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        return result;
    }

    public List<User> getUsersList(String key, String value) {
        List<User> result = new ArrayList<>();
        String request = "SELECT u.user_id, u.user_surname, u.user_firstName, u.user_secondName, u.user_phoneNumber, p.position_id " +
                "FROM users u " +
                "LEFT JOIN positions p " +
                "USING (position_id)";
        String requestWithParam = "SELECT u.user_id, u.user_surname, u.user_firstName, u.user_secondName, u.user_phoneNumber, p.position_id " +
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

    public void addUser(String surname, String firstName, String secondName, long phoneNumber, int position) {
        String request = "INSERT INTO users VALUES (NULL, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(request)) {
            preparedStatement.setString(1, surname);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, secondName);
            preparedStatement.setLong(4, phoneNumber);
            preparedStatement.setInt(5, position);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateUser(int id, String surname, String firstName, String secondName, long phoneNumber, int position) {
        String request = "UPDATE users " +
                "SET user_surname=?, user_firstName=?, user_secondName=?, user_phoneNumber=?, position_id=? " +
                "WHERE user_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(request)) {
            preparedStatement.setString(1, surname);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, secondName);
            preparedStatement.setLong(4, phoneNumber);
            preparedStatement.setInt(5, position);
            preparedStatement.setInt(6, id);
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
