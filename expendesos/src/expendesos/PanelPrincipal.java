package expendesos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel implements ActionListener{

    private static final int EXPENDEDOR_X = 690;
    private static final int EXPENDEDOR_Y = 60;
    private static final int EXPENDEDOR_W = 550;
    private static final int EXPENDEDOR_H = 600;

    private Comprador com;
    private Expendedor exp;

    private JButton botonCoca;
    private JButton botonFanta;
    private JButton botonSprite;

    
    public PanelPrincipal () {
        exp = new Expendedor(10, 100, EXPENDEDOR_X, EXPENDEDOR_Y, EXPENDEDOR_W, EXPENDEDOR_H);
        com = new Comprador(new Moneda100(), 1, exp, 30, 50);

        this.setBackground(Color.white);
        this.setLayout(null);

        botonCoca = new JButton("Coca");
        botonSprite = new JButton("Fanta");
        botonFanta = new JButton("Sprite");
        
        this.add(botonCoca);
        this.add(botonSprite);
        this.add(botonFanta);

        botonCoca.setBounds((int)(EXPENDEDOR_X + 0.766 * EXPENDEDOR_W), (int)(EXPENDEDOR_Y + 0.15 * EXPENDEDOR_H), (int)(0.164 * EXPENDEDOR_W), (int)(0.08 * EXPENDEDOR_H));
        botonFanta.setBounds((int)(EXPENDEDOR_X + 0.766 * EXPENDEDOR_W), (int)(EXPENDEDOR_Y + 0.274 * EXPENDEDOR_H), (int)(0.164 * EXPENDEDOR_W), (int)(0.08 * EXPENDEDOR_H));
        botonSprite.setBounds((int)(EXPENDEDOR_X + 0.766 * EXPENDEDOR_W), (int)(EXPENDEDOR_Y + 0.398 * EXPENDEDOR_H), (int)(0.164 * EXPENDEDOR_W), (int)(0.08 * EXPENDEDOR_H));

        //botonCoca.setOpaque(false);
        //botonCoca.setContentAreaFilled(false);
        //botonCoca.setBorderPainted(false);
    }
    
    @Override
    public void paint(Graphics g) { 
        super.paint(g); 
        g.clearRect(0, 0, 1280, 720);

        exp.paint(g); 
        com.paint(g); 

        //Botones expendedor
        g.setColor(Color.red);
        g.fillRect((int)(EXPENDEDOR_X + 0.766 * EXPENDEDOR_W), (int)(EXPENDEDOR_Y + 0.15 * EXPENDEDOR_H), (int)(0.164 * EXPENDEDOR_W), (int)(0.08 * EXPENDEDOR_H));
        botonFanta.setBounds((int)(EXPENDEDOR_X + 0.766 * EXPENDEDOR_W), (int)(EXPENDEDOR_Y + 0.274 * EXPENDEDOR_H), (int)(0.164 * EXPENDEDOR_W), (int)(0.08 * EXPENDEDOR_H));
        botonSprite.setBounds((int)(EXPENDEDOR_X + 0.766 * EXPENDEDOR_W), (int)(EXPENDEDOR_Y + 0.398 * EXPENDEDOR_H), (int)(0.164 * EXPENDEDOR_W), (int)(0.08 * EXPENDEDOR_H));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    } 
}
