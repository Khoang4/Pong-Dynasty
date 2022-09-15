import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Information and instructions for combining player movements
 * sounds from sounds-resource.com
 * John
 * 12/6/19
 */
public class Information2 extends World
{
    private int i = 0;
    private int p = 0;
    private int l = 0;
    private TrainingGif gif = new TrainingGif();
    private FadeOut fadeOut = new FadeOut();
    private FadeIn fadeIn = new FadeIn();
    private GreenfootSound gfs = new GreenfootSound("BBS Confirm.wav");
    private GreenfootSound gfs1 = new GreenfootSound("BBS Back.wav");
    /**
     * Constructor for objects of class Information2.
     * 
     */
    public Information2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);
        addObject(fadeOut, 500, 300);
        addObject(gif, 500, 300);
    }
    
    public void act()
    {
        Greenfoot.setSpeed(50);
        //to next screen
        if (Greenfoot.isKeyDown("enter") && i < 1) 
        {
            addObject(fadeIn, 500, 300);
            i++;
            gfs.setVolume(70);
            gfs.play();
        }
        if (i >= 1 && i <= 100)
        {
            i++;
            showText("", 500, 575);
            l = 0;
        }
        if (i == 100)
        {
            Greenfoot.setWorld(new MainMenu());
        }
        
        //to first instruction slide
        if (Greenfoot.isKeyDown("backspace") && p < 1) 
        {
            addObject(fadeIn, 500, 300);
            p++;
            gfs1.setVolume(70);
            gfs1.play();
        }
        if (p >= 1 && p <= 100)
        {
            p++;
            showText("", 500, 575);
            l = 0;
        }
        if (p == 100)
        {
            Greenfoot.setWorld(new Information());
        }
        
        l++;
        if (l == 75)
        {
            showText("Press \"Enter\" to continue, \"Backspace\" to go back.", 500, 575);
        }
    }
}
