import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject
{
    private BufferedImage image;
    private int angle;

    private final int R = 2;
    private final int ROTATIONSPEED = 4;

    public Player(int x, int y, ID id)
    {
        super(x, y, id);

        angle = 0;
    }

    public void tick()
    {
        x += getVelX();
        y += getVelY();

        x = Game.clamp(x,0, Game.WIDTH - 32);
        y = Game.clamp(y, 0, Game.HEIGHT - 54);

    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y + ", angle=" + angle;
    }

    public void render(Graphics g)
    {
        if (id == ID.Player)
        {
            g.setColor(Color.white);
        }
        else
        {
            g.setColor(Color.blue);
        }
        g.fillRect(x, y, 32, 32);
    }


}
