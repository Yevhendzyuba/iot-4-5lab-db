package db.lab4.DAO.implementation;

import db.lab4.model.implementation.MaxWaterConsumption;


public class MaxWaterConsumptionDAO extends GeneralDAO<MaxWaterConsumption> {

    @Override
    public final Class<MaxWaterConsumption> getClazz() {
        return MaxWaterConsumption.class;
    }


}
