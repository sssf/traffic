import java.util.*;

class Statistics {
    private int numTurned;
    private int numStraight;
    private int numAdded;
    private int systemFull;
    private List<Integer> timeTurned   = new ArrayList<Integer>();
    private List<Integer> timeStraight = new ArrayList<Integer>();


    public int getNumTurned() {
        return this.numTurned;
    }


    public int getNumStraight() {
        return this.numStraight;
    }


    public int getNumAdded() {
        return this.numAdded;
    }


    public int getSystemFull() {
        return this.systemFull;
    }

    public int getAverageTurnTime() {
        return calculateAverageTime(this.timeTurned);
    }

    public int getAverageStraightTime() {
        return calculateAverageTime(this.timeStraight);
    }

    public int getStillInSystem() {
        return this.numAdded - this.numStraight - this.numTurned;
    }

    public int getTotalPassed() {
        return this.numStraight + this.numTurned;
    }
    /**
     * Increases the count for how many times a car have turned and keeps a log of the time when a car turned
     * @param time the time for when the car turned
     */
    public void turned(int time) {
        this.numTurned++;
        this.timeTurned.add(time);
    }

    /**
     *  Increases the count for how mant times a car went straight and keeps a log of the time when a car went straight
     *  @param time the time for when the car turned
     */
    public void straight(int time) {
        this.numStraight++;
        this.timeStraight.add(time);
    }

    /**
     *  Keeps track of the number of times a car enters the lane.
     */
    public void numAdded() {
        this.numAdded++;
    }

    /**
     *  Keeps track of the number of times a car tries to enter the lane but the lane is full
     */
    public void systemFull() {
        this.systemFull++;
    }


    private int calculateAverageTime(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum / ((list.size() == 0) ? 1 : list.size());
    }

    /**
     *  prints statistics
     */
    public void print() {
        System.out.println("=========================================");
        System.out.println(" STATISTICS");
        System.out.println("=========================================");
        System.out.println("number turned          " + this.numTurned);
        System.out.println("average turned time:   " + this.calculateAverageTime(this.timeTurned));
        System.out.println("");
        System.out.println("number straight:       " + this.numStraight);
        System.out.println("average straight time: " + this.calculateAverageTime(this.timeStraight));
        System.out.println("");
        System.out.println("system full:           " + this.systemFull);
        System.out.println("");
        System.out.println("still in system:       " + (this.numAdded - this.numStraight - this.numTurned));
        System.out.println("total added:           " + (this.numAdded));
        System.out.println("total passed:          " + (this.numStraight + this.numTurned));
    }
}
