package WeightTables;

public class CoXUniques {

    int lootRolls = 2;

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

    UniqueItem dRune = new UniqueItem("Death Runes", 1);
    UniqueItem bRune = new UniqueItem("Blood Runes", 1);
    UniqueItem sRune = new UniqueItem("Soul Runes", 1);
    UniqueItem rArrow = new UniqueItem("Rune Arrows", 1);
    UniqueItem dArrows = new UniqueItem("Dragon Arrows", 1);
    UniqueItem ranWeed = new UniqueItem("Ranarr Weeds", 1);
    UniqueItem toadflax = new UniqueItem("Toadlfax", 1);
    UniqueItem irit = new UniqueItem("Irit Leaves", 1);
    UniqueItem avantoe = new UniqueItem("Avantoes", 1);
    UniqueItem kwuarm = new UniqueItem("Kwuarms", 1);
    UniqueItem snapdragon = new UniqueItem("Snapdragons", 1);
    UniqueItem cadantine = new UniqueItem("Cadantines", 1);
    UniqueItem lantadyme = new UniqueItem("Lantadymes", 1);
    UniqueItem dwarfWeed = new UniqueItem("Dwarf Weeds", 1);
    UniqueItem torstol = new UniqueItem("Torstols", 1);
    UniqueItem sOre = new UniqueItem("Silver Ore", 1);
    UniqueItem coal = new UniqueItem("Coal", 1);
    UniqueItem gOre = new UniqueItem("Gold Ore", 1);
    UniqueItem mOre = new UniqueItem("Mithril Ore", 1);
    UniqueItem aOre = new UniqueItem("Adamantite Ore", 1);
    UniqueItem rOre = new UniqueItem("Runite Ore", 1);
    UniqueItem uSapphire = new UniqueItem("Uncut Sapphires", 1);
    UniqueItem uEmerald = new UniqueItem("Uncut Emeralds", 1);
    UniqueItem uRuby = new UniqueItem("Uncut Rubies", 1);
    UniqueItem uDiamond = new UniqueItem("Uncut Diamonds", 1);
    UniqueItem lFang = new UniqueItem("Liazardmen Fangs", 1);
    UniqueItem pEss = new UniqueItem("Pure Essence", 1);
    UniqueItem saltpetre = new UniqueItem("Saltpetre", 1);
    UniqueItem tPlank = new UniqueItem("Teak Planks", 1);
    UniqueItem mPlank = new UniqueItem("Mahogany Planks", 1);
    UniqueItem dyanamite = new UniqueItem("Dynamite", 1);
    UniqueItem tpScroll = new UniqueItem("Torn Prayer Scroll", 1);
    UniqueItem dRelic = new UniqueItem("Dark Relic", 1);

    public UniqueItem[] CoXLoot =
    {
        dRune,
        bRune,
        sRune,
        rArrow,
        dArrows,
        ranWeed,
        toadflax,
        irit,
        avantoe,
        kwuarm,
        snapdragon,
        cadantine,
        lantadyme,
        dwarfWeed,
        torstol,
        sOre,
        coal,
        gOre,
        mOre,
        aOre,
        rOre,
        uSapphire,
        uEmerald,
        uRuby,
        uDiamond,
        lFang,
        pEss,
        saltpetre,
        tPlank,
        mPlank,
        dyanamite,
        dRelic
    };

    public CoXUniques(){}

    public UniqueItem[] getPurples()
    {
        return this.CoXPurples;
    }

    public UniqueItem[] getLoot()
    {
        return this.CoXLoot;
    }

    public int getLootRolls()
    {
        return this.lootRolls;
    }
}
