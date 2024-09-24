package WeightTables;
import java.util.Random;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CoX {

    public static int lootRolls = 2;
    public static int cappedPoints = 570000;
    public static int purpleLimit = 6;
    public static int accuracy = 100; // More 0s, more accurate purple chance. Default 100.
    public static double purpleRate = 8676.0;

    public static String COX_UNIQUES_PATH = "WeightTables\\CoxUniques.json";
    public static String COX_GENERICS_PATH = "WeightTables\\CoxGenerics.json";

    public static String runCoX(int numRaids, int raidPoints, int partySize, boolean normLoot)
    {
        String output = "";
        JSONParser parser = new JSONParser();
        JSONArray CoxUniques = null;
        JSONArray CoxGenerics = null;
        JSONObject Purple = null;
        Random rand = new Random();
        int checkPurple;
        int purpleWeight;
        int totalPWeight = accuracy * accuracy;
        int cappedRolls;
        int remainingPoints;
        int totalLoots;
        int totalPurples;

        try
        {
            CoxUniques = (JSONArray) parser.parse(new FileReader(COX_UNIQUES_PATH));
            CoxGenerics = (JSONArray) parser.parse(new FileReader(COX_GENERICS_PATH));
        }
        catch (IOException | ParseException e)
        {
            System.out.println("Invalid File Setup");
        }
        
        System.out.println(numRaids + " raids, each with " + raidPoints + " points, in a party of " + partySize);
        output += (numRaids + " raids, each with " + raidPoints + " points, in a party of " + partySize + "\n");
        for (int i = 1; i <= numRaids; i++)
        {
            totalLoots = 0;
            totalPurples = 0;
            cappedRolls = raidPoints / cappedPoints;
            remainingPoints = raidPoints % cappedPoints;

            // No more purples than the purple limit may be rolled.
            if(cappedRolls > purpleLimit){cappedRolls = purpleLimit;}
            
            while(cappedRolls >= 1 && totalLoots < partySize && totalPurples < purpleLimit)
            {
                // Roll purple using capped points.
                purpleWeight = (int)Math.ceil(accuracy * (cappedPoints / purpleRate));
                checkPurple = rand.nextInt(totalPWeight + 1);
                if (checkPurple <= purpleWeight)
                {
                    // Award purple
                    System.out.print("Player " + (totalLoots+1) + ": ");
                    output += ("Player " + (totalLoots+1) + ": ");

                    Purple = WeightFunctions.rollItem(CoxUniques);
                    String name = (String) Purple.get("name");

                    System.out.print("Purple: " + name + " at killcount: " + i + "\n");
                    output += ("Purple: " + name + " at killcount: " + i + "\n");
                    
                    totalLoots++;
                    totalPurples++;
                }
                cappedRolls -= 1;
            }

            if(totalLoots < partySize)
            {
                // Roll purple using the remaining points.
                while(partySize - totalLoots > 0)
                {
                    if(totalPurples <= 0 && totalPurples < purpleLimit)
                    {
                        purpleWeight = (int)Math.ceil(accuracy * ((remainingPoints/partySize) / purpleRate));
                        checkPurple = rand.nextInt(totalPWeight + 1);
                        if (checkPurple <= purpleWeight)
                        {
                            System.out.print("Player " + (totalLoots+1) + ": ");
                            output += ("Player " + (totalLoots+1) + ": ");

                            Purple = WeightFunctions.rollItem(CoxUniques);
                            String name = (String) Purple.get("name");

                            System.out.print("Purple: " + name + " at killcount: " + i + "\n");
                            output += ("Purple: " + name + " at killcount: " + i + "\n");

                            totalLoots++;
                            totalPurples++;
                        }
                        else
                        {
                            if(normLoot)
                            {
                                System.out.print("Player " + (totalLoots+1) + ": ");
                                output += ("Player " + (totalLoots+1) + ": ");
                                output += rollLootCoX(i, raidPoints/partySize, CoxGenerics);
                            }
                            totalLoots++;
                        }
                    }
                    else
                    {
                        if(normLoot)
                        {
                            System.out.print("Player " + (totalLoots+1) + ": ");
                            output += ("Player " + (totalLoots+1) + ": ");
                            output += rollLootCoX(i, raidPoints/partySize, CoxGenerics);
                        }
                        totalLoots++;
                    }
                }
            }
        }
        return output;
    }

    public static String rollLootCoX(int killCount, int raidPoints, JSONArray CoxGenerics)
    {
        String output;
        String msg1 = "Loot ";
        String msg2 = " at killcount: ";
        JSONObject Generic;

        for (int i = 1; i <= lootRolls; i++)
        {
            Generic = WeightFunctions.rollItem(CoxGenerics);

            Long long_divisor = (Long) Generic.get("divisor");
            int divisor = long_divisor.intValue();
            int quantity = 0;

            if (divisor == 0) {quantity = 1;}
            else
            {
                quantity = (raidPoints / divisor);
            }

            String GenericName = (String) Generic.get("name");

            if (i == lootRolls && i > 1)
            {
                msg1 += "and " + quantity + " " + GenericName;
            }
            else 
            {
                msg1 += (quantity + " " + GenericName + ", ");
            }
        }

        System.out.println(msg1 + msg2 + killCount);
        output = (msg1 + msg2 + killCount + "\n");
        return output;

    }

    public static void getTbowChance(int raidPoints)
    {
        JSONParser parser = new JSONParser();
        JSONArray CoxUniques = null;

        try
        {
            CoxUniques = (JSONArray) parser.parse(new FileReader(COX_UNIQUES_PATH));
        }
        catch (IOException | ParseException e)
        {
            System.out.println("Invalid File Setup");
        }

        String msg1 = "With ";
        String msg2 = " Points, tbow chance is 1/";

        int totalPWeight = WeightFunctions.getTotalWeight(CoxUniques);

        // 1 out of purple weight
        double purpleWeight = (double)accuracy * (((double)raidPoints) / purpleRate); // large int
        double purpleRate = ((double)accuracy * 100.0)/purpleWeight; //  10k / large int
        double tbowRate = totalPWeight/2.0;
        int tbowChance = (int)Math.round(tbowRate * purpleRate);

        System.out.println(msg1 + raidPoints + msg2 + tbowChance);
    }
}
