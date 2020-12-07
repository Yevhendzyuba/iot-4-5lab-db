package db.lab4.DAO.implementation;

import db.lab4.model.implementation.DataOfSensors;


public class DataOfSensorsDAO extends GeneralDAO<DataOfSensors> {

    @Override
    public final Class<DataOfSensors> getClazz(){
        return DataOfSensors.class;
    }


}

