package db.lab4.service.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.DAO.implementation.LocationDAO;
import db.lab4.model.implementation.Location;

public class LocationService extends GeneralService<Location> {
    private final GeneralDAOInterface<Location> LOCATION_DAO = new LocationDAO();

    @Override
    public GeneralDAOInterface<Location> getDAO() {
        return LOCATION_DAO;

    }
}
