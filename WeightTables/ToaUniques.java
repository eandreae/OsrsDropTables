package WeightTables;

public class ToaUniques {

        int lootRolls = 3;

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

        UniqueItem cache = new UniqueItem("Cache of Runes", 1);
        UniqueItem coins = new UniqueItem("Coins", 1);
        UniqueItem dRunes = new UniqueItem("Death Runes", 1);
        UniqueItem sRunes = new UniqueItem("Soul Runes", 1);
        UniqueItem gOre = new UniqueItem("Gold Ore", 1);
        UniqueItem ddTip = new UniqueItem("Dragon Dart Tips", 1);
        UniqueItem mLogs = new UniqueItem("Mahogany Logs", 1);
        UniqueItem sapphire = new UniqueItem("Sapphires", 1);
        UniqueItem emerald = new UniqueItem("Emeralds", 1);
        UniqueItem gBar = new UniqueItem("Gold Bars", 1);
        UniqueItem pCactus = new UniqueItem("Potato Cactus", 1);
        UniqueItem rShark = new UniqueItem("Raw Shark", 1);
        UniqueItem ruby = new UniqueItem("Rubies", 1);
        UniqueItem diamond = new UniqueItem("Diamonds", 1);
        UniqueItem rmRay = new UniqueItem("Raw Manta Rays", 1);
        UniqueItem cSpine = new UniqueItem("Cactus Spines", 1);
        UniqueItem dragonstone = new UniqueItem("Dragonstones", 1);
        UniqueItem bstaff = new UniqueItem("Battlestaves", 1);
        UniqueItem cMilk = new UniqueItem("Coconut Milk", 1);
        UniqueItem lotSands = new UniqueItem("Lily of the Sands", 1);
        UniqueItem tflxSeed = new UniqueItem("Toadflax Seeds", 1);
        UniqueItem rSeeds = new UniqueItem("Ranarr Seeds", 1);
        UniqueItem tortSeed = new UniqueItem("Torstol Seeds", 1);
        UniqueItem snapSeed = new UniqueItem("Snapdragon Seeds", 1);
        UniqueItem dmHelm = new UniqueItem("Dragon Med Helms", 1);
        UniqueItem mSeeds = new UniqueItem("Magic Seeds", 1);
        UniqueItem bEssence = new UniqueItem("Blood Essence", 1);

        public UniqueItem[] ToaLoot = 
        {
            cache,
            coins,
            dRunes,
            sRunes,
            gOre,
            ddTip,
            mLogs,
            sapphire,
            emerald,
            gBar,
            pCactus,
            rShark,
            ruby,
            diamond,
            rmRay,
            cSpine,
            dragonstone,
            bstaff,
            cMilk,
            lotSands,
            tflxSeed,
            rSeeds,
            tortSeed,
            snapSeed,
            dmHelm,
            mSeeds,
            bEssence
        };

    public ToaUniques(){}

    public UniqueItem[] getPurples()
    {
        return this.ToaPurples;
    }

    public UniqueItem[] getLoot()
    {
        return this.ToaLoot;
    }

    public int getLootRolls()
    {
        return this.lootRolls;
    }
}
