import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Listado_Piezas {
    private JLabel lavel123;
    private JTextField textRegistrosNumber;
    private JLabel label12asds;
    private JTextField textNombre;
    private JTextField textCodigoPiezas;
    private JLabel labelcodigo;
    private JTextField textMaxREG;
    private JButton buttonCargarDatos;
    private JTextField textDescripcion;
    private JTextField textPrecio;
    private JButton buttonUltimoReg;
    private JButton button_reg_adelante;
    private JButton button_reg_siguiente;
    private JButton buttonPrimerReg;
    JPanel PanelListadoPiezas;
    int contador = 0;
    int valorBuscador = 0;

    public Listado_Piezas() {
        buttonCargarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;

                try {
                    Class.forName("org.mariadb.jdbc.Driver");
                    conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");

                    Statement sentencia = conexion.createStatement();
                    ResultSet resul = sentencia.executeQuery("SELECT * FROM PIEZAS;");
                    while (resul.next()) {
                        System.out.println("- CODIGO: " + resul.getInt(1) + ", Nombre: " + resul.getString(2) + ", Precio: " + resul.getDouble(3) + ",Descripcion: " + resul.getString(4));
                        Piezas piezas = new Piezas(resul.getInt(1), resul.getString(2), resul.getDouble(3), resul.getString(4));

                        ventana_principal.ListaPiezas[contador] = piezas;
                        contador++;
                        if (contador == 100) {
                            break;
                        }
                    }

                    textRegistrosNumber.setText("0");
                    textMaxREG.setText(String.valueOf(contador - 1));
                    valorBuscador = 0;
                    textCodigoPiezas.setText(String.valueOf(ventana_principal.ListaPiezas[0].codigo));
                    textDescripcion.setText(ventana_principal.ListaPiezas[0].descrpcion);
                    textPrecio.setText(String.valueOf(ventana_principal.ListaPiezas[0].precio));
                    textNombre.setText(ventana_principal.ListaPiezas[0].Nombre);


                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null,"Error en la clase  por favor revise la configuracion del run o si esa clase tiene static para que se vea","Error",JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null,ex);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Error en la conexion o en la consulta por favor revise","Error",JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null,ex);
                }


            }
        });
        button_reg_adelante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (ventana_principal.ListaPiezas[valorBuscador] == null || valorBuscador == contador -1) {

                        JOptionPane.showMessageDialog(null, "No hay mas valores guardados","INFO", JOptionPane.INFORMATION_MESSAGE);


                    } else if (valorBuscador < contador) {
                        valorBuscador++;

                        textRegistrosNumber.setText(String.valueOf(valorBuscador));
                        textCodigoPiezas.setText(String.valueOf(ventana_principal.ListaPiezas[valorBuscador].codigo));
                        textDescripcion.setText(ventana_principal.ListaPiezas[valorBuscador].descrpcion);
                        textPrecio.setText(String.valueOf(ventana_principal.ListaPiezas[valorBuscador].precio));
                        textNombre.setText(ventana_principal.ListaPiezas[valorBuscador].Nombre);

                    }


                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Error no se puede continuar no hay mas datos","Error",JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex,"Error",JOptionPane.ERROR_MESSAGE);


                }


            }


        });
        buttonUltimoReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (ventana_principal.ListaPiezas[valorBuscador] == null || valorBuscador == contador -1) {

                        JOptionPane.showMessageDialog(null, "No hay mas valores guardados","INFO", JOptionPane.INFORMATION_MESSAGE);


                    } else if (valorBuscador < contador) {
                        valorBuscador = contador-1;

                        textRegistrosNumber.setText(String.valueOf(valorBuscador));
                        textCodigoPiezas.setText(String.valueOf(ventana_principal.ListaPiezas[valorBuscador].codigo));
                        textDescripcion.setText(ventana_principal.ListaPiezas[valorBuscador].descrpcion);
                        textPrecio.setText(String.valueOf(ventana_principal.ListaPiezas[valorBuscador].precio));
                        textNombre.setText(ventana_principal.ListaPiezas[valorBuscador].Nombre);

                    }


                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Error no se puede continuar no hay mas datos","Error",JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex,"Error",JOptionPane.ERROR_MESSAGE);


                }


            }

        });
        button_reg_siguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    if (ventana_principal.ListaPiezas[valorBuscador] == null || valorBuscador == 0) {

                        JOptionPane.showMessageDialog(null, "No hay mas valores guardados","INFO", JOptionPane.INFORMATION_MESSAGE);


                    } else if (valorBuscador < contador) {
                        valorBuscador--;

                        textRegistrosNumber.setText(String.valueOf(valorBuscador));
                        textCodigoPiezas.setText(String.valueOf(ventana_principal.ListaPiezas[valorBuscador].codigo));
                        textDescripcion.setText(ventana_principal.ListaPiezas[valorBuscador].descrpcion);
                        textPrecio.setText(String.valueOf(ventana_principal.ListaPiezas[valorBuscador].precio));
                        textNombre.setText(ventana_principal.ListaPiezas[valorBuscador].Nombre);

                    }


                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Error no se puede continuar no hay mas datos","Error",JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex,"Error",JOptionPane.ERROR_MESSAGE);


                }




            }
        });
        buttonPrimerReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (ventana_principal.ListaPiezas[valorBuscador] == null || valorBuscador == 0) {

                        JOptionPane.showMessageDialog(null, "No hay mas valores guardados","INFO", JOptionPane.INFORMATION_MESSAGE);


                    } else if (valorBuscador < contador) {
                        valorBuscador =0;

                        textRegistrosNumber.setText(String.valueOf(valorBuscador));
                        textCodigoPiezas.setText(String.valueOf(ventana_principal.ListaPiezas[valorBuscador].codigo));
                        textDescripcion.setText(ventana_principal.ListaPiezas[valorBuscador].descrpcion);
                        textPrecio.setText(String.valueOf(ventana_principal.ListaPiezas[valorBuscador].precio));
                        textNombre.setText(ventana_principal.ListaPiezas[valorBuscador].Nombre);

                    }


                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Error no se puede continuar no hay mas datos","Error",JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex,"Error",JOptionPane.ERROR_MESSAGE);


                }
            }
        });
    }
}
