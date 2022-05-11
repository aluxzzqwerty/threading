package parking;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class WaitingCars {
    protected List<Autopark> parkings;
    public static ArrayBlockingQueue<Car> waitingCars;
    private int numberOfCars;

    public WaitingCars(int numberOfCars, int numberOfParkings) {
        this.numberOfCars = numberOfCars;
        this.parkings = new ArrayList<>();
        this.waitingCars = new ArrayBlockingQueue<>(numberOfCars);
        for (int i = 0; i < numberOfParkings; i++) {
            parkings.add(new Autopark("AutoPark #" + i));
        }
    }

    public void addCarsToWaitingList() {
        for (int i = 0; i < numberOfCars; i++) {
            try {
                waitingCars.put(new Car("Car #" + i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void startParking() {
        for (Autopark parking : parkings) {
            new Thread(parking).start();
        }
    }
}
