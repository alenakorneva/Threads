package parking;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ParkingRunner {
    public static void main(String[] args) {
        //1 - кол-во ресурсов, к к-м одновременно может быть предоставлен доступ
        //потокам исполнения
        //true - разрешение предоставляется вызывающим потоков в том порядке, в к-м они запрашивают
        Semaphore semaphore = new Semaphore(1, true);
        //создание объектов Car и запуск соответствующих потоков
        List<Car> cars = new ArrayList<>() {{
            add(new Car(semaphore, 1, "AUDI", "1275"));
            add(new Car(semaphore, 2, "BMW", "3402"));
            add(new Car(semaphore,3, "JEEP", "9547"));
            add(new Car(semaphore, 4, "VOLKSWAGEN", "1353"));
            add(new Car(semaphore,5, "HYUNDAI", "9603"));
            add(new Car(semaphore, 6, "HONDA", "8734"));
            add(new Car(semaphore, 7, "JAGUAR", "3399"));
            add(new Car(semaphore, 8, "LAMBORGHINI", "0475"));
        }};
    }
}
