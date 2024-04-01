
import javax.swing.JFrame;

public class SimplePlatformer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Platformer");
        frame.setBounds(0, 0, 960, 540);

        frame.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        
        gamePanel.setSize(frame.getWidth(),frame.getHeight());
        gamePanel.setLocation(-50, -50);

        frame.add(gamePanel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
