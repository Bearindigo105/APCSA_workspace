import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Animation {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animation");
        frame.setBounds(0, 0, 600, 600);

        GamePanel gamePanel = new GamePanel();

        gamePanel.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                if (code == KeyEvent.VK_W) {
                    gamePanel.moveHiro(0, -5);
                } else if (code == KeyEvent.VK_A) {
                    gamePanel.moveHiro(-5, 0);
                } else if (code == KeyEvent.VK_S) {
                    gamePanel.moveHiro(0, 5);
                } else if (code == KeyEvent.VK_D) {
                    gamePanel.moveHiro(5, 0);
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });

        frame.add(gamePanel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamePanel.requestFocus();
    }
}