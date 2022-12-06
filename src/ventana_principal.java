import org.hibernate.resource.transaction.backend.jta.internal.JtaIsolationDelegate;
import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.client.result.ResultSetMetaData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ventana_principal extends JFrame {


    //gestion
    static JFrame frameGestion = new JFrame("Gestion Global");
    static JFrame frameGestionListar = new JFrame("Listar Gestion");
    static JFrame frameGestionCrear = new JFrame("Gestionar gestion");

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
    static JFrame modificarProve = new JFrame("Modificar prove");
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
    private ImageIcon image1;
    private JLabel label1;
    public static Proyectos[] ListadoProyectos = new Proyectos[100];
    public static Proveedores[] Listaproveedores = new Proveedores[100];
    public static Piezas[] ListaPiezas = new Piezas[100];

    public static GestionGlobal[] ListaGestion = new GestionGlobal[100];

    public ventana_principal() {

        setLayout(new FlowLayout());
        image1 = new ImageIcon(".imagen\\fondo.jpg");
        label1 = new JLabel(image1);
        add(label1);
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
                String[] listaNameGestion = new String[6];
                String[] listaTypeGestion = new String[6];
                String[] listaNamePiezas = new String[5];
                String[] listaTypePiezas = new String[5];
                String[] listaNameProveedores = new String[5];
                String[] listaTypeProveedores = new String[5];

                String[] listaNameProyectos = new String[5];
                String[] listaTypeProyectos = new String[5];
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


                        if (name ==null  || name =="") {
                            break;

                        }else {
                            listaNamePiezas[i] = name;

                        type = rsmd.getColumnTypeName(i);
                        listaTypePiezas[i] = type;

                        System.out.println(name + " (" + type + ")");

                    }}
                    JOptionPane.showMessageDialog(null, listaNamePiezas[1] + "(" + listaTypePiezas[1] + ")" + "____" + listaNamePiezas[2] + "(" + listaTypePiezas[2] + ")" + "____" + listaNamePiezas[3] + "(" + listaTypePiezas[3] + ")" + "____" + listaNamePiezas[4] + "(" + listaTypePiezas[4] + ")", "Piezas", JOptionPane.INFORMATION_MESSAGE);

//proveedores

                    pstmt = conexion.prepareStatement("SELECT * FROM PROVEEDORES;");
                    resul = pstmt.executeQuery();

                    rsmd = (ResultSetMetaData) resul.getMetaData();
                    count = rsmd.getColumnCount();
                    for (int i = 1; i <= count; i++) {

                        name = rsmd.getColumnName(i);
                        if (name ==null  || name =="") {
                            break;

                        }else {
                        listaNameProyectos[i] = name;

                        type = rsmd.getColumnTypeName(i);
                        listaTypeProyectos[i] = type;

                        System.out.println(name + " (" + type + ")");

                    }}
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


                    //Gestion:
                    pstmt = conexion.prepareStatement("SELECT * FROM Gestion;");
                    resul = pstmt.executeQuery();

                    rsmd = (ResultSetMetaData) resul.getMetaData();
                    count = rsmd.getColumnCount();
                    for (int i = 1; i <= count; i++) {
                        name = rsmd.getColumnName(i);

                        if (name ==null  || name =="") {
                            break;

                        }else {
                            listaNameGestion[i] = name;

                            type = rsmd.getColumnTypeName(i);
                            listaTypeGestion[i] = type;

                            System.out.println(name + " (" + type + ")");
                        }
                    }
                    JOptionPane.showMessageDialog(null, listaNameGestion[1] + "(" + listaTypeGestion[1] + ")" + "____" + listaNameGestion[2] + "(" + listaTypeGestion[2] + ")" + "____" + listaNameGestion[3] + "(" + listaTypeGestion[3] + ")" + "____" + listaNameGestion[4] + "(" + listaTypeGestion[4] + ")", "Gestion", JOptionPane.INFORMATION_MESSAGE);


                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Error en la clase  por favor revise la configuracion del run o si esa clase tiene static para que se vea", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en la conexion o en la consulta por favor revise", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex);
                }


            }
        });
        buttonGestionGlobal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_principal.frameGestion.setVisible(true);
            }
        });
        buttonAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Creado por Alexander Regalado Bayon durante el curso de Programacion Multiplataforma", "Author", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
