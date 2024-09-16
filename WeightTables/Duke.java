package WeightTables;

public class Duke {

    static String BossName = "Duke";
    static UniqueItem tablet = new UniqueItem("Frozen Tablet", 1);
    static UniqueItem quartz = new UniqueItem("Ice Quartz", 1);
    static UniqueItem vestige = new UniqueItem("Magus Vestige", 1); // Awarded after 3 vestige rolls.
    static UniqueItem axePiece = new UniqueItem("Eye of the Duke", 1);

    public static void run(int killCount)
    {
        DT2.HAS_TABLET = false; // Reset tablet to false;
        DT2.VESTIGE_ROLLS = 0; // Reset to 0.
        String msg1 = " Awarded at killcount: ";
        UniqueItem loot;

        // Determine which boss we're simulating
        DT2.setDT2Boss(BossName);

        for(int i = 1; i <= killCount; i++)
        {
            loot = DT2.rollDT2BossLoot(BossName);
            System.out.println(loot.getName()+ msg1 + i);
        }
    }
}
