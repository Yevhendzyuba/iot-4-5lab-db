package db.lab4.DAO.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.model.implementation.MaxWaterConsumption;
import db.lab4.model.implementation.Noozle;
import db.lab4.persistance.ConnectionManager;

import java.sql.*;
import java.util.List;
import java.util.LinkedList;

public class NoozleDAO implements GeneralDAOInterface<Noozle, Integer> {
    private static final String GET_ALL = "SELECT * FROM mydb.noozle";
    private static final String GET_BY_ID = "SELECT * FROM mydb.noozle WHERE id=?";
    private static final String CREATE = "INSERT mydb.noozle"
            + "(id,cordinates,diamter,max_water_consumption_id VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE mydb.noozle"
            + "SET cordinates=?,diamter=?,max_water_consumption_id=?  WHERE id=? ";
    private static final String DELETE = "DELETE FROM mydb.noozle WHERE id=?";

    @Override
    public final List<Noozle> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Noozle> noozles = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String cordinates = resultSet.getString(2);
                    String diametr = resultSet.getString(3);
                    Integer max_water_consumption_id = resultSet.getInt(4);
                    noozles.add(new Noozle(id, cordinates, diametr, max_water_consumption_id));

                }

            }

        }
        return noozles;
    }

    @Override
    public final Noozle getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Noozle noozle = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String cordinates = resultSet.getString(2);
                    String diametr = resultSet.getString(3);
                    Integer max_water_consumption_id = resultSet.getInt(4);
                    noozle = new Noozle(foundId, cordinates, diametr, max_water_consumption_id);
                }
            }
        }
        return noozle;
    }

    @Override
    public final int create(final Noozle entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getCordinates());
            ps.setString(3, entity.getDiametr());
            ps.setInt(4, entity.getMaxWaterConsumptionId());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Noozle entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getCordinates());
            ps.setString(2, entity.getDiametr());
            ps.setInt(3, entity.getMaxWaterConsumptionId());
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
