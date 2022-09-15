
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Selector for the MainMenu Screen
 * Drawn by John
 * Code by Kenny
 * 11/26/19
 */
public class Selecter extends Actor
{
    private int i = 0;
    private int l = 0;
    private int confirm = 0;
    private GreenfootSound gfs = new GreenfootSound("BBS Confirm.wav");
    private GreenfootSound gfs1 = new GreenfootSound("BBS Scroll.wav");
    public void act()
    {
        // Add your action code here.
        move();
        sound();
        i++;
    }
    /**
     * Reads a user's input and moves corresponding to the input.
     * Kenny
     */
    private void move()
    {
        int x = getX();
        if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) 
        {
            setLocation(getX(), getY()-150);
            
        }    
        if(Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY()+150);
            
        }
        if(getY() > 475)    
        {
            setLocation (getX(), 475);
        }
        if(getY() < 325)    
        {
            setLocation (getX(), 325);
        }
        if(x == getX() && i == 20)
        {
            move(-20);
        }
        if(getX() == 280 && i == 40)
        {
            move(20);
            i = 0;
        }
    }
    /**
     * Plays a sound whenever the selector moves
     * sounds from sounds-resource.com
     * Kenny
     */
    public void sound()
    {
        if((Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("s") || (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("down"))) && l < 1) 
        
        {
           gfs1.setVolume(80);
           gfs1.play();
        }
        if((Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("s") || (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("down"))))
        {
            l++;
        }
        else
        {
            l = 0;
        }
        if(Greenfoot.isKeyDown("enter") && confirm < 1)
        {
            gfs.setVolume(65);
            gfs.play();
        }
        if(Greenfoot.isKeyDown("enter"))
        {
            confirm++;
        }
        else
        {
            confirm = 0;
        }
    }
    
}
