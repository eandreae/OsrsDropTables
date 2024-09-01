package DropTables;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
        UniqueItem sword = new UniqueItem("Sword", 1);
        UniqueItem bow = new UniqueItem("Bow", 30);
        UniqueItem poop = new UniqueItem("poop", 50);
        UniqueItem[] UniquesList = 
        {
            sword, // 20/100 -> 20%
            bow, // 30/100 -> 30%
            poop // 50/100 -> 50%
        };
        
        for (int i = 0; i < 100; i++)
        {
            rollUnique(UniquesList);
        }

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

    public static void rollUnique(UniqueItem[] UniquesList)
    {
        int totalWeight = getTotalWeight(UniquesList);

        Random r = new Random();
        int lootRoll = r.nextInt(totalWeight+1);

        for (UniqueItem item : UniquesList)
        {
            int uniqueWeight = item.getWeight();
            String uniqueName = item.getName();

            if (lootRoll <= uniqueWeight)
            {
                // Reward this item, and stop.
                System.out.println(uniqueName);
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
