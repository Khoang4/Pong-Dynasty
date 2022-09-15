
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Describes how the ball will act according to the influences of the other characters 
 * 
 * John and Kenny 
 * 12/6/19
 */
public class Ball extends Actor
{
    //velocity of ball by components (John and Kenny)
    private int movingX = 0;
    private int movingY = 0;
   
    private boolean Swing1 = false;
    private boolean Swing2 = false;
    private boolean Safety1 = false;
    private boolean Safety2 = false;
    private int safetyCooldown1 = 0;
    private int safetyCooldown2 = 0;
    private int swingLength1 = 0;
    private int swingLength2 = 0;
    private int cooldown1 = 0;
    private int cooldown2 = 0;
    
    //counters 
    private int l = 0;
    private int i = 0;
    
    //sounds for ball bounce, hits, and player disappearing (John)
    private GreenfootSound poof = new GreenfootSound("poof.mp3");
    private GreenfootSound bounce = new GreenfootSound("bounce.wav");
    private GreenfootSound hit1 = new GreenfootSound("hit1.mp3");
    private GreenfootSound hit2 = new GreenfootSound("hit2.mp3");
    
    public void act()
    {
        setLocation(getX() + movingX, getY() + movingY); //move ball
        swing();
        evaluateHitFail();
        hitSuccess();
        collideWall();
    }  
    /**
     * Checking if the player swings at the correct timing and removes him if he does not
     * Adds points for player if defeats other player
     * Kenny and John
     */
    public void swing()
    {
        //player 1 swing
        if ((Greenfoot.isKeyDown("g") || Greenfoot.isKeyDown("space")) && cooldown1 >= 15)
        {
            Swing1 = true;
        }
        if ((Greenfoot.isKeyDown("g") || Greenfoot.isKeyDown("space")))
        {
            l++;
        }
        else
        {
            l = 0;
        }
        if (l > 25 || swingLength1 > 15)
        {
            Swing1 = false;
        }
        if (Swing1 == true)
        {
            swingLength1++;
            cooldown1=0;
        }
        else
        {
            swingLength1 = 0;
        }
        
        //player 2 swing
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
        
        cooldown1++;
        cooldown2++;
    }
    /**
     * Check if the player is safe or should be removed after touching the ball
     * Kenny
     */
    public void evaluateHitFail()
    {
        if (isTouching(Player1.class) && Swing1)
        {
            Safety1 = true;
        }
        if (!isTouching(Player1.class))
        {
            Safety1 = false;
        }
        if (isTouching(Player1.class) && (!Swing1 || l > 25) && !Safety1 && 
                            (Math.abs(movingX) > 0 || Math.abs(movingY) > 0))
        {
            removeTouching(Player1.class);
            
            poof.play();
            Battlefield b = (Battlefield)getWorld();
            b.addScore(0,1);
        }
        
        if (isTouching(Player2.class) && Swing2)
        {
            Safety2 = true;
        }
        if (!isTouching(Player2.class))
        {
            Safety2 = false;
        }
        if (isTouching(Player2.class) && (!Swing2 || i > 25) && !Safety2 &&
                            (Math.abs(movingX) > 0 || Math.abs(movingY) > 0))
        {
            removeTouching(Player2.class);
            
            poof.play();
            Battlefield b = (Battlefield)getWorld();
            b.addScore(1,0);
        }
    }
    /**
     * When the ball bounces off the wall
     * John
     */
    public void collideWall()
    {
        //bounce off of walls
        if(getX() <= 25 || getX() >= 975)
        {
            movingX = -movingX;
            GreenfootSound bounce = new GreenfootSound("bounce.wav");
            bounce.setVolume(85);
            bounce.play();
        }
        
        //bounce off of floor and ceiling
        if(getY() <= 25 || getY() >= 575)
        {
            movingY = -movingY;
            GreenfootSound bounce = new GreenfootSound("bounce.wav");
            bounce.setVolume(85);
            bounce.play();
        }
    }
    /**
     * Gets the ball moving faster if the ball is hit by the player successfully
     * Kenny and John
     */
    public void hitSuccess()
    {
        //interaction with player 1
        if (isTouching(Player1.class) && Swing1 && l <= 25)
        {
            hit1.play();
            if (getX() < getWorld().getObjects(Player1.class).get(0).getX() && 
                    getWorld().getObjects(Player1.class).get(0).getOrientation())
            {
                movingX = -(Math.abs(movingX)+1);
            }
            if (getX() > getWorld().getObjects(Player1.class).get(0).getX() && 
                    !getWorld().getObjects(Player1.class).get(0).getOrientation())
            {
                movingX = Math.abs(movingX)+1;
            }
        }
        if (isTouching(Player1.class) && Swing1 && l <= 25 && Greenfoot.isKeyDown("w"))
        {
            movingY = -(Math.abs(movingY)+1);
        }
        if (isTouching(Player1.class) && Swing1 && l <= 25 && Greenfoot.isKeyDown("s"))
        {
            movingY = Math.abs(movingY)+1;
        }
        
        //interaction with player 2
        if (isTouching(Player2.class) && Swing2 && i <= 25)
        {
            hit2.play();
            if (getX() < getWorld().getObjects(Player2.class).get(0).getX() && 
                    getWorld().getObjects(Player2.class).get(0).getOrientation())
            {
                movingX = -(Math.abs(movingX)+1);
            }
            if (getX() > getWorld().getObjects(Player2.class).get(0).getX() && 
                    !getWorld().getObjects(Player2.class).get(0).getOrientation())
            {
                movingX = Math.abs(movingX)+1;
            }
        }
        if (isTouching(Player2.class) && Swing2 && i <= 25 && Greenfoot.isKeyDown("up"))
        {
            movingY = -(Math.abs(movingY)+1);
        }
        if (isTouching(Player2.class) && Swing2 && i <= 25 && Greenfoot.isKeyDown("down"))
        {
            movingY = Math.abs(movingY)+1;
        }
    }
}
