package expendesos;

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame{
    public Ventana(){
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setTitle("Tarea 3");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.add(new PanelPrincipal(), BorderLayout.CENTER);
        this.setVisible(true);
    }
}
