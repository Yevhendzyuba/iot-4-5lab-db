package db.lab4.controller.implementation;

import db.lab4.model.implementation.SensorData;
import db.lab4.service.implementation.GeneralService;
import db.lab4.service.implementation.SensorDataService;

public class SensorDataController extends GeneralController<SensorData>{
    public static final SensorDataService sensorDataService = new SensorDataService();

    @Override
    public GeneralService<SensorData> getService(){
        return sensorDataService;
    }
}
