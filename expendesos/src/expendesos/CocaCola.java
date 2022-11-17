package expendesos;

import java.awt.Color;

public class CocaCola extends Bebida {
    public CocaCola(int numSerie){
        super(numSerie);
        color = Color.RED;
    }

    @Override
    public String beber() {
        return "CocaCola";
    }

    
}
