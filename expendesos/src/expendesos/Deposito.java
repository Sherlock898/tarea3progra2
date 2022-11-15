package expendesos;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Deposito {
    private ArrayList<Bebida> arr;
    private int x, y;
    
    public Deposito(int x, int y){
        this.x = x;
        this.y = y;
        arr = new ArrayList<Bebida>();
    }
    
    public void addBebida(Bebida bebida){
        arr.add(bebida);
    }
    
    public Bebida getBebida(){
        if(arr.size() > 0){
            return arr.remove(0);
        }
        else{
            return null;
        }
    }
    
    public void paint(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(x, y, 330, 140);
        for(int i = 0; i < arr.size(); i++){
            arr.get(i).setXY(x + 10 * ((i%(int)(arr.size()/2))+1) + (i%(int)(arr.size()/2))*15, y + ((int)i/(int)(arr.size()/2) *40) + 10); //Hay que cambiar la formula, se bugea cuando arr.size es impar
            arr.get(i).paint(g);
        }
    }
}
    