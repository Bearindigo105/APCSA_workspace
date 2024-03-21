import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class GravityPanel extends JPanel implements ActionListener{
    private Ball ball;
    private Ground ground;
    private final double GCONSTANT = 0.2;

    public GravityPanel(){
        ball = new Ball();
        ground = new Ground();
        this.setLayout(null);
        
        ball.setLocation(200,40);
        this.add(ball);
        ground.setLocation(-10, 513);
        this.add(ground);
        Timer timer = new Timer(17, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ball.update();
        ball.groundBounce(ground);
        ball.setDy(ball.getDy() + GCONSTANT);
    }
}