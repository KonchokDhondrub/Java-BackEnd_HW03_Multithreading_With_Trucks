package ait.elevator.task;

import ait.elevator.model.Elevator;

public class Truck implements Runnable {
    private int nRaces;
    private double capacity;
    private static Elevator[] elevators;

    public Truck(int nRaces, int capacity, Elevator[] elevators) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevators = elevators;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            for (int j = 0; j < elevators.length; j++) {
                synchronized (elevators[j]) {
                    elevators[j].add(capacity / elevators.length);
//                    System.out.println("Round: " + (j < 10 ? ("0" + j) : j) + " @ " + elevators[j].getName());
                }
            }
        }
    }
}
