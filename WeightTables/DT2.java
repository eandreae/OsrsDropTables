package WeightTables;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DT2 {
    
    public static String DT2_UNIQUES_PATH = "WeightTables\\DT2Uniques.json";
    public static String VIRTUS_PATH = "WeightTables\\Virtus.json";

    public static boolean HAS_TABLET = false; // Default false.
    public static int VESTIGE_ROLLS = 0; // default 0.

    public static void simulateBoss(String InputBossName, int numKills, boolean ShowNormalLoot)
    {
        JSONParser parser = new JSONParser();
        JSONArray BossArray = null;
        JSONArray UniversalDT2Uniques = null;
        JSONArray VirtusTable = null;

        try
        {
            String DT2_BOSS_PATH = ("WeightTables\\" + InputBossName + ".json");
            BossArray = (JSONArray) parser.parse(new FileReader(DT2_BOSS_PATH));
            UniversalDT2Uniques = (JSONArray) parser.parse(new FileReader(DT2_UNIQUES_PATH));
            VirtusTable = (JSONArray) parser.parse(new FileReader(VIRTUS_PATH));
        }
        catch (IOException | ParseException e)
        {
            System.out.println("Invalid Boss Name");
        }

        JSONObject BossUniques = (JSONObject) BossArray.get(0);
        String loot = null;

        Long PC = (Long) BossUniques.get("Pet Chance");
        int PetChance = PC.intValue();
        String PetName = (String) BossUniques.get("Pet Name");
        
        Random rand = new Random();
        int roll;

        System.out.println("The Player killed " + InputBossName + " " + numKills + " times, receiving: ");
        
        for (int i = 1; i <= numKills; i++)
        {
            // Regular Loot
            loot = rollDT2Loot(BossUniques, UniversalDT2Uniques, VirtusTable);
            // Check for Pet
            roll = rand.nextInt(PetChance+1);
            if ((loot.equals("Normal Loot") || loot.equals("Supply Drop")) && !ShowNormalLoot)
            {
                // Print nothing for normal loot, still check pet.
                if (roll == PetChance)
                {
                    System.out.println(PetName + " at killcount: " + i);
                }

            }
            else 
            {
                if (roll == PetChance)
                {
                    System.out.println(loot + " & " + PetName + " at killcount: " + i);
                }
                else 
                {
                    System.out.println(loot + " at killcount: " + i);
                }
            }
        }
    }

    public static String rollDT2Loot(JSONObject BossUniques, JSONArray UniversalUniques, JSONArray VirtusTable)
    {
        String output;
        Random rand = new Random();
        int roll;

        // First, check if the loot roll is a Unique
        Long UC = (Long) BossUniques.get("Unique Chance");
        int UniqueChance = UC.intValue();

        roll = rand.nextInt(UniqueChance+1);
        if (roll == UniqueChance)
        {
            // Roll the Unique Table
            JSONObject Unique = WeightFunctions.rollItem(UniversalUniques);
            String name = (String) Unique.get("name");

            // Check if the Unique is a Vestige Roll
            if (name.equals("Vestige Roll"))
            {
                VESTIGE_ROLLS++;
                if (VESTIGE_ROLLS >= 3)
                {
                    VESTIGE_ROLLS = 0;
                    return output = (String) BossUniques.get("Vestige Name");
                }
                return output = name;
            }

            // Check if the Unique is a Virtus Piece
            if (name.equals("Virtus Piece"))
            {
                // Roll the Virtus Table
                JSONObject VirtusPiece = WeightFunctions.rollItem(VirtusTable);
                return output = (String) VirtusPiece.get("name");
            }

            // Check if the Unique was the Axe Piece
            if (name.equals("Axe Piece"))
            {
                return output = (String) BossUniques.get("Axe Piece Name");
            }

            // Return Chromium Ingot
            return output = name;
        }

        // Next, roll for the Orb
        Long OC = (Long) BossUniques.get("Orb Chance");
        int OrbChance = OC.intValue();

        roll = rand.nextInt(OrbChance+1);
        if (roll == OrbChance) {return output = "Awakener's Orb";}

        // Next, roll for the Tablet
        if (!HAS_TABLET)
        {
            Long TC = (Long) BossUniques.get("Tablet Chance");
            int TabletChance = TC.intValue();

            roll = rand.nextInt(TabletChance+1);
            if (roll == TabletChance)
            {
                HAS_TABLET = true;
                return output = (String) BossUniques.get("Tablet Name");
            }
        }

        // Next, roll for the Quartz
        Long QC = (Long) BossUniques.get("Quartz Chance");
        int QuartzChance = QC.intValue();

        roll = rand.nextInt(QuartzChance+1);
        if (roll == QuartzChance)
        {
            return output = (String) BossUniques.get("Quartz Name");
        }
        
        // Next, roll for Supply Drop
        Long SC = (Long) BossUniques.get("Supply Chance");
        int SupplyChance = SC.intValue();

        roll = rand.nextInt(SupplyChance+1);
        if (roll == SupplyChance) {return output = "Supply Drop";}
        
        // Finally, return Normal Loot.
        return output = "Normal Loot";
    }
}
