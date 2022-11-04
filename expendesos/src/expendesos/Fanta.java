package expendesos;

public class Fanta extends Bebida{
    public Fanta(int numSerie){
        super(numSerie);
    }

    @Override
    public String beber() {
        return "Fanta";
    }
}
