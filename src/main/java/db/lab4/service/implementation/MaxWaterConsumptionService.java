package db.lab4.service.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.DAO.implementation.MaxWaterConsumptionDAO;
import db.lab4.model.implementation.MaxWaterConsumption;

public class MaxWaterConsumptionService extends GeneralService<MaxWaterConsumption> {
    private final GeneralDAOInterface<MaxWaterConsumption> MAX_WATER_CONSUMPTION_DAO = new MaxWaterConsumptionDAO();

    @Override
    public GeneralDAOInterface<MaxWaterConsumption> getDAO() {
        return MAX_WATER_CONSUMPTION_DAO;
    }
}
