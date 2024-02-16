import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Hiro extends JLabel {

    public enum Direction{
        LEFT,
        RIGHT,
        UP,
        DOWN
    }

    private ImageIcon[][] icons;
    private int direction;
    private int phase;

    public Hiro(int x, int y) {
        this.setBounds(x, y, 32, 36);
        direction = 0;
        phase = 1;
        icons = new ImageIcon[4][3];
        for (int i = 0; i < icons.length; i++) {
            for (int j = 0; j < icons[i].length; j++) { 
               icons[i][j] = new ImageIcon("./images/character/sprite_"+ i +"_"+ j +".png");
            }
        }
        this.setIcon(icons[direction][phase]);
    }

    public void setDirection(Direction direction){
        switch(direction){
            case UP:
                this.direction = 2;
                break;
            case DOWN:
                this.direction = 0;
                break;
            case LEFT:
                this.direction = 3;
                break;
            case RIGHT:
                this.direction = 1;
                break;
            default:
                break;
        }
    }

    public void updateX(int dx) {
        this.setLocation(this.getX() + dx, this.getY());
    }

    public void updateY(int dy) {
        this.setLocation(this.getX(), this.getY() + dy);
    }

}
