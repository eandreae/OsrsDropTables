package WeightTables;

public class Main {
    public static void main(String[] args) {


        // Universal
        int NUM_KILLS = 1000;
        boolean SHOW_NORMAL_LOOT = false;
        // Chambers
        int COX_POINTS = 570000;
        int PARTY_SIZE = 1;
        // DT2
        String Duke = "Duke";
        String Leviathan = "Leviathan";
        String Whisperer = "Whisperer";
        String Vardorvis = "Vardorvis";
        //int TOA_INVOCATION = 300;

        //CoX.runCoX(COX_POINTS, NUM_KILLS, PARTY_SIZE, SHOW_NORMAL_LOOT);
        //CoX.getTbowChance(COX_POINTS);

        DT2.simulateBoss(Leviathan, NUM_KILLS, SHOW_NORMAL_LOOT);
    }
}
