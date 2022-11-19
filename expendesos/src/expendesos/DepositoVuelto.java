package expendesos;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class DepositoVuelto {
    private ArrayList<Moneda> arr;
    private Transform t;
    
    public DepositoVuelto(Transform t){
        arr = new ArrayList<Moneda>();
        this.t = t;    
    }
    
    public void addMoneda(Moneda moneda){
        if(moneda == null){
            return;
        }
        arr.add(moneda);
        arr.get(0).setXY((int)(t.w - arr.get(0).getTransform().w ) , (int)(t.h - arr.get(0).getTransform().h));
    }
    
    public Moneda getMoneda(){
        if(arr.size() > 0){
            Moneda m = arr.remove(0);
            if(arr.size() > 0){
                arr.get(0).setXY((int)(t.w - arr.get(0).getTransform().w) , (int)(t.h - arr.get(0).getTransform().h));
            }
            return m;
        }
        else{
            return null;
        }
    }

    public Transform getTransform(){
        return t;
    }
    
    public void paint(Graphics g, int px, int py){
        g.setColor(Color.GRAY);
        g.fillRect(t.x + px, t.y + py, t.w, t.h);
        
        if(arr.size() > 0) {
            arr.get(0).paint(g, t.x + px, t.y + py);
        }
    }
}
