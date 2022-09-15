
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the players that will hit the ball and can move around
 * Drawn by John  
 * Code by both Kenny and John
 * 12/9/19
 */
public class Player2 extends Actor
{
    private boolean Swing2 = false;
    private int i = 0;
    private int swingLength2 = 0;
    private int cooldown2 = 0;
    private int velocity = 0;
    private int g = 1;
    private GreenfootImage imageLeft = new GreenfootImage("Player2_Left.png");
    private GreenfootImage imageRight = new GreenfootImage("Player2_Right.png");
    private GreenfootImage imageRightSwing = new GreenfootImage("Player2_Right_Swing.png");
    private GreenfootImage imageLeftSwing = new GreenfootImage("Player2_Left_Swing.png");
    private boolean left = true;
    
    public void act() 
    {
        swing();
        move();
        orientation();
    } 
    /**determines if the player is swinging/trying to hit the ball
     * Kenny
     */
    private void swing()
    {
        if (Greenfoot.isKeyDown("shift") && cooldown2 >= 15)
        {
            Swing2 = true;
        }
        if (Greenfoot.isKeyDown("shift"))
        {
            i++;
        }
        else
        {
            i = 0;
        }
        if (i > 25 || swingLength2 > 15)
        {
            Swing2 = false;
        }
        if (Swing2 == true)
        {
            swingLength2++;
            cooldown2=0;
        }
        else
        {
            swingLength2 = 0;
        }
        cooldown2++;
    }
    /**
     * Getting the player to move 
     * Kenny
     */
    private void move()
    {
        setLocation(getX(), getY()+velocity);
        if(Greenfoot.isKeyDown("right"))
        {
            move(10);
            left = false;
        }
        if(Greenfoot.isKeyDown("left"))
        {
            move(-10);
            left = true;
        }
        if(Greenfoot.isKeyDown("up") && (getY() >= 500))
        {
            velocity = -22;
        }    
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY()+5);
        }
        velocity += g;
        
        if(getY() > 519)    //stops player from clipping through floor
        {
            setLocation (getX(), 519);
        }
    }
    /**orients which way the image faces 
     * John
     */
    
    public void orientation()
    {
        if (left == true)
        {
            if (Swing2)
            {
                setImage(imageLeftSwing);
            }
            else
            {
                setImage(imageLeft);
            }
        }
        else
        {
            if (Swing2)
            {
                setImage(imageRightSwing);
            }
            else
            {
                setImage(imageRight);
            }
        }
    }
    /**
     * Determines how the player is oriented
     * John
     */
    public boolean getOrientation()
    {
        return left;
    }
}
