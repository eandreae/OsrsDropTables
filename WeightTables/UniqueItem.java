package WeightTables;

public class UniqueItem
{
    public String name;
    public int weight;
    public int quantity;

    public UniqueItem(String name, int weight)
    {
        this.name = name;
        this.weight = weight;
    }

    public UniqueItem(String name, int weight, int quantity)
    {
        this.name = name;
        this.weight = weight;
        this.quantity = quantity;
    }

    public String getName()
    {
        return this.name;
    }

    public int getWeight()
    {
        return this.weight;
    }

    public int getQuantity()
    {
        return this.quantity;
    }
        
}