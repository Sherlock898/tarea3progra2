package expendesos;

import java.awt.Color;

public class Fanta extends Bebida{
    public Fanta(int numSerie, int w, int h){
        super(numSerie, w, h);
        color = Color.ORANGE;
    }

    @Override
    public String beber() {
        return "Fanta";
    }
    
}
