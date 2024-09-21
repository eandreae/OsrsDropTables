package WeightTables;

public class GenericItem extends UniqueItem {

    public int divisor;

    public GenericItem(String name, int weight, int divisor)
    {
        super(name, weight);
        this.divisor = divisor;
    }

    public int getDivisor()
    {
        return this.divisor;
    }
}
