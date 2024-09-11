package WeightTables;

public class UniqueItem
{
    public String name;
    public int weight;
    public int divisor;

    public UniqueItem(String name, int weight)
    {
        this.name = name;
        this.weight = weight;
    }

    public UniqueItem(String name, int weight, int divisor)
    {
        this.name = name;
        this.weight = weight;
        this.divisor = divisor;
    }

    public String getName()
    {
        return this.name;
    }

    public int getWeight()
    {
        return this.weight;
    }

    public int getDivisor()
    {
        return this.divisor;
    }
        
}