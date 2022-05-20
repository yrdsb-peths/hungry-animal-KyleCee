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
    GreenfootImage[] idleRight = new GreenfootImage[6];
    GreenfootImage[] idleLeft = new GreenfootImage[6];
    
    
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    public Fish()
    {
        for (int i = 1; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/idleani/idle" + i + ".png");
            idleRight[i].scale(110,80);
        }
    
    
        for (int i = 1; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/idleani/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();       
            idleLeft[i].scale(110,80);
            
        }
        
        
        animationTimer.mark();
        setImage(idleRight[1]);
    }
    
    int imageIndex = 1;
    public void animate()
    {
        if(animationTimer.millisElapsed() < 200)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("d"))
        {
            move(4);
            facing = "right";
        }
        
        if (Greenfoot.isKeyDown("a"))
        {
            move(-4);
            facing = "left";
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
