import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ball extends JComponent {
    private double dx;
    private double dy;
    private Ellipse2D.Double ball;

    public Ball() {
        dx = 0;
        dy = 1;
        ball = new Ellipse2D.Double(0,0,10,10);
        this.setSize(11,11);
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(ball);
    }

    public void update(){
        this.setLocation(this.getX() + (int)dx, this.getY() + (int)dy);
    }

    public void groundBounce(Ground ground){
        if(this.getBounds().intersects(ground.getBounds())){
            dy = -0.75*dy;
            this.setLocation(this.getX(), ground.getY()-this.getHeight());
        }
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }
}