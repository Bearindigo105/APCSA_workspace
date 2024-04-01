import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends GameObject {
    
    private double dx;
    private double dy;
    private Rectangle costume;
    private final double GCONSTANT;
    private boolean canJump;

    public Player(int x, int y, double g) {
        super(x, y);
        this.setSize(12, 12);
        dx = 0;
        dy = 0;
        canJump = false;
        GCONSTANT = g;
        costume = new Rectangle(1,1,10,10);
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.DARK_GRAY);
        g2.fill(costume);
    }

    public void update(){
        this.setLocation(this.getX() + (int)dx, this.getY() + (int)dy);
        System.out.println(canJump);
        if(dy + GCONSTANT < 11){
            dy += GCONSTANT;
        }else{
            dy = 11 - GCONSTANT;
        }
        if(dy > 1.25){
            canJump = false;
        }
        System.out.println(dy);
    }

    @Override
    public boolean hasCollidedWith(GameObject other) {    
        Rectangle r1 = new Rectangle(this.getBounds());
        Rectangle r2 = new Rectangle(other.getBounds());
        return r1.intersects(r2);
    }

    @Override
    public void collided(GameObject other){
        if(other instanceof Platform){
            if(this.getY() + this.getHeight() >= other.getY() && this.getY() < other.getY()){
                this.setLocation(this.getX(), other.getY() - this.getHeight());
                canJump = true;
                dy = 0;
            }
            else if(this.getY() <= other.getY() + other.getHeight() && this.getY() + this.getHeight() > other.getY() + other.getHeight()){
                this.setLocation(this.getX(), other.getY() + other.getHeight());
                dy = 0.25;
            }else if(this.getX() <= other.getX() + other.getWidth() && this.getX() + this.getWidth() > other.getX() + other.getWidth()){
                this.setLocation(other.getX() + other.getWidth(), this.getY());
                dx = 0.1;
            }else if(this.getX() + this.getWidth() >= other.getX() && this.getX() < other.getX()){
                this.setLocation(other.getX() - this.getWidth(), this.getY());
                dx = -0.1;
            }
        }
    }

    @Override
    public void checkBounds(int width, int height) {
        if (this.getY() < 0) {
            this.setLocation(this.getX(), 0);
        }
        if (this.getX() < 0) {
            this.setLocation(0, this.getY());
        }
        if (this.getX() + this.getWidth() > width) {
            this.setLocation(width - this.getWidth(), this.getY());
        }
        if (this.getY() + this.getHeight() > height) {
            this.setLocation(this.getX(), height - this.getHeight());
        }
    }

    public void Jump(){
        if(canJump){
            this.setDy(-9);
            canJump = false;
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