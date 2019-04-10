import java.awt.*;
import java.util.LinkedList;

//looping through all objects in game and individually update and render
//to string
public class Handler
{
    LinkedList<GameObject> object = new LinkedList<>(); //gonna contain all game objects

    //get an object and use the tick method for it
    public void tick()
    {
        for (int i = 0; i < object.size(); i++)
        {
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }

    //get an object and use the render method for it
    public void render(Graphics g)
    {
        for (int i = 0; i < object.size(); i++)
        {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject obj) {this.object.add(obj); }
    public void removeObject(GameObject obj) {this.object.remove(obj);}


}
