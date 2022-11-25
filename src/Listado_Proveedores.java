import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Listado_Proveedores {
    JPanel PanelListadoProveedores;
    private JLabel lavel123;
    private JTextField textCodigoProveedor;
    private JTextField textNombre;
    private JTextField textDireccion;
    private JTextField textApellidos;
    private JTextField textRegistrosNumber;
    private JLabel label12asds;
    private JLabel labelcodigo;
    private JTextField textMaxREG;
    private JButton button_reg_adelante;
    private JButton buttonUltimoReg;
    private JButton button_reg_siguiente;
    private JButton buttonPrimerReg;
    private JButton buttonCargarDatos;
    Proveedores[] Listaproveedores = new Proveedores[100];
    int contador = 0;
    int valorBuscador = 0;


    public Listado_Proveedores() {
        buttonCargarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;

                try {
                    Class.forName("org.mariadb.jdbc.Driver");
                    conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");

                    Statement sentencia = conexion.createStatement();
                    ResultSet resul = sentencia.executeQuery("SELECT * FROM PROVEEDORES;");
                    while (resul.next()) {
                        //EMPLEADOS:	1-DNI VARCHAR, 2-NOMBRE VARCHAR, 3-APELLIDO VARCHAR, 4-FECHA_NACIMIENTO VARCHAR, 5-FECHA_CONTRATACION VARCHAR, 6-NACIONALIDAD VARCHAR, 7-CARGO VARCHAR, 8-AGENCIA VARCHAR
                        System.out.println("- CODIGO: " + resul.getString(1) + ", Nombre: " + resul.getString(2) + ", Apellido: " + resul.getString(3) + ",Direccion: " + resul.getString(4));
                        Proveedores proveedores1 = new Proveedores(resul.getString(1), resul.getString(2), resul.getString(3), resul.getString(4));
                        Listaproveedores[contador] = proveedores1;
                        contador++;
                        if (contador == 100) {
                            break;
                        }
                    }

                    textRegistrosNumber.setText("0");
                    textMaxREG.setText(String.valueOf(contador -1));
                    valorBuscador =0;
                    textCodigoProveedor.setText(Listaproveedores[0].codigo);
                    textDireccion.setText(Listaproveedores[0].direccion);
                    textApellidos.setText(Listaproveedores[0].apellido);
                    textNombre.setText(Listaproveedores[0].nombre);


                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        button_reg_adelante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Listaproveedores[valorBuscador] == null ||valorBuscador == contador) {
                        JOptionPane.showMessageDialog(null, "No hay mas valores guardados","INFO", JOptionPane.INFORMATION_MESSAGE);
                        textRegistrosNumber.setText(String.valueOf(valorBuscador -1 ));

                    }  else if (valorBuscador < contador) {
                        valorBuscador++;

                        textRegistrosNumber.setText(String.valueOf(valorBuscador ));
                        textCodigoProveedor.setText(Listaproveedores[valorBuscador].codigo);
                        textDireccion.setText(Listaproveedores[valorBuscador].direccion);
                        textApellidos.setText(Listaproveedores[valorBuscador].apellido);
                        textNombre.setText(Listaproveedores[valorBuscador].nombre);

                    }





                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Error no se puede continuar no hay mas datos","Error",JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex,"Error",JOptionPane.ERROR_MESSAGE);


                }


            }
        });
    }
}
