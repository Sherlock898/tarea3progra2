package expendesos;

import java.awt.Graphics;
import java.awt.Color;

public class Comprador {
    private String sabor;
    private int cantidadTotal;
    private int x, y;
    
    public Comprador(Moneda m, int cualBebida, Expendedor exp, int x, int y){
        cantidadTotal = 0;
        Bebida bebida;
        this.x = x;
        this.y = y;

        try {
            exp.comprarBebida(m, cualBebida);
        } catch (NoHayBebidaException e) {
            cantidadTotal += exp.getVuelto().getValor();
            sabor = "Nada";
            System.out.println(e);
            return;
        } catch (PagoInsuficienteException e) {
            cantidadTotal += exp.getVuelto().getValor();
            sabor = "Nada";
            System.out.println(e);
            return;
        } catch (PagoIncorrectoException e) {
            sabor = "Nada";
            System.out.println(e);
            return;
        }

        //sabor = bebida.beber();
        
        Moneda vuelto = exp.getVuelto();
        while(vuelto != null){
            cantidadTotal += vuelto.getValor();
            vuelto = exp.getVuelto();
        }
    }
    
    public int cuantoVuelto(){
        return cantidadTotal;
    }

    public String quebebiste(){
        return sabor;
    }

    public void paint(Graphics g){
        g.setColor(Color.PINK);
        g.fillRect(x, y, 300, 300);
        g.setColor(Color.BLACK);
        //Ojos
        //g.fillRect(x + 30, y + 30, 90, 90);
        //g.fillRect(x + 180, y + 30, 90, 90);
        //Boca
        g.fillRect(x + 30, y + 200, 240, 30);

        //Otros ojos:
        g.fillOval(x + 30, y + 30, 90, 100);
        g.fillOval(x + 180, y + 30, 90, 100);

        g.setColor(Color.RED);
        g.fillRect(x + 77, y + 130, 25, 1000);
        g.fillRect(x + 227, y + 130, 25, 1000);
    }
}
