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

    public void runCoX(int raidPoints, int numRaids, int partySize)
    {
        Random rand = new Random();
        CoXUniques CoX = new CoXUniques();
        UniqueItem[] Purples = CoX.getPurples();
        int checkPurple;
        int purpleWeight;
        int accuracy = CoX.getAccuracy();
        int totalPWeight = accuracy * accuracy;
        int cappedRolls;
        int remainingPoints;
        int totalLoots;
        int totalPurples;
        
        System.out.println(numRaids + " raids, each with " + raidPoints + " points, in a party of " + partySize);
        for (int i = 1; i <= numRaids; i++)
        {
            totalLoots = 0;
            totalPurples = 0;
            cappedRolls = raidPoints / CoX.getCappedPoints();
            remainingPoints = raidPoints % CoX.getCappedPoints();

            // No more than 6 purples may be rolled.
            if(cappedRolls > 6){cappedRolls = 6;}
            
            while(cappedRolls >= 1 && totalLoots < partySize && totalPurples < 6)
            {
                // Roll purple using capped points.
                purpleWeight = (int)Math.ceil(accuracy * (CoX.getCappedPoints() / CoX.getPurpleRate()));
                checkPurple = rand.nextInt(totalPWeight + 1);
                if (checkPurple <= purpleWeight)
                {
                    // Award purple
                    System.out.print("Player " + (totalLoots+1) + ": ");
                    rollUnique(Purples, i);
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
                    if(totalPurples <= 0 && totalPurples < 6)
                    {
                        purpleWeight = (int)Math.ceil(accuracy * ((remainingPoints/partySize) / CoX.getPurpleRate()));
                        checkPurple = rand.nextInt(totalPWeight + 1);
                        if (checkPurple <= purpleWeight)
                        {
                            System.out.print("Player " + (totalLoots+1) + ": ");
                            rollUnique(Purples, i);
                            totalLoots++;
                            totalPurples++;
                        }
                        else
                        {
                            System.out.print("Player " + (totalLoots+1) + ": ");
                            rollLootCoX(i, raidPoints/partySize);
                            totalLoots++;
                        }
                    }
                    else
                    {
                        System.out.print("Player " + (totalLoots+1) + ": ");
                        rollLootCoX(i, raidPoints/partySize);
                        totalLoots++;
                    }
                }
            }
            System.out.println();
        }
    }

    

    public void rollLootCoX(int killCount, int raidPoints)
    {
        String msg1 = "Loot ";
        String msg2 = " at killcount: ";
        UniqueItem loot;

        CoXUniques CoX = new CoXUniques();
        int lootRolls = CoX.getLootRolls();
        UniqueItem[] raidLoot = CoX.getLoot();

        for (int i = 1; i <= lootRolls; i++)
        {
            loot = rollItem(raidLoot, killCount);
            //int quantity = (int)(loot.getQuantity() * (raidPoints / pChance));
            int quantity = (raidPoints / loot.getDivisor());
            if (loot.getName() == "Dark Relic" || loot.getName() == "Torn Prayer Scroll")
            {
                quantity = 1;
            }
            if (i == lootRolls && i > 1)
            {
                msg1 += "and " + quantity + " " + loot.getName();
            }
            else 
            {
                msg1 += (quantity + " " + loot.getName() + ", ");
            }
        }

        System.out.println(msg1 + msg2 + killCount);

    }

    public void run(int pChance, int numRaids, String raid)
    {
        int checkPurple;
        Random rand = new Random();
        ToaUniques ToA = new ToaUniques();
        CoXUniques CoX = new CoXUniques();
        UniqueItem[] Purples = this.getDefault();
        UniqueItem[] Loot = this.getDefault();
        int lootRolls = 1;

        if (raid == "ToA")
        {
            Purples = ToA.getPurples();
            Loot = ToA.getLoot();
            lootRolls = ToA.getLootRolls();
        }
        if (raid == "CoX")
        {
            Purples = CoX.getPurples();
            Loot = CoX.getLoot();
            lootRolls = CoX.getLootRolls();
        }

        for (int i = 1; i <= numRaids; i++)
        {
            // Check for Purple
            checkPurple = rand.nextInt(pChance+1);
            if (checkPurple == pChance)
            {
                // Award Purple
                this.rollUnique(Purples, i);
            }
            else
            {
                // Award normal loot.
                rollLoot(Loot, lootRolls, i);
                
            }
        }
    }

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

    public UniqueItem rollItem(UniqueItem[] UniquesList, int killCount)
    {
        UniqueItem loot = this.default1;

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

    public void rollLoot(UniqueItem[] raidLoot, int lootRolls, int killCount)
    {
        String msg1 = "Loot ";
        String msg2 = " at killcount: ";
        UniqueItem loot;

        for (int i = 1; i <= lootRolls; i++)
        {
            loot = rollItem(raidLoot, killCount);
            if (i == lootRolls && i > 1)
            {
                msg1 += "and " + loot.getName();
            }
            else 
            {
                msg1 += (loot.getName() + ", ");
            }
        }

        System.out.println(msg1 + msg2 + killCount);

    }
}
