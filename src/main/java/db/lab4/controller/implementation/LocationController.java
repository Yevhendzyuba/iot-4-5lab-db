package db.lab4.controller.implementation;

import db.lab4.model.implementation.Location;
import db.lab4.service.implementation.GeneralService;
import db.lab4.service.implementation.LocationService;

public class LocationController extends GeneralController<Location> {
    public static final LocationService locationService = new LocationService();

    @Override
    public GeneralService<Location> getService() {
        return locationService;
    }
}
