import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class Ground extends JComponent{
    
    private Rectangle ground;

    public Ground(){
        ground = new Rectangle(0,0,500,50);
        this.setSize(500,50);
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.darkGray);
        g2.fill(ground);
    }
}
