package expendesos;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionListener;

public class BotonSelector extends BotonOculto{
    private int seleccion;
    private Color color;

    public BotonSelector(int x, int y, int w, int h, ActionListener al, int seleccion){
        super(x, y, w, h, al);
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

    public void paint(Graphics g){
        super.paint(g);
        g.setColor(color);
        g.fillRect(x, y, w, h);
    }

    public int getSeleccion(){
        return seleccion;
    }

}
