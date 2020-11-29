package db.lab4.model.implementation;

import db.lab4.model.GeneralModelInterface;

public class PersonInformation implements GeneralModelInterface {
    private Integer id;
    private String name;
    private String surname;
    private String lastName;

    public PersonInformation(Integer id, String name, String surname, String lastName) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "PersonInformation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
