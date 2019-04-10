import java.awt.*;
import java.awt.image.BufferedImage;

//referring to all game objects (inheriting all objects)
public abstract class GameObject
{
    protected int x,y; //
    protected ID id;
    protected float velX, velY = 0;
    private int angle;

    private BufferedImage img;
    private final int R = 2;
    private final int ROTATIONSPEED = 4;

    private boolean up, down, right, left = false;

    public GameObject(int x, int y, ID id)
    {
        this.x = x;
        this.y = y;
        this.id = id;
        this.img = img;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public int getX() { return x; }

    public void setX(int x) { this.x = x; }

    public int getY() { return y; }

    public void setY(int y) { this.y = y; }

    public ID getId() { return id; }

    public void setId(ID id) { this.id = id; }

    public float getVelX() { return velX; }

    public void setVelX(int velX) { this.velX = velX; }

    public float getVelY() { return velY; }

    public void setVelY(int velY) { this.velY = velY; }

    public int getAngle() { return angle; }

    public void setAngle(int angle) { this.angle = angle; }

    public BufferedImage getImg() { return img; }

    public void setImg(BufferedImage img) { this.img = img; }

    public int getROTATIONSPEED() { return ROTATIONSPEED; }

    public int getR() { return R; }

    public boolean isUp() { return up; }

    public void setUp(boolean up) { this.up = up; }

    public boolean isDown() { return down; }

    public void setDown(boolean down) { this.down = down; }

    public boolean isRight() { return right; }

    public void setRight(boolean right) { this.right = right; }

    public boolean isLeft() { return left; }

    public void setLeft(boolean left) { this.left = left; }
}
