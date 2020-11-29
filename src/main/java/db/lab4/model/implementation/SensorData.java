package db.lab4.model.implementation;

import db.lab4.model.GeneralModelInterface;

public class SensorData implements GeneralModelInterface {
    private Integer id;
    private String time;
    private String lightning;
    private String temperature;
    private String humidity;
    private Integer locationId;

    public SensorData(Integer id, String time, String lightning, String temperature, String humidity, Integer locationId) {
        this.id = id;
        this.time = time;
        this.lightning = lightning;
        this.temperature = temperature;
        this.humidity = humidity;
        this.locationId = locationId;


    }

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

    public String getLightning() {
        return lightning;
    }

    public void setLightning(String lightning) {
        this.lightning = lightning;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", lightning='" + lightning + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", locationId=" + locationId +
                '}';
    }
}
