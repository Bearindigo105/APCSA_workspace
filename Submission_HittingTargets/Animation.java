
import javax.swing.JFrame;

public class Animation {

    /**
     * main method which instantiates our JFrame and
     * our gamePanel.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Shooting Targets");
        frame.setBounds(50, 50, 500, 500);

        // makes it impossible to resize the frame
        frame.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        
        gamePanel.setSize(frame.getWidth(),frame.getHeight());
        gamePanel.setLocation(-50, -50);

        frame.add(gamePanel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
