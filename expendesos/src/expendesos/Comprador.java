package expendesos;

public class Comprador {
    private String sabor;
    private int cantidadTotal;
    
    public Comprador(Moneda m, int cualBebida, Expendedor exp){
        cantidadTotal = 0;
        Bebida bebida;
        try {
            bebida = exp.comprarBebida(m, cualBebida);
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

        sabor = bebida.beber();
        
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
}
