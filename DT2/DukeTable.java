package DT2;
import java.util.HashMap;

public class DukeTable
{
    public HashMap<Integer, String> UniqueTable;

    public DukeTable()
    {
        // Duke Sucellus Drop Table
        // 1/90 for a Unique
        //      3/8 Chromium
        //      3/8 Vestige
        //      1/8 Eye of Duke
        //      1/8 Virtus
        // 1/48 for Awakener's orb
        // 1/25 for Frozen Tablet
        // 1/200 for ice quartz
        // 1/5 for supply drop
        // regular drop

        // Populate the Unique Table
        UniqueTable.put(1, "Chromium Ingot");
        UniqueTable.put(2, "Chromium Ingot");
        UniqueTable.put(3, "Chromium Ingot");
        UniqueTable.put(4, "Chromium Ingot");
        UniqueTable.put(5, "Chromium Ingot");
        UniqueTable.put(6, "Chromium Ingot");
        UniqueTable.put(7, "Chromium Ingot");
        UniqueTable.put(8, "Chromium Ingot");
    }

    public String getReward(int number)
    {
        return UniqueTable.get(number);
    }

    public int getLength()
    {
        return UniqueTable.size();
    }


}