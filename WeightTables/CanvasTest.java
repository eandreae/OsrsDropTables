package WeightTables;

import java.awt.Color;

import java.awt.Graphics2D;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.File;

import java.io.IOException;

public class CanvasTest {

    public static int WIDTH = 500;
    public static int HEIGHT = 500;
    public static String IMAGE_PATH = "WeightTables\\Ancient_chest2.png";

    public static void main(String[] args) throws IOException {

        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = image.createGraphics();

        BufferedImage test = ImageIO.read(new File(IMAGE_PATH));

        g2d.drawImage(test, 0, 0, null);

        g2d.setColor(Color.BLUE);

        g2d.fillRect(20, 30, 100, 50);

        g2d.setColor(Color.RED);

        g2d.fillRect(400, 100, 200, 200);

        ImageIO.write(image, "png", new File("myRectangle.png"));

    }

}
