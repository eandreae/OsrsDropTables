package WeightTables;

public class CoXUniques {

    int lootRolls = 2;
    double purpleRate = 8676.0;
    int cappedPoints = 570000;
    int accuracy = 100; // More 0s, more accurate purple chance. Default 100.

    UniqueItem dex = new UniqueItem("Dextrous Prayer Scroll", 20);
    UniqueItem arcane = new UniqueItem("Arcane Prayer Scroll", 20);
    UniqueItem buckler = new UniqueItem("Twisted Buckler", 4);
    UniqueItem dhcb = new UniqueItem("Dragon Hunter Crossbow", 4);
    UniqueItem dinhs = new UniqueItem("Dinh's Bulwark", 3);
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
        dinhs,
        dhcb,
        buckler,
        arcane,
        dex
    };

    UniqueItem dRune = new UniqueItem("Death Runes", 1, 241);
    UniqueItem bRune = new UniqueItem("Blood Runes", 1, 271);
    UniqueItem sRune = new UniqueItem("Soul Runes", 1, 433);
    UniqueItem rArrow = new UniqueItem("Rune Arrows", 1, 619);
    UniqueItem dArrows = new UniqueItem("Dragon Arrows", 1, 42);
    UniqueItem ranWeed = new UniqueItem("Ranarr Weeds", 1, 11);
    UniqueItem toadflax = new UniqueItem("Toadlfax", 1, 16);
    UniqueItem irit = new UniqueItem("Irit Leaves", 1, 53);
    UniqueItem avantoe = new UniqueItem("Avantoes", 1, 26);
    UniqueItem kwuarm = new UniqueItem("Kwuarms", 1, 22);
    UniqueItem snapdragon = new UniqueItem("Snapdragons", 1, 6);
    UniqueItem cadantine = new UniqueItem("Cadantines", 1, 26);
    UniqueItem lantadyme = new UniqueItem("Lantadymes", 1, 34);
    UniqueItem dwarfWeed = new UniqueItem("Dwarf Weeds", 1, 43);
    UniqueItem torstol = new UniqueItem("Torstols", 1, 10);
    UniqueItem sOre = new UniqueItem("Silver Ore", 1, 433);
    UniqueItem coal = new UniqueItem("Coal", 1, 433);
    UniqueItem gOre = new UniqueItem("Gold Ore", 1, 197);
    UniqueItem mOre = new UniqueItem("Mithril Ore", 1, 271);
    UniqueItem aOre = new UniqueItem("Adamantite Ore", 1, 52);
    UniqueItem rOre = new UniqueItem("Runite Ore", 1, 4);
    UniqueItem uSapphire = new UniqueItem("Uncut Sapphires", 1, 46);
    UniqueItem uEmerald = new UniqueItem("Uncut Emeralds", 1, 61);
    UniqueItem uRuby = new UniqueItem("Uncut Rubies", 1, 35);
    UniqueItem uDiamond = new UniqueItem("Uncut Diamonds", 1, 17);
    UniqueItem lFang = new UniqueItem("Liazardmen Fangs", 1, 309);
    UniqueItem pEss = new UniqueItem("Pure Essence", 1, 4338);
    UniqueItem saltpetre = new UniqueItem("Saltpetre", 1, 361);
    UniqueItem tPlank = new UniqueItem("Teak Planks", 1, 90);
    UniqueItem mPlank = new UniqueItem("Mahogany Planks", 1, 36);
    UniqueItem dyanamite = new UniqueItem("Dynamite", 1, 160);
    UniqueItem tpScroll = new UniqueItem("Torn Prayer Scroll", 1, 1);
    UniqueItem dRelic = new UniqueItem("Dark Relic", 1, 1);

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

    public double getPurpleRate()
    {
        return this.purpleRate;
    }

    public int getCappedPoints()
    {
        return this.cappedPoints;
    }

    public int getAccuracy()
    {
        return this.accuracy;
    }
}
