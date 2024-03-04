import javax.swing.ImageIcon;

/**
 * create a class representing targets which can
 * be created and added to the gamePanel. You
 * should use the image from the target folder
 * to display for the target. The dimensions of
 * the target should be 32x28 and the constructor
 * should take the position as an argument.
 * 
 */

public class Target extends GameObject {
    //me
    private ImageIcon[] icons;
    private int phase;
    private int phaseCounter;
    
    public Target(int x, int y) {
        super(x, y);
        this.setSize(32, 36);
        phase = 3;
        phaseCounter = 0;
        icons = new ImageIcon[4];

        for (int i = 0; i < icons.length; i++) {
            icons[i] = new ImageIcon("./images/target/green_target" + i + ".png");
        }

        this.setIcon(icons[phase]);
    }

    private void updateIcon() {
        if (phaseCounter % 6 == 0) {
            phase = (phase + 1) % 4;
            this.setIcon(icons[phase]);
        }

        phaseCounter++;
    }

    @Override
    public void update() {
        if(Math.random() < 0.04 || phase % 4 != 0){
            updateIcon();
        }
    }

    // TODO implment the Target class

}
