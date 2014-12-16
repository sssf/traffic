import org.junit.*;
import static org.junit.Assert.*;


public class LaneTest {

    @Test
    public void createLaneTest() {
        Lane lane = new Lane(3);
        assertTrue(lane.getFirst() == null);
        assertTrue(lane.firstCar() == null);
        assertTrue(lane.lastFree());
        lane.putLast(new Car(10, 5));
        assertFalse(lane.lastFree());

    }

    @Test
    public void StepLaneTest() {
        Lane lane = new Lane(3);
        assertTrue(lane.firstCar() == null);
        assertTrue(lane.getFirst() == null);
        assertTrue(lane.lastFree());

        Car c = new Car(10, 5);

        // [ null, null, car ]
        lane.putLast(c);
        assertTrue(lane.firstCar() == null);
        assertTrue(lane.getFirst() == null);
        assertFalse(lane.lastFree());

        // [ null, car, null ]
        lane.step();
        assertTrue(lane.firstCar() == null);
        assertTrue(lane.getFirst() == null);
        assertTrue(lane.lastFree());

        // [ car, null, null ]
        lane.step();
        assertTrue(lane.firstCar() == c);
        assertTrue(lane.getFirst() == c);
        assertTrue(lane.firstCar() == null);
        assertTrue(lane.lastFree());
    }

    @Test
    public void overflowLaneTest() {
        Lane lane = new Lane(3);
        assertTrue(lane.firstCar() == null);
        assertTrue(lane.getFirst() == null);
        assertTrue(lane.lastFree());

        lane.putLast(new Car(1337, 42));
        try {
            lane.putLast(new Car(1337, 42));
            assertTrue(false && false && false);
        } catch (Lane.OverflowException e) {
            assertTrue(true && true && true);
        }
        lane.step();

        try {
            lane.putLast(new Car(1337, 42));
            assertTrue(true && true && true);
        } catch (Lane.OverflowException e) {
            assertTrue(false && false && false);
        }

    }

}
