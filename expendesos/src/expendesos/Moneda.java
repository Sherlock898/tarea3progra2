package expendesos;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Moneda {
    protected Transform t;
    protected Color color;
    protected int serie;
    public static int ultimaSerie;
    
    public Moneda(Transform t){
        this.t = t;
        this.serie = Moneda.ultimaSerie++;
    }
    
    public Moneda getSerie(){
        return this;
    }

    public abstract int getValor();
    
    public void paint(Graphics g, int px, int py){
        g.setColor(color);
        g.fillOval(t.x + px, t.y + py, t.w, t.h);
        g.setColor(Color.black);
        g.drawString(Integer.toString(this.serie), t.x + px + t.w / 2 - 2, t.y + py + t.h / 2 + 5);
    }
    
    public void setXY(int x, int y){
        t.x = x;
        t.y = y;
    }
    
    public Transform getTransform(){
        return t;
    }

    public String toString(){
        return getSerie().toString() + getValor();
    }
}

