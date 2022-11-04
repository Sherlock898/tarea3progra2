package expendesos;

public abstract class Moneda {
    public Moneda getSerie(){
        return this;
    }

    public abstract int getValor();

    public String toString(){
        return getSerie().toString() + getValor();
    }
}

