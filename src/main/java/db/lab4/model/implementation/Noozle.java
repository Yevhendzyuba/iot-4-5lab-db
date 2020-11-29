package db.lab4.model.implementation;

import db.lab4.model.GeneralModelInterface;

public class Noozle implements GeneralModelInterface {
    private Integer id;
    private String cordinates;
    private String diametr;
    private Integer maxWaterConsumptionId;

    public Noozle(Integer id, String cordinates, String diametr, Integer maxWaterConsumptionId) {
        this.id = id;
        this.cordinates = cordinates;
        this.diametr = diametr;
        this.maxWaterConsumptionId = maxWaterConsumptionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCordinates() {
        return cordinates;
    }

    public void setCordinates(String cordinates) {
        this.cordinates = cordinates;
    }

    public String getDiametr() {
        return diametr;
    }

    public void setDiametr(String diametr) {
        this.diametr = diametr;
    }

    public Integer getMaxWaterConsumptionId() {
        return maxWaterConsumptionId;
    }

    public void setMaxWaterConsumptionId(Integer maxWaterConsumptionId) {
        this.maxWaterConsumptionId = maxWaterConsumptionId;
    }

    @Override
    public String toString() {
        return "Noozle{" +
                "id=" + id +
                ", cordinates='" + cordinates + '\'' +
                ", diametr='" + diametr + '\'' +
                ", maxWaterConsumptionId=" + maxWaterConsumptionId +
                '}';
    }
}
