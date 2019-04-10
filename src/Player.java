import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject
{
    private BufferedImage image;
    private boolean UpPressed;
    private boolean DownPressed;
    private boolean RightPressed;
    private boolean LeftPressed;
    private int angle;

    private int vx, vy = 0;
    private final int R = 2;
    private final int ROTATIONSPEED = 4;

    public Player(int x, int y, ID id)
    {
        super(x, y, id);

        angle = 0;
    }

    public void tick()
    {

        /*
        if (this.UpPressed) {
            this.moveForwards();
        }
        if (this.DownPressed) {
            this.moveBackwards();
        }

        if (this.LeftPressed) {
            this.rotateLeft();
        }
        if (this.RightPressed) {
            this.rotateRight();
        }


         */

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

    public Rectangle getBounds()
    {
        return null;
    }

    /*
    void toggleUpPressed() {
        this.UpPressed = true;
    }

    void toggleDownPressed() {
        this.DownPressed = true;
    }

    void toggleRightPressed() {
        this.RightPressed = true;
    }

    void toggleLeftPressed() {
        this.LeftPressed = true;
    }

    void unToggleUpPressed() {
        this.UpPressed = false;
    }

    void unToggleDownPressed() {
        this.DownPressed = false;
    }

    void unToggleRightPressed() {
        this.RightPressed = false;
    }

    void unToggleLeftPressed() {
        this.LeftPressed = false;
    }

    private void rotateLeft() {
        this.angle -= this.ROTATIONSPEED;
    }

    private void rotateRight() {
        this.angle += this.ROTATIONSPEED;
    }

    private void moveBackwards() {
        vx = (int) Math.round(R * Math.cos(Math.toRadians(angle)));
        vy = (int) Math.round(R * Math.sin(Math.toRadians(angle)));
        x -= vx;
        y -= vy;
        checkBorder();
    }

    private void moveForwards() {
        vx = (int) Math.round(R * Math.cos(Math.toRadians(angle)));
        vy = (int) Math.round(R * Math.sin(Math.toRadians(angle)));
        x += vx;
        y += vy;
        checkBorder();
    }




    private void checkBorder() {
        if (x < 30) {
            x = 30;
        }
        if (x >= Game.WIDTH - 88) {
            x = Game.WIDTH - 88;
        }
        if (y < 40) {
            y = 40;
        }
        if (y >= Game.HEIGHT - 80) {
            y = Game.HEIGHT - 80;
        }
    }

*/
}
