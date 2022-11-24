import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;

public class ventana_principal {
   static JFrame frameMain = new JFrame("ventana_principal");
   static  JFrame frameListadoProveedores = new JFrame("Listado_Proveedores");
   static    JFrame frameProveedores = new JFrame("Ventana_Proveedores");
   static JFrame framePiezas = new JFrame("ventana_Piezas");
   static JFrame frameGestionProvedores = new JFrame("Gestion_Proveedores");
   static JFrame frameGestionPiezas = new JFrame("Gestion Piezas");
   static JFrame frameListadoPiezas = new JFrame("Listado Piezas");
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
        buttonPiezas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                framePiezas.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
//ventana principal
        frameMain.setContentPane(new ventana_principal().PanelMain);
    frameMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameMain.pack();
        frameMain.setVisible(true);
//ventana proveedores

        frameProveedores.setContentPane(new Ventana_Proveedores().PanelProveedores);

        frameProveedores.pack();
        frameProveedores.setVisible(false);
//ventana piezas
        framePiezas.setContentPane(new ventana_Piezas().PanelPieza);
        framePiezas.pack();
        framePiezas.setVisible(false);
//gestion piezas
        frameGestionPiezas.setContentPane(new Gestion_Piezas().panelGestionPiezas);
        frameGestionPiezas.pack();
        frameGestionPiezas.setVisible(false);

        //gestion proveedores
        frameGestionProvedores.setContentPane(new Gestion_Proveedores().panelGestionProveedores);
frameGestionProvedores.pack();
frameGestionProvedores.setVisible(false);
//listado proveedores
        frameListadoProveedores.setContentPane(new Listado_Proveedores().PanelListadoProveedores);
        frameListadoProveedores.pack();
        frameListadoProveedores.setVisible(false);

        //lsitado piezas
        frameListadoPiezas.setContentPane(new Listado_Piezas().PanelListadoPiezas);
        frameListadoPiezas.pack();
        frameListadoPiezas.setVisible(false);
    }
}
