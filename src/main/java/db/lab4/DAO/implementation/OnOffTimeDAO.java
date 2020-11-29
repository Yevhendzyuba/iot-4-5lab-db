package db.lab4.DAO.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.model.implementation.DataOfSensors;
import db.lab4.model.implementation.OnOffTime;
import db.lab4.persistance.ConnectionManager;

import java.sql.*;
import java.util.List;
import java.util.LinkedList;

public class OnOffTimeDAO implements GeneralDAOInterface<OnOffTime, Integer> {
    private static final String GET_ALL = "SELECT * FROM mydb.on_off_time";
    private static final String GET_BY_ID = "SELECT * FROM mydb.on_off_time WHERE id=?";
    private static final String CREATE = "INSERT mydb.on_off_time"
            + "(id, on_time,off_time) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE mydb.on_off_time"
            + "SET on_time=?,off_time=? WHERE id=? ";
    private static final String DELETE = "DELETE FROM mydb.on_off_time WHERE id=?";

    @Override
    public final List<OnOffTime> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<OnOffTime> onOffTimes = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String on_time = resultSet.getString(2);
                    String off_time = resultSet.getString(3);
                    onOffTimes.add(new OnOffTime(id, on_time, off_time));

                }

            }

        }
        return onOffTimes;
    }

    @Override
    public final OnOffTime getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        OnOffTime onOffTime = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String on_time = resultSet.getString(2);
                    String off_time = resultSet.getString(3);
                    onOffTime = new OnOffTime(foundId, on_time, off_time);
                }
            }
        }
        return onOffTime;
    }

    @Override
    public final int create(final OnOffTime entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getOnTime());
            ps.setString(3, entity.getOffTime());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final OnOffTime entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getOnTime());
            ps.setString(2, entity.getOffTime());
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
