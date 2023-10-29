package Demo_Clicker;

public class ClickerMain {
    public static void main(String[] args){
        Clicker clicker1 = new Clicker("Room 100");
        clicker1.click();
        clicker1.click(5);
        System.out.println(clicker1);
    }
}
