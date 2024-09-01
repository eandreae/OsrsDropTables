package WeightTables;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Runner r = new Runner();
        Random rand = new Random();
        ToaUniques ToA = new ToaUniques();
        CoXUniques CoX = new CoXUniques();
        UniqueItem[] Purples = r.getDefault();
        int checkPurple;

        int PURPLE_CHANCE = 29;
        int NUM_RAIDS = 1000;
        String RAID = "ToA";

        if (RAID == "ToA")
        {
            Purples = ToA.getPurples();
        }
        if (RAID == "Cox")
        {
            Purples = CoX.getPurples();
        }
        
        for (int i = 0; i < NUM_RAIDS; i++)
        {
            // Check for Purple
            checkPurple = rand.nextInt(PURPLE_CHANCE+1);
            if (checkPurple == PURPLE_CHANCE)
            {
                // Award Purple
                r.rollUnique(Purples, i);
            }
        }

    }
}
