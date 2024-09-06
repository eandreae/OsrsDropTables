package WeightTables;

import java.util.Random;

public class CoX {

    public static int lootRolls = 2;
    public static int cappedPoints = 570000;
    public static int purpleLimit = 6;
    public static int accuracy = 100; // More 0s, more accurate purple chance. Default 100.
    public static double purpleRate = 8676.0;

    static UniqueItem dex = new UniqueItem("Dextrous Prayer Scroll", 20);
    static UniqueItem arcane = new UniqueItem("Arcane Prayer Scroll", 20);
    static UniqueItem buckler = new UniqueItem("Twisted Buckler", 4);
    static UniqueItem dhcb = new UniqueItem("Dragon Hunter Crossbow", 4);
    static UniqueItem dinhs = new UniqueItem("Dinh's Bulwark", 3);
    static UniqueItem hat = new UniqueItem("Ancestral Hat", 3);
    static UniqueItem body = new UniqueItem("Ancestral Body", 3);
    static UniqueItem legs = new UniqueItem("Ancestral Legs", 3);
    static UniqueItem claws = new UniqueItem("Dragon Claws", 3);
    static UniqueItem maul = new UniqueItem("Elder Maul", 2);
    static UniqueItem kodai = new UniqueItem("Kodai Insignia", 2);
    static UniqueItem bow = new UniqueItem("Twisted Bow", 2);

    public static UniqueItem[] CoXPurples =
    {
        bow,kodai,maul,claws,legs,body,hat,
        dinhs,dhcb,buckler,arcane,dex
    };

    static UniqueItem dRune = new UniqueItem("Death Runes", 1, 36);
    static UniqueItem bRune = new UniqueItem("Blood Runes", 1, 32);
    static UniqueItem sRune = new UniqueItem("Soul Runes", 1, 20);
    static UniqueItem rArrow = new UniqueItem("Rune Arrows", 1, 14);
    static UniqueItem dArrows = new UniqueItem("Dragon Arrows", 1, 202);
    static UniqueItem ranWeed = new UniqueItem("Ranarr Weeds", 1, 788);
    static UniqueItem toadflax = new UniqueItem("Toadlfax", 1, 520);
    static UniqueItem irit = new UniqueItem("Irit Leaves", 1, 162);
    static UniqueItem avantoe = new UniqueItem("Avantoes", 1, 324);
    static UniqueItem kwuarm = new UniqueItem("Kwuarms", 1, 378);
    static UniqueItem snapdragon = new UniqueItem("Snapdragons", 1, 1300);
    static UniqueItem cadantine = new UniqueItem("Cadantines", 1, 330);
    static UniqueItem lantadyme = new UniqueItem("Lantadymes", 1, 248);
    static UniqueItem dwarfWeed = new UniqueItem("Dwarf Weeds", 1, 200);
    static UniqueItem torstol = new UniqueItem("Torstols", 1, 810);
    static UniqueItem sOre = new UniqueItem("Silver Ore", 1, 20);
    static UniqueItem coal = new UniqueItem("Coal", 1, 20);
    static UniqueItem gOre = new UniqueItem("Gold Ore", 1, 44);
    static UniqueItem mOre = new UniqueItem("Mithril Ore", 1, 32);
    static UniqueItem aOre = new UniqueItem("Adamantite Ore", 1, 166);
    static UniqueItem rOre = new UniqueItem("Runite Ore", 1, 2000);
    static UniqueItem uSapphire = new UniqueItem("Uncut Sapphires", 1, 188);
    static UniqueItem uEmerald = new UniqueItem("Uncut Emeralds", 1, 142);
    static UniqueItem uRuby = new UniqueItem("Uncut Rubies", 1, 242);
    static UniqueItem uDiamond = new UniqueItem("Uncut Diamonds", 1, 508);
    static UniqueItem lFang = new UniqueItem("Liazardmen Fangs", 1, 28);
    static UniqueItem pEss = new UniqueItem("Pure Essence", 1, 2);
    static UniqueItem saltpetre = new UniqueItem("Saltpetre", 1, 24);
    static UniqueItem tPlank = new UniqueItem("Teak Planks", 1, 96);
    static UniqueItem mPlank = new UniqueItem("Mahogany Planks", 1, 238);
    static UniqueItem dyanamite = new UniqueItem("Dynamite", 1, 54);
    static UniqueItem tpScroll = new UniqueItem("Torn Prayer Scroll", 1, 1);
    static UniqueItem dRelic = new UniqueItem("Dark Relic", 1, 1);

    public static UniqueItem[] CoXLoot =
    {
        dRune,bRune,sRune,rArrow,dArrows,ranWeed,toadflax,irit,
        avantoe,kwuarm,snapdragon,cadantine,lantadyme,dwarfWeed,
        torstol,sOre,coal,gOre,mOre,aOre,rOre,uSapphire,uEmerald,
        uRuby,uDiamond,lFang,pEss,saltpetre,tPlank,mPlank,dyanamite,
        dRelic
    };

    public static void runCoX(int raidPoints, int numRaids, int partySize)
    {
        Random rand = new Random();
        int checkPurple;
        int purpleWeight;
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
                    WeightFunctions.rollUnique(CoXPurples, i);
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
                            WeightFunctions.rollUnique(CoXPurples, i);
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

    public static void rollLootCoX(int killCount, int raidPoints)
    {
        String msg1 = "Loot ";
        String msg2 = " at killcount: ";
        UniqueItem loot;

        for (int i = 1; i <= lootRolls; i++)
        {
            loot = WeightFunctions.rollItem(CoXLoot, killCount);
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
}
