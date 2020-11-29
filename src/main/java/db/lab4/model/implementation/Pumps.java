package db.lab4.model.implementation;

import db.lab4.model.GeneralModelInterface;

public class Pumps implements GeneralModelInterface {
    private Integer id;
    private String area;
    private String amountOfWater;
    private Integer onOffTimeId;

    public Pumps(Integer id, String area, String amountOfWater, Integer onOffTimeId) {
        this.id = id;
        this.area = area;
        this.amountOfWater = amountOfWater;
        this.onOffTimeId = onOffTimeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAmountOfWater() {
        return amountOfWater;
    }

    public void setAmountOfWater(String amountOfWater) {
        this.amountOfWater = amountOfWater;
    }

    public Integer getOnOffTimeId() {
        return onOffTimeId;
    }

    public void setOnOffTimeId(Integer onOffTimeId) {
        this.onOffTimeId = onOffTimeId;
    }

    @Override
    public String toString() {
        return "Pumps{" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", amountOfWater=" + amountOfWater +
                ", onOffTimeId=" + onOffTimeId +
                '}';
    }
}
