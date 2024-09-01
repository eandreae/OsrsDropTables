package WeightTables;
import java.util.Random;

public class Runner {

    public Runner() {}
    
    UniqueItem default1 = new UniqueItem("default1", 5);
    UniqueItem default2 = new UniqueItem("default2", 5);
    public UniqueItem[] defaultItems = 
    {
        default1,
        default2
    };

    public UniqueItem[] getDefault()
    {
        return this.defaultItems;
    }

    public int getTotalWeight(UniqueItem[] UniquesList)
    {
        int totalWeight = 0;

        for (UniqueItem item : UniquesList)
        {
            totalWeight += item.getWeight();
        }

        return totalWeight;
    }

    public void rollUnique(UniqueItem[] UniquesList, int killCount)
    {
        int totalWeight = getTotalWeight(UniquesList);
        String msg1 = "Awarded ";
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
}
