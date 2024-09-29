package WeightTables;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class CoX {

    public static int lootRolls = 2;
    public static int cappedPoints = 570000;
    public static int purpleLimit = 6;
    public static int accuracy = 100; // More 0s, more accurate purple chance. Default 100.
    public static double purpleRate = 8676.0;

    public static int LOOT_IMAGE_WIDTH;
    public static int LOOT_IMAGE_HEIGHT;

    public static String COX_UNIQUES_PATH = "WeightTables\\CoxUniques.json";
    public static String COX_GENERICS_PATH = "WeightTables\\CoxGenerics.json";
    public static String COX_IMAGE_PATH = "WeightTables\\Ancient_chest2.png";
    public static String COX_LOOT_IMAGE_PATH = "WeightTables\\CoxLoot.png";

    public static HashMap<String, Integer> runCoX(int numRaids, int raidPoints, int partySize)
    {
        HashMap<String, Integer> output = new HashMap<String, Integer>();
        JSONParser parser = new JSONParser();
        JSONArray CoxUniques = null;
        JSONArray CoxGenerics = null;
        JSONObject Purple = null;
        JSONObject NormalLoot = null;
        Random rand = new Random();
        int checkPurple;
        int purpleWeight;
        int totalPWeight = accuracy * accuracy;
        int cappedRolls;
        int remainingPoints;
        int totalLoots;
        int totalPurples;

        try
        {
            CoxUniques = (JSONArray) parser.parse(new FileReader(COX_UNIQUES_PATH));
            CoxGenerics = (JSONArray) parser.parse(new FileReader(COX_GENERICS_PATH));
        }
        catch (IOException | ParseException e)
        {
            System.out.println("Invalid File Setup");
        }
        
        for (int i = 1; i <= numRaids; i++)
        {
            totalLoots = 0;
            totalPurples = 0;
            cappedRolls = raidPoints / cappedPoints;
            remainingPoints = raidPoints % cappedPoints;

            // No more purples than the purple limit may be rolled.
            if(cappedRolls > purpleLimit){cappedRolls = purpleLimit;}
            
            while(cappedRolls >= 1 && totalLoots < partySize && totalPurples < purpleLimit)
            {
                // Roll purple using capped points.
                purpleWeight = (int)Math.ceil(accuracy * (cappedPoints / purpleRate));
                checkPurple = rand.nextInt(totalPWeight + 1);
                if (checkPurple <= purpleWeight)
                {
                    // Award purple
                    Purple = WeightFunctions.rollItem(CoxUniques);
                    String name = (String) Purple.get("name");
                    if (output.containsKey(name))
                    {
                        output.put(name, (output.get(name)+1));
                    }
                    else
                    {
                        output.put(name, 1);
                    }
                    
                    totalLoots++;
                    totalPurples++;
                }
                cappedRolls -= 1;
            }

            if(totalLoots < partySize)
            {
                // Roll purple using the remaining points.
                while(partySize - totalLoots > 0)
                {
                    if(totalPurples <= 0 && totalPurples < purpleLimit)
                    {
                        purpleWeight = (int)Math.ceil(accuracy * ((remainingPoints/partySize) / purpleRate));
                        checkPurple = rand.nextInt(totalPWeight + 1);
                        if (checkPurple <= purpleWeight)
                        {
                            Purple = WeightFunctions.rollItem(CoxUniques);
                            String name = (String) Purple.get("name");
                            if (output.containsKey(name))
                            {
                                output.put(name, (output.get(name)+1));
                            }
                            else
                            {
                                output.put(name, 1);
                            }

                            totalLoots++;
                            totalPurples++;
                        }
                        else
                        {
                            // Roll normal loot;
                            NormalLoot = WeightFunctions.rollItem(CoxGenerics);
                            String name = (String) NormalLoot.get("name");
                            int divisor = ((Long) NormalLoot.get("divisor")).intValue();
                            int quantity;

                            if (divisor == 0) 
                            {quantity = 1;}
                            else
                            {quantity = (raidPoints / divisor);}
                            
                            if (output.containsKey(name))
                            {
                                output.put(name, (output.get(name)+quantity));
                            }
                            else
                            {
                                output.put(name, quantity);
                            }
                            
                            totalLoots++;
                        }
                    }
                    else
                    {
                        // Roll normal loot;
                        NormalLoot = WeightFunctions.rollItem(CoxGenerics);
                        String name = (String) NormalLoot.get("name");
                        int divisor = ((Long) NormalLoot.get("divisor")).intValue();
                        int quantity;

                        if (divisor == 0) 
                        {quantity = 1;}
                        else
                        {quantity = (raidPoints / divisor);}

                        if (output.containsKey(name))
                        {
                            output.put(name, (output.get(name)+quantity));
                        }
                        else
                        {
                            output.put(name, quantity);
                        }
                        
                        totalLoots++;
                    }
                }
            }
        }
        return output;
    }

    public static void getTbowChance(int raidPoints)
    {
        JSONParser parser = new JSONParser();
        JSONArray CoxUniques = null;

        try
        {
            CoxUniques = (JSONArray) parser.parse(new FileReader(COX_UNIQUES_PATH));
        }
        catch (IOException | ParseException e)
        {
            System.out.println("Invalid File Setup");
        }

        String msg1 = "With ";
        String msg2 = " Points, tbow chance is 1/";

        int totalPWeight = WeightFunctions.getTotalWeight(CoxUniques);

        // 1 out of purple weight
        double purpleWeight = (double)accuracy * (((double)raidPoints) / purpleRate); // large int
        double purpleRate = ((double)accuracy * 100.0)/purpleWeight; //  10k / large int
        double tbowRate = totalPWeight/2.0;
        int tbowChance = (int)Math.round(tbowRate * purpleRate);

        System.out.println(msg1 + raidPoints + msg2 + tbowChance);
    }

    public static String GenerateCoxLootImage(HashMap<String,Integer> CoxLoot) throws Exception
    {
        int TILE_WIDTH = 32;
        int TILE_HEIGHT = 32;

        int BUFFER_WIDTH = 16;
        int BUFFER_HEIGHT = 4;

        int TEXT_OFFSET_X = 1;
        int TEXT_OFFSET_Y = 9;

        int X = BUFFER_WIDTH;
        int Y = BUFFER_HEIGHT;

        int CANVAS_WIDTH = 400;
        int CANVAS_HEIGHT = (((CoxLoot.size()/8)+1)*36);

        //(((CoxLoot.size()/8)+1)*36);

        String IMAGE_PATH = "WeightTables\\LootSourceImages\\";
        String FONT_PATH = "WeightTables\\RuneScape-Plain-11.ttf";

        BufferedImage image = new BufferedImage(CANVAS_WIDTH, CANVAS_HEIGHT, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = image.createGraphics();

        // Font information
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font font = Font.createFont(Font.TRUETYPE_FONT, new File(FONT_PATH));
        ge.registerFont(font);
        Font osrsFont = new Font(font.getFontName(), Font.PLAIN, 16);
        g2d.setFont(osrsFont);

        // Images for Purples
        BufferedImage hat = ImageIO.read(new File(IMAGE_PATH+"Ancestral_hat.png"));
        BufferedImage shirt = ImageIO.read(new File(IMAGE_PATH+"Ancestral_robe_top.png"));
        BufferedImage pants = ImageIO.read(new File(IMAGE_PATH+"Ancestral_robe_bottom.png"));
        BufferedImage arcane = ImageIO.read(new File(IMAGE_PATH+"Arcane_prayer_scroll.png"));
        BufferedImage dex = ImageIO.read(new File(IMAGE_PATH+"Dexterous_prayer_scroll.png"));
        BufferedImage dinhs = ImageIO.read(new File(IMAGE_PATH+"Dinh's_bulwark.png"));
        BufferedImage claws = ImageIO.read(new File(IMAGE_PATH+"Dragon_claws.png"));
        BufferedImage dhcb = ImageIO.read(new File(IMAGE_PATH+"Dragon_hunter_crossbow.png"));
        BufferedImage maul = ImageIO.read(new File(IMAGE_PATH+"Elder_maul.png"));
        BufferedImage kodai= ImageIO.read(new File(IMAGE_PATH+"Kodai_Insignia.png"));
        BufferedImage bow = ImageIO.read(new File(IMAGE_PATH+"Twisted_bow.png"));
        BufferedImage buckler = ImageIO.read(new File(IMAGE_PATH+"Twisted_buckler.png"));

        // Images for normal items
        // TODO: add normal images and their paths
        BufferedImage addyOre = ImageIO.read(new File(IMAGE_PATH+"Adamantite_ore.png"));
        BufferedImage bloodRune = ImageIO.read(new File(IMAGE_PATH+"Blood_rune.png"));
        BufferedImage coal = ImageIO.read(new File(IMAGE_PATH+"Coal.png"));
        BufferedImage darkRelic = ImageIO.read(new File(IMAGE_PATH+"Dark_relic.png"));
        BufferedImage dragonArrow = ImageIO.read(new File(IMAGE_PATH+"Dragon_arrow.png"));
        BufferedImage dynamite = ImageIO.read(new File(IMAGE_PATH+"Dynamite.png"));
        BufferedImage goldOre = ImageIO.read(new File(IMAGE_PATH+"Gold_ore.png"));
        BufferedImage avantoe = ImageIO.read(new File(IMAGE_PATH+"Grimy_avantoe.png"));
        BufferedImage cadantine = ImageIO.read(new File(IMAGE_PATH+"Grimy_cadantine.png"));
        BufferedImage dwarfWeed = ImageIO.read(new File(IMAGE_PATH+"Grimy_dwarf_weed.png"));
        BufferedImage iritLeaf = ImageIO.read(new File(IMAGE_PATH+"Grimy_irit_leaf.png"));
        BufferedImage kwuarm = ImageIO.read(new File(IMAGE_PATH+"Grimy_kwuarm.png"));
        BufferedImage lantadyme = ImageIO.read(new File(IMAGE_PATH+"Grimy_lantadyme.png"));
        BufferedImage ranarrWeed = ImageIO.read(new File(IMAGE_PATH+"Grimy_ranarr_weed.png"));
        BufferedImage snapdragon = ImageIO.read(new File(IMAGE_PATH+"Grimy_snapdragon.png"));
        BufferedImage toadflax = ImageIO.read(new File(IMAGE_PATH+"Grimy_toadflax.png"));
        BufferedImage torstol = ImageIO.read(new File(IMAGE_PATH+"Grimy_torstol.png"));
        BufferedImage lizardFang = ImageIO.read(new File(IMAGE_PATH+"Lizardmen_fang.png"));
        BufferedImage mahogPlank = ImageIO.read(new File(IMAGE_PATH+"Mahogany_plank.png"));
        BufferedImage mithrilOre = ImageIO.read(new File(IMAGE_PATH+"Mithril_ore.png"));
        BufferedImage pureEss = ImageIO.read(new File(IMAGE_PATH+"Pure_essence.png"));
        BufferedImage runeArrow = ImageIO.read(new File(IMAGE_PATH+"Rune_arrow.png"));
        BufferedImage runiteOre = ImageIO.read(new File(IMAGE_PATH+"Runite_ore.png"));
        BufferedImage saltpetre = ImageIO.read(new File(IMAGE_PATH+"Saltpetre.png"));
        BufferedImage silverOre = ImageIO.read(new File(IMAGE_PATH+"Silver_ore.png"));
        BufferedImage soulRune = ImageIO.read(new File(IMAGE_PATH+"Soul_rune.png"));
        BufferedImage teakPlank = ImageIO.read(new File(IMAGE_PATH+"Teak_plank.png"));
        BufferedImage tornPrayer = ImageIO.read(new File(IMAGE_PATH+"Torn_prayer_scroll.png"));
        BufferedImage uncutDiamond = ImageIO.read(new File(IMAGE_PATH+"Uncut_diamond.png"));
        BufferedImage uncutEmerald = ImageIO.read(new File(IMAGE_PATH+"Uncut_emerald.png"));
        BufferedImage uncutRuby = ImageIO.read(new File(IMAGE_PATH+"Uncut_ruby.png"));
        BufferedImage uncutSapphire = ImageIO.read(new File(IMAGE_PATH+"Uncut_sapphire.png"));
        BufferedImage deathRune = ImageIO.read(new File(IMAGE_PATH+"Death_rune.png"));

        for(Map.Entry<String, Integer> item : CoxLoot.entrySet())
        {
            String name = item.getKey();
            int num = item.getValue();

            BufferedImage tempImage = null;

            switch (name)
            {
                case "Ancestral Hat":
                    tempImage = hat;
                    break;
                case "Ancestral Robe Top":
                    tempImage = shirt;
                    break;
                case "Ancestral Robe Bottom":
                    tempImage = pants;
                    break;
                case "Arcane Prayer Scroll":
                    tempImage = arcane;
                    break;
                case "Dexterous Prayer Scroll":
                    tempImage = dex;
                    break;
                case "Dinh's Bulwark":
                    tempImage = dinhs;
                    break;
                case "Dragon Claws":
                    tempImage = claws;
                    break;
                case "Dragon Hunter Crossbow":
                    tempImage = dhcb;
                    break;
                case "Elder Maul":
                    tempImage = maul;
                    break;
                case "Kodai Insignia":
                    tempImage = kodai;
                    break;
                case "Twisted Bow":
                    tempImage = bow;
                    break;
                case "Twisted Buckler":
                    tempImage = buckler;
                    break;
                case "Adamantite Ore":
                    tempImage = addyOre;
                    break;
                case "Blood Runes":
                    tempImage = bloodRune;
                    break;
                case "Coal":
                    tempImage = coal;
                    break;
                case "Dark Relic":
                    tempImage = darkRelic;
                    break;
                case "Dragon Arrows":
                    tempImage = dragonArrow;
                    break;
                case "Dynamite":
                    tempImage = dynamite;
                    break;
                case "Gold Ore":
                    tempImage = goldOre;
                    break;
                case "Avantoes":
                    tempImage = avantoe;
                    break;
                case "Cadantines":
                    tempImage = cadantine;
                    break;
                case "Dwarf Weeds":
                    tempImage = dwarfWeed;
                    break;
                case "Irit Leaves":
                    tempImage = iritLeaf;
                    break;
                case "Kwuarms":
                    tempImage = kwuarm;
                    break;
                case "Lantadymes":
                    tempImage = lantadyme;
                    break;
                case "Ranarr Weeds":
                    tempImage = ranarrWeed;
                    break;
                case "Snapdragons":
                    tempImage = snapdragon;
                    break;
                case "Toadflax":
                    tempImage = toadflax;
                    break;
                case "Torstols":
                    tempImage = torstol;
                    break;
                case "Lizardmen Fangs":
                    tempImage = lizardFang;
                    break;
                case "Mahogany Planks":
                    tempImage = mahogPlank;
                    break;
                case "Mithril Ore":
                    tempImage = mithrilOre;
                    break;
                case "Pure Essence":
                    tempImage = pureEss;
                    break;
                case "Rune Arrows":
                    tempImage = runeArrow;
                    break;
                case "Runite Ore":
                    tempImage = runiteOre;
                    break;
                case "Saltpetre":
                    tempImage = saltpetre;
                    break;
                case "Silver Ore":
                    tempImage = silverOre;
                    break;
                case "Soul Runes":
                    tempImage = soulRune;
                    break;
                case "Teak Planks":
                    tempImage = teakPlank;
                    break;
                case "Torn Prayer Scroll":
                    tempImage = tornPrayer;
                    break;
                case "Uncut Diamonds":
                    tempImage = uncutDiamond;
                    break;
                case "Uncut Emeralds":
                    tempImage = uncutEmerald;
                    break;
                case "Uncut Rubies":
                    tempImage = uncutRuby;
                    break;
                case "Uncut Sapphires":
                    tempImage = uncutSapphire;
                    break;
                case "Death Runes":
                    tempImage = deathRune;
                    break;
                default:
                tempImage = kodai;
            }

            g2d.drawImage(tempImage, X, Y, null);

            g2d.setColor(Color.BLACK);
            g2d.drawString(Integer.toString(num), X+TEXT_OFFSET_X+1, Y+TEXT_OFFSET_Y+1);
            g2d.setColor(Color.YELLOW);
            g2d.drawString(Integer.toString(num), X+TEXT_OFFSET_X, Y+TEXT_OFFSET_Y);

            X += TILE_WIDTH;
            X += BUFFER_WIDTH;

            if (X >= 400)
            {
                X = BUFFER_WIDTH;
                Y += BUFFER_HEIGHT;
                Y += TILE_HEIGHT;
            }
        }

        ImageIO.write(image, "png", new File(COX_LOOT_IMAGE_PATH));

        return COX_LOOT_IMAGE_PATH;

    }
}
