package ait.elevator.task;

import ait.elevator.model.Elevator;

public class Truck implements Runnable {
    private int nr;
    private int nRaces;
    private double capacity;
    private static Elevator[] elevators;

    public Truck(int nr, int nRaces, int capacity, Elevator[] elevators) {
        this.nr = nr;
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevators = elevators;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            if (nr % 2 == 0) {
                for (int j = 0; j < elevators.length ; j++) {
                    synchronized (elevators[j]) {
                        elevators[j].add(capacity / elevators.length);
//                    System.out.println("Round: " + (j < 10 ? ("0" + j) : j) + " @ " + elevators[j].getName());
                    }
                }
            } else {
                for (int j = (elevators.length - 1); j >= 0; j--) {
                    synchronized (elevators[j]) {
                        elevators[j].add(capacity / elevators.length);
//                    System.out.println("Round: " + (j < 10 ? ("0" + j) : j) + " @ " + elevators[j].getName());
                    }
                }
            }
        }
    }
}
