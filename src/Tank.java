import java.awt.image.BufferedImage;

public class Tank
{
    private int x;
    private int y;
    private int vx;
    private int vy;
    private int angle;

    private final int R = 2;
    private final int ROTATIONSPEED = 4;

    private BufferedImage img;
    private boolean UpPressed;
    private boolean DownPressed;
    private boolean RightPressed;
    private boolean LeftPressed;

    Tank(int x, int y, int vx, int vy, int angle, BufferedImage img)
    {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.img = img;
        this.angle = angle;
    }

    
}
