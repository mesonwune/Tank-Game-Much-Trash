import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BufferedImageLoader
{
    private BufferedImage image;

    public BufferedImage loadImage(String path) throws IOException
    {
        File f = new File(path);
        image = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
        image = ImageIO.read(f);
        System.out.println("Reading complete.");

        return image;
    }
}
