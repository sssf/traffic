
public class Lane {

    public static class OverflowException extends RuntimeException {
        // Undantag som kastas när det inte gick att lägga
        // in en ny bil på vägen
        public OverflowException(String message) {
            super(message);
        }
    }

    private Car[] theLane;
    /**
        Constructor for Lane
        @param n Number of available slots for cars
     */
    public Lane(int n) {
	// Konstruerar ett Lane-objekt med plats för n fordon
        theLane = new Car[n];
    }

    /**
        Moves all vehicles one step forward, the vehicle in front is removed from the lane
     */
    public void step() {
	// Stega fram alla fordon (utom det på plats 0) ett steg
        // (om det går). (Fordonet på plats 0 tas bort utifrån
	// mm h a metoden nedan.)
        for (int i = 1; i < theLane.length; ++i)
        {
            if (this.theLane[i-1] == null) {
                this.theLane[i-1] = this.theLane[i];
                this.theLane[i] = null;
            }
        }

    }
    /**
        Get the first car in the lane and remove it
        @return The first car in the lane.
    */
    public Car getFirst() {
	// Returnera och tag bort bilen som står först
        Car car = this.theLane[0];
        this.theLane[0] = null;
        return car;
    }
    /**
        Returns the first car in the lane without removing it
        @return The first car in the lane
     */
    public Car firstCar() {
	// Returnera bilen som står först utan att ta bort den
        return this.theLane[0];
    }

    /**
        Checks if the last slot in the lane is free
        @return true if the last slot in the lane is free, false otherwhise
    */
    public boolean lastFree() {
	// Returnera true om sista platsen ledig, annars false
        return (this.theLane[this.theLane.length - 1] == null);
    }

    /**
        Adds a new car to the end of the lane
        @param c The car to add to the end of the lane.
        @throws OverflowException if lane is full
     */
    public void putLast(Car c) throws OverflowException {
	// Ställ en bil på sista platsen på vägen
	// (om det går).
        if (this.theLane[this.theLane.length - 1] != null) {
            //TODO: skriv något bätte då, bror
            throw new OverflowException("för många bilar bror");
        }
        this.theLane[this.theLane.length - 1] = c;
    }

    /**
        @return String representation of the lane
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.theLane.length; i++) {
            sb.append("====");
        }
        sb.append("\n");
        for (int i = 0; i < this.theLane.length; i++) {
            if (this.theLane[i] != null) {
                sb.append(" car");
            } else {
                sb.append("    ");
            }
        }
        sb.append("\n");
        for (int i = 0; i < this.theLane.length; i++) {
            sb.append("- - ");
        }

        sb.append("\n");
        for (int i = 0; i < this.theLane.length; i++) {
            sb.append("====");
        }
        sb.append("\n");

        return sb.toString();

        /*
        String lane = "";
        for (int i = 0; i < this.theLane.length; i++) {
           for (int j = 0; j < 4; j++) {
               lane += "=";
           }
        }
        lane += "\n";
        for (int i = 0; i < this.theLane.length; i++) {
            lane += " ";
            if (this.theLane[i] != null) {
                lane += "car";
            } else {
                lane += "   ";
            }
        }
        lane += "\n";
        for (int i = 0; i < this.theLane.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (!(j % 2 != 0)){
                    lane += "-";
                }
                if (!(j % 2 == 0)) {
                    lane += " ";
                }
            }
        }
        lane += "\n";
        lane += "\n";
        for (int i = 0; i < this.theLane.length; i++) {
           for (int j = 0; j < 4; j++) {
               lane += "=";
           }
        }
        lane += "\n";
        return lane;
        */
    }
}
