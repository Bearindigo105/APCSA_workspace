import javax.swing.JLabel;


public class Score extends JLabel{
    
    private int score = 0;

    public Score(){
        
        this.setSize(100, 20);
        this.setLocation(10,10);
        this.setText("Score: " + score );
        this.setFocusable(false);
        this.setVisible(true);
    }

    public void incrementScore(){
        score ++;
        this.setText("Score: " + score);
    }
}
