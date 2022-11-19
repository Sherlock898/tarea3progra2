package expendesos;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Deposito {
    private ArrayList<Bebida> arr;
    private int x;
    private int y;
    private int w;
    private int h;
    private int wLata;
    private int capacidad;
    
    public Deposito(int x, int y, int w, int h, int capacidad){
        arr = new ArrayList<Bebida>();
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.capacidad = capacidad;
        this.wLata = 0;
    }
    
    public void addBebida(Bebida bebida){
        arr.add(bebida);
        //Se considera capacidad maxima de un deposito = 20
        wLata = bebida.w;
        bebida.setXY((int)(x + (w - wLata) / 2), (int)(y + h - arr.size() * (0.7 * 0.4 * w + 0.03 * h)));
    }
    
    public Bebida getBebida(){
        if(arr.size() > 0){
            for(int i = 1; i < Math.min(arr.size(), capacidad); i++){
                arr.get(i).setXY(x + (int)(0.15 * w), (int)(y + h - i * (0.7 * 0.4 * w + 0.03 * h)));
            }
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
        for(int i = 0; i < Math.min(arr.size(), capacidad); i++){
            arr.get(i).paint(g);
        }
    }
}
    