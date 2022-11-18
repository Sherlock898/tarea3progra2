package expendesos;

import java.awt.Color;

public class CocaCola extends Bebida {
    public CocaCola(int numSerie, int w, int h){
        super(numSerie, w, h);
        color = Color.RED;
    }

    @Override
    public String beber() {
        return "CocaCola";
    }

    
}
