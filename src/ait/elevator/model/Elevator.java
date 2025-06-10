package ait.elevator.model;

public class Elevator {
    private String name;
    private double currentVolume;

    public Elevator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public double getCurrentVolume() {
        return currentVolume;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void add(double portion){
        currentVolume = currentVolume + portion;
    }
}
