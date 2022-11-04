package expendesos;
import java.util.ArrayList;

public class DepositoVuelto {
    private ArrayList<Moneda> arr;
    
    public DepositoVuelto(){
        arr = new ArrayList<Moneda>();
    }
    
    public void addMoneda(Moneda moneda){
        arr.add(moneda);
    }
    
    public Moneda getMoneda(){
        if(arr.size() > 0){
            return arr.remove(0);
        }
        else{
            return null;
        }
    }
}
