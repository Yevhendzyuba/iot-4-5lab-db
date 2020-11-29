package db.lab4.DAO.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.model.implementation.DataOfSensors;
import db.lab4.model.implementation.Date;
import db.lab4.model.implementation.Location;
import db.lab4.persistance.ConnectionManager;

import java.sql.*;
import java.util.List;
import java.util.LinkedList;

public class LocationDAO implements GeneralDAOInterface<Location, Integer> {
    private static final String GET_ALL = "SELECT * FROM mydb.location";
    private static final String GET_BY_ID = "SELECT * FROM mydb.location WHERE id=?";
    private static final String CREATE = "INSERT mydb.location"
            + "(id, section,number,subscription VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE mydb.location"
            + "SET section=?,number=?,subscription=? WHERE id=? ";
    private static final String DELETE = "DELETE FROM mydb.location WHERE id=?";

    @Override
    public final List<Location> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Location> locations = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String section = resultSet.getString(2);
                    String number = resultSet.getString(3);
                    String subscription = resultSet.getString(4);
                    locations.add(new Location(id, section, number, subscription));

                }

            }

        }
        return locations;
    }

    @Override
    public final Location getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Location location = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String section = resultSet.getString(2);
                    String number = resultSet.getString(3);
                    String subscription = resultSet.getString(4);
                    location = new Location(foundId, section, number, subscription);
                }
            }
        }

        return location;
    }

    @Override
    public final int create(final Location entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getSection());
            ps.setString(3, entity.getNumber());
            ps.setString(4, entity.getSubscription());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Location entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getSection());
            ps.setString(3, entity.getNumber());
            ps.setString(4, entity.getSubscription());

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
