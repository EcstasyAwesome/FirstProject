package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO {
    private final Connection connection;

    public PositionDAO(Connection connection) {
        this.connection = connection;
    }

    private Position getPositionFromResultSet(ResultSet resultSet) throws SQLException {
        Position result = new Position();
        result.setId(resultSet.getInt("position_id"));
        result.setName(resultSet.getString("position_name"));
        result.setDescription(resultSet.getString("position_description"));
        return result;
    }

    public List<Position> getPositionsList(String key, String value) {
        List<Position> result = new ArrayList<>();
        String request = "SELECT * FROM positions";
        String requestWithParam = "SELECT * FROM positions WHERE " + key + "='" + value + "'";
        try (ResultSet resultSet = connection.createStatement().executeQuery(key!=null&&key.equals("position_id") ? requestWithParam : request)) {
            while (resultSet.next()) {
                result.add(getPositionFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public void addPosition(String name, String description) {
        String request = "INSERT INTO positions VALUES(NULL,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(request)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updatePosition(int id, String name, String description){
        String request = "UPDATE positions SET position_name=?, position_description=? WHERE position_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(request)) {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,description);
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public void deletePosition(int id){
        String request = "DELETE FROM positions WHERE position_id=?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(request)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
