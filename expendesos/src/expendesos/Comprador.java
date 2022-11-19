package expendesos;

import java.awt.Graphics;
import java.awt.Color;

public class Comprador {
    private Expendedor exp;
    private String sabor;
    private int cantidadTotal;
    private Transform t;
    private Deposito inventario;
    private DepositoVuelto monedero;
    private Moneda monedaQueUsa;
    
    public Comprador(Expendedor exp, Transform t){
        sabor = "";
        this.exp = exp;
        cantidadTotal = 0;
        this.t = t;
        
        Transform tInv = new Transform(170, 240, 0, 0);
        inventario = new Deposito(tInv, 1);

        Transform tMon = new Transform((int)(t.w), 0, 0, (int)(1 * t.w));
        monedero = new DepositoVuelto(tMon);
        monedaQueUsa = null;

    }
    
    
    public void comprarBebida(int cual){
        try {
            exp.comprarBebida(monedaQueUsa, cual);
        } catch (NoHayBebidaException e) {
            monedero.addMoneda(exp.getVuelto());
            monedaQueUsa = null;
            e.printStackTrace();
            return;
        } catch (PagoInsuficienteException e) {
            monedero.addMoneda(exp.getVuelto());
            e.printStackTrace();
            return;
        } catch (PagoIncorrectoException e) {
            e.printStackTrace();
            return;
        }

        monedaQueUsa = null;
    }

    public void agarrarBebida(){
        inventario.addBebida(exp.entregaBebida());
    }

    public void agarrarMoneda(){
        Moneda m = exp.getVuelto();
        if(m == null){
            return;
        }
        monedero.getMoneda();
        monedero.addMoneda(m);
    }

    public void setMoneda(Moneda m){
        monedaQueUsa = m;
    }

    public int cuantoVuelto(){
        return cantidadTotal;
    }

    public void beber(){
        Bebida b = inventario.getBebida();
        if(b != null){
            sabor = b.beber();
        }

    }

    public String quebebiste(){
        return sabor;
    }

    public void paint(Graphics g){
        g.setColor(Color.PINK);
        g.fillRect(t.x, t.x, t.w, t.h);
        g.setColor(Color.BLACK);
        //Ojos
        //g.fillRect(x + 30, y + 30, 90, 90);
        //g.fillRect(x + 180, y + 30, 90, 90);
        //Boca
        g.fillRect(t.x + 30, t.y + 200, 240, 30);

        //Otros ojos:
        g.fillOval(t.x + 30, t.y + 30, 90, 100);
        g.fillOval(t.x + 180, t.y + 30, 90, 100);

        g.drawString(sabor, 150, 200);

        inventario.paint(g, t.x, t.y);
        monedero.paint(g, t.x, t.y);

        if(monedaQueUsa != null){
            monedaQueUsa.paint(g, 0, 0);
        }
    }
}
