import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Player extends GameObject
{
    private BufferedImage image;

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

        if (this.isUp()) {
            this.moveForwards();
        }
        if (this.isDown()) {
            this.moveBackwards();
        }

        if (this.isLeft()) {
            this.rotateLeft();
        }
        if (this.isRight()) {
            this.rotateRight();
        }




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

    void drawImage(Graphics g) {
        AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
        rotation.rotate(Math.toRadians(angle), this.image.getWidth() / 2.0, this.image.getHeight() / 2.0);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.image, rotation, null);
    }

}
