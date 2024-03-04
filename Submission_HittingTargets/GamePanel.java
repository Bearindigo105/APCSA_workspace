import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * This class will house all game objects which are part of the
 * simulation. You must add several targets which can be
 * hit by fireballs and removed from the game.
 */

public class GamePanel extends JPanel implements ActionListener {

    private BufferedImage background;
    private Hero hero;
    private Score scoreboard;

    private ArrayList<Fireball> fireballs = new ArrayList<Fireball>();
    private ArrayList<Target> targets = new ArrayList<Target>();

    /**
     * Construct a game panel and initialize the game
     */
    public GamePanel() {
        this.setLayout(null);
        hero = new Hero(100, 100);
        scoreboard = new Score();

        URL imageURL = getClass().getResource("./images/background/gray_tile_background.png");

        try {
            background = ImageIO.read(imageURL);
        } catch (IOException e) {
            e.printStackTrace();
        }


        addTarget();
        this.add(hero);
        this.add(scoreboard);

        // Handle key presses. We will set dx/dy for the character
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                switch (code) {
                    case KeyEvent.VK_W:
                        hero.setDy(-5);// moving up
                        hero.setDx(0);// horizontal v Vertical mutually exclusive
                        hero.setDirection(new Direction(Direction.UP));
                        break;
                    case KeyEvent.VK_A:
                        hero.setDy(0);
                        hero.setDx(-5);// moving left
                        hero.setDirection(new Direction(Direction.LEFT));
                        break;
                    case KeyEvent.VK_S:
                        hero.setDy(5);// moving down
                        hero.setDx(0);// horizontal v Vertical mutually exclusive
                        hero.setDirection(new Direction(Direction.DOWN));
                        break;
                    case KeyEvent.VK_D:
                        hero.setDy(0);// moving up
                        hero.setDx(5);// horizontal v Vertical mutually exclusive
                        hero.setDirection(new Direction(Direction.RIGHT));
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int code = e.getKeyCode();
                switch (code) {
                    case KeyEvent.VK_W:
                        hero.setDy(0);
                        hero.setIdle();
                        break;
                    case KeyEvent.VK_A:
                        hero.setDx(0);
                        hero.setIdle();
                        break;
                    case KeyEvent.VK_S:
                        hero.setDy(0);
                        hero.setIdle();
                        break;
                    case KeyEvent.VK_D:
                        hero.setDx(0);
                        hero.setIdle();
                        break;
                    
                    //me
                    case  KeyEvent.VK_SPACE:
                        addFireball();
                        break;
                }
            }

        });

        // create and start the game timer. This gamepanel is passed
        // as the action listener which will be triggered every 17 milliseconds
        Timer gameLoop = new Timer(17, this);
        gameLoop.start();

        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    //me
    public void addFireball(){
        Fireball tempFireball = new Fireball(hero.getX(), hero.getY(), hero.getDirection());
        fireballs.add(tempFireball);
        this.add(tempFireball);
    }

    public void addTarget(){
        Target tempTarget = new Target((int)(Math.random() * 450 - 30), (int)(Math.random() * 450 - 30));
        targets.add(tempTarget);
        this.add(tempTarget);
    }

    // render the gamePanel with the background image
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    // The timer will trigger this method every 17 milliseconds.
    // This is the main game loop and should house the logic for
    // moving everything on the screen and their interactions.
    @Override
    public void actionPerformed(ActionEvent e) {
        hero.update();
        //me
        for(int i = 0; i < fireballs.size(); i++){
            fireballs.get(i).update();
            for (int j = 0; j < targets.size(); j++) {
                if(targets.get(j).hasCollidedWith(fireballs.get(i))){
                    this.remove(fireballs.get(i));
                    fireballs.remove(fireballs.get(i));
                    this.remove(targets.get(j));
                    targets.remove(targets.get(j));
                    this.repaint();
                    this.addTarget();
                    this.scoreboard.incrementScore();
                }
            }
            
        }
        for(int i = 0; i < targets.size(); i++){
            targets.get(i).update();
        }
    }
}
