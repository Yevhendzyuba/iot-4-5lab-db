package db.lab4.DAO.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.model.implementation.DataOfSensors;
import db.lab4.model.implementation.SensorData;
import db.lab4.persistance.ConnectionManager;

import java.sql.*;
import java.util.List;
import java.util.LinkedList;

public class SensorDataDAO implements GeneralDAOInterface<SensorData, Integer> {

    private static final String GET_ALL = "SELECT * FROM mydb.sensor_data";
    private static final String GET_BY_ID = "SELECT * FROM mydb.sensor_data WHERE id=?";
    private static final String CREATE = "INSERT mydb.sensor_data"
            + "(id, time, lightning,temperature,humidity,location_id) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE mydb.sensor_data"
            + "SET time=?, lightning=?,temperature=?,humidity=?,location_id=? WHERE id=? ";
    private static final String DELETE = "DELETE FROM mydb.sensor_data WHERE id=?";

    @Override
    public final List<SensorData> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<SensorData> sensorData = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String time = resultSet.getString(2);
                    String lightning = resultSet.getString(3);
                    String temperature = resultSet.getString(4);
                    String humidity = resultSet.getString(5);
                    Integer location_id = resultSet.getInt(6);
                    sensorData.add(new SensorData(id, time, lightning, temperature, humidity, location_id));

                }

            }

        }
        return sensorData;
    }


    @Override
    public final SensorData getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        SensorData sensorData = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String time = resultSet.getString(2);
                    String lightning = resultSet.getString(3);
                    String temperature = resultSet.getString(4);
                    String humidity = resultSet.getString(5);
                    Integer location_id = resultSet.getInt(6);
                    sensorData = new SensorData(foundId, time, lightning, temperature, humidity, location_id);
                }
            }
        }
        return sensorData;
    }

    @Override
    public final int create(final SensorData entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getTime());
            ps.setString(3, entity.getLightning());
            ps.setString(4, entity.getTemperature());
            ps.setString(5, entity.getHumidity());
            ps.setInt(6, entity.getLocationId());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final SensorData entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getTime());
            ps.setString(2, entity.getLightning());
            ps.setString(3, entity.getTemperature());
            ps.setString(4, entity.getHumidity());
            ps.setInt(5, entity.getLocationId());
            ps.setInt(6, entity.getId());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int delete(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);

            return ps.executeUpdate();
        }
    }


}
