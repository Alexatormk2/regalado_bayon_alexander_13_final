import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestionGlobalListar {
    JPanel ListarGLobar;
    private JLabel lavel123;
    private JTextField textRegistrosNumber;
    private JLabel label12asds;
    private JTextField textProveedorCodigo;
    private JTextField textCodigoPiezas;
    private JLabel labelcodigo;
    private JTextField textMaxREG;
    private JButton buttonCargarDatos;
    private JTextField textCantidad;
    private JTextField textCodigoProyecto;
    private JButton buttonUltimoReg;
    private JButton button_reg_adelante;
    private JButton button_reg_siguiente;
    private JButton buttonPrimerReg;
    private JTextField textCodigoGestion;
    int contador = 0;
    int valorBuscador = 0;


    public GestionGlobalListar() {
        buttonCargarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;

                try {
                    Class.forName("org.mariadb.jdbc.Driver");
                    conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");

                    Statement sentencia = conexion.createStatement();
                    ResultSet resul = sentencia.executeQuery("SELECT * FROM gestion;");
                    while (resul.next()) {
                        System.out.println("- CODIGO Gestion: " + resul.getString(1) + "- CODIGO Proveedor: " + resul.getString(2) + ", CodigoPiezas: " + resul.getString(3) + ",Codigo Proyecto: " + resul.getString(4) + ",Cantidad: " + resul.getDouble(5));
                        GestionGlobal gestionGlobal = new GestionGlobal(resul.getInt(1), resul.getInt(2), resul.getInt(3), resul.getInt(4), resul.getDouble(5));

                        ventana_principal.ListaGestion[contador] = gestionGlobal;
                        contador++;
                        if (contador == 100) {
                            break;
                        }
                    }

                    textRegistrosNumber.setText("0");
                    textMaxREG.setText(String.valueOf(contador - 1));
                    valorBuscador = 0;
                    textCodigoGestion.setText(String.valueOf(ventana_principal.ListaGestion[0].codigoGestion));
                    textCodigoPiezas.setText(String.valueOf(ventana_principal.ListaGestion[0].piezasCodigo));
                    textCodigoProyecto.setText(String.valueOf(ventana_principal.ListaGestion[0].proyectosCodigo));
                    textProveedorCodigo.setText(String.valueOf(ventana_principal.ListaGestion[0].proveedoresCodigo));
                    textCantidad.setText(String.valueOf(ventana_principal.ListaGestion[0].cantidad));


                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null,"Error en la clase  por favor revise la configuracion del run o si esa clase tiene static para que se vea","Error",JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null,ex);

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        button_reg_adelante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (ventana_principal.ListaGestion[valorBuscador] == null || valorBuscador == contador - 1) {

                        JOptionPane.showMessageDialog(null, "No hay mas valores guardados", "INFO", JOptionPane.INFORMATION_MESSAGE);


                    } else if (valorBuscador < contador) {
                        valorBuscador++;

                        textRegistrosNumber.setText(String.valueOf(valorBuscador));
                        textCodigoGestion.setText(String.valueOf(ventana_principal.ListaGestion[valorBuscador].codigoGestion));
                        textCodigoPiezas.setText(String.valueOf(ventana_principal.ListaGestion[valorBuscador].piezasCodigo));
                        textCodigoProyecto.setText(String.valueOf(ventana_principal.ListaGestion[valorBuscador].proyectosCodigo));
                        textProveedorCodigo.setText(String.valueOf(ventana_principal.ListaGestion[valorBuscador].proveedoresCodigo));
                        textCantidad.setText(String.valueOf(ventana_principal.ListaGestion[valorBuscador].cantidad));

                    }


                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Error no se puede continuar no hay mas datos", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);


                }


            }


        });
        buttonUltimoReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (ventana_principal.ListaPiezas[valorBuscador] == null || valorBuscador == contador - 1) {

                        JOptionPane.showMessageDialog(null, "No hay mas valores guardados", "INFO", JOptionPane.INFORMATION_MESSAGE);


                    } else if (valorBuscador < contador) {
                        valorBuscador = contador - 1;

                        textRegistrosNumber.setText(String.valueOf(valorBuscador));
                        textCodigoGestion.setText(String.valueOf(ventana_principal.ListaGestion[valorBuscador].codigoGestion));
                        textCodigoPiezas.setText(String.valueOf(ventana_principal.ListaGestion[valorBuscador].piezasCodigo));
                        textCodigoProyecto.setText(String.valueOf(ventana_principal.ListaGestion[valorBuscador].proyectosCodigo));
                        textProveedorCodigo.setText(String.valueOf(ventana_principal.ListaGestion[valorBuscador].proveedoresCodigo));
                        textCantidad.setText(String.valueOf(ventana_principal.ListaGestion[valorBuscador].cantidad));

                    }


                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Error no se puede continuar no hay mas datos", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);


                }


            }

        });
        button_reg_siguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    if (ventana_principal.ListaPiezas[valorBuscador] == null || valorBuscador == 0) {

                        JOptionPane.showMessageDialog(null, "No hay mas valores guardados", "INFO", JOptionPane.INFORMATION_MESSAGE);


                    } else if (valorBuscador < contador) {
                        valorBuscador--;

                        textRegistrosNumber.setText(String.valueOf(valorBuscador));
                        textCodigoGestion.setText(String.valueOf(ventana_principal.ListaGestion[valorBuscador].codigoGestion));
                        textCodigoPiezas.setText(String.valueOf(ventana_principal.ListaGestion[valorBuscador].piezasCodigo));
                        textCodigoProyecto.setText(String.valueOf(ventana_principal.ListaGestion[valorBuscador].proyectosCodigo));
                        textProveedorCodigo.setText(String.valueOf(ventana_principal.ListaGestion[valorBuscador].proveedoresCodigo));
                        textCantidad.setText(String.valueOf(ventana_principal.ListaGestion[valorBuscador].cantidad));

                    }


                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Error no se puede continuar no hay mas datos", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);


                }


            }
        });
        buttonPrimerReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (ventana_principal.ListaPiezas[valorBuscador] == null || valorBuscador == 0) {

                        JOptionPane.showMessageDialog(null, "No hay mas valores guardados", "INFO", JOptionPane.INFORMATION_MESSAGE);


                    } else if (valorBuscador < contador) {
                        valorBuscador = 0;

                        textRegistrosNumber.setText(String.valueOf(valorBuscador));
                        textCodigoGestion.setText(String.valueOf(ventana_principal.ListaGestion[valorBuscador].codigoGestion));
                        textCodigoPiezas.setText(String.valueOf(ventana_principal.ListaGestion[valorBuscador].piezasCodigo));
                        textCodigoProyecto.setText(String.valueOf(ventana_principal.ListaGestion[valorBuscador].proyectosCodigo));
                        textProveedorCodigo.setText(String.valueOf(ventana_principal.ListaGestion[valorBuscador].proveedoresCodigo));
                        textCantidad.setText(String.valueOf(ventana_principal.ListaGestion[valorBuscador].cantidad));

                    }


                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Error no se puede continuar no hay mas datos", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);


                }
            }
        });
    }
}
