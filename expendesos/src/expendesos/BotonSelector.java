package expendesos;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionListener;

public class BotonSelector extends BotonOculto{
    private int seleccion;
    protected Color color;

    public BotonSelector(Transform t, int px, int py, ActionListener al, int seleccion){
        super(t, px, py, al);
        this.seleccion = seleccion;

        switch (seleccion) {
            case 1:
                color = Color.RED;
                break;
            case 2:
                color = Color.ORANGE;
                break;
            case 3:
                color = Color.GREEN;
            default:
                break;
        }
    }

    public void paint(Graphics g, int px, int py){
        super.paint(g);
        g.setColor(color);
        g.fillRect(t.x + px, t.y + py, t.w, t.h);
    }

    public int getSeleccion(){
        return seleccion;
    }

}
