package expendesos;

import java.awt.Color;
import java.awt.Graphics;

public class CocaCola extends Bebida {
    public CocaCola(int numSerie){
        super(numSerie);
    }

    @Override
    public String beber() {
        return "CocaCola";
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, w, h);
    }
    
}
