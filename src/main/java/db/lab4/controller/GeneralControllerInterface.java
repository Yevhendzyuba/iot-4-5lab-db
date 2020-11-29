package db.lab4.controller;

import db.lab4.service.GeneralServiceInterface;

import java.sql.SQLException;

public interface GeneralControllerInterface<T> {
    void create(T entity) throws SQLException;

    void update(T entity) throws SQLException;

    void delete(int id) throws SQLException;

    void getAll() throws SQLException;

    void getById(int id) throws SQLException;

    GeneralServiceInterface<T> getService();
}
