package db.lab4.DAO.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.model.implementation.DataOfSensors;
import db.lab4.model.implementation.DataOfSensorsHasPersonInformation;
import db.lab4.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DataOfSensorsHasPersonInformationDAO implements GeneralDAOInterface<DataOfSensorsHasPersonInformation, Integer> {

    private static final String GET_ALL = "SELECT * FROM mydb.data_of_sensors_has_person_information";
    private static final String GET_BY_ID = "SELECT * FROM mydb.data_of_sensors_has_person_information WHERE id=?";
    private static final String CREATE = "INSERT mydb.data_of_sensors_has_person_information"
            + "(id,data_of_sensors_id,person_information_id) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE mydb.data_of_sensors_has_person_information"
            + "SET data_of_sensors_id=?,person_information_id=? WHERE id=? ";
    private static final String DELETE = "DELETE FROM mydb.data_of_sensors_has_person_information WHERE id=?";

    @Override
    public final List<DataOfSensorsHasPersonInformation> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<DataOfSensorsHasPersonInformation> dataOfSensorsHasPersonInformations = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer data_of_sensors_id = resultSet.getInt(2);
                    Integer person_information_id = resultSet.getInt(3);
                    dataOfSensorsHasPersonInformations.add(new DataOfSensorsHasPersonInformation(data_of_sensors_id, person_information_id));

                }

            }

        }
        return dataOfSensorsHasPersonInformations;
    }

    @Override
    public final DataOfSensorsHasPersonInformation getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        DataOfSensorsHasPersonInformation dataOfSensorsHasPersonInformation = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Integer data_of_sensors_id = resultSet.getInt(2);

                    dataOfSensorsHasPersonInformation = new DataOfSensorsHasPersonInformation(foundId, data_of_sensors_id);
                }
            }
        }
        return dataOfSensorsHasPersonInformation;
    }

    @Override
    public final int create(final DataOfSensorsHasPersonInformation entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getDataOfSensorsId());
            ps.setInt(3, entity.getPersonInformationId());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final DataOfSensorsHasPersonInformation entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getDataOfSensorsId());
            ps.setInt(2, entity.getPersonInformationId());
            ps.setInt(3, entity.getId());

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
