package WeightTables;

import java.util.HashMap;

import com.google.errorprone.annotations.Var;

public class Main {
    public static void main(String[] args) throws Exception {

        String COX_LOOT_IMAGE_PATH = "WeightTables\\CoxLoot.png";
        String DT2_LOOT_IMAGE_PATH = "WeightTables\\DT2Loot.png";
        String IMAGE_FILE_FORMAT = "png";

        // Universal
        int NUM_KILLS = 4000; 
        // Chambers
        int COX_POINTS = 30000;
        int PARTY_SIZE = 1;
        // DT2
        String Duke = "Duke";
        String Leviathan = "Leviathan";
        String Whisperer = "Whisperer";
        String Vardorvis = "Vardorvis";
        //int TOA_INVOCATION = 300;

        //HashMap<String, Integer> test = CoX.runCoX(NUM_KILLS, COX_POINTS, PARTY_SIZE);
        //String imageTest = ImageGenerator.GenerateLootImage(test, COX_LOOT_IMAGE_PATH, IMAGE_FILE_FORMAT);

        HashMap<String, Integer> test = DT2.simulateBoss(Whisperer, NUM_KILLS);
        String imageTest = ImageGenerator.GenerateLootImage(test, DT2_LOOT_IMAGE_PATH, IMAGE_FILE_FORMAT);
        

        //HashMap<String, Integer> test = CoX.runCoX(NUM_KILLS, COX_POINTS, PARTY_SIZE);

        //System.out.println(test.toString());

        //CoX.runCoX(NUM_KILLS, COX_POINTS, PARTY_SIZE, SHOW_NORMAL_LOOT);
        //CoX.getTbowChance(COX_POINTS)
        //DT2.simulateBoss(Vardorvis, NUM_KILLS, SHOW_NORMAL_LOOT);
    }
}
