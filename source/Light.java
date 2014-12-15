
public class Light {
    private int period;
    private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...
    private int green; // Signalen grön när time<green 

    public Light(int period, int green) {
        this.period = period;
        this.green = green;
    }

    public void step() { 
        //TODO: Micael wrote this, so its probably wrong, get someone not retarded to fix it
        // Stegar fram klocka ett steg
        time = (time < period) ? ++time : 0;
        System.out.println("light time: " + time);
    }

    public boolean isGreen()   {
        // Returnerar true om time<green, annars false
        return (this.time < this.green);
    }

    public String  toString()  {
        return isGreen() ? "Green" : "Red";
    }

}

