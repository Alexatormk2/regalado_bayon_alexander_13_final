import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;

public class ventana_principal {
   static JFrame frameMain = new JFrame("ventana_principal");
   static    JFrame frameProveedores = new JFrame("Ventana_Proveedores");
    private JButton baseDeDatosButton;
    private JButton buttonProveedores;
    private JButton buttonPiezas;
    private JButton buttonProyectos;
    private JButton buttonGestionGlobal;
    private JButton buttonAyuda;
    private JPanel PanelMain;


    public ventana_principal() {
        buttonProveedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameProveedores.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {

        frameMain.setContentPane(new ventana_principal().PanelMain);
    frameMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameMain.pack();
        frameMain.setVisible(true);


        frameProveedores.setContentPane(new Ventana_Proveedores().PanelProveedores);
        frameProveedores.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameProveedores.pack();
        frameProveedores.setVisible(false);

    }
}
