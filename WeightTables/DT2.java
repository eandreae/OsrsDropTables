package WeightTables;

import java.util.Random;

public class DT2 {
    
    // ORDER OF OPERATIONS FOR ALL DT2 BOSSES
    // 1. Roll for Unique
    // 2. Roll for Orb
    // 3. Roll for Tablet (Universal 1/25)
    // 4. Roll for Quartz (Universal 1/200)
    // 5. Roll for Supply Drop (Universal 1/5)
    // 6. All else fails, Roll Normal loot.

    // Universal to all DT2 Bosses
    public static UniqueItem ingot = new UniqueItem("Chromium Ingot", 3); // 3/8 Chromium
    public static UniqueItem vestigeRoll = new UniqueItem("Vestige Roll", 3); // 3/8 Vestige
    public static UniqueItem axePiece = new UniqueItem("Axe Piece", 1); // 1/8 Axe Piece
    public static UniqueItem virtusPiece = new UniqueItem("Virtus Piece", 1); // 1/8 Virtus Piece

    public static UniqueItem[] BossUniques =
    {
        ingot,vestigeRoll,axePiece,virtusPiece
    };

    static UniqueItem vMask = new UniqueItem("Virtus Mask", 1);
    static UniqueItem vTop = new UniqueItem("Virtus Robe Top", 1);
    static UniqueItem vBottom = new UniqueItem("Virtus Robe Bottom", 1);

    public static UniqueItem[] VirtusTable =
    {
        vMask,vTop,vBottom
    };

    public static UniqueItem orb = new UniqueItem("Awakener's Orb", 1);
    public static UniqueItem supply = new UniqueItem("Supply Drop", 1);
    public static UniqueItem normal = new UniqueItem("Normal Drop", 1);

    public static int QuartzChance = 200;
    public static int TabletChance = 25;
    public static int SupplyChance = 5;

    public static boolean HAS_TABLET = false; // Default false.
    public static int VESTIGE_ROLLS = 0; // default 0.

    // Duke Numbers
    public static int Duke_UniqueChance = 90;
    public static int Duke_AwakenerOrbChance = 48;

    // Leviathan Numbers
    public static int Levi_UniqueChance = 96;
    public static int Levi_AwakenerOrbChance = 53;

    // Vardorvis Numbers
    public static int Vard_UniqueChance = 136;
    public static int Vard_AwakenerOrbChance = 80;

    // Whisperer Numbers
    public static int Whisp_UniqueChance = 64;
    public static int Whisp_AwakenerOrbChance = 34;

    // Dynamic Variables to be declared during the program.
    static int UniqueChance;
    static int OrbChance;
    static UniqueItem Vestige;
    static UniqueItem AxePiece;
    static UniqueItem Tablet;
    static UniqueItem Quartz;

    public static void setDT2Boss(String BossName)
    {
        if (BossName.equals("Duke"))
        {
            UniqueChance = Duke_UniqueChance;
            OrbChance = Duke_AwakenerOrbChance;
            Vestige = Duke.vestige;
            AxePiece = Duke.axePiece;
            Tablet = Duke.tablet;
            Quartz = Duke.quartz;
            return;
        }

        if (BossName.equals("Leviathan"))
        {
            UniqueChance = Levi_UniqueChance;
            OrbChance = Levi_AwakenerOrbChance;
            Vestige = Leviathan.vestige;
            AxePiece = Leviathan.axePiece;
            Tablet = Leviathan.tablet;
            Quartz = Leviathan.quartz;
            return;
        }

        if (BossName.equals("Vardorvis"))
        {
            UniqueChance = Vard_UniqueChance;
            OrbChance = Vard_AwakenerOrbChance;
            Vestige = Vardorvis.vestige;
            AxePiece = Vardorvis.axePiece;
            Tablet = Vardorvis.tablet;
            Quartz = Vardorvis.quartz;
            return;
        }

        if (BossName.equals("Whisperer"))
        {
            UniqueChance = Whisp_UniqueChance;
            OrbChance = Whisp_AwakenerOrbChance;
            Vestige = Whisperer.vestige;
            AxePiece = Whisperer.axePiece;
            Tablet = Whisperer.tablet;
            Quartz = Whisperer.quartz;
            return;
        }
    }

    public static UniqueItem rollDT2BossLoot(String BossName)
    {
        Random rand = new Random();
        UniqueItem unique;
        int checker;

        // First, check Unique
        checker = rand.nextInt(UniqueChance+1);
        if (checker == UniqueChance)
        {
            // Roll Unique Table
            unique = WeightFunctions.rollItem(BossUniques);

            // Check Vestige
            if (unique.getName() == "Vestige Roll")
            {
                VESTIGE_ROLLS++;
                if (VESTIGE_ROLLS >= 3)
                {
                    VESTIGE_ROLLS = 0;
                    return Vestige;
                }
                return vestigeRoll;
            }

            // Check Virtus
            if (unique.getName() == "Virtus Piece")
            {
                return WeightFunctions.rollItem(VirtusTable);
            }

            // Check Axe Piece
            if (unique.getName() == "Axe Piece") {return AxePiece;}
            
            // Otherwise, reward unique as normal.
            return unique;
        }

        // Next, check Orb
        checker = rand.nextInt(OrbChance+1);
        if (checker == OrbChance) {return orb;}

        // Next, check Tablet
        if (!HAS_TABLET) 
        {
            checker = rand.nextInt(TabletChance+1);
            if (checker == TabletChance)
            {
                // Award Tablet;
                HAS_TABLET = true;
                return Tablet;
            }
        }

        // Next, check Quartz
        checker = rand.nextInt(QuartzChance+1);
        if (checker == QuartzChance) {return Quartz;}

        // Next, check Supply Drop
        checker = rand.nextInt(SupplyChance+1);
        if (checker == SupplyChance) {return supply;}

        // Finally, award normal loot 
        return normal;       
    }



}
