import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Game extends Canvas implements Runnable
{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    //window size
    public static final int WIDTH = 1280, HEIGHT = 720;

    //entire game runs through the thread
    private Thread thread;
    private boolean running = false;

    //buffers the whole window
    private BufferedImage image, tank1, tank2 = null;

    private Random r;
    private Handler handler;
    private HUD hud;
    private Menu menu;

    /*
    public enum STATE
    {
        Menu,
        Help,
        Game,
        End
    }

    public STATE gameState = STATE.Menu;

*/
    public Game()
    {
        handler = new Handler();
        //menu = new Menu(this, handler);
        this.addKeyListener(new KeyInput(handler));
        //this.addMouseListener(menu);

        BufferedImageLoader loader = new BufferedImageLoader();

        image = loader.loadImage("src/resources/images/tank_level.png");

        System.out.println(image == null);

        /*System.out.println("Height: " + screenSize.getHeight());
        System.out.println("Width: " + screenSize.getWidth());
        System.out.println("size: " + screenSize.getSize());*/
        new Window(WIDTH, HEIGHT, "Tanker", this);



        hud = new HUD();

        r = new Random();

        /*
        if (gameState == STATE.Game)
        {
            this.loadLevel(image);
        }
        */

        loadLevel(image);
    }

    public synchronized void start()
    {
        thread = new Thread(this);
        thread.start();
        running = true;
    }


    public synchronized void stop()
    {
        try {
            //kill off the thread
            thread.join();
            running = false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //classic game loop method
    public void run()
    {
        this.requestFocus();
        long lastTime = System.nanoTime(); //start time to measure amount of time passed
        double amountOfTicks = 60.0; //# of ticks per second
        double ns = 1000000000 / amountOfTicks; //# of nanoseconds allowed between ticks
        double delta = 0; //amount of time difference between ticks
        long timer = System.currentTimeMillis(); //used @ the start time for measuring a second
        int frames = 0; //# of frames per second

        //this loop is checking that the game is running in general
        //adding the time it took to go through 1 iteration of loop
        //then adds it to delta
        while(running)
        {
            //update delta with the amount of time passed
            //since the last iteration of the loop
            long now = System.nanoTime(); //getting current time
            delta += (now - lastTime) / ns;
            lastTime = now;

            //while we're behind on game ticks:
            //once delta is >= 1, enough time has passed to go forward one tick
            //ensures that the game isn't running to fast
            while (delta >= 1)
            {
                tick();
                delta--;
            }

            //render everything and add to frames counter
            if(running) {render();}
            frames++;

            //if a second passed, print total number of frames in the last second and reset FPS
            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    //update to all valid game objects in game
    private void tick()
    {
        handler.tick();
        /*
        if (gameState == STATE.Game)
        {
            hud.tick();
        }
        else if (gameState == STATE.Menu || gameState == STATE.End)
        {
            menu.tick();
        }
        */

    }

    //redrawing of the screen
    private void render()
    {

        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null)
        {
            //we're going to have 3 buffers
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.red);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        /*
        if (gameState == STATE.Game)
        {
            hud.render(g);
        }
        else if (gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End)
        {
            menu.render(g);
        }
        */


        g.dispose();
        bs.show();
    }

    private void loadLevel(BufferedImage image)
    {
        int w = image.getWidth();
        int h = image.getHeight();

        for (int xx = 0; xx < w; xx++)
        {
            for (int yy = 0; yy < h; yy++)
            {
                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;


                if (red == 255 && blue == 255 && green == 255)
                {
                    handler.addObject(new Player(xx*32, yy*32, ID.Player));
                }
                else if (blue == 255 && green == 0 && red == 0)
                {
                    handler.addObject(new Player(xx*32, yy*32, ID.Player2));
                }
                else if (red == 0 && blue == 0 && green == 0)
                {
                    handler.addObject(new Block (xx*32, yy*32, ID.Block));
                }
            }
        }
    }

    //making sure that the player can't leave the game
    public static int clamp(int var, int min, int max)
    {
        if(var >= max)
        {
            return var = max;
        }
        else if (var <= min)
        {
            return var = min;
        }
        else
        {
            return var;
        }
    }


    public static void main(String[] args)
    {
        new Game();

    }
}
