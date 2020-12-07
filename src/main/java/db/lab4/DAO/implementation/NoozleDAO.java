package db.lab4.DAO.implementation;

import db.lab4.model.implementation.Noozle;


public class NoozleDAO extends GeneralDAO<Noozle> {

    @Override
    public final Class<Noozle> getClazz() {
        return Noozle.class;
    }


}
