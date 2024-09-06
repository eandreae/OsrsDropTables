package WeightTables;

public class Main {
    public static void main(String[] args) {

        // All Raids
        int NUM_RAIDS = 1;
        // Chambers
        int COX_POINTS = 7000000;
        int PARTY_SIZE = 8;
        // ToA
        //int TOA_INVOCATION = 300;

        CoX.runCoX(COX_POINTS, NUM_RAIDS, PARTY_SIZE);
        //r.run(PURPLE_CHANCE, NUM_RAIDS, RAID);
    }
}
