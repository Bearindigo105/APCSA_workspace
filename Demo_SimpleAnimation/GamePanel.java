import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GamePanel extends JPanel implements ActionListener{

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
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                switch (code) {
                    case KeyEvent.VK_W:
                        hiro.setDy(-3);
                        hiro.setDirection(Hiro.Direction.UP);
                        break;
                    case KeyEvent.VK_S:
                        hiro.setDy(3);
                        hiro.setDirection(Hiro.Direction.DOWN);
                        break;
                    case KeyEvent.VK_A:
                        hiro.setDx(-3);
                        hiro.setDirection(Hiro.Direction.LEFT);
                        break;
                    case KeyEvent.VK_D:
                        hiro.setDx(3);
                        hiro.setDirection(Hiro.Direction.RIGHT);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_W:
                        hiro.setDy(0);
                        break;
                    case KeyEvent.VK_S:
                        hiro.setDy(0);
                        break;
                    case KeyEvent.VK_A:
                        hiro.setDx(0);
                        break;
                    case KeyEvent.VK_D:
                        hiro.setDx(0);
                        break;
                    default:
                        break;
                }
            }

        });
        
        this.setFocusable(true);
        this.requestFocusInWindow();
        Timer mainLoop = new Timer(17, this);
        mainLoop.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        hiro.update();
    }
}
