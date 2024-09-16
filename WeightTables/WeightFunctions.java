package WeightTables;
import java.util.Random;

public class WeightFunctions {

    static UniqueItem default1 = new UniqueItem("default1", 5);
    static UniqueItem default2 = new UniqueItem("default2", 5);
    public static UniqueItem[] defaultItems = 
    {
        default1,
        default2
    };

    public static UniqueItem[] getDefault()
    {
        return defaultItems;
    }
    
    public static int getTotalWeight(UniqueItem[] UniquesList)
    {
        int totalWeight = 0;

        for (UniqueItem item : UniquesList)
        {
            totalWeight += item.getWeight();
        }

        return totalWeight;
    }

    public static void rollUnique(UniqueItem[] UniquesList, int killCount)
    {
        int totalWeight = getTotalWeight(UniquesList);
        
        String msg1 = "Purple ";
        String msg2 = " at killcount: ";

        Random r = new Random();
        int lootRoll = r.nextInt(totalWeight+1);

        for (UniqueItem item : UniquesList)
        {
            int uniqueWeight = item.getWeight();
            String uniqueName = item.getName();

            if (lootRoll <= uniqueWeight)
            {
                // Reward this item, and stop.
                System.out.println(msg1 + uniqueName + msg2 + killCount);
                return;
            }
            else
            {
                // try again
                lootRoll -= uniqueWeight;
            }
        }
    }

    public static UniqueItem rollItem(UniqueItem[] UniquesList)
    {
        UniqueItem loot = default1;

        int totalWeight = getTotalWeight(UniquesList);

        Random r = new Random();
        int lootRoll = r.nextInt(totalWeight+1);

        for (UniqueItem item : UniquesList)
        {
            int uniqueWeight = item.getWeight();

            if (lootRoll <= uniqueWeight)
            {
                // Reward this item, and stop.
                return item;
            }
            else
            {
                // try again
                lootRoll -= uniqueWeight;
            }
        }

        return loot;
    }
}
