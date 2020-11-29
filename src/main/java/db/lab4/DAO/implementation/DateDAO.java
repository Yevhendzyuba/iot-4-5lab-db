package db.lab4.DAO.implementation;

import db.lab4.DAO.GeneralDAOInterface;

import db.lab4.model.implementation.DataOfSensors;
import db.lab4.model.implementation.Date;
import db.lab4.persistance.ConnectionManager;

import java.util.LinkedList;
import java.sql.*;
import java.util.List;

public class DateDAO implements GeneralDAOInterface<Date, Integer> {

    private static final String GET_ALL = "SELECT * FROM mydb.date";
    private static final String GET_BY_ID = "SELECT * FROM mydb.date WHERE id=?";
    private static final String CREATE = "INSERT mydb.date"
            + "(id,from,to) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE mydb.date"
            + "SET from=?,to=? WHERE id=? ";
    private static final String DELETE = "DELETE FROM mydb.date WHERE id=?";

    @Override
    public final List<Date> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Date> dates = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {

                    Integer id = resultSet.getInt(1);
                    String from = resultSet.getString(2);
                    String to = resultSet.getString(3);
                    dates.add(new Date(id, from, to));
                }
            }
        }
        return dates;
    }

    @Override
    public final Date getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Date date = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String from = resultSet.getString(2);
                    String to = resultSet.getString(3);
                    date = new Date(foundId, from, to);
                }
            }

        }
        return date;
    }

    @Override
    public final int create(final Date entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getFrom());
            ps.setString(3, entity.getTo());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Date entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getFrom());
            ps.setString(2, entity.getTo());
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
