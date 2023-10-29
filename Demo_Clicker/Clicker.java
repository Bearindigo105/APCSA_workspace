package Demo_Clicker;

public class Clicker{

    private int value;
    private String name;

    public Clicker(String n, int v){
        value = v;
        name = n;
    }

    public Clicker(String n){
        name = n;
        value = 0;
    }

    public void click(){
        value ++;
    }

    public void click(int clicks){
        value += clicks;
    }

    public String getName(){return name;}
    public int getValue(){return value;}

    public String toString(){
        return "name: " + name + "\nvalue: " + value;
    }
}