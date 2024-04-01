import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Platform extends GameObject{

    private Color color;
    private Rectangle costume;

    public Platform(int x, int y, int width, int height, Color c){
        super(0, 0);
        this.setBounds(x, y, width, height);
        color = c;
        costume = new Rectangle(0, 0, width, height);
    }

    public Platform(Rectangle r, Color c){
        super(0, 0);
        this.setBounds(r);
        color = c;
        costume = new Rectangle(0, 0, r.width, r.height);
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.fill(costume);
    }

    public void update(){}

    @Override
    public void checkBounds(int width, int height) {}
}
