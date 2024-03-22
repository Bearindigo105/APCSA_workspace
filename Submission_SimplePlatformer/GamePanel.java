import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener{
    private Player player;
    private Stage stage;
    private final double GCONSTANT = 0.2;

    public GamePanel(){
        player = new Player(200,40);
        stage = new Stage();
        this.setLayout(null);
        
        this.add(player);
        this.add(stage);
        Timer timer = new Timer(17, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        player.setDy(player.getDy() + GCONSTANT);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // implemented game loop to update all objects, check bounds, check collisions
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            object.update();
            object.checkBounds(getWidth(), getHeight());
            Rectangle bounds = object.getBounds();

            for (int j = 0; j < gameObjects.size(); j++) {
                if (i != j && object.hasCollidedWith(gameObjects.get(j))) {
                    object.collided(gameObjects.get(j));
                }
            }

            if (object.Destroy()) {
                remove(object);
                gameObjects.remove(object);
                i--;
            }
            repaint(bounds);
        }
    }
}


/**
 * This class will house all game objects which are part of the
 * simulation. You must add several targets which can be
 * hit by fireballs and removed from the game.
 */

public class GamePanel extends JPanel implements ActionListener {

    private BufferedImage background;
    private Hero hero;
    private ArrayList<GameObject> gameObjects;// added to track all objects

    /**
     * Construct a game panel and initialize the game
     */
    public GamePanel() {
        this.setLayout(null);
        gameObjects = new ArrayList<GameObject>();
        hero = new Hero(100, 100);
        gameObjects.add(hero);
        gameObjects.add(new Target(300, 200));
        gameObjects.add(new Target(400, 350));

        URL imageURL = getClass().getResource("./images/background/gray_tile_background.png");

        try {
            background = ImageIO.read(imageURL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (GameObject object : gameObjects) {
            this.add(object);
        }

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
                    case KeyEvent.VK_SPACE: // fireball implementation
                        Fireball fireball = hero.fire();
                        if (fireball != null) {
                            gameObjects.add(fireball);
                            add(fireball);
                        }
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

    // render the gamePanel with the background image
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    // The timer will trigger this method every 17 milliseconds.
    // This is the main game loop and should house the logic for
    // moving everything on the screen and their interactions.
    

}