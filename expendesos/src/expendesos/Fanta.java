package expendesos;

import java.awt.Color;
import java.awt.Graphics;

public class Fanta extends Bebida{
    public Fanta(int numSerie){
        super(numSerie);
    }

    @Override
    public String beber() {
        return "Fanta";
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(x, y, w, h);
    }
}
