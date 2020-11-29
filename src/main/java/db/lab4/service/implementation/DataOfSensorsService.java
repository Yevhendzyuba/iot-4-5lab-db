package db.lab4.service.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.DAO.implementation.DataOfSensorsDAO;
import db.lab4.model.implementation.DataOfSensors;

public class DataOfSensorsService extends GeneralService<DataOfSensors> {
    public GeneralDAOInterface<DataOfSensors, Integer> dataOfSensorsDAO = new DataOfSensorsDAO();

    @Override
    public GeneralDAOInterface<DataOfSensors, Integer> getDAO() {
        return dataOfSensorsDAO;
    }

}
