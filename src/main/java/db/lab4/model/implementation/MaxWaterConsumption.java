package db.lab4.model.implementation;

import db.lab4.model.GeneralModelInterface;

public class MaxWaterConsumption implements GeneralModelInterface {
    private Integer id;
    private String time;
    private String power;
    private String litres;

    public MaxWaterConsumption(Integer id, String time, String power, String litres) {
        this.id = id;
        this.time = time;
        this.power = power;
        this.litres = litres;
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

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getLitres() {
        return litres;
    }

    public void setLitres(String litres) {
        this.litres = litres;
    }

    @Override
    public String toString() {
        return "MaxWaterConsumption{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", power='" + power + '\'' +
                ", litres='" + litres + '\'' +
                '}';
    }
}
