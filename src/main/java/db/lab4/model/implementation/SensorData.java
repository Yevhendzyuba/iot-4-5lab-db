package db.lab4.model.implementation;

import db.lab4.model.GeneralModelInterface;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
@Entity
@Table(name = "sensor_data",schema = "mydb",catalog = "")
public class SensorData implements GeneralModelInterface {
    private Integer id;
    private String time;
    private String lightning;
    private String temperature;
    private String humidity;
    private Location locationByLocationId;
    private Collection<DataOfSensors> dataOfSensorsById;

    public SensorData() {

    }

    public SensorData(Integer id, String time, String lightning, String temperature, String humidity, Location locationByLocationId) {
        this.id = id;
        this.time = time;
        this.lightning = lightning;
        this.temperature = temperature;
        this.humidity = humidity;
        this.locationByLocationId = locationByLocationId;


    }

    public SensorData(final Integer id, final String time, final String lightning, final String temperature, final String humidity, final Location locationId, final Collection<DataOfSensors> dataOfSensorsById) {
        this.id = id;
        this.time = time;
        this.lightning = lightning;
        this.temperature = temperature;
        this.humidity = humidity;
        this.locationByLocationId = locationId;
        this.dataOfSensorsById = dataOfSensorsById;

    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "lightning")
    public String getLightning() {
        return lightning;
    }

    public void setLightning(String lightning) {
        this.lightning = lightning;
    }

    @Basic
    @Column(name = "temperature")
    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Basic
    @Column(name = "humidity")
    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
    public Location getLocationByLocationId() {
        return locationByLocationId;
    }

    public void setLocationByLocationId(Location locationByLocationId) {
        this.locationByLocationId = locationByLocationId;
    }

    @OneToMany(mappedBy = "sensorDataBySensorDataId")
    public Collection<DataOfSensors> getDataOfSensorsById() {
        return dataOfSensorsById;
    }

    public void setDataOfSensorsById(Collection<DataOfSensors> dataOfSensorsById) {
        this.dataOfSensorsById = dataOfSensorsById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SensorData that = (SensorData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(time, that.lightning) &&
                Objects.equals(temperature, that.temperature) &&
                Objects.equals(humidity, that.humidity) &&
                Objects.equals(locationByLocationId, that.locationByLocationId);


    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, temperature, humidity, locationByLocationId);
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", lightning='" + lightning + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", locationId=" + locationByLocationId +
                '}';
    }
}
