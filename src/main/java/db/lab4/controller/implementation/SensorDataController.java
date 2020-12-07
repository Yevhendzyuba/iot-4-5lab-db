package db.lab4.controller.implementation;

import db.lab4.model.implementation.SensorData;
import db.lab4.service.GeneralServiceInterface;
import db.lab4.service.implementation.GeneralService;
import db.lab4.service.implementation.SensorDataService;

public class SensorDataController extends GeneralController<SensorData> {
    private final GeneralService<SensorData> sensorDataService = new SensorDataService();

    @Override
    public final GeneralServiceInterface<SensorData> getService() {
        return sensorDataService;
    }
}
