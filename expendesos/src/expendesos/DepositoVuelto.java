package expendesos;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class DepositoVuelto {
    private ArrayList<Moneda> arr;
    private int x, y;
    private static final int w = 50;
    private static final int h = 300;
    
    public DepositoVuelto(){
        arr = new ArrayList<Moneda>();
    }
    
    public void addMoneda(Moneda moneda){
        arr.add(moneda);
    }
    
    public Moneda getMoneda(){
        if(arr.size() > 0){
            return arr.remove(0);
        }
        else{
            return null;
        }
    }
    
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(x, y, w, h);
        
        for(int i = 0; i < arr.size(); i++){
            
        }
    }
}
