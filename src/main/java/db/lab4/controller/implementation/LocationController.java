package db.lab4.controller.implementation;

import db.lab4.model.implementation.Location;
import db.lab4.service.GeneralServiceInterface;
import db.lab4.service.implementation.GeneralService;
import db.lab4.service.implementation.LocationService;

public class LocationController extends GeneralController<Location> {

    private final GeneralService<Location> locationService = new LocationService();

    @Override
    public final GeneralServiceInterface<Location> getService() {
        return locationService;
    }
}
