package db.lab4.model.implementation;

import db.lab4.model.GeneralModelInterface;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "noozle", schema = "mydb", catalog = "")
public class Noozle implements GeneralModelInterface {
    private Integer id;
    private String cordinates;
    private String diametr;
    private MaxWaterConsumption maxWaterConsumptionByMaxWaterConsumptionId;
    private Collection<DataOfSensors> dataOfSensorsById;

    public Noozle() {

    }

    public Noozle(Integer id, String cordinates, String diametr, MaxWaterConsumption maxWaterConsumptionByMaxWaterConsumptionId) {
        this.id = id;
        this.cordinates = cordinates;
        this.diametr = diametr;
        this.maxWaterConsumptionByMaxWaterConsumptionId = maxWaterConsumptionByMaxWaterConsumptionId;
    }

    public Noozle(final Integer id, final String cordinates, final String diametr, final MaxWaterConsumption maxWaterConsumptionByMaxWaterConsumptionId, final Collection<DataOfSensors> dataOfSensorsById) {
        this.id = id;
        this.cordinates = cordinates;
        this.diametr = diametr;
        this.maxWaterConsumptionByMaxWaterConsumptionId = maxWaterConsumptionByMaxWaterConsumptionId;
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
    @Column(name = "cordinates")
    public String getCordinates() {
        return cordinates;
    }

    public void setCordinates(String cordinates) {
        this.cordinates = cordinates;
    }

    @Basic
    @Column(name = "diametr")
    public String getDiametr() {
        return diametr;
    }

    public void setDiametr(String diametr) {
        this.diametr = diametr;
    }

    @ManyToOne
    @JoinColumn(name = "max_water_consumption_id", referencedColumnName = "id", nullable = false)
    public MaxWaterConsumption getMaxWaterConsumptionByMaxWaterConsumptionId() {
        return maxWaterConsumptionByMaxWaterConsumptionId;
    }

    public void setMaxWaterConsumptionByMaxWaterConsumptionId(MaxWaterConsumption maxWaterConsumptionByMaxWaterConsumptionId) {
        this.maxWaterConsumptionByMaxWaterConsumptionId = maxWaterConsumptionByMaxWaterConsumptionId;
    }

    @OneToMany(mappedBy = "noozleByNoozleId")
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
        Noozle that = (Noozle) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(cordinates, that.cordinates) &&
                Objects.equals(diametr, that.diametr) &&
                Objects.equals(maxWaterConsumptionByMaxWaterConsumptionId, that.maxWaterConsumptionByMaxWaterConsumptionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cordinates, diametr, maxWaterConsumptionByMaxWaterConsumptionId);
    }


    @Override
    public String toString() {
        return "Noozle{" +
                "id=" + id +
                ", cordinates='" + cordinates + '\'' +
                ", diametr='" + diametr + '\'' +
                ", maxWaterConsumptionId=" + maxWaterConsumptionByMaxWaterConsumptionId +
                '}';
    }
}
