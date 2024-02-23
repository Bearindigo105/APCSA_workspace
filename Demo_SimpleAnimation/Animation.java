

import javax.swing.JFrame;

public class Animation {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animation");
        frame.setBounds(0, 0, 600, 600);

        GamePanel gamePanel = new GamePanel();

        frame.add(gamePanel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}