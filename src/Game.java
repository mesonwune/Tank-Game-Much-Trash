import java.awt.*;

public class Game extends Canvas implements Runnable
{

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;

    public Game()
    {
        new Window(WIDTH, HEIGHT, "Tanker", this);
    }
    public synchronized void start()
    {

    }

    public void run()
    {

    }

    public static void main(String[] args)
    {
        new Game();
    }
}
