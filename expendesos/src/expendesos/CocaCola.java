package expendesos;

public class CocaCola extends Bebida {
    public CocaCola(int numSerie){
        super(numSerie);
    }

    @Override
    public String beber() {
        return "CocaCola";
    }
    
}
