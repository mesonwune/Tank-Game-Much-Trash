import java.awt.*;
import java.awt.image.BufferedImage;

//referring to all game objects (inheriting all objects)
public abstract class GameObject
{
    protected int x,y; //
    protected ID id;
    protected int velX, velY;
    private int angle;

    private BufferedImage img;

    public GameObject(int x, int y, ID id)
    {
        this.x = x;
        this.y = y;
        this.id = id;
        this.img = img;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public int getX() { return x; }

    public void setX(int x) { this.x = x; }

    public int getY() { return y; }

    public void setY(int y) { this.y = y; }

    public ID getId() { return id; }

    public void setId(ID id) { this.id = id; }

    public int getVelX() { return velX; }

    public void setVelX(int velX) { this.velX = velX; }

    public int getVelY() { return velY; }

    public void setVelY(int velY) { this.velY = velY; }

    public int getAngle() { return angle; }

    public void setAngle(int angle) { this.angle = angle; }

    public BufferedImage getImg() { return img; }

    public void setImg(BufferedImage img) { this.img = img; }
}
