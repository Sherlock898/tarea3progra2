package expendesos;

import java.awt.Color;

public class Sprite extends Bebida{
    public Sprite(int numSerie, int x, int y){
        super(numSerie, x, y);
        color = Color.GREEN;
    }

    @Override
    public String beber() {
        return "Sprite";
    }

}
