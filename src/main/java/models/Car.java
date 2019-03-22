package models;

import daos.DTO;

public class Car implements DTO {

    private String make;
    private String model;
    private int year;
    private String color;
    private String vin;
    private int ID;

    public Car(String make, String model, int year, String color, String vin, int ID) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vin = vin;
        this.ID = ID;
    }

    public Car() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getId() {
        return ID;
    }

    public void setId(int Id){
        this.ID = Id;
    }

}
