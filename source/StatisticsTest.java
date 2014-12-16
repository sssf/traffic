import org.junit.*;
import static org.junit.Assert.*;


public class StatisticsTest {

    @Test
    public void statisticsTest() {
        Statistics s = new Statistics();

        assertTrue(s.getNumTurned() == 0); s.turned(5);
        assertTrue(s.getNumTurned() == 1); s.turned(10);
        assertTrue(s.getNumTurned() == 2); s.turned(15);
        assertTrue(s.getNumTurned() == 3);

        assertTrue(s.getAverageTurnTime() == 10);

        assertTrue(s.getNumStraight() == 0); s.straight(13);
        assertTrue(s.getNumStraight() == 1); s.straight(11);
        assertTrue(s.getNumStraight() == 2); s.straight(10);
        assertTrue(s.getNumStraight() == 3); s.straight(9);
        assertTrue(s.getNumStraight() == 4); s.straight(7);
        assertTrue(s.getNumStraight() == 5);

        assertTrue(s.getAverageStraightTime() == 10);

        assertTrue(s.getNumAdded() == 0);
        for (int n = 0; n<16; ++n) {
            assertTrue(s.getNumAdded() == n);
            s.numAdded();
            assertTrue(s.getNumAdded() == n+1);
        }

        assertTrue(s.getSystemFull() == 0); s.systemFull();
        assertTrue(s.getSystemFull() == 1); s.systemFull();
        assertTrue(s.getSystemFull() == 2);

        assertTrue(s.getTotalPassed() == 8);
        assertTrue(s.getStillInSystem() == 8);
    }
}
