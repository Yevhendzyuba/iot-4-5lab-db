package db.lab4.service.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.DAO.implementation.DataOfSensorsHasPersonInformationDAO;
import db.lab4.model.implementation.DataOfSensorsHasPersonInformation;

public class DataOfSensorsHasPersonInformationService extends GeneralService<DataOfSensorsHasPersonInformation> {

    public GeneralDAOInterface<DataOfSensorsHasPersonInformation,Integer> dataOfSensorsHasPersonInformationDAO = new DataOfSensorsHasPersonInformationDAO();

    @Override
    public GeneralDAOInterface<DataOfSensorsHasPersonInformation,Integer> getDAO(){
        return dataOfSensorsHasPersonInformationDAO;
    }
}
