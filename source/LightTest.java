import org.junit.*;
import static org.junit.Assert.*;

public class LightTest {
    @Test
    public void createLightTest() {
        Light light = new Light(5, 3);
        assertTrue(light.isGreen());
        assertTrue(light.toString().equals("Green"));
    }

    @Test
    public void stepLightTest() {
        this.testLightCycle(5, 3);
        this.testLightCycle(15, 3);
        this.testLightCycle(12, 3);
        this.testLightCycle(3, 3);
    }

    public void testLightCycle(int period, int green) {

        Light light = new Light(period, green);

        for (int i = 0; i < 5; ++i) {
            for (int n = 0; n<green; ++n) {
                assertTrue(light.isGreen());
                light.step();
            }

            for (int n = 0; n<(period-green+1); ++n) {
                assertFalse(light.isGreen());
                light.step();
            }
        }
    }
}
