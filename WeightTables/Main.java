package WeightTables;

public class Main {
    public static void main(String[] args) {
        Runner r = new Runner();

        // All Raids
        int NUM_RAIDS = 5;
        // Chambers
        int COX_POINTS = 60000;
        // ToA
        //int TOA_INVOCATION = 300;

        r.runCoX(COX_POINTS, NUM_RAIDS);
        //r.run(PURPLE_CHANCE, NUM_RAIDS, RAID);
    }
}
