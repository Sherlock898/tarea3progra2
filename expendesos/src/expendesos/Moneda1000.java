package expendesos;

import java.awt.Color;

public class Moneda1000 extends Moneda{

    public Moneda1000(Transform t){
        super(t);
        color = Color.MAGENTA;
    }

    @Override
    public int getValor() {
        return 1000;
    }
}
