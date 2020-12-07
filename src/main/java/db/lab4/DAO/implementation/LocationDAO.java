package db.lab4.DAO.implementation;

import db.lab4.model.implementation.Location;


public class LocationDAO extends GeneralDAO<Location> {

    @Override
    public final Class<Location> getClazz() {
        return Location.class;
    }

}
