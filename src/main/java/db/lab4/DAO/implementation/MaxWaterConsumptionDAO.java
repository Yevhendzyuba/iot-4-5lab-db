package db.lab4.DAO.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.model.implementation.DataOfSensors;
import db.lab4.model.implementation.Location;
import db.lab4.model.implementation.MaxWaterConsumption;
import db.lab4.persistance.ConnectionManager;

import java.sql.*;
import java.util.List;
import java.util.LinkedList;

public class MaxWaterConsumptionDAO implements GeneralDAOInterface<MaxWaterConsumption, Integer> {

    private static final String GET_ALL = "SELECT * FROM mydb.max_water_consumption";
    private static final String GET_BY_ID = "SELECT * FROM mydb.max_water_consumption WHERE id=?";
    private static final String CREATE = "INSERT mydb.max_water_consumption"
            + "(id,time,power,litres VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE mydb.max_water_consumption"
            + "SET time=?,power=?,litres=? WHERE id=? ";
    private static final String DELETE = "DELETE FROM mydb.max_water_consumption WHERE id=?";

    @Override
    public final List<MaxWaterConsumption> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<MaxWaterConsumption> maxWaterConsumptions = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String time = resultSet.getString(2);
                    String power = resultSet.getString(3);
                    String litres = resultSet.getString(4);
                    maxWaterConsumptions.add(new MaxWaterConsumption(id, time, power, litres));

                }

            }

        }
        return maxWaterConsumptions;
    }

    public final MaxWaterConsumption getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        MaxWaterConsumption maxWaterConsumption = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String time = resultSet.getString(2);
                    String power = resultSet.getString(3);
                    String litres = resultSet.getString(4);
                    maxWaterConsumption = new MaxWaterConsumption(foundId, time, power, litres);
                }
            }
        }

        return maxWaterConsumption;
    }

    @Override
    public final int create(final MaxWaterConsumption entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getTime());
            ps.setString(3, entity.getPower());
            ps.setString(4, entity.getLitres());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final MaxWaterConsumption entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getTime());
            ps.setString(2, entity.getPower());
            ps.setString(3, entity.getLitres());
            ps.setInt(4, entity.getId());

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
