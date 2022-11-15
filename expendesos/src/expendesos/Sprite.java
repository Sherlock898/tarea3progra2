package expendesos;

import java.awt.Color;
import java.awt.Graphics;

public class Sprite extends Bebida{
    public Sprite(int numSerie){
        super(numSerie);
    }

    @Override
    public String beber() {
        return "Sprite";
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, 20, 35);
    }
    
}
