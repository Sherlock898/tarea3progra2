package expendesos;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class BotonMoneda extends BotonSelector{
    protected String texto; 

    public BotonMoneda(Transform t, ActionListener al, int seleccion, String texto){
        super(t, 0, 0, al, seleccion);
        color = Color.YELLOW;
        this.texto = texto;
    }

    public void paint(Graphics g){
        super.paint(g, 0, 0);
        g.setFont(new Font("ComicSans", Font.BOLD, 12));
        g.setColor(Color.BLACK);
        g.drawString(texto, t.x + t.w / 2 - 20, t.y + t.h / 2);
    }

}
