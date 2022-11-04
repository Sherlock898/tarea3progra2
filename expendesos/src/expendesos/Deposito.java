package expendesos;
import java.util.ArrayList;

public class Deposito {
    private ArrayList<Bebida> arr;
    
    public Deposito(){
        arr = new ArrayList<Bebida>();
    }
    
    public void addBebida(Bebida bebida){
        arr.add(bebida);
    }
    
    public Bebida getBebida(){
        if(arr.size() > 0){
            return arr.remove(0);
        }
        else{
            return null;
        }
    }
}
    