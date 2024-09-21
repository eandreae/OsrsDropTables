package WeightTables;

public class UniqueItem extends Item
{
    public int weight;

    public UniqueItem(String name, int weight)
    {
        super(name);
        this.weight = weight;
    }

    public int getWeight()
    {
        return this.weight;
    }
        
}