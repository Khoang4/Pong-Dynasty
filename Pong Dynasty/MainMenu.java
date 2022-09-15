import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the Title of the game and lets the players click to either see information on how to play or to play
 * sounds from sounds-resource.com
 * music from soundcloud
 * John and Kenny
 * 12/4/19
 */
public class MainMenu extends World
{
    //John and Kenny
    PlayButton Play = new PlayButton();
    InfoButton Info = new InfoButton();
    Selecter mouse = new Selecter();
    FadeIn fadeIn = new FadeIn();
    FadeOut fadeOut = new FadeOut();
    int i = 0;
    int l =0;
    int p = 0;
    int t = 0;
    boolean playSelecterPosition = true;
    GreenfootSound gfs = new GreenfootSound("BBS Confirm.wav");
    GreenfootSound gfs1 = new GreenfootSound("BBS Back.wav");
    GreenfootSound title = new GreenfootSound("02 - presenting vvvvvv.mp3");
    /**
     * Constructor for objects of class MainMenu.
     * Kenny
     */
    ;
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        addObject(Play, 500, 325);
        addObject(Info,500, 475);
        addObject(mouse, 300, 325);
        addObject(fadeOut, 500, 300);
        title.setVolume(65);
        title.play();
    }
    
    public void act()
    {
        //sets the speed of the game automatically to 50 (John)
        Greenfoot.setSpeed(50);
        l++;
        //Prompts player on how to progress across the menu
        if (l == 75)
        {
            showText("Press \"Enter\" to continue, \"Backspace\" to go back.", 500, 575);
        }
        
        if(!title.isPlaying()) //loop title music
        {
               title.play();
        }
        
        updateSelecterPosition();
        toNextScreen();
        toTitleScreen();
        
    }
    /**
     * Checks on a user's input and then changes the position of the selector based on the input
     * John
     */
    public void updateSelecterPosition()
    {
        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up"))
        {
            playSelecterPosition = true;
        }
        if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down"))
        {
            playSelecterPosition = false;
        }
    }
    /**
     * Checks position of the selector and then goes to different world depending on the position
     * Kenny
     */
    public void toNextScreen() //moves to info screens or begins game
    {
        if (Greenfoot.isKeyDown("enter") && playSelecterPosition)
        {
            showText("", 500, 575);
            addObject(fadeIn, 500, 300);
            i++;
        }
        if (i >= 1 && i <= 100)
        {
            i++;
            showText("", 500, 575);
            l = 0;
        }
        if (i == 100)
        {
            title.stop();
            Greenfoot.setWorld(new Battlefield());
        }
        
        if (Greenfoot.isKeyDown("enter") && !playSelecterPosition)
        {
            showText("", 500, 575);
            addObject(fadeIn, 500, 300);
            t++;
        }
        if (t >= 1 && t <= 100)
        {
            t++;
            showText("", 500, 575);
            l = 0;
        }
        if (t == 100)
        {
            title.stop();
            Greenfoot.setWorld(new Information());
        }
        
    }
    /**
     *returns to title screen 
     *John
     */
    public void toTitleScreen() //returns to title screen
    {
       if (Greenfoot.isKeyDown("backspace") && p < 1) 
        {
            showText("", 500, 575);
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
            Greenfoot.setWorld(new TitleScreen());
            title.stop();
        }
    }
}
