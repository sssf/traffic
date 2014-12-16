import java.util.*;
import java.io.*;

public class TrafficSystem {
    // Definierar de vägar och signaler som ingår i det
    // system som skall studeras.
    // Samlar statistik

    // Attribut som beskriver beståndsdelarna i systemet
    private Lane  r0;
    private Lane  r1;
    private Lane  r2;
    private Light s1;
    private Light s2;
    private Statistics stats = new Statistics();

    // Diverse attribut för simuleringsparametrar (ankomstintensiteter,
    // destinationer...)

    // Diverse attribut för statistiksamling

    private int time = 0;
    private Random r = new Random();
    private int frequency = 0;

    /**
     *  Constructor for TrafficSystem
     */
    public TrafficSystem() {
        Properties p = readParameters("properties.data");

        r0 = new Lane(Integer.parseInt(p.getProperty("AtoB")));
        r1 = new Lane(Integer.parseInt(p.getProperty("BtoC")));
        r2 = new Lane(Integer.parseInt(p.getProperty("Turn")));

        int period = Integer.parseInt(p.getProperty("period"));
        int green  = Integer.parseInt(p.getProperty("green"));

        s1 = new Light(period, green);
        s2 = new Light(period, green);

        this.frequency  = Integer.parseInt(p.getProperty("frequency"));
    }

    /**
     *  reads a file with the parameters for the simulation
     *  @param filename the filename containing the paramaters for the simulation
     *  @return Properties with the parameters
     */
    public Properties readParameters(String filename) {
	// Läser in parametrar för simuleringen
	// Metoden kan läsa från terminalfönster, dialogrutor
	// eller från en parameterfil. Det sista alternativet
	// är att föredra vid uttestning av programmet eftersom
	// man inte då behöver mata in värdena vid varje körning.
        // Standardklassen Properties är användbar för detta.

        Properties p = new Properties();
        try {
            p.load(new FileInputStream(filename));
        } catch (IOException e) {
            System.out.println(e);
        }
        return p;
    }

    /**
     *  Steps the simulation
     */
    public void step() {
	// Stega systemet ett tidssteg m h a komponenternas step-metoder
	// Skapa bilar, lägg in och ta ur på de olika Lane-kompenenterna

        time++;
        s1.step();
        s2.step();

        Car car = null;
        if (s1.isGreen()) {
            car = r1.getFirst();
            if (car != null) {
                stats.straight(this.time - car.getBornTime());
            }
        }
        if (s2.isGreen()){
            car = r2.getFirst();
            if (car != null) {
                stats.turned(this.time - car.getBornTime());
            }
        }
        r1.step();
        r2.step();

        Car c = r0.firstCar();
        Lane to = null;
        if (c != null && c.getDestination() == 1) {
            to = r1;
        } else {
            to = r2;
        }

        if (to.lastFree()) {
            to.putLast(r0.getFirst());
        }
        r0.step();
        if (r.nextInt(100) > this.frequency) {
            if (r0.lastFree()) {
                r0.putLast(new Car(time, r.nextInt(100)%2 + 1));
                stats.numAdded();
            } else {
                stats.systemFull();
            }
        }


    }

    /**
     *  Prints the statistics for the simulation
     */
    public void printStatistics() {
	// Skriv statistiken samlad så här långt
        stats.print();
    }

    /**
     *  prints the simulated crossing.
     */
    public void print() {
	// Skriv ut en grafisk representation av kösituationen
	// med hjälp av klassernas toString-metoder
        System.out.println("A -> B");
        System.out.println(r0);
        System.out.println("B -> C");
        System.out.println(r1);
        System.out.println("turn");
        System.out.println(r2);
        //System.out.println("light 1");
        System.out.println(s1);
        //System.out.println("light 2");
        System.out.println(s2);
    }

}

