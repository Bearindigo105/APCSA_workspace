import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener{
    private Player player;
    private Stage stage;
    private ArrayList<GameObject> gameObjects;
    private final double GCONSTANT = 0.25;

    public GamePanel(){
        gameObjects = new ArrayList<GameObject>();
        player = new Player(200, 40, GCONSTANT);
        stage = new Stage();
        this.setLayout(null);
        
        addGameObject(player);
        for (Platform platform : stage.getPlatforms()) {
            addGameObject(platform);
        }

        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                switch (code) {
                    case KeyEvent.VK_W:
                        player.Jump();
                        break;
                    case KeyEvent.VK_A:
                        player.setDx(-5);
                        break;
                    case KeyEvent.VK_D:
                        player.setDx(5);
                        break;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                int code = e.getKeyCode();
                switch (code) {
                    case KeyEvent.VK_A:
                        player.setDx(0);
                        break;
                    case KeyEvent.VK_D:
                        player.setDx(0);
                        break;
                    case KeyEvent.VK_W:
                        player.setDy(player.getDy() + 3);
                        break;
                }
            }

        });

        Timer gameLoop = new Timer(17, this);
        gameLoop.start();

        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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

    public GameObject addGameObject(GameObject GObj){
        this.gameObjects.add(GObj);
        return (GameObject)this.add(GObj);
    }
}