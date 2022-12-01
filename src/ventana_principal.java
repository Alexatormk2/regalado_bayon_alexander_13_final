import org.hibernate.resource.transaction.backend.jta.internal.JtaIsolationDelegate;
import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.client.result.ResultSetMetaData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        baseDeDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet resul;
                Connection conexion = null;
                PreparedStatement pstmt;
                ResultSetMetaData rsmd;
                String name;
                String type;
///piezas
                String[] listaNamePiezas = new String[5];
                String[] listaTypePiezas = new String[5];
                String[] listaNameProveedores = new String[5];
                String[] listaTypeProveedores = new String[5];

                String[] listaNameProyectos = new String[4];
                String[] listaTypeProyectos = new String[4];
                try {
                    Class.forName("org.mariadb.jdbc.Driver");
//piezas
                    conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");
                    pstmt = conexion.prepareStatement("SELECT * FROM Piezas;");
                    resul = pstmt.executeQuery();

                    rsmd = (ResultSetMetaData) resul.getMetaData();
                    int count = rsmd.getColumnCount();
                    for (int i = 1; i <= count; i++) {
                        name = rsmd.getColumnName(i);
                        listaNamePiezas[i] = name;

                        type = rsmd.getColumnTypeName(i);
                        listaTypePiezas[i] = type;

                        System.out.println(name + " (" + type + ")");

                    }
                    JOptionPane.showMessageDialog(null, listaNamePiezas[1] + "(" + listaTypePiezas[1] + ")" + "____" + listaNamePiezas[2] + "(" + listaTypePiezas[2] + ")" + "____" + listaNamePiezas[3] + "(" + listaTypePiezas[3] + ")" + "____" + listaNamePiezas[4] + "(" + listaTypePiezas[4] + ")", "Piezas", JOptionPane.INFORMATION_MESSAGE);

//proveedores

                    pstmt = conexion.prepareStatement("SELECT * FROM PROVEEDORES;");
                    resul = pstmt.executeQuery();

                    rsmd = (ResultSetMetaData) resul.getMetaData();
                    count = rsmd.getColumnCount();
                    for (int i = 1; i <= count; i++) {
                        name = rsmd.getColumnName(i);
                        listaNameProyectos[i] = name;

                        type = rsmd.getColumnTypeName(i);
                        listaTypeProyectos[i] = type;

                        System.out.println(name + " (" + type + ")");

                    }
                    JOptionPane.showMessageDialog(null, listaNameProyectos[1] + "(" + listaTypeProyectos[1] + ")" + "____" + listaNameProyectos[2] + "(" + listaTypeProyectos[2] + ")" + "____" + listaNameProyectos[3] + "(" + listaTypeProyectos[3] + ")" + "____" + listaNameProyectos[4] + "(" + listaTypeProyectos[4] + ")", "Proyectos", JOptionPane.INFORMATION_MESSAGE);


                    pstmt = conexion.prepareStatement("SELECT * FROM PROVEEDORES;");
                    resul = pstmt.executeQuery();

                    rsmd = (ResultSetMetaData) resul.getMetaData();
                    count = rsmd.getColumnCount();
                    for (int i = 1; i <= count; i++) {
                        name = rsmd.getColumnName(i);
                        listaNameProveedores[i] = name;

                        type = rsmd.getColumnTypeName(i);
                        listaTypeProveedores[i] = type;

                        System.out.println(name + " (" + type + ")");

                    }
                    JOptionPane.showMessageDialog(null, listaNameProveedores[1] + "(" + listaTypeProveedores[1] + ")" + "____" + listaNameProveedores[2] + "(" + listaTypeProveedores[2] + ")" + "____" + listaNameProveedores[3] + "(" + listaTypeProveedores[3] + ")" + "____" + listaNameProveedores[4] + "(" + listaTypeProveedores[4] + ")", "Proveedores", JOptionPane.INFORMATION_MESSAGE);


                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }


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
