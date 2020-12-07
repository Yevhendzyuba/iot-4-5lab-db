package db.lab4.model.implementation;

import db.lab4.model.GeneralModelInterface;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "data_of_sensors", schema = "mydb", catalog = "")
public class DataOfSensors implements GeneralModelInterface {
    private Integer id;
    private String time;
    private SensorData sensorDataBySensorDataId;
    private Noozle noozleByNoozleId;


    public DataOfSensors() {

    }

    public DataOfSensors(final Integer id, final String time, final SensorData sensorDataBySensorDataId, final Noozle noozleByNoozleId) {
        this.id = id;
        this.time = time;
        this.sensorDataBySensorDataId = sensorDataBySensorDataId;
        this.noozleByNoozleId = noozleByNoozleId;
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

    @ManyToOne
    @JoinColumn(name = "noozle_id", referencedColumnName = "id", nullable = false)
    public Noozle getNoozleByNoozleId() {
        return noozleByNoozleId;
    }

    public void setNoozleByNoozleId(Noozle noozleByNoozleId) {
        this.noozleByNoozleId = noozleByNoozleId;
    }

    @ManyToOne
    @JoinColumn(name = "sensor_data_id", referencedColumnName = "id", nullable = false)
    public SensorData getSensorDataBySensorDataId() {
        return sensorDataBySensorDataId;
    }

    public void setSensorDataBySensorDataId(SensorData sensorDataBySensorDataId) {
        this.sensorDataBySensorDataId = sensorDataBySensorDataId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataOfSensors that = (DataOfSensors) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(time, that.time);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time);
    }

    @Override
    public String toString() {
        return "DataOfSensord{" +
                "id=" + id +
                ", time=" + time +
                ", noozleId=" + noozleByNoozleId +
                ", sensorDataId=" + sensorDataBySensorDataId +
                '}';
    }

}
