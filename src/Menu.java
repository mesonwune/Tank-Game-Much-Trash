import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter
{
    //private int mx, my;\
    private Game game;
    private Handler handler;
    private Random r = new Random();

    public Menu(Game game, Handler handler)
    {
        this.game = game;
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e)
    {
         int mx = e.getX();
         int my = e.getY();

         if (game.gameState == Game.STATE.Menu)
         {
             //play button
             if (mouseOver(mx, my, 540, 150, 200, 64))
             {
                 game.gameState = Game.STATE.Game;
                 handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player));
                 handler.addObject(new Player(Game.WIDTH / 2 + 64, Game.HEIGHT / 2 - 32, ID.Player2));
             }
             //help button
             if (mouseOver(mx, my, 540, 300, 200, 64))
             {
                 game.gameState = Game.STATE.Help;
             }

             //quit button
             if (mouseOver(mx, my, 540, 450, 200, 64))
             {
                 System.exit(1);
             }

         }

        //back button for help
        if (game.gameState == Game.STATE.Help)
        {
            if (mouseOver(mx, my, 540, 450, 200, 64))
            {
                game.gameState = Game.STATE.Menu;
                return;
            }
        }

    }

    public void mouseReleased(MouseEvent e)
    {

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height)
    {
        if (mx > x && mx < x + width)
        {
            if (my > y && my < y + height)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public void tick()
    {

    }

    @SuppressWarnings("Duplicates")
    public void render(Graphics g)
    {
        if (game.gameState == Game.STATE.Menu)
        {
            Font font = new Font("arial", 1, 50);
            Font font2 = new Font("arial", 1, 30);

            g.setFont(font);
            g.setColor(Color.white);
            g.drawString("Tanker Menu", 500, 75);

            g.setFont(font2);
            g.drawRect(540, 150, 200, 64);
            g.drawString("Play", 600, 190);

            g.drawRect(540, 300, 200, 64);
            g.drawString("Help", 600, 340);

            g.drawRect(540, 450, 200, 64);
            g.drawString("Quit", 600, 490);
        }
        else if (game.gameState == Game.STATE.Help)
        {
            Font font = new Font("arial", 1, 50);
            Font font2 = new Font("arial", 1, 30);
            Font font3 = new Font("arial", 1, 20);

            g.setFont(font);
            g.setColor(Color.white);
            g.drawString("Help", 500, 75);

            g.setFont(font3);
            g.drawString("Player 1: Use WASD keys to move/rotate. Use SPACE to shoot.", 100, 200);
            g.drawString("Player 2: Use UP, DOWN, LEFT, AND RIGHT keys to move/rotate. Use ENTER to shoot.", 100, 300);

            g.setFont(font2);
            g.drawRect(540, 450, 200, 64);
            g.drawString("Back", 600, 490);
        }
    }
}
