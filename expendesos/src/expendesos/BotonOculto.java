package expendesos;

import javax.swing.JButton;
import java.awt.event.ActionListener;

public class BotonOculto extends JButton{
    protected int x;
    protected int y;
    protected int w;
    protected int h;

    public BotonOculto(int x, int y, int w, int h, ActionListener al){
            super();
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.setBounds(x, y, w, h);
            this.addActionListener(al);
            this.setOpaque(false);
            this.setContentAreaFilled(false);
            this.setBorderPainted(false);
    }
}
