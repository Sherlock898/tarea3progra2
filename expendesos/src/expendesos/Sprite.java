package expendesos;

public class Sprite extends Bebida{
    public Sprite(int numSerie){
        super(numSerie);
    }

    @Override
    public String beber() {
        return "Sprite";
    }

    
}
