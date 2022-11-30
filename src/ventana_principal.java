import org.hibernate.resource.transaction.backend.jta.internal.JtaIsolationDelegate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventana_principal {

    //proyectos
    static JFrame frameListadoProyectos = new JFrame("Listado proyectos");
    static JFrame frameGestionPoyectos = new JFrame("Gestion Proyectos");
    static JFrame frameVentanaProyectos = new JFrame("Ventana Proyectos");


    //proveedores
    static JFrame frameConsultasProveedorCodigo = new JFrame("Consultas Proveedor codigo");
    static JFrame frameConsultasProveedorNombre = new JFrame("Consultas Proveedor nombre");
    static JFrame frameMenuConsultasProve = new JFrame("Menu Consultas");
    static JFrame frameConsultarProveedorDireccion = new JFrame("Consultas Proveedor Direccion");
    static JFrame frameListadoProveedores = new JFrame("Listado_Proveedores");
    static JFrame frameProveedores = new JFrame("Ventana_Proveedores");
    static JFrame frameGestionProvedores = new JFrame("Gestion_Proveedores");
    //piezas

    static JFrame frameMenuConsultasPiezas = new JFrame("Menu Consultas");


    static JFrame framePiezas = new JFrame("ventana_Piezas");

    static JFrame frameGestionPiezas = new JFrame("Gestion Piezas");
    static JFrame frameListadoPiezas = new JFrame("Listado Piezas");
    static JFrame FrameConsultasPiezasDescripcion = new JFrame("Consultas Piezas Nomnbre");
    static JFrame frameConsultasPiezasCodigo = new JFrame("Consultas Piezas Codigo ");
    static JFrame frameConsultasPiezasNombre = new JFrame("Consultas Piezas Codigo");


    static JFrame frameMain = new JFrame("ventana_principal");


    private JButton baseDeDatosButton;
    private JButton buttonProveedores;
    private JButton buttonPiezas;
    private JButton buttonProyectos;
    private JButton buttonGestionGlobal;
    private JButton buttonAyuda;
    private JPanel PanelMain;
    public static Proyectos[] ListadoProyectos = new Proyectos[100];
    public static Proveedores[] Listaproveedores = new Proveedores[100];
    public static Piezas[] ListaPiezas = new Piezas[100];

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
        buttonProyectos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameVentanaProyectos.setVisible(true);
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
        frameProveedores.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameProveedores.pack();
        frameProveedores.setVisible(false);
//ventana piezas
        framePiezas.setContentPane(new ventana_Piezas().PanelPieza);
        framePiezas.pack();
        framePiezas.setVisible(false);
        framePiezas.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//gestion piezas
        frameGestionPiezas.setContentPane(new Gestion_Piezas().panelGestionPiezas);
        frameGestionPiezas.pack();
        frameGestionPiezas.setVisible(false);
        frameGestionPiezas.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //gestion proveedores
        frameGestionProvedores.setContentPane(new Gestion_Proveedores().panelGestionProveedores);
        frameGestionProvedores.pack();
        frameGestionProvedores.setVisible(false);
        frameGestionProvedores.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//listado proveedores
        frameListadoProveedores.setContentPane(new Listado_Proveedores().PanelListadoProveedores);
        frameListadoProveedores.pack();
        frameListadoProveedores.setVisible(false);
        frameListadoProveedores.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //lsitado piezas
        frameListadoPiezas.setContentPane(new Listado_Piezas().PanelListadoPiezas);
        frameListadoPiezas.pack();
        frameListadoPiezas.setVisible(false);
        frameListadoPiezas.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //listado_proyectos
        frameListadoProyectos.setContentPane(new listado_proyectos().panelListaProyecto);
        frameListadoProyectos.pack();
        frameListadoProyectos.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameListadoProyectos.setVisible(false);
        //ventana proyectos
        frameVentanaProyectos.setContentPane(new ventana_Proyectos().PanelProyectos);
        frameVentanaProyectos.pack();
        frameVentanaProyectos.setVisible(false);
        frameVentanaProyectos.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //Proyectos gestion
        frameGestionPoyectos.setContentPane(new Gestion_proyectos().PanelGestionProyectos);
        frameGestionPoyectos.pack();
        frameGestionPoyectos.setVisible(false);
        frameGestionPoyectos.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        //conuslta provedores
        //menu
        frameMenuConsultasProve.setContentPane(new menuConsultasProveedor().panelMenuProve);
        frameMenuConsultasProve.pack();
        frameMenuConsultasProve.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameMenuConsultasProve.setVisible(false);
        //codigo
        frameConsultasProveedorCodigo.setContentPane(new ConsultaProveedoresCodigo().PanelConsultaProveedores);
        frameConsultasProveedorCodigo.pack();
        frameConsultasProveedorCodigo.setVisible(false);
        frameConsultasProveedorCodigo.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //nombre
        frameConsultasProveedorNombre.setContentPane(new ConsultaProveedorNombre().panelConsultasNombreProveedor);
        frameConsultasProveedorNombre.pack();
        frameConsultasProveedorNombre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameConsultasProveedorNombre.setVisible(false);
        //direccion
        frameConsultarProveedorDireccion.setContentPane(new ConsultaProveedorDireccion().panelConsutlarDireccionProve);
        frameConsultarProveedorDireccion.pack();
        frameConsultarProveedorDireccion.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameConsultarProveedorDireccion.setVisible(false);

        //consulta piezas
        //menu
        frameMenuConsultasPiezas.setContentPane(new MenuConsultasPiezas().panelMenuPiezas);
        frameMenuConsultasPiezas.pack();
        frameMenuConsultasPiezas.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameMenuConsultasPiezas.setVisible(false);
        //nombre
        frameConsultasPiezasNombre.setContentPane(new ConsultaPiezasNombre().panelConsultaPiezasNombre);
        frameConsultasPiezasNombre.pack();
        frameConsultasPiezasNombre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameConsultasPiezasNombre.setVisible(false);
        //codigo
        frameConsultasPiezasCodigo.setContentPane(new ConsultaPiezasCodigo().panelConsultaPiezasCodogo);
        frameConsultasPiezasCodigo.pack();
        frameConsultasPiezasCodigo.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //descripcion
        FrameConsultasPiezasDescripcion.setContentPane(new ConsultaPiezasDescripcion().panelConsultaPiezasDecripcion);
        FrameConsultasPiezasDescripcion.pack();
        FrameConsultasPiezasDescripcion.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        FrameConsultasPiezasDescripcion.setVisible(false);
    }
}
