package parking;

public class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void parkCar(String parkingName) {
        System.out.println(this.name + " is parking in " + parkingName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name + " ends parking");
    }

}
