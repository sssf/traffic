import java.util.*;

class Statistics {
    private int numTurned;
    private int numStraight;
    private int numAdded;
    private int systemFull;
    private List<Integer> timeTurned   = new ArrayList<Integer>();
    private List<Integer> timeStraight = new ArrayList<Integer>();


    public void turned(int time) {
        this.numTurned++;
        this.timeTurned.add(time);
    }

    public void straight(int time) {
        this.numStraight++;
        this.timeStraight.add(time);
    }

    public void numAdded() {
        this.numAdded++;
    }

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
