package db.lab4.DAO.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.model.GeneralModelInterface;
import db.lab4.model.implementation.DataOfSensors;
import db.lab4.persistance.ConnectionManager;


import java.sql.*;
import java.util.List;
import java.util.LinkedList;

public class DataOfSensorsDAO implements GeneralDAOInterface<DataOfSensors, Integer> {

    private static final String GET_ALL = "SELECT * FROM mydb.data_of_sensors";
    private static final String GET_BY_ID = "SELECT * FROM mydb.data_of_sensors WHERE id=?";
    private static final String CREATE = "INSERT mydb.data_of_sensors"
            + "(id, time, sensor_data_id, pumps_id, noozle_id, date_id) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE mydb.data_of_sensors"
            + "SET time=?, sensor_data_id=?, pumps_id=?, noozle_id=?, date_id=? WHERE id=? ";
    private static final String DELETE = "DELETE FROM mydb.data_of_sensors WHERE id=?";

    @Override
    public final List<DataOfSensors> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<DataOfSensors> dataOfSensors = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String time = resultSet.getString(2);
                    Integer sensor_data_id = resultSet.getInt(3);
                    Integer pumps_id = resultSet.getInt(4);
                    Integer noozle_id = resultSet.getInt(5);
                    Integer date_id = resultSet.getInt(6);
                    dataOfSensors.add(new DataOfSensors(id, time, sensor_data_id, pumps_id, noozle_id, date_id));

                }

            }

        }
        return dataOfSensors;
    }

    @Override
    public final DataOfSensors getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        DataOfSensors dataOfSensors = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String time = resultSet.getString(2);
                    Integer sensor_data_id = resultSet.getInt(3);
                    Integer pumps_id = resultSet.getInt(4);
                    Integer noozle_id = resultSet.getInt(5);
                    Integer date_id = resultSet.getInt(6);
                    dataOfSensors = new DataOfSensors(foundId, time, sensor_data_id, pumps_id, noozle_id, date_id);
                }
            }
        }
        return dataOfSensors;
    }

    @Override
    public final int create(final DataOfSensors entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getTime());
            ps.setInt(3, entity.getSensorDataId());
            ps.setInt(4, entity.getPumpsId());
            ps.setInt(5, entity.getNoozleId());
            ps.setInt(6, entity.getDateId());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final DataOfSensors entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getTime());
            ps.setInt(2, entity.getSensorDataId());
            ps.setInt(3, entity.getPumpsId());
            ps.setInt(4, entity.getNoozleId());
            ps.setInt(5, entity.getDateId());
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

