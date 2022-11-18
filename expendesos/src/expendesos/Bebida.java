package expendesos;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Bebida {
    private int numSerie;
    protected int x;
    protected int y;
    protected int w = 20;
    protected int h = 35;
    protected Color color;


    public Bebida(int numSerie, int w, int h){
        this.numSerie = numSerie;
        this.w = w;
        this.h = h;
    }

    public int getSerie(){
        return numSerie;
    }
    
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, w, h);
        
    }
    public abstract String beber();
}
