import java.util.HashMap;

public class DukeTable
{
    public HashMap<Integer, String> UniqueTable;
    public HashMap<Integer, String> VirtusTable;

    public DukeTable()
    {
        // Table for Duke's Uniques
        UniqueTable = new HashMap<Integer, String>();
        UniqueTable.put(1, "Virtus");
        UniqueTable.put(2, "Vestige Roll");
        UniqueTable.put(3, "Vestige Roll");
        UniqueTable.put(4, "Vestige Roll");
        UniqueTable.put(5, "Chromium");
        UniqueTable.put(6, "Chromium");
        UniqueTable.put(7, "Chromium");
        UniqueTable.put(8, "Eye of the Duke");

        // Table for Possible Virtus Pieces from Duke
        VirtusTable = new HashMap<Integer, String>();
        VirtusTable.put(1, "Virtus Mask");
        VirtusTable.put(2, "Virtus Shirt");
        VirtusTable.put(3, "Virtus Pants");
    }
}