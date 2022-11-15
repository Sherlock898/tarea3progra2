package expendesos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel{
    private Comprador com;
    private Expendedor exp;
    
    public PanelPrincipal () {
        exp = new Expendedor(20, 110, 700, 110);
        //cf = new Comprador(10, exp);
        this.setBackground(Color.white);
    }
    
    public void paint(Graphics g) { 
        super.paint(g); 

        //com.paint(g); 
        exp.paint(g); 
    } 
}
