package WeightTables;

public class Main {
    public static void main(String[] args) {


        // All Raids
        int NUM_RAIDS = 100;
        // Chambers
        int COX_POINTS = 570000;
        int PARTY_SIZE = 1;
        boolean SHOW_NORMAL_LOOT = false;
        // ToA
        //int TOA_INVOCATION = 300;

        CoX.runCoX(COX_POINTS, NUM_RAIDS, PARTY_SIZE, SHOW_NORMAL_LOOT);
        CoX.getTbowChance(COX_POINTS);
        //r.run(PURPLE_CHANCE, NUM_RAIDS, RAID);
        //Duke.run(NUM_RAIDS);
        //Leviathan.run(NUM_RAIDS);
        //Vardorvis.run(NUM_RAIDS);
        //Whisperer.run(NUM_RAIDS);
    }
}
