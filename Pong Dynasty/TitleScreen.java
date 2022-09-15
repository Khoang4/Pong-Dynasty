import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shows developer name of the game
 * Sounds from sounds-resource.com
 * John & Kenny
 * 12/1/19
 */
public class TitleScreen extends World
{
    //Kenny
    private FadeIn fadeIn = new FadeIn();
    private FadeOut fadeOut = new FadeOut();
    private int i = 0;
    private int l = 0;
    private GreenfootSound gfs = new GreenfootSound("BBS Confirm.wav");
    
    /**
     * Constructor for objects of class TitleScreen.
     * Kenny
     */
    public TitleScreen()
    {  
        super(1000, 600, 1);
        Greenfoot.start();      //automatically start the program upon opening
        Greenfoot.setSpeed(50);
        addObject(fadeOut, 500, 300);
    }
    public void act()
    {
        Greenfoot.setSpeed(50);
        l++;
        
        //clue user to move forward after brief wait (John)
        if (l == 75)
        {
            showText("Press \"Enter\" to continue.", 500, 575);
        }
        //Goes to next world (Kenny)
        if (Greenfoot.isKeyDown("enter") && i < 1) 
        {
            showText("", 500, 575);
            addObject(fadeIn, 500, 300);
            i++;
            gfs.setVolume(65);   
            gfs.play();
        }
        if (i >= 1 && i <= 100)
        {
            i++;
            l = 0;
        }
        if (i == 100)
        {
            Greenfoot.setWorld(new MainMenu());
        }
        Greenfoot.setSpeed(50);
    }
}
