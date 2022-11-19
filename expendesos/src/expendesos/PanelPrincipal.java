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
    private BotonSelector boton100;
    private BotonSelector boton500;
    private BotonSelector boton1000;
    private BotonDeposito botonRecogeBebida;
    private BotonDeposito botonRecogeMoneda;
    private BotonDeposito botonBeber;

    
    public PanelPrincipal(){
        super();
        exp = new Expendedor(100, EXPENDEDOR_X, EXPENDEDOR_Y, EXPENDEDOR_W, EXPENDEDOR_H, this);

        Transform tCom = new Transform(30, 50, 300, 300);
        com = new Comprador(exp, tCom);

        this.setBackground(Color.white);
        this.setLayout(null);

        Transform tBotonCoca = new Transform((int)(0.766 * EXPENDEDOR_W), (int)(0.15 * EXPENDEDOR_H), (int)(0.164 * EXPENDEDOR_W), (int)(0.08 * EXPENDEDOR_H));
        Transform tBotonFanta = new Transform((int)(0.766 * EXPENDEDOR_W), (int)(0.274 * EXPENDEDOR_H), (int)(0.164 * EXPENDEDOR_W), (int)(0.08 * EXPENDEDOR_H));
        Transform tBotonSprite = new Transform((int)(0.766 * EXPENDEDOR_W), (int)(0.398 * EXPENDEDOR_H), (int)(0.164 * EXPENDEDOR_W), (int)(0.08 * EXPENDEDOR_H));
        Transform entregaTrans = exp.getEntregaTransform();
        Transform vueltoTrans = exp.getVueltoTransform();

        Transform tBoton100 = new Transform(40, 500, 100, 100);
        Transform tBoton500 = new Transform(160, 500, 100, 100);
        Transform tBoton1000 = new Transform(280, 500, 100, 100);

        botonCoca = new BotonSelector(tBotonCoca, EXPENDEDOR_X, EXPENDEDOR_Y, this, 1);
        botonFanta = new BotonSelector(tBotonFanta, EXPENDEDOR_X, EXPENDEDOR_Y, this, 2);
        botonSprite = new BotonSelector(tBotonSprite, EXPENDEDOR_X, EXPENDEDOR_Y, this, 3);

        boton100 = new BotonMoneda(tBoton100, this, 1, "$100");
        boton500 = new BotonMoneda(tBoton500, this, 2, "$500");
        boton1000 = new BotonMoneda(tBoton1000, this, 3, "$1000");

        botonRecogeBebida = new BotonDeposito(entregaTrans, EXPENDEDOR_X, EXPENDEDOR_Y, this);
        botonRecogeMoneda = new BotonDeposito(vueltoTrans, EXPENDEDOR_X, EXPENDEDOR_Y, this);
        botonBeber = new BotonDeposito(tCom, 0, 0, this);

        this.add(botonCoca);
        this.add(botonSprite);
        this.add(botonFanta);
        this.add(botonRecogeBebida);
        this.add(botonRecogeMoneda);
        this.add(botonBeber);
        this.add(boton100);
        this.add(boton500);
        this.add(boton1000);
        

    }
    
    @Override
    public void paint(Graphics g) { 
        super.paint(g); 
        g.clearRect(0, 0, 1280, 720);

        exp.paint(g); 
        com.paint(g); 

        botonCoca.paint(g, exp.getTransform().x, exp.getTransform().y);
        botonFanta.paint(g, exp.getTransform().x, exp.getTransform().y);
        botonSprite.paint(g, exp.getTransform().x, exp.getTransform().y);

        boton100.paint(g);
        boton500.paint(g);
        boton1000.paint(g);
    }   

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().getClass() == BotonSelector.class){
            BotonSelector botonApretado = (BotonSelector)e.getSource();
            com.comprarBebida(botonApretado.getSeleccion());

        }

        if(e.getSource() == botonRecogeBebida){
            com.agarrarBebida();   
        }

        if(e.getSource() == botonRecogeMoneda){
            com.agarrarMoneda();
        }

        if(e.getSource() == botonBeber){
            com.beber();
        }

        
        if(e.getSource().getClass() == BotonMoneda.class){
            BotonMoneda b = (BotonMoneda)(e.getSource());
            Transform tMoneda = new Transform(500, 200, 50, 50);
            switch (b.getSeleccion()) {
                case 1:
                    com.setMoneda(new Moneda100(tMoneda));
                    break;
                case 2:
                    com.setMoneda(new Moneda500(tMoneda));
                    break;
                case 3:
                    com.setMoneda(new Moneda1000(tMoneda));
                    break;
                default:
                    break;
            }
        }
        

        repaint();
    } 
}
