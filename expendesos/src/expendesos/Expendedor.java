package expendesos;

import java.awt.Color;
import java.awt.Graphics;

public class Expendedor{
    private Deposito depCoca;
    private Deposito depFanta;
    private Deposito depSprite;
    private DepositoVuelto depVuelto;
    private int precioBebidas;
    private int x, y;
    private static final int w = 370;
    private static final int h = 500;
    
    public Expendedor(int numBebidas, int precioBebidas, int x, int y){
        this.x = x;
        this.y = y;

        depVuelto = new DepositoVuelto();
        depCoca = new Deposito();
        depFanta= new Deposito();
        depSprite = new Deposito();

        depVuelto.setXY(x + w + 10, y);
        depCoca.setXY(x + 20, y + 20);
        depFanta.setXY(x + 20, y + 180);
        depSprite.setXY(x + 20, y + 340);

        for(int i = 0; i < numBebidas; i++){
            depCoca.addBebida(new CocaCola(i));
            depFanta.addBebida(new Fanta(i + 100));
            depSprite.addBebida(new Sprite(i + 200));
        }
        this.precioBebidas = precioBebidas;
    }
    
    public Bebida comprarBebida(Moneda m, int cual) throws NoHayBebidaException, PagoInsuficienteException, PagoIncorrectoException{
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
                bebida = depSprite.getBebida();
                break;
            case 3:
                bebida = depFanta.getBebida();
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
            depVuelto.addMoneda(new Moneda100());
        }

        return bebida;

    }
    
    public Moneda getVuelto(){
        return depVuelto.getMoneda();
    }
    
    public void paint(Graphics g){
        //super();
        g.setColor(Color.BLACK);
        g.fillRect(x, y, w, h);
        depCoca.paint(g);
        depFanta.paint(g);
        depSprite.paint(g);
        depVuelto.paint(g);
    }
    
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
}
