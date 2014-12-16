import org.junit.*;
import static org.junit.Assert.*;


public class CarTest {

    @Test
    public void CreateCarTest() {
        Car c1 = new Car(10, 2);
        assertTrue(c1.getBornTime() == 10);
        assertTrue(c1.getDestination() == 2);

        Car c2 = new Car(0, 1);
        assertTrue(c2.getBornTime() == 0);
        assertTrue(c2.getDestination() == 1);
    }
}
