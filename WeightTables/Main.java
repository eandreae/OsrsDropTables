package WeightTables;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {


        // Universal
        int NUM_KILLS = 100; 
        // Chambers
        int COX_POINTS = 30000;
        int PARTY_SIZE = 1;
        // DT2
        String Duke = "Duke";
        String Leviathan = "Leviathan";
        String Whisperer = "Whisperer";
        String Vardorvis = "Vardorvis";
        //int TOA_INVOCATION = 300;

        HashMap<String, Integer> test = CoX.runCoX(NUM_KILLS, COX_POINTS, PARTY_SIZE);

        System.out.println(test.toString());

        //CoX.runCoX(NUM_KILLS, COX_POINTS, PARTY_SIZE, SHOW_NORMAL_LOOT);
        //CoX.getTbowChance(COX_POINTS)
        //DT2.simulateBoss(Vardorvis, NUM_KILLS, SHOW_NORMAL_LOOT);
    }
}
