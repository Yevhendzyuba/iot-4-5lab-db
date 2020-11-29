package db.lab4.DAO.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.model.implementation.DataOfSensors;
import db.lab4.model.implementation.Pumps;
import db.lab4.persistance.ConnectionManager;

import java.sql.*;
import java.util.List;
import java.util.LinkedList;

public class PumpsDAO implements GeneralDAOInterface<Pumps, Integer> {
    private static final String GET_ALL = "SELECT * FROM mydb.pumps";
    private static final String GET_BY_ID = "SELECT * FROM mydb.pumps WHERE id=?";
    private static final String CREATE = "INSERT mydb.pumps"
            + "(id, area,amount_of_water,on_off_time_id) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE mydb.pumps"
            + "SET area=?,amount_of_water=?,on_off_time_id=? WHERE id=? ";
    private static final String DELETE = "DELETE FROM mydb.pumps WHERE id=?";

    @Override
    public final List<Pumps> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Pumps> pumps = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String area = resultSet.getString(2);
                    String amount_of_water = resultSet.getString(3);
                    Integer on_off_time_id = resultSet.getInt(4);

                    pumps.add(new Pumps(id, area, amount_of_water, on_off_time_id));

                }

            }

        }
        return pumps;
    }

    @Override
    public final Pumps getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Pumps pumps = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String area = resultSet.getString(2);
                    String amount_of_water = resultSet.getString(3);
                    Integer on_off_time_id = resultSet.getInt(4);
                    pumps = new Pumps(foundId, area, amount_of_water, on_off_time_id);
                }
            }
        }
        return pumps;
    }

    @Override
    public final int create(final Pumps entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getArea());
            ps.setString(3, entity.getAmountOfWater());
            ps.setInt(4, entity.getOnOffTimeId());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Pumps entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getArea());
            ps.setString(2, entity.getAmountOfWater());
            ps.setInt(3, entity.getOnOffTimeId());
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
