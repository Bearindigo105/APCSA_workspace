import javax.swing.JComponent;


import java.awt.Color;
import java.util.ArrayList;


public class Stage extends JComponent{
    
    private ArrayList<Platform> platforms;

    public Stage(){
        platforms = new ArrayList<Platform>();
        platforms.add(new Platform(0, 460, 960, 540, Color.BLACK));
        platforms.add(new Platform(650,170,80,25, Color.LIGHT_GRAY));
        platforms.add(new Platform(150,200,80,25, Color.BLUE));
        platforms.add(new Platform(250,350,80,25, Color.RED));
        platforms.add(new Platform(590,100,40,40, Color.GREEN));
        platforms.add(new Platform(300,80,200,25, Color.DARK_GRAY));

    }

    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }
}


