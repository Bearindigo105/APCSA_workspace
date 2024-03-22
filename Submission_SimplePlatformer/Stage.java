import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Stage extends JComponent{
    
    private ArrayList<Rectangle> platforms;

    public Stage(){
        this.setLocation(0, 0);
        platforms = new ArrayList<Rectangle>();
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.darkGray);
        for (Rectangle platform : platforms) {
            g2.fill(platform);
        }
    }

    public ArrayList<Rectangle> getPlatforms() {
        return platforms;
    }
}
