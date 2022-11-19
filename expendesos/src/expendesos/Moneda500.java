package expendesos;

import java.awt.Color;

public class Moneda500 extends Moneda{

    public Moneda500(Transform t){
        super(t);
        color = Color.PINK;
    }

    @Override
    public int getValor() {
        return 500;
    }
}
