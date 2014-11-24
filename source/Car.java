
public class Car {

    private int bornTime;
    private int destination; // 1 för rakt fram, 2 för vänstersväng

    // konstruktor och get-metoder
    public Car(int bornTime, int destination) {
        this.bornTime = bornTime;
        this.destination = destination;
    }

    public int getBornTime() {
        return this.bornTime;
    }


    public int getDestination() {
        return this.destination;
    }

    public String toString() {
        return "Born time:\n\t" + bornTime + "Destination:\n\t" + destination;
    }

}
