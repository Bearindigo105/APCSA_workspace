import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GamePanel extends JPanel {

    private BufferedImage background;
    private Hiro hiro;

    public GamePanel() {
        this.hiro = new Hiro(150, 150);
        URL imageURL = getClass().getResource("./images/background/gray_tile_background.png");

        try {
            background = ImageIO.read(imageURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setLayout(null);
        this.add(hiro);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

    }

    public void moveHiro(int dx, int dy) {
        hiro.updateX(dx);
        hiro.updateY(dy);
    }
}
