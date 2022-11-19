package expendesos;

import java.awt.Color;

public class Moneda100 extends Moneda{

    public Moneda100(Transform t){
        super(t);
        color = Color.LIGHT_GRAY;
    }

    @Override
    public int getValor() {
        return 100;
    }
}
