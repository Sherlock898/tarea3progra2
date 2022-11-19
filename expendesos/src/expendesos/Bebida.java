package expendesos;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Bebida {
    private int numSerie;
    private Transform t;
    protected Color color;


    public Bebida(int numSerie, int w, int h){
        t = new Transform(0, 0, w, h);
        this.numSerie = numSerie;
    }

    public int getSerie(){
        return numSerie;
    }
    
    public void setXY(int x, int y){
        t.x = x;
        t.y = y;
    }

    public Transform getTransform(){
        return t;
    }
    
    public void paint(Graphics g, int px, int py){
        g.setColor(color);
        g.fillRect(t.x + px, t.y + py, t.w, t.h);
        g.setColor(Color.black);        
        g.drawString(Integer.toString(numSerie), t.x + px + (int)(t.w / 2), t.y + py + (int)(t.h / 2));
        
    }
    public abstract String beber();
}
