import javax.swing.JLabel;

/**
 * this class is an abstract class intended to represent
 * any interactive character or object which we will be
 * able to add to our game.
 * 
 */
public abstract class GameObject extends JLabel {
    
    private boolean hasCollided;

    public GameObject(int x, int y) {
        this.setLocation(x, y);
        hasCollided = false;
    }

    /**
     * 
     * determine if this object has collided with other
     * 
     * @param other GameObject with which we are detecting collision
     * @return true if collision is detected between this and other
     */
    public boolean hasCollidedWith(GameObject other) {
        //me
        
        return other.getBounds().intersects(this.getBounds());
    }

    public void setHasCollided(boolean hasCollided){
        this.hasCollided = hasCollided;
    }

    public boolean getHasCollided(){
        return hasCollided;
    }

    public abstract void update();
}
