import javax.swing.*;
import java.io.FileReader;

public class ventana_principal {
    private JButton baseDeDatosButton;
    private JButton buttonProveedores;
    private JButton buttonPiezas;
    private JButton buttonProyectos;
    private JButton buttonGestionGlobal;
    private JButton buttonAyuda;
    private JPanel PanelMain;


    public static void main(String[] args) {
        JFrame frameMain = new JFrame("ventana_principal");
        frameMain.setContentPane(new ventana_principal().PanelMain);
    frameMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameMain.pack();
        frameMain.setVisible(true);

        JFrame frameProveedores = new JFrame("Ventana_Proveedores");
        frameProveedores.setContentPane(new Ventana_Proveedores().PanelProveedores);

    }
}
