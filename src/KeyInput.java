import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{

    private Handler handler;

    public KeyInput(Handler handler)
    {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e)
    {

        int key = e.getKeyCode();

        for (GameObject obj : handler.object)
        {
            if (obj.getId() == ID.Player)
            {
                //all key events for Player 1
                if (key == KeyEvent.VK_W) { obj.setVelY(-3);}
                if (key == KeyEvent.VK_S) { obj.setVelY(3);}
                if (key == KeyEvent.VK_A) { obj.setVelX(-3);}
                if (key == KeyEvent.VK_D) { obj.setVelX(3);}
            }
            else if (obj.getId() == ID.Player2)
            {
                //all key events for Player 2
                if (key == KeyEvent.VK_UP) { obj.setVelY(-3); }
                if (key == KeyEvent.VK_DOWN) { obj.setVelY(3);}
                if (key == KeyEvent.VK_LEFT) { obj.setVelX(-3);}
                if (key == KeyEvent.VK_RIGHT) { obj.setVelX(3);}
            }
        }

        //if(key == keyEvent.)
    }


    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();

        for (GameObject obj : handler.object)
        {
            if (obj.getId() == ID.Player)
            {
                //all key events for Player 1
                if (key == KeyEvent.VK_W) { obj.setVelY(0); }
                if (key == KeyEvent.VK_S) { obj.setVelY(0); }
                if (key == KeyEvent.VK_A) { obj.setVelX(0); }
                if (key == KeyEvent.VK_D) { obj.setVelX(0); }
            } else if (obj.getId() == ID.Player2)
            {
                //all key events for Player 2
                if (key == KeyEvent.VK_UP) { obj.setVelY(0); }
                if (key == KeyEvent.VK_DOWN) { obj.setVelY(0); }
                if (key == KeyEvent.VK_LEFT) { obj.setVelX(0); }
                if (key == KeyEvent.VK_RIGHT) { obj.setVelX(0); }
            }
        }
    }
}

