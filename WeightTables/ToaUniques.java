package WeightTables;

public class ToaUniques {

        public static int lootRolls = 3;
        public static int purpleLimit = 1;
        public static int accuracy = 100; // More 0s, more accurate purple chance. Default 100.
        public static double purpleRate = 8676.0;
        // Players will have a 1% chance to receive a unique item for every:
        // 10,500 - 20(X + y/3) total reward points
        // X is the sum of raid levels between 1 and 400
        // Y is the sum of raid levels between 401 and 550

        // NPC point multipliers


        static UniqueItem fang = new UniqueItem("Fang", 7);
        static UniqueItem lightbearer = new UniqueItem("Lightbearer", 7);
        static UniqueItem ward = new UniqueItem("Ward", 3);
        static UniqueItem mask = new UniqueItem("Masori Mask", 2);
        static UniqueItem body = new UniqueItem("Masori Body", 2);
        static UniqueItem legs = new UniqueItem("Masori Legs", 2);
        static UniqueItem shadow = new UniqueItem("Tumeken's Shadow", 1);

        public static UniqueItem[] ToaPurples =
        {
            shadow,
            legs,
            body,
            mask,
            ward,
            lightbearer,
            fang
        };

        static UniqueItem cache = new UniqueItem("Cache of Runes", 1);
        static UniqueItem coins = new UniqueItem("Coins", 1);
        static UniqueItem dRunes = new UniqueItem("Death Runes", 1);
        static UniqueItem sRunes = new UniqueItem("Soul Runes", 1);
        static UniqueItem gOre = new UniqueItem("Gold Ore", 1);
        static UniqueItem ddTip = new UniqueItem("Dragon Dart Tips", 1);
        static UniqueItem mLogs = new UniqueItem("Mahogany Logs", 1);
        static UniqueItem sapphire = new UniqueItem("Sapphires", 1);
        static UniqueItem emerald = new UniqueItem("Emeralds", 1);
        static UniqueItem gBar = new UniqueItem("Gold Bars", 1);
        static UniqueItem pCactus = new UniqueItem("Potato Cactus", 1);
        static UniqueItem rShark = new UniqueItem("Raw Shark", 1);
        static UniqueItem ruby = new UniqueItem("Rubies", 1);
        static UniqueItem diamond = new UniqueItem("Diamonds", 1);
        static UniqueItem rmRay = new UniqueItem("Raw Manta Rays", 1);
        static UniqueItem cSpine = new UniqueItem("Cactus Spines", 1);
        static UniqueItem dragonstone = new UniqueItem("Dragonstones", 1);
        static UniqueItem bstaff = new UniqueItem("Battlestaves", 1);
        static UniqueItem cMilk = new UniqueItem("Coconut Milk", 1);
        static UniqueItem lotSands = new UniqueItem("Lily of the Sands", 1);
        static UniqueItem tflxSeed = new UniqueItem("Toadflax Seeds", 1);
        static UniqueItem rSeeds = new UniqueItem("Ranarr Seeds", 1);
        static UniqueItem tortSeed = new UniqueItem("Torstol Seeds", 1);
        static UniqueItem snapSeed = new UniqueItem("Snapdragon Seeds", 1);
        static UniqueItem dmHelm = new UniqueItem("Dragon Med Helms", 1);
        static UniqueItem mSeeds = new UniqueItem("Magic Seeds", 1);
        static UniqueItem bEssence = new UniqueItem("Blood Essence", 1);

        public static UniqueItem[] ToaLoot = 
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
}
