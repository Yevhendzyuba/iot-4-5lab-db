package db.lab4.service.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.DAO.implementation.SensorDataDAO;
import db.lab4.model.implementation.SensorData;

public class SensorDataService extends GeneralService<SensorData> {
    private final GeneralDAOInterface<SensorData> SENSOR_DATA_DAO = new SensorDataDAO();

    @Override
    public GeneralDAOInterface<SensorData> getDAO() {
        return SENSOR_DATA_DAO;
    }
}