///gestion global

        frameGestion.setContentPane(new GestionGlobalMenu().PanelGestion);
        frameGestion.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameGestion.pack();
        frameGestion.setResizable(false);
        frameGestion.setLocationRelativeTo(null);
        frameGestion.setSize(500, 325);
        frameGestion.setVisible(false);
        //gestionar gestionGlobal
        frameGestionCrear.setContentPane(new GestionGlobalCrear().CrearGestion);
        frameGestionCrear.setVisible(false);
        frameGestionCrear.pack();
        frameGestionCrear.setResizable(false);
        frameGestionCrear.setLocationRelativeTo(null);
        frameGestionCrear.setSize(850, 600);


        //listar gestion
        frameGestionListar.setContentPane(new GestionGlobalListar().ListarGLobar);
        frameGestionListar.pack();
        frameGestionListar.setResizable(false);
        frameGestionListar.setLocationRelativeTo(null);
        frameGestionListar.setSize(720, 420);
        frameGestionListar.setVisible(false);

//ventana principal
        frameMain.setContentPane(new ventana_principal().PanelMain);
        frameMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameMain.pack();
        frameMain.setResizable(false);
        frameMain.setLocationRelativeTo(null);
        frameMain.setSize(1000, 325);
        frameMain.setVisible(true);

//ventana proveedores

        frameProveedores.setContentPane(new Ventana_Proveedores().PanelProveedores);
        frameProveedores.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameProveedores.pack();
        frameProveedores.setLocationRelativeTo(null);
        frameProveedores.setResizable(false);
        frameProveedores.setSize(700, 325);
        frameProveedores.setVisible(false);
