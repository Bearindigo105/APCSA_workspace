import java.awt.Rectangle;

import javax.swing.JLabel;

/**
 * this class is an abstract class intended to represent
 * any interactive character or object which we will be
 * able to add to our game.
 * 
 */
public abstract class GameObject extends JLabel {

    public GameObject(int x, int y) {
        this.setLocation(x, y);

    }

    public boolean hasCollidedWith(GameObject other) {
        Rectangle r1 = new Rectangle(this.getBounds());
        Rectangle r2 = new Rectangle(other.getBounds());
        return r1.intersects(r2);

    }

    public abstract void update();

    public abstract void checkBounds(int width, int height); 

    public void collided(GameObject other) {}
}
