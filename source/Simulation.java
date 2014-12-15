import java.util.*;
import java.io.*;
public class Simulation {

    public static void main(String [] args) {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("properties.data"));
        } catch (IOException e) {
            System.out.println(e);
        }

        int delay = Integer.parseInt(p.getProperty("delay"));
        int steps = Integer.parseInt(p.getProperty("steps"));

        TrafficSystem ts = new TrafficSystem();
        ts.print();

        for (int n=0; n<steps; ++n) {
            try {
                Thread.sleep(delay);
            } catch(Exception e) {

            }

            ts.step();
            ts.print();
        }


        ts.printStatistics();
    }
}


