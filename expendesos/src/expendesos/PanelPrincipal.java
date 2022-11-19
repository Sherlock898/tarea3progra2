package expendesos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.JPanel;

public class PanelPrincipal extends JPanel implements ActionListener{
    
    private static final int EXPENDEDOR_X = 690;
    private static final int EXPENDEDOR_Y = 60;
    private static final int EXPENDEDOR_W = 550;
    private static final int EXPENDEDOR_H = 600;

    private Comprador com;
    private Expendedor exp;

    private BotonSelector botonCoca;
    private BotonSelector botonFanta;
    private BotonSelector botonSprite;

    
    public PanelPrincipal () {
        super();
        exp = new Expendedor(10, 100, EXPENDEDOR_X, EXPENDEDOR_Y, EXPENDEDOR_W, EXPENDEDOR_H);
        com = new Comprador(new Moneda100(), 1, exp, 30, 50);

        this.setBackground(Color.white);
        this.setLayout(null);

        botonCoca = new BotonSelector((int)(EXPENDEDOR_X + 0.766 * EXPENDEDOR_W), (int)(EXPENDEDOR_Y + 0.15 * EXPENDEDOR_H), (int)(0.164 * EXPENDEDOR_W), (int)(0.08 * EXPENDEDOR_H), this, 1);
        botonFanta = new BotonSelector((int)(EXPENDEDOR_X + 0.766 * EXPENDEDOR_W), (int)(EXPENDEDOR_Y + 0.274 * EXPENDEDOR_H), (int)(0.164 * EXPENDEDOR_W), (int)(0.08 * EXPENDEDOR_H), this, 2);
        botonSprite = new BotonSelector((int)(EXPENDEDOR_X + 0.766 * EXPENDEDOR_W), (int)(EXPENDEDOR_Y + 0.398 * EXPENDEDOR_H), (int)(0.164 * EXPENDEDOR_W), (int)(0.08 * EXPENDEDOR_H), this, 3);
        
        this.add(botonCoca);
        this.add(botonSprite);
        this.add(botonFanta);
        
    }
    
    @Override
    public void paint(Graphics g) { 
        super.paint(g); 
        g.clearRect(0, 0, 1280, 720);

        exp.paint(g); 
        com.paint(g); 
        botonCoca.paint(g);
        botonFanta.paint(g);
        botonSprite.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().getClass() == BotonSelector.class){
            BotonSelector botonApretado = (BotonSelector)e.getSource();
            Moneda1500 m = new Moneda1500();
            try {
                exp.comprarBebida(m, botonApretado.getSeleccion());
            } catch (NoHayBebidaException | PagoInsuficienteException | PagoIncorrectoException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            repaint();
            System.out.print("AAA");
        }
    } 
}
