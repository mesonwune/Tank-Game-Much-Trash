import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{

    private Handler handler;
    private Player t1, t2;

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
                //forward backwards
                if (key == KeyEvent.VK_W) { obj.setUp(true); }
                if (key == KeyEvent.VK_S) { obj.setDown(true);}

                //rotate left and right
                if (key == KeyEvent.VK_A) { obj.setLeft(true); }
                if (key == KeyEvent.VK_D) { obj.setRight(true);}
            }
            else if (obj.getId() == ID.Player2)
            {
                //all key events for Player 2
                if (key == KeyEvent.VK_UP) { obj.setUp(true); }
                if (key == KeyEvent.VK_DOWN) { obj.setDown(true);}
                if (key == KeyEvent.VK_LEFT) { obj.setLeft(true);}
                if (key == KeyEvent.VK_RIGHT) { obj.setRight(true);}
            }
        }

    }


    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();

        for (GameObject obj : handler.object)
        {
            if (obj.getId() == ID.Player)
            {
                //all key events for Player 1
                if (key == KeyEvent.VK_W) { obj.setUp(false); }
                if (key == KeyEvent.VK_S) { obj.setDown(false); }
                if (key == KeyEvent.VK_A) { obj.setLeft(false); }
                if (key == KeyEvent.VK_D) { obj.setRight(false); }
            } else if (obj.getId() == ID.Player2)
            {
                //all key events for Player 2
                if (key == KeyEvent.VK_UP) { obj.setUp(false); }
                if (key == KeyEvent.VK_DOWN) { obj.setDown(false); }
                if (key == KeyEvent.VK_LEFT) { obj.setLeft(false); }
                if (key == KeyEvent.VK_RIGHT) { obj.setRight(false); }
            }
        }
    }
}

