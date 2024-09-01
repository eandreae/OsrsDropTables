package WeightTables;

public class CoXUniques {
    UniqueItem dex = new UniqueItem("Dextrous Prayer Scroll", 20);
    UniqueItem arcane = new UniqueItem("Arcane Prayer Scroll", 20);
    UniqueItem buckler = new UniqueItem("Twisted Buckler", 4);
    UniqueItem dhcb = new UniqueItem("Dragon Hunter Crossbow", 4);
    UniqueItem hat = new UniqueItem("Ancestral Hat", 3);
    UniqueItem body = new UniqueItem("Ancestral Body", 3);
    UniqueItem legs = new UniqueItem("Ancestral Legs", 3);
    UniqueItem claws = new UniqueItem("Dragon Claws", 3);
    UniqueItem maul = new UniqueItem("Elder Maul", 2);
    UniqueItem kodai = new UniqueItem("Kodai Insignia", 2);
    UniqueItem bow = new UniqueItem("Twisted Bow", 2);

    public UniqueItem[] CoXPurples =
    {
        bow,
        kodai,
        maul,
        claws,
        legs,
        body,
        hat,
        dhcb,
        buckler,
        arcane,
        dex
    };

    public CoXUniques(){}

    public UniqueItem[] getPurples()
    {
        return this.CoXPurples;
    }    
}
