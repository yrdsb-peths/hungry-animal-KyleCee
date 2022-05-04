import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fish extends Actor
{
    /**
     * Act - do whatever the Fish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("d"))
        {
            move(10);
        }
        
        if (Greenfoot.isKeyDown("a"))
        {
            move(-10);
        }
        
        if (Greenfoot.isKeyDown("s"))
        {
            int x = getX();
            int y = getY();
            setLocation(x, y + 10);
        }
        
        if (Greenfoot.isKeyDown("w"))
        {
            int x = getX();
            int y = getY();
            setLocation(x, y - 10);
        }
        
        if (isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnApple();
        }
    }
}
