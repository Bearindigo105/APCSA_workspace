import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Hiro extends JLabel {

    private ImageIcon[][] icons;
    private int direction;
    private int phase;
    private int phaseCounter;
    private int dx;
    private int dy;

    public Hiro(int x, int y) {
        this.setBounds(x, y, 32, 36);
        direction = 0;
        phase = 1;
        phaseCounter = 0;
        icons = new ImageIcon[4][4];
        for (int i = 0; i < icons.length; i++) {
            for (int j = 0; j < icons[i].length; j++) {
                icons[i][j] = new ImageIcon("./images/character/sprite_" + i + "_" + j + ".png");
            }
        }
        this.setIcon(icons[direction][phase]);
    }

    public void setDirection() {
        if(dx > 0){
            this.direction = 1;
        }else if (dx < 0){
            this.direction = 3;
        }
        if(dy > 0){
            this.direction = 0;
        }else if (dy < 0){
            this.direction = 2;
        }
    }

    public void update() {
        if (dx == 0 && dy == 0) {
            this.setIdle();
        } else {
            this.setLocation(this.getX() + dx, this.getY() + dy);
            updateIcon();
        }
    }

    private void updateIcon() {
        if (phaseCounter % 3 == 0) {
            phase = (phase + 1) % 4;
            this.setIcon(icons[direction][phase]);
        }
        phaseCounter++;

    }

    public void setIdle() {
        this.setIcon(icons[direction][0]);
        phaseCounter = 0;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}
