package airport;

import java.util.concurrent.Semaphore;

public class Plane implements Runnable {
    Semaphore semaphore;
    private final int id;
    private final String model;

    public Plane(Semaphore semaphore, int id, String model) {
        this.semaphore = semaphore;
        this.id = id;
        this.model = model;
        //поток запускается при создании экземпляра класса
        new Thread(this).start();
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void run() {
        // 1
        System.out.println("Airplane " + id + " has started moving to running line.");
        try {
            semaphore.acquire();
                //3
                System.out.println("The line has received the plane " + id);
                //2
                System.out.println("The plane " + id + " has took off");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            //4
            System.out.println("The running line is available");
        }
    }

    @Override
    public String toString() {
        return "Plane{" +
                "semaphore=" + semaphore +
                ", id=" + id +
                ", model='" + model + '\'' +
                '}';
    }
}
