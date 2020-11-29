package db.lab4.service.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.DAO.implementation.SensorDataDAO;
import db.lab4.model.implementation.SensorData;

public class SensorDataService extends GeneralService<SensorData> {
    public GeneralDAOInterface<SensorData, Integer> sensorDataDAO = new SensorDataDAO();

    @Override
    public GeneralDAOInterface<SensorData, Integer> getDAO() {
        return sensorDataDAO;
    }
}
