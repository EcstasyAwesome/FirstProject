package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    private final Connection connection;

    public MemberDAO(Connection connection) {
        this.connection = connection;
    }

    private Member getMemberFromResultSet(ResultSet resultSet) throws SQLException {
        Member result = new Member();
        result.setLogin(resultSet.getString("member_login"));
        result.setPassword(resultSet.getString("member_password"));
        result.setSurname(resultSet.getString("member_surname"));
        result.setFirstName(resultSet.getString("member_firstName"));
        result.setLastName(resultSet.getString("member_lastName"));
        result.setRegisterDate(resultSet.getDate("member_registerDate"));
        return result;
    }

    public List<Member> getMembersList() {
        List<Member> result = new ArrayList<>();
        String request = "SELECT * FROM members";
        try (ResultSet resultSet = connection.createStatement().executeQuery(request)) {
            while (resultSet.next()) {
                result.add(getMemberFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public Member checkMember(String login) throws SQLException {
        String request = "SELECT * FROM members WHERE member_login='" + login + "'";
        ResultSet resultSet = connection.createStatement().executeQuery(request);
        resultSet.next();
        Member result = getMemberFromResultSet(resultSet);
        resultSet.close();
        return result;
    }

    public void registerMember(String login, String password, String surname, String firstName, String lastName) {
        String request = "INSERT INTO members VALUES (?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(request)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, surname);
            preparedStatement.setString(4, firstName);
            preparedStatement.setString(5, lastName);
            preparedStatement.setDate(6, new Date(new java.util.Date().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateMember(String login, String password, String surname, String firstName, String lastName) {
        String request = "UPDATE members " +
                "SET member_password=?, member_surname=?, member_firstName=?, member_lastName=? " +
                "WHERE member_login=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(request)) {
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);
            preparedStatement.setString(5, login);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteMember(String login) {
        String request = "DELETE FROM members WHERE member_login=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(request)) {
            preparedStatement.setString(1, login);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
