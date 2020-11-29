package db.lab4.model.implementation;

import db.lab4.model.GeneralModelInterface;

public class DataOfSensors implements GeneralModelInterface {
    private Integer id;
    private String time;
    private Integer sensorDataId;
    private Integer pumpsId;
    private Integer noozleId;
    private Integer dateId;

    public DataOfSensors(Integer id, String time, Integer sensorDataId, Integer pumpsId, Integer noozleId, Integer dateId) {
        this.id = id;
        this.time = time;
        this.sensorDataId = sensorDataId;
        this.pumpsId = pumpsId;
        this.noozleId = noozleId;
        this.dateId = dateId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getSensorDataId() {
        return sensorDataId;
    }

    public void setSensorDataId(Integer sensorDataId) {
        this.sensorDataId = sensorDataId;
    }

    public Integer getPumpsId() {
        return pumpsId;
    }

    public void setPumpsId(Integer pumpsId) {
        this.pumpsId = pumpsId;
    }

    public Integer getNoozleId() {
        return noozleId;
    }

    public void setNoozleId(Integer noozleId) {
        this.noozleId = noozleId;
    }

    public Integer getDateId() {
        return dateId;
    }

    public void setDateId(Integer dateId) {
        this.dateId = dateId;
    }

    @Override
    public String toString() {
        return "DataOfSensord{" +
                "id=" + id +
                ", time=" + time +
                ", sensorDataId=" + sensorDataId +
                ", pumpsId=" + pumpsId +
                ", noozleId=" + noozleId +
                ", dateId=" + dateId +
                '}';
    }
}
