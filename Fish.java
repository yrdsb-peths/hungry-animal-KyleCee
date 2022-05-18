import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fish extends Actor
{
    GreenfootSound fishSound = new GreenfootSound("fishbubbling.mp3");
    GreenfootImage[] idle = new GreenfootImage[6];
    
    public Fish()
    {
        for (int i = 1; i < 6; i++)
        {
            idle[i] = new GreenfootImage("images/idleani/idle" + i + ".png");
        }
        setImage(idle[1]);
    }
    
    
    int imageIndex = 1;
    public void animate()
    {
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("d"))
        {
            move(4);
        }
        
        if (Greenfoot.isKeyDown("a"))
        {
            move(-4);
        }
        
        if (Greenfoot.isKeyDown("s"))
        {
            int x = getX();
            int y = getY();
            setLocation(x, y + 4);
        }
        
        if (Greenfoot.isKeyDown("w"))
        {
            int x = getX();
            int y = getY();
            setLocation(x, y - 4);
        }
        
        eat();
        
        animate();
    }
    public void eat()
    {
        if (isTouching(Apple.class))
        {
            
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            world.spawnApple();
            fishSound.play();
        }
    }
}
