
public class Car {

    private int bornTime;
    private int destination; // 1 för rakt fram, 2 för vänstersväng

    // konstruktor och get-metoder
    /**
     *  Constructor for Car
     *  @param bornTime the time the car was created
     *  @param destination the destination of the car
     */
    public Car(int bornTime, int destination) {
        this.bornTime = bornTime;
        this.destination = destination;
    }

    /**
     *  @return the time of creation of the car
     */
    public int getBornTime() {
        return this.bornTime;
    }

    /**
     *  @return the destination of the car
     */
    public int getDestination() {
        return this.destination;
    }
    
    /**
     *  @return string representation of the car
     */
    public String toString() {
        return "Born time:\n\t" + bornTime + "Destination:\n\t" + destination;
    }

}
