package DesertTreasure2;

import java.util.HashMap;

public class Table 
{
    // Each boss will have different rates for their uniques, but they all share these uniques.

    public HashMap<Integer, String> UniqueTable; // Handles Duke's Uniques
    public HashMap<Integer, String> VirtusTable; // Handles the 3 Virtus Pieces.

    public int OrbChance;
    public int TabletChance;
    public int QuartzChance;
    public int SupplyChance;
    public String VestigeName;
    public String AxePieceName;

    // oc = OrbChance, tc = TabletChance, qc = QuartzChance, sc = SupplyChance
    public Table()
    {
        // Populate the Unique Table
        UniqueTable.put(1, "Chromium Ingot");
        UniqueTable.put(2, "Chromium Ingot");
        UniqueTable.put(3, "Chromium Ingot");
        UniqueTable.put(1, "Vestige");
        UniqueTable.put(1, "Vestige");
        UniqueTable.put(1, "Vestige");
        UniqueTable.put(1, "Axe Piece");
        UniqueTable.put(1, "Virtus");

        // Populate the Virtus Table
        VirtusTable.put(1, "Virtus Mask");
        VirtusTable.put(2, "Virtus Body");
        VirtusTable.put(3, "Virtus Pants");

        // Carry over the HashMap of the normal drops
    }

    public void setAll(int oc, int tc, int qc, int sc, String vn, String ap)
    {
        setOrbChance(oc);
        setTabletChance(tc);
        setQuartzChance(qc);
        setSupplyChance(sc);
        setVestigeName(vn);
        setAxePieceName(ap);
    }

    public void setOrbChance(int num)
    {
        OrbChance = num;
    }

    public int getOrbChance()
    {
        return OrbChance;
    }

    public void setTabletChance(int num)
    {
        TabletChance = num;
    }

    public int getTabletChance()
    {
        return TabletChance;
    }

    public void setQuartzChance(int num)
    {
        QuartzChance = num;
    }

    public int getQuartzChance()
    {
        return QuartzChance;
    }

    public void setSupplyChance(int num)
    {
        SupplyChance = num;
    }

    public int getSupplyChance()
    {
        return SupplyChance;
    }

    public void setVestigeName(String name)
    {
        VestigeName = name;
    }
    
    public String getVestigeName()
    {
        return VestigeName;
    }

    public void setAxePieceName(String name)
    {
        AxePieceName = name;
    }

    public String getAxePieceName()
    {
        return AxePieceName;
    }
}
