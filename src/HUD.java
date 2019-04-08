import java.awt.*;

public class HUD
{
    public static int HEALTH1 = 100;
    public static int HEALTH2 = 100;

    public void tick()
    {
        //HEALTH--;
        HEALTH1 = Game.clamp(HEALTH1,0, 100);
        HEALTH2 = Game.clamp(HEALTH2,0, 100);
    }

    public void render(Graphics g)
    {

        //for player1
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 15);
        g.setColor(Color.green);
        g.fillRect(15,15, HEALTH1*2, 15);
        g.setColor(Color.white);
        g.drawRect(15,15, 200, 15);
        g.drawString("Player 1",15,12);

        //for player2
        g.setColor(Color.gray);
        g.fillRect(Game.WIDTH - 215, 15, 200, 15);
        g.setColor(Color.green);
        g.fillRect(Game.WIDTH - 215, 15, HEALTH2*2, 15);
        g.setColor(Color.white);
        g.drawRect(Game.WIDTH - 215, 15, 200, 15);
        g.drawString("Player 2",Game.WIDTH - 215,12);

    }
}
