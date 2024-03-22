import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends GameObject {
    
    private double dx;
    private double dy;
    private Rectangle player;

    public Player(int x, int y) {
        super(x, y);
        this.setSize(11, 11);
        dx = 0;
        dy = 0;
        player = new Rectangle(0,0,10,10);
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(player);
    }

    public void update(){
        this.setLocation(this.getX() + (int)dx, this.getY() + (int)dy);
    }

    public void groundCollision(Stage stage){
        for (Rectangle platform : stage.getPlatforms()) {   
            if(this.getBounds().intersects(platform.getBounds())){
                this.setLocation(this.getX(), (int)platform.getY()-this.getHeight());
            }
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