package db.lab4.controller.implementation;

import db.lab4.controller.GeneralControllerInterface;
import db.lab4.model.GeneralModelInterface;
import db.lab4.service.implementation.GeneralService;

import java.sql.SQLException;
import java.util.List;

public abstract class GeneralController<T extends GeneralModelInterface> implements GeneralControllerInterface<T> {

    @Override
    public abstract GeneralService<T> getService();

    @Override
    public void create(T entity) throws SQLException {
        getService().create(entity);
        System.out.println("Entity has been created now");
        System.out.println(entity);
    }

    @Override
    public void update(T entity) throws SQLException {
        getService().update(entity);
        System.out.println("Entity has been updated now");
        System.out.println(entity.getId());
    }

    @Override
    public void delete(int id) throws SQLException {
        getService().delete(id);
        System.out.println("Entity has been deleted now");
    }

    @Override
    public void getAll() throws SQLException {
        List<T> ts = getService().getAll();
        for (T t : ts) {
            System.out.println(t);
        }
    }

    @Override
    public void getById(int id) throws SQLException {
        T t = getService().getById(id);
        if (t != null) {
            System.out.println("Entity with id " + id + "found");
            System.out.println(t);
        } else {
            System.out.println("Entity with id " + id + "not found");
        }
    }
}
