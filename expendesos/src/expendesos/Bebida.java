package expendesos;

import java.awt.Graphics;

public abstract class Bebida {
    private int numSerie;
    protected static final int w = 20;
    protected static final int h = 35;
    protected int x, y;


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
    
    public abstract void paint(Graphics g);
    public abstract String beber();
}
