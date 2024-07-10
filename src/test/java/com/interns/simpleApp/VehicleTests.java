package com.interns.simpleApp;

public class VehicleTests {

    private String storage;
    private String type;
    private String fuel;
    private String size;

    public void setStorage(String storage) {
        this.storage = storage;
    }
    public String getStorage() {
        return storage;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
    public String getFuel() {
        return fuel;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getSize() {
        return size;
    }

    public String toString(){
        return "Storage: " + storage + ", Type: " + type + ", Fuel: " + fuel + ", Size: " + size;
    }
}
