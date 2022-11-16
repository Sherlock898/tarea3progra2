package expendesos;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Deposito {
    private ArrayList<Bebida> arr;
    private int x, y;
    private static final int w = 330;
    private static final int h = 140;
    
    public Deposito(){
        arr = new ArrayList<Bebida>();
    }
    
    public void addBebida(Bebida bebida){
        arr.add(bebida);
        //Se considera capacidad maxima de un deposito = 20
        int y_margin = arr.size() - 1 < 10 ? 0 : 1;
        bebida.setXY(x + ((w - 200) / 11) + (((w - 200) / 11) + 20) * ((arr.size() - 1)%10) , y + 10 + 45 * y_margin);
        //bebida.setXY(x + 20 * ((arr.size() - 1)%10) , y + 10 + 45 * y_margin);
    }
    
    public Bebida getBebida(){
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
            arr.get(i).paint(g);
        }
    }
}
    