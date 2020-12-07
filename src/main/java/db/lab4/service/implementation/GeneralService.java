package db.lab4.service.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.service.GeneralServiceInterface;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public abstract class GeneralService<T> implements GeneralServiceInterface<T> {

    @Override
    public abstract GeneralDAOInterface<T> getDAO();

    @Override
    public List<T> getAll(Session session) throws SQLException {
        return getDAO().getAll(session);
    }

    @Override
    public T getById(Integer id, Session session) throws SQLException {
        return (T) getDAO().getById(id, session);
    }

    @Override
    public void create(T entity, Session session) throws SQLException {
        getDAO().create(entity, session);
    }

    @Override
    public void update(T entity, Session session) throws SQLException {
        getDAO().update(entity, session);
    }

    @Override
    public void delete(Integer id, Session session) throws SQLException {
        getDAO().delete(id, session);
    }

}
