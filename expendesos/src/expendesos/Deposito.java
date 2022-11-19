package expendesos;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Deposito {
    private ArrayList<Bebida> arr;
    private Transform t;
    private int wLata;
    private int capacidad;
    
    public Deposito(Transform t, int capacidad){
        arr = new ArrayList<Bebida>();
        this.t = t;
        this.capacidad = capacidad;
        this.wLata = 0;
    }
    
    public void addBebida(Bebida bebida){
        arr.add(bebida);
        //Se considera capacidad maxima de un deposito = 10
        wLata = bebida.getTransform().w;
        bebida.setXY((int)((t.w - wLata) / 2), (int)(t.h - arr.size() * (0.7 * 0.4 * t.w + 0.03 * t.h)));
    }
    
    public Bebida getBebida(){
        if(arr.size() > 0){
            Bebida b = arr.remove(0);
            for(int i = 0; i < Math.min(arr.size(), capacidad); i++){
                arr.get(i).setXY(((int)((t.w - wLata) / 2)), (int)(t.h - (i + 1) * (0.7 * 0.4 * t.w + 0.03 * t.h)));
            }
            return b;
        }
        else{
            return null;
        }
    }

    public int getCurrentSize(){
        return arr.size();        
    }

    public void setXY(int x, int y){
        t.x = x;
        t.y = y;
    }

    public Transform getTransform(){
        return t;
    }
    
    public void paint(Graphics g, int px, int py){
        g.setColor(Color.GRAY);
        g.fillRect(px + t.x, py + t.y, t.w, t.h);
        for(int i = 0; i < Math.min(arr.size(), capacidad); i++){
            arr.get(i).paint(g, t.x + px, t.y + py);
        }
    }
}
    