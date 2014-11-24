
public class Lane {

    public static class OverflowException extends RuntimeException {
        // Undantag som kastas när det inte gick att lägga 
        // in en ny bil på vägen
        public OverflowException(String message) {
            super(message);
        }
    }

    private Car[] theLane;

    public Lane(int n) {
	// Konstruerar ett Lane-objekt med plats för n fordon
        theLane = new Car[n];
    }

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

    public Car getFirst() {
	// Returnera och tag bort bilen som står först
        Car car = this.theLane[0];
        this.theLane[0] = null;
        return car;
    }

    public Car firstCar() {
	// Returnera bilen som står först utan att ta bort den
        return this.theLane[0];
    }


    public boolean lastFree() {
	// Returnera true om sista platsen ledig, annars false
        return (this.theLane[this.theLane.length - 1] == null);
    }

    public void putLast(Car c) throws OverflowException {
	// Ställ en bil på sista platsen på vägen
	// (om det går).
        if (this.theLane[this.theLane.length - 1] == null) {
            //TODO: skriv något bätte då, bror
            throw new OverflowException("för många bilar bror");
        }
    }

    public String toString() {
        String lane = "";
        for (int i = 0; i < this.theLane.length; i++) {
           for (int j = 0; j < 4; j++) {
               lane += "=";
           }
        }
        lane += "\n";
        for (int i = 0; i < this.theLane.length; i++) {
            lane += " ";
            lane += "car";
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
    }
}
