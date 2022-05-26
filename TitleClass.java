import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen
 * 
 * @author Tse 
 * @version May 20, 2022
 */
public class TitleClass extends World
{
    Label titleLabel = new Label("Hungry Fish", 85);
    Label howStart = new Label ("press <space> to start", 40);
    /**
     * Constructor for objects of class TitleClass.
     * 
     */
    public TitleClass()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject (howStart, 300, 260);
        addObject(titleLabel, getWidth()/2, getHeight()/2);
        prepare();
    }

    /**
     * The main world act loop
     */
    public void act()
    {
        // Starts game if user presses the sapce bar down
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Fish fish = new Fish();
        addObject(fish,78,73);
        Fish fish2 = new Fish();
        addObject(fish2,188,119);
        Fish fish3 = new Fish();
        addObject(fish3,261,37);
        Label label = new Label("use WASD to move", 50);
        addObject(label,283,312);
        label.setLocation(180,308);
        label.setLocation(294,313);
    }
}
