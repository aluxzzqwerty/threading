package parking;

public class Main {
    public static void main(String[] args) {
        WaitingCars waitingCars = new WaitingCars(15, 2);
        waitingCars.addCarsToWaitingList();
        waitingCars.startParking();
    }
}
