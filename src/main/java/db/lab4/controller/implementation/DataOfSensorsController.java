package db.lab4.controller.implementation;

import db.lab4.model.implementation.DataOfSensors;
import db.lab4.service.GeneralServiceInterface;
import db.lab4.service.implementation.DataOfSensorsService;
import db.lab4.service.implementation.GeneralService;

public class DataOfSensorsController extends GeneralController<DataOfSensors> {

    private final GeneralService<DataOfSensors> dataOfSensorsService = new DataOfSensorsService();

    @Override
    public final GeneralServiceInterface<DataOfSensors> getService() {
        return dataOfSensorsService;
    }
}
