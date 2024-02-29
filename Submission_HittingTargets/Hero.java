import javax.swing.ImageIcon;

public class Hero extends GameObject {

    private ImageIcon[][] icons;
    private int phase;
    private int direction;
    private int phaseCounter;
    private int dx;
    private int dy;

    public Hero(int x, int y) {
        super(x, y);
        this.setSize(32, 36);
        direction = Direction.DOWN;
        phase = 0;
        phaseCounter = 0;
        dx = 0;
        dy = 0;

        icons = new ImageIcon[4][4];

        for (int i = 0; i < icons.length; i++) {
            for (int j = 0; j < icons[i].length; j++) {
                icons[i][j] = new ImageIcon("./images/character/sprite_" + i + "_" + j + ".png");

            }
        }

        this.setIcon(icons[direction][phase]);

    }

    /**
     * Change direction of the character
     * 
     * @param direction
     */
    public void setDirection(Direction direction) {
        this.direction = direction.getDirection();
    }

    //me
    public Direction getDirection(){
        return new Direction(this.direction);
    }

    /**
     * update the icon to animate the character
     */
    private void updateIcon() {
        if (phaseCounter % 6 == 0) {
            phase = (phase + 1) % 4;
            this.setIcon(icons[direction][phase]);
        }

        phaseCounter++;
    }

    /**
     * reset character in idle position
     */
    public void setIdle() {
        this.setIcon(icons[direction][0]);
        phaseCounter = 0;
    }

    /**
     * set dx for the character to make him move horizontally
     * 
     * @param dx horizontal velocity
     */
    public void setDx(int dx) {
        this.dx = dx;
    }

    /**
     * set dy for the character to make him move vertically
     * 
     * @param dy vertical velocity
     */
    public void setDy(int dy) {
        this.dy = dy;
    }
    
    

    /**
     * update the character's location and image based on the dx and dy
     */
    public void update() {
        if (dx != 0 || dy != 0) {
            this.setLocation(this.getX() + dx, this.getY() + dy);
            this.updateIcon();
        }
    }
}