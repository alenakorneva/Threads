package parking;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car implements Runnable {
    private Semaphore carSemaphore;
    private final int id;
    private final String model;
    private final String registrationNumber;

    public Car(Semaphore carSemaphore, int id, String model, String registrationNumber) {
        this.carSemaphore = carSemaphore;
        this.id = id;
        this.model = model;
        this.registrationNumber = registrationNumber;
        //поток запускается при создании экземпляра класса Car
        new Thread(this).start();
    }

    public Integer getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carSemaphore=" + carSemaphore +
                ", id=" + id +
                ", model='" + model + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }

    @Override
    public void run() {
        System.out.println("parking.Car " + model + " " + registrationNumber + " launch");
        try {
            if (carSemaphore.tryAcquire(1, TimeUnit.MILLISECONDS)) {
                System.out.println("parking.Car " + model + " " + registrationNumber + " has got permission to take parking place");
                Thread.sleep(100);
                System.out.println("parking.Car " + model + " " + registrationNumber + " is leaving parking place");
            } else {
                System.out.println("parking.Car " + model + " " + registrationNumber + " is leaving Parking Place after wasting 1 sec");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            carSemaphore.release();
        }
    }
}
