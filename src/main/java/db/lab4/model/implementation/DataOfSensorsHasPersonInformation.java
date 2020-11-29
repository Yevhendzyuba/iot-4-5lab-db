package db.lab4.model.implementation;

import db.lab4.model.GeneralModelInterface;

public class DataOfSensorsHasPersonInformation implements GeneralModelInterface {
    private Integer dataOfSensorsId;
    private Integer personInformationId;

    public DataOfSensorsHasPersonInformation(Integer dataOfSensorsId, Integer personInformationId) {
        this.dataOfSensorsId = dataOfSensorsId;
        this.personInformationId = personInformationId;
    }

    public Integer getDataOfSensorsId() {
        return dataOfSensorsId;
    }

    public void setDataOfSensorsId(Integer dataOfSensorsId) {
        this.dataOfSensorsId = dataOfSensorsId;
    }

    public Integer getPersonInformationId() {
        return personInformationId;
    }

    public void setPersonInformationId(Integer personInformationId) {
        this.personInformationId = personInformationId;
    }

    @Override
    public String toString() {
        return "DataOfSensorsHasPersonInformation{" +
                "dataOfSensorsId=" + dataOfSensorsId +
                ", personInformationId=" + personInformationId +
                '}';
    }

    @Override
    public Integer getId() {
        return null;
    }
}
