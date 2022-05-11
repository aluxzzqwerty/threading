package parking;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Autopark implements Runnable {
    private String autoparkName;
    public static final int maxSizeOfParking = 10;
    public int countOfCars;
    private ArrayBlockingQueue<Car> carsInParking;

    public String getAutoparkName() {
        return autoparkName;
    }

    public Autopark(String parkingName) {
        this.autoparkName = parkingName;
        this.carsInParking = new ArrayBlockingQueue<>(maxSizeOfParking);
    }

    @Override
    public void run() {
        while (countOfCars++ < maxSizeOfParking) {
            try {
                Thread.sleep(2000);
                Car car = WaitingCars.waitingCars.poll();
                car.parkCar(this.getAutoparkName());
                carsInParking.offer(car, 1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            catch (NullPointerException e) {
                System.out.println("Process finished");
            }
        }
    }
}
