package db.lab4.controller.implementation;

import db.lab4.model.implementation.DataOfSensorsHasPersonInformation;
import db.lab4.service.implementation.DataOfSensorsHasPersonInformationService;
import db.lab4.service.implementation.GeneralService;

public class DataOfSensorsHasPersonInformationController extends GeneralController<DataOfSensorsHasPersonInformation> {


    public static final DataOfSensorsHasPersonInformationService dataOfSensorsHasPersonInformationService = new DataOfSensorsHasPersonInformationService();

    @Override
    public GeneralService<DataOfSensorsHasPersonInformation> getService() {
        return dataOfSensorsHasPersonInformationService;
    }
}
