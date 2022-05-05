package airport;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class AirportRunner {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1, true);
        ArrayList<Plane> planes = new ArrayList<>() {{
            //создано 10 самолетов
            add(new Plane(semaphore, 1, "Airbus А321сео"));
            add(new Plane(semaphore, 2, "Boeing 737-200"));
            /*add(new Plane(semaphore, 3, "C-130"));
            add(new Plane(semaphore, 4, "MC 21-300"));
            add(new Plane(semaphore, 5, "Boeing 737-700"));
            add(new Plane(semaphore, 6, "Super jet 100"));
            add(new Plane(semaphore, 7, "T-160"));
            add(new Plane(semaphore, 8, "Boeing 747-8"));
            add(new Plane(semaphore, 9, "S-3 A/B Viking"));
            add(new Plane(semaphore, 10, "MH-53 Sea Dragon"));*/
        }};
    }
}
