import javax.swing.JLabel;

public abstract class GameObject extends JLabel {
    private boolean destroy;

    public GameObject(int x, int y) {
        this.setLocation(x, y);
        destroy = false;
    }

    public boolean hasCollidedWith(GameObject other){
        return false;
    }

    public abstract void update();

    public abstract void checkBounds(int width, int height); 

    public void collided(GameObject other) {}

    public boolean Destroy() {
        return destroy;
    }

    public void setDestroy(boolean destroy) {
        this.destroy = destroy;
    }

}
