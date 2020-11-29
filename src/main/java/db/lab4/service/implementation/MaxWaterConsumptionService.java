package db.lab4.service.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.DAO.implementation.MaxWaterConsumptionDAO;
import db.lab4.model.implementation.MaxWaterConsumption;

public class MaxWaterConsumptionService extends GeneralService<MaxWaterConsumption> {
    public GeneralDAOInterface<MaxWaterConsumption, Integer> maxWaterConsumptionDAO = new MaxWaterConsumptionDAO();

    @Override
    public GeneralDAOInterface<MaxWaterConsumption, Integer> getDAO() {
        return maxWaterConsumptionDAO;
    }
}
