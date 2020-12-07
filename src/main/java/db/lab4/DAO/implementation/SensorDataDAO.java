package db.lab4.DAO.implementation;

import db.lab4.model.implementation.SensorData;

public class SensorDataDAO extends GeneralDAO<SensorData> {

    @Override
    public final Class<SensorData> getClazz() {
        return SensorData.class;
    }


}
