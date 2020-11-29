package db.lab4.DAO.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.model.implementation.DataOfSensors;
import db.lab4.model.implementation.PersonInformation;
import db.lab4.persistance.ConnectionManager;

import java.sql.*;
import java.util.List;
import java.util.LinkedList;

public class PersonInformationDAO implements GeneralDAOInterface<PersonInformation, Integer> {
    private static final String GET_ALL = "SELECT * FROM mydb.person_information";
    private static final String GET_BY_ID = "SELECT * FROM mydb.person_information WHERE id=?";
    private static final String CREATE = "INSERT mydb.person_information"
            + "(id, name,surname,lastname) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE mydb.person_information"
            + "SET  name=?,surname=?,lastname=? WHERE id=? ";
    private static final String DELETE = "DELETE FROM mydb.person_information WHERE id=?";

    @Override
    public final List<PersonInformation> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<PersonInformation> personInformations = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String surname = resultSet.getString(3);
                    String lastname = resultSet.getString(4);
                    personInformations.add(new PersonInformation(id, name, surname, lastname));

                }

            }

        }
        return personInformations;
    }

    @Override
    public final PersonInformation getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        PersonInformation personInformation = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String surname = resultSet.getString(3);
                    String lastname = resultSet.getString(4);
                    personInformation = new PersonInformation(foundId, name, surname, lastname);
                }
            }
        }
        return personInformation;
    }

    @Override
    public final int create(final PersonInformation entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getSurname());
            ps.setString(4, entity.getLastName());


            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final PersonInformation entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getSurname());
            ps.setString(3, entity.getLastName());
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
