package expendesos;

import java.awt.Color;

public class Sprite extends Bebida{
    public Sprite(int numSerie){
        super(numSerie);
        color = Color.GREEN;
    }

    @Override
    public String beber() {
        return "Sprite";
    }

}
