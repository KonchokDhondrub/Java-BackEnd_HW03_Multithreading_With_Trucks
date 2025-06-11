package ait.elevator;

import ait.elevator.model.Elevator;
import ait.elevator.task.Truck;

import java.util.Arrays;

public class ElevatorAppl {
    private static final int N_TRUCK = 10_000;
    private static final int N_RACES = 20;
    private static final int CAPACITY = 10;
    private static final int ELEVATORS_AMOUNT = 2;

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime(); /// Timer Start

        ///  Creating Silos
        Elevator[] elevators = new Elevator[ELEVATORS_AMOUNT];
        for (int i = 0; i < elevators.length; i++) {
            elevators[i] = new Elevator("V. I. Lenin " + (i + 1) + ": ");
        }

        /// Preparing Trucks
        Truck[] trucks = new Truck[N_TRUCK];
        for (int i = 0; i < trucks.length; i++) {
            trucks[i] = new Truck(i, N_RACES, CAPACITY, elevators);
        }

        ///  Starting process
        Thread[] threads = new Thread[trucks.length];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(trucks[i]);
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        /// Result print
        Arrays.stream(elevators).forEach(el -> System.out.printf( "%s: %.2f\n",el.getName(), el.getCurrentVolume()));

        /// Running time logger
        long end = System.nanoTime(); /// Timer Ends
        System.out.println("Lead time: " + (end - start) / 1_000_000 + " ms");
    }
}