//ventana piezas
        framePiezas.setContentPane(new ventana_Piezas().PanelPieza);
        framePiezas.pack();
        framePiezas.setLocationRelativeTo(null);
        framePiezas.setResizable(false);
        framePiezas.setVisible(false);
        framePiezas.setSize(700, 325);
        framePiezas.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//gestion piezas
        frameGestionPiezas.setContentPane(new Gestion_Piezas().panelGestionPiezas);
        frameGestionPiezas.pack();
        frameGestionPiezas.setResizable(false);
        frameGestionPiezas.setLocationRelativeTo(null);
        frameGestionPiezas.setSize(700, 325);
        frameGestionPiezas.setVisible(false);
        frameGestionPiezas.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //gestion proveedores
        frameGestionProvedores.setContentPane(new Gestion_Proveedores().panelGestionProveedores);
        frameGestionProvedores.pack();
        frameGestionProvedores.setLocationRelativeTo(null);
        frameGestionProvedores.setResizable(false);
        frameGestionProvedores.setSize(700, 325);
        frameGestionProvedores.setVisible(false);
        frameGestionProvedores.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //modificador
        modificarProve.setContentPane(new ModificarProveedor().PanelModificarProve);
        modificarProve.pack();
        modificarProve.setLocationRelativeTo(null);
        modificarProve.setResizable(false);
        modificarProve.setSize(700, 300);
        modificarProve.setVisible(false);
        modificarProve.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//listado proveedores
        frameListadoProveedores.setContentPane(new Listado_Proveedores().PanelListadoProveedores);
        frameListadoProveedores.pack();
        frameListadoProveedores.setLocationRelativeTo(null);
        frameListadoProveedores.setResizable(false);
        frameListadoProveedores.setSize(700, 325);
        frameListadoProveedores.setVisible(false);
        frameListadoProveedores.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //lsitado piezas
        frameListadoPiezas.setContentPane(new Listado_Piezas().PanelListadoPiezas);
        frameListadoPiezas.pack();
        frameListadoPiezas.setResizable(false);
        frameListadoPiezas.setLocationRelativeTo(null);
        frameListadoPiezas.setSize(700, 325);
        frameListadoPiezas.setVisible(false);
        frameListadoPiezas.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //listado_proyectos
        frameListadoProyectos.setContentPane(new listado_proyectos().panelListaProyecto);
        frameListadoProyectos.pack();
        frameListadoProyectos.setLocationRelativeTo(null);
        frameListadoProyectos.setResizable(false);
        frameListadoProyectos.setSize(700, 325);
        frameListadoProyectos.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameListadoProyectos.setVisible(false);
        //ventana proyectos
        frameVentanaProyectos.setContentPane(new ventana_Proyectos().PanelProyectos);
        frameVentanaProyectos.pack();
        frameVentanaProyectos.setResizable(false);
        frameVentanaProyectos.setLocationRelativeTo(null);
        frameVentanaProyectos.setSize(700, 325);
        frameVentanaProyectos.setVisible(false);
        frameVentanaProyectos.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //Proyectos gestion
        frameGestionPoyectos.setContentPane(new Gestion_proyectos().PanelGestionProyectos);
        frameGestionPoyectos.pack();
        frameGestionPoyectos.setLocationRelativeTo(null);
        frameGestionPoyectos.setResizable(false);
        frameGestionProvedores.setSize(700, 325);
        frameGestionPoyectos.setVisible(false);
        frameGestionPoyectos.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        //conuslta provedores
        //menu
        frameMenuConsultasProve.setContentPane(new menuConsultasProveedor().panelMenuProve);
        frameMenuConsultasProve.pack();
        frameMenuConsultasProve.setLocationRelativeTo(null);
        frameMenuConsultasProve.setResizable(false);
        frameMenuConsultasProve.setSize(700, 325);
        frameMenuConsultasProve.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameMenuConsultasProve.setVisible(false);
        //codigo
        frameConsultasProveedorCodigo.setContentPane(new ConsultaProveedoresCodigo().PanelConsultaProveedores);
        frameConsultasProveedorCodigo.pack();
        frameConsultasProveedorCodigo.setLocationRelativeTo(null);
        frameConsultasProveedorCodigo.setResizable(false);
        frameConsultasProveedorCodigo.setSize(700, 325);
        frameConsultasProveedorCodigo.setVisible(false);
        frameConsultasProveedorCodigo.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //nombre
        frameConsultasProveedorNombre.setContentPane(new ConsultaProveedorNombre().panelConsultasNombreProveedor);
        frameConsultasProveedorNombre.pack();
        frameConsultasProveedorNombre.setLocationRelativeTo(null);
        frameConsultasProveedorNombre.setResizable(false);
        frameConsultasProveedorNombre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameConsultasProveedorNombre.setSize(700, 325);
        frameConsultasProveedorNombre.setVisible(false);
        //direccion
        frameConsultarProveedorDireccion.setContentPane(new ConsultaProveedorDireccion().panelConsutlarDireccionProve);
        frameConsultarProveedorDireccion.pack();
        frameConsultarProveedorDireccion.setResizable(false);
        frameConsultarProveedorDireccion.setLocationRelativeTo(null);
        frameConsultarProveedorDireccion.pack();
        frameConsultarProveedorDireccion.setSize(700, 325);
        frameConsultarProveedorDireccion.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameConsultarProveedorDireccion.setVisible(false);

        //consulta piezas
        //menu
        frameMenuConsultasPiezas.setContentPane(new MenuConsultasPiezas().panelMenuPiezas);
        frameMenuConsultasPiezas.pack();
        frameMenuConsultasPiezas.setLocationRelativeTo(null);
        frameMenuConsultasPiezas.setResizable(false);
        frameMenuConsultasPiezas.setSize(700, 325);
        frameMenuConsultasPiezas.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameMenuConsultasPiezas.setVisible(false);
        //nombre
        frameConsultasPiezasNombre.setContentPane(new ConsultaPiezasNombre().panelConsultaPiezasNombre);
        frameConsultasPiezasNombre.pack();
        frameConsultasPiezasNombre.setLocationRelativeTo(null);
        frameConsultasPiezasNombre.setResizable(false);
        frameConsultasPiezasNombre.setSize(700, 325);
        frameConsultasPiezasNombre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameConsultasPiezasNombre.setVisible(false);
        //codigo
        frameConsultasPiezasCodigo.setContentPane(new ConsultaPiezasCodigo().panelConsultaPiezasCodogo);
        frameConsultasPiezasCodigo.pack();
        frameConsultasPiezasCodigo.setLocationRelativeTo(null);
        frameConsultasPiezasCodigo.setResizable(false);
        frameConsultasPiezasCodigo.setVisible(false);
        frameConsultasPiezasCodigo.setSize(700, 325);
        frameConsultasPiezasCodigo.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //descripcion
        FrameConsultasPiezasDescripcion.setContentPane(new ConsultaPiezasDescripcion().panelConsultaPiezasDecripcion);
        FrameConsultasPiezasDescripcion.pack();
        FrameConsultasPiezasDescripcion.setLocationRelativeTo(null);
        FrameConsultasPiezasDescripcion.setResizable(false);
        FrameConsultasPiezasDescripcion.setSize(700, 325);
        FrameConsultasPiezasDescripcion.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        FrameConsultasPiezasDescripcion.setVisible(false);
    }
}
