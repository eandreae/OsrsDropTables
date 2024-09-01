package WeightTables;

public class ToaUniques {

        UniqueItem fang = new UniqueItem("Fang", 7);
        UniqueItem lightbearer = new UniqueItem("Lightbearer", 7);
        UniqueItem ward = new UniqueItem("Ward", 3);
        UniqueItem mask = new UniqueItem("Masori Mask", 2);
        UniqueItem body = new UniqueItem("Masori Body", 2);
        UniqueItem legs = new UniqueItem("Masori Legs", 2);
        UniqueItem shadow = new UniqueItem("Tumeken's Shadow", 1);

        public UniqueItem[] ToaPurples =
        {
            shadow,
            legs,
            body,
            mask,
            ward,
            lightbearer,
            fang
        };

    public ToaUniques(){}

    public UniqueItem[] getToaPurples()
    {
        return this.ToaPurples;
    }
}
