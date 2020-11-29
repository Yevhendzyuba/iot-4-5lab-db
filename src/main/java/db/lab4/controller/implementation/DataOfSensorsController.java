package db.lab4.controller.implementation;

import db.lab4.model.implementation.DataOfSensors;
import db.lab4.service.implementation.DataOfSensorsService;
import db.lab4.service.implementation.GeneralService;

public class DataOfSensorsController extends GeneralController<DataOfSensors> {

    public static final DataOfSensorsService dataOfSensorsService = new DataOfSensorsService();

    @Override
    public GeneralService<DataOfSensors> getService() {
        return dataOfSensorsService;
    }
}
