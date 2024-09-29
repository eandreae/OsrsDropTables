package WeightTables;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.File;
import java.util.Random;

public class CanvasTest {

    public static int TILE_WIDTH = 32;
    public static int TILE_HEIGHT = 32;

    public static int BUFFER_WIDTH = 16;
    public static int BUFFER_HEIGHT = 4;

    public static int TEXT_OFFSET_X = 1;
    public static int TEXT_OFFSET_Y = 9;

    public static int X = BUFFER_WIDTH;
    public static int Y = BUFFER_HEIGHT;

    public static int WIDTH = 400;
    public static int HEIGHT = 500;

    public static String IMAGE_PATH = "WeightTables\\LootSourceImages\\";
    public static String FONT_PATH = "WeightTables\\RuneScape-Plain-11.ttf";

    public static void main(String[] args) throws Exception {

        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = image.createGraphics();

        //BufferedImage test = ImageIO.read(new File(IMAGE_PATH));
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
        
        BufferedImage[] imageArray = 
        {
            hat,shirt,pants,arcane,dex,dinhs,claws,dhcb,maul,kodai,bow,buckler
        };

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font font = Font.createFont(Font.TRUETYPE_FONT, new File(FONT_PATH));
        ge.registerFont(font);

        Font osrsFont = new Font(font.getFontName(), Font.PLAIN, 16);
        g2d.setFont(osrsFont);

        for(BufferedImage item : imageArray)
        {

            //g2d.setColor(Color.RED);
            //g2d.fillRect(X, Y, TILE_WIDTH, TILE_HEIGHT);

            g2d.drawImage(item, X, Y, null);

            

            Random rand = new Random();

            int num = rand.nextInt(10);

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

        
        

        ImageIO.write(image, "png", new File("TESTLOOT.png"));

    }

}
