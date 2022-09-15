import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Gives a video for the user to watch in order to learn how to play the game
 * Drawn by John
 * John 
 * 12/9/19
 */
public class TrainingGif extends Actor
{
    private GifImage animation = new GifImage("combo example.gif");
    /**
     * Gets the gif to play on the screen
     */
    public void act() 
    {
        setImage(animation.getCurrentImage());
    }    
}
