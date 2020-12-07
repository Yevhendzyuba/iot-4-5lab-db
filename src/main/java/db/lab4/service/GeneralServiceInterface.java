package db.lab4.service;

import db.lab4.DAO.GeneralDAOInterface;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public interface GeneralServiceInterface<T> {
    GeneralDAOInterface<T> getDAO();

    List<T> getAll(Session session) throws SQLException;

    T getById(Integer id, Session session) throws SQLException;

    void create(T entity, Session session) throws SQLException;

    void update(T entity, Session session) throws SQLException;

    void delete(Integer id, Session session) throws SQLException;


}
