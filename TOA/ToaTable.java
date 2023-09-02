package TOA;
import java.util.HashMap;

public class ToaTable
{
    public HashMap<Integer, String> UniqueTable;

    public ToaTable()
    {
        UniqueTable = new HashMap<Integer, String>();
        // Toa Uniques Hash Table       
        // Fang             = 7/24
        UniqueTable.put(1, "Fang");
        UniqueTable.put(2, "Fang");
        UniqueTable.put(3, "Fang");
        UniqueTable.put(4, "Fang");
        UniqueTable.put(5, "Fang");
        UniqueTable.put(6, "Fang");
        UniqueTable.put(7, "Fang");
        // Lightbearer      = 7/24
        UniqueTable.put(8,  "Lightbearer");
        UniqueTable.put(9,  "Lightbearer");
        UniqueTable.put(10, "Lightbearer");
        UniqueTable.put(11, "Lightbearer");
        UniqueTable.put(12, "Lightbearer");
        UniqueTable.put(13, "Lightbearer");
        UniqueTable.put(14, "Lightbearer");
        // Elidinis' Ward   = 3/24
        UniqueTable.put(15, "Elidinis' Ward");
        UniqueTable.put(16, "Elidinis' Ward");
        UniqueTable.put(17, "Elidinis' Ward");
        // Masori Mask      = 2/24
        UniqueTable.put(18, "Masori Mask");
        UniqueTable.put(19, "Masori Mask");
        // Masori Body      = 2/24
        UniqueTable.put(20, "Masori Body");
        UniqueTable.put(21, "Masori Body");
        // Masori Chaps     = 2/24
        UniqueTable.put(22, "Masori Chaps");
        UniqueTable.put(23, "Masori Chaps");
         // Tumeken's Shadow = 1/24
        UniqueTable.put(24, "☼ Tumeken's Shadow ☼");
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