package db.lab4.service.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.DAO.implementation.DataOfSensorsDAO;
import db.lab4.model.implementation.DataOfSensors;

public class DataOfSensorsService extends GeneralService<DataOfSensors> {
    private final GeneralDAOInterface<DataOfSensors> DATA_OF_SENSORS_DAO = new DataOfSensorsDAO();

    @Override
    public GeneralDAOInterface<DataOfSensors> getDAO() {
        return DATA_OF_SENSORS_DAO;
    }

}
