package DesertTreasure2;

public class DukeTable
{
    // Information for Duke's Drops

    // 1/90 for Unique
    //      3/8 Chromium
    //      3/8 Vestige
    //      1/8 Eye of Duke
    //      1/8 Virtus
    // 1/48 for Orb
    // 1/25 for Tablet
    // 1/200 for Ice Quartz
    // 1/5 for Supply Drop
    // All else fails, normal loot.

    public int UniqueChance;
    public int OrbChance;
    public int TabletChance;
    public int QuartzChance;
    public int SupplyChance;
    public String VestigeName;
    public String AxePieceName;

    public DukeTable()
    {
        // The drop values specific to the Duke.
        UniqueChance = 90;
        OrbChance    = 48;
        TabletChance = 25;
        QuartzChance = 200;
        SupplyChance = 5;
        VestigeName  = "Magus Vestige";
        AxePieceName = "Eye of the Duke";

        // Add the other drops?

    }

    public int getUniqueChance()
    {
        return UniqueChance;
    }

    public int getOrbChance()
    {
        return OrbChance;
    }

    public int getTabletChance()
    {
        return TabletChance;
    }

    public int getQuartzChance()
    {
        return QuartzChance;
    }

    public int getSupplyChance()
    {
        return SupplyChance;
    }

    public String getVestigeName()
    {
        return VestigeName;
    }

    public String getAxePieceName()
    {
        return AxePieceName;
    }

}