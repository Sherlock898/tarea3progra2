package expendesos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel{
    private Comprador com;
    private Expendedor exp;
    
    public PanelPrincipal () {
        exp = new Expendedor(20, 110, 700, 110);
        com = new Comprador(new Moneda100(), 1, exp, 30, 50);
        this.setBackground(Color.white);
    }
    
    @Override
    public void paint(Graphics g) { 
        super.paint(g); 

        com.paint(g); 
        exp.paint(g); 
    } 
}
