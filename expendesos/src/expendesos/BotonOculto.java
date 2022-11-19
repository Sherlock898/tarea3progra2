package expendesos;

import javax.swing.JButton;
import java.awt.event.ActionListener;

public class BotonOculto extends JButton{
    protected Transform t;

    public BotonOculto(Transform t, int px, int py, ActionListener al){
            super();
            this.t = t;
            this.setBounds(t.x + px, t.y + py, t.w, t.h);
            this.addActionListener(al);
            this.setOpaque(false);
            this.setContentAreaFilled(false);
            this.setBorderPainted(false);
    }
}
