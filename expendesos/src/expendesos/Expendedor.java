package expendesos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.JPanel;


public class Expendedor implements ActionListener{
    private int precioBebidas;
    private int serieCoca;
    private int serieFanta;
    private int serieSprite;
    private Deposito depCoca; 
    private Deposito depFanta;
    private Deposito depSprite;
    private Deposito depEntrega;
    private DepositoVuelto depVuelto;
    private BotonDeposito botonCoca;
    private BotonDeposito botonFanta;
    private BotonDeposito botonSprite;
    private Transform t;
    private JPanel parent;
    
    public Expendedor(int precioBebidas, int x, int y, int w, int h, JPanel parent){
        t = new Transform(x, y, w, h);

        this.parent = parent;


        Transform tDepCoca = new Transform((int)(0.05 * t.w), (int)(0.05 * t.h), (int)(0.182 * t.w), (int)(0.70 * t.h));
        Transform tDepFanta= new Transform((int)(0.282 * t.w), (int)(0.05 * t.h), (int)(0.182 * t.w), (int)(0.70 * t.h));
        Transform tDepSprite = new Transform((int)(0.514 * t.w), (int)(0.05 * t.h), (int)(0.182 * t.w), (int)(0.70 * t.h));
        Transform tDepEntrega = new Transform((int)(0.325 * t.w), (int)(0.82 * t.h)  , (int)(0.35 * t.w), (int)(0.11 * t.h));
        Transform tDepVuelto = new Transform((int)(0.784 * t.w), (int)(0.60 * t.h), (int)(0.12 * t.w), (int)(0.12 * t.w));

        depCoca = new Deposito(tDepCoca, 10);
        depFanta= new Deposito(tDepFanta, 10);
        depSprite = new Deposito(tDepSprite, 10);
        depEntrega = new Deposito(tDepEntrega, 1);
        depVuelto = new DepositoVuelto(tDepVuelto);

        Transform tBotonCoca = new Transform((int)(0.05 * t.w), (int)(0.05 * t.h), (int)(0.182 * t.w), (int)(0.70 * t.h));
        Transform tBotonFanta = new Transform((int)(0.282 * t.w), (int)(0.05 * t.h), (int)(0.182 * t.w), (int)(0.70 * t.h));
        Transform tBotonSprite = new Transform((int)(0.514 * t.w), (int)(0.05 * t.h), (int)(0.182 * t.w), (int)(0.70 * t.h));

        botonCoca = new BotonDeposito(tBotonCoca, t.x, t.y, this);
        botonFanta= new BotonDeposito(tBotonFanta, t.x, t.y, this);
        botonSprite = new BotonDeposito(tBotonSprite, t.x, t.y, this);

        parent.add(botonCoca);
        parent.add(botonFanta);
        parent.add(botonSprite);

        serieCoca = 0;
        serieFanta = 100;
        serieSprite = 200;

        for(int i = 0; i < 10; i++){
            depCoca.addBebida(new CocaCola(serieCoca++, (int)(0.7 * 0.182 * t.w), (int)(0.8 * 0.182 * t.w *  0.4)));
            depFanta.addBebida(new Fanta(serieFanta++, (int)(0.7 * 0.182 * t.w), (int)(0.8 * 0.182 * t.w *  0.4)));
            depSprite.addBebida(new Sprite(serieSprite++, (int)(0.7 * 0.182 * t.w), (int)(0.8 * 0.182 * t.w *  0.4)));
        }

        this.precioBebidas = precioBebidas;
    }
    
    public void comprarBebida(Moneda m, int cual) throws NoHayBebidaException, PagoInsuficienteException, PagoIncorrectoException{
        if(m == null){
            throw new PagoIncorrectoException("Pago Incorrecto");
        }
        
        if(m.getValor() < precioBebidas){
            depVuelto.addMoneda(m);
            throw new PagoInsuficienteException("Pago insuficiente");
        }
        
        Bebida bebida;

        switch (cual) {
            case 1:
                bebida = depCoca.getBebida();
                break;
            case 2:
                bebida = depFanta.getBebida();
                break;
            case 3:
                bebida = depSprite.getBebida();
                break;
            default:
                depVuelto.addMoneda(m);
                throw new NoHayBebidaException("No hay bebida");
        }

        if(bebida == null){
            depVuelto.addMoneda(m);
            throw new NoHayBebidaException("No hay bebida");
        }

        //compra exitosa
        for(int i = 0; i < (m.getValor() - precioBebidas) / 100; i++){
            Transform tMoneda = new Transform(0, 0, 50, 50);
            depVuelto.addMoneda(new Moneda100(tMoneda));
        }

        depEntrega.addBebida(bebida);
        parent.repaint();
    }
    
    public Bebida entregaBebida(){
        return depEntrega.getBebida();
    }

    public Moneda getVuelto(){
        return depVuelto.getMoneda();
    }

    public Transform getVueltoTransform (){
        return depVuelto.getTransform();
    }
    
    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(t.x, t.y, t.w, t.h);
        depCoca.paint(g, t.x, t.y);
        depFanta.paint(g, t.x, t.y);
        depSprite.paint(g, t.x, t.y);
        depEntrega.paint(g, t.x, t.y);
        depVuelto.paint(g, t.x, t.y);
    }
    
    public void setXY(int x, int y){
        t.x = x;
        t.y = y;  
    }

    public Transform getTransform(){
        return t;
    }

    public Transform getEntregaTransform(){
        return depEntrega.getTransform();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonCoca){
            if(depCoca.getCurrentSize() <= 0){
                for(int i = 0; i < 10; i++){
                    depCoca.addBebida(new CocaCola(serieCoca++, (int)(0.7 * 0.182 * t.w), (int)(0.8 * 0.182 * t.w *  0.4)));
                }
            }
        }
        if(e.getSource() == botonFanta){
            if(depFanta.getCurrentSize() <= 0){
                for(int i = 0; i < 10; i++){
                    depFanta.addBebida(new Fanta(serieFanta++, (int)(0.7 * 0.182 * t.w), (int)(0.8 * 0.182 * t.w *  0.4)));
                }
            }
        }
        if(e.getSource() == botonSprite){
            if(depSprite.getCurrentSize() == 0){
                for(int i = 0; i < 10; i++){
                    depSprite.addBebida(new Sprite(serieSprite++, (int)(0.7 * 0.182 * t.w), (int)(0.8 * 0.182 * t.w *  0.4)));
                }
            }
        }

        parent.repaint();
    }
}
