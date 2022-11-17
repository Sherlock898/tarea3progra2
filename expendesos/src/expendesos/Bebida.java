package expendesos;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Bebida {
    private int numSerie;
    protected static final int w = 20;
    protected static final int h = 35;
    protected int x, y;
    protected Color color;


    public Bebida(int numSerie){
        this.numSerie = numSerie;
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
