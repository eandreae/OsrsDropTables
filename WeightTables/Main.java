package WeightTables;

public class Main {
    public static void main(String[] args) {
        Runner r = new Runner();

        // All Raids
        int NUM_RAIDS = 10;
        // Chambers
        int COX_POINTS = 85000;
        int PARTY_SIZE = 1;
        // ToA
        //int TOA_INVOCATION = 300;

        r.runCoX(COX_POINTS, NUM_RAIDS, PARTY_SIZE);
        //r.run(PURPLE_CHANCE, NUM_RAIDS, RAID);
    }
}
