package expendesos;

import java.awt.Color;

public class Fanta extends Bebida{
    public Fanta(int numSerie){
        super(numSerie);
        color = Color.ORANGE;
    }

    @Override
    public String beber() {
        return "Fanta";
    }
    
}
