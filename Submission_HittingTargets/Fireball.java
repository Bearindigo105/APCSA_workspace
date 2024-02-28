import javax.swing.ImageIcon;

/**
 * Create a class representing our projectiles. These
 * will be blue fireballs and have an image in the
 * fireball folder for each direction. The fireball
 * should travel in whatever direction the player is
 * facing. Be sure to handle their motion
 * 
 */

public class Fireball extends GameObject {
    //me
    private ImageIcon icon;
    private Direction direction;
    private int dx;
    private int dy;
    

    public Fireball(int x, int y, Direction direction) {
        super(x, y);
        this.setSize(18, 18);
        this.direction = direction;

        switch(this.direction.getDirection()){
            case Direction.UP:
                this.dy = -8;
                this.dx = 0;
                icon = new ImageIcon("./images/fireball/blue_fireball_up.png");
                break;
            case Direction.DOWN:
                this.dy = 8;
                this.dx = 0;
                icon = new ImageIcon("./images/fireball/blue_fireball_down.png");
                break;
            case Direction.LEFT:
                this.dy = 0;
                this.dx = -8;
                icon = new ImageIcon("./images/fireball/blue_fireball_left.png");
                break;
            case Direction.RIGHT:
                this.dy = 0;
                this.dx = 8;
                icon = new ImageIcon("./images/fireball/blue_fireball_right.png");
                break;
        }
        this.setIcon(icon);
    }

    @Override
    public void update() {
        this.setLocation(this.getX() + dx, this.getY() + dy);
    }

    // TODO implement this class
}
