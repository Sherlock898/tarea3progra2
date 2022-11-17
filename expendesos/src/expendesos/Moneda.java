package expendesos;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Moneda {
    protected int x;
    protected int y;
    protected static final int w = 50;
    protected static final int h = 50;
    protected Color color;
    
    
    public Moneda getSerie(){
        return this;
    }

    public abstract int getValor();
    
    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, w, h);
    }
    
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public String toString(){
        return getSerie().toString() + getValor();
    }
}

