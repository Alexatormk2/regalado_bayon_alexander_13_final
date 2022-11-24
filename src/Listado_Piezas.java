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
    Piezas[] ListaPiezas = new Piezas[100];
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
                        System.out.println("- CODIGO: " + resul.getString(1) + ", Nombre: " + resul.getString(2) + ", Precio: " + resul.getDouble(3) + ",Direccion: " + resul.getString(4));
                        Piezas piezas = new Piezas(resul.getString(1), resul.getString(2), resul.getDouble(3), resul.getString(4));
                        ListaPiezas[contador] = piezas;
                        contador++;
                        if (contador == 100) {
                            break;
                        }
                    }

                    textRegistrosNumber.setText("0");
                    textMaxREG.setText(String.valueOf(contador - 1));
                    valorBuscador = 0;
                    textCodigoPiezas.setText(ListaPiezas[0].codigo);
                    textDescripcion.setText(ListaPiezas[0].descrpcion);
                    textPrecio.setText(String.valueOf(ListaPiezas[0].precio));
                    textNombre.setText(ListaPiezas[0].Nombre);
                    buttonCargarDatos.setVisible(false);

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
                    if (ListaPiezas[valorBuscador] == null || valorBuscador == contador) {

                        JOptionPane.showMessageDialog(null, "No hay mas valores guardados");
                        textRegistrosNumber.setText(String.valueOf(valorBuscador - 1));

                    } else if (valorBuscador < contador) {
                        valorBuscador++;

                        textRegistrosNumber.setText(String.valueOf(valorBuscador));
                        textCodigoPiezas.setText(ListaPiezas[valorBuscador].codigo);
                        textDescripcion.setText(ListaPiezas[valorBuscador].descrpcion);
                        textPrecio.setText(String.valueOf(ListaPiezas[valorBuscador].precio));
                        textNombre.setText(ListaPiezas[valorBuscador].Nombre);

                    }


                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Error no se puede continuar no hay mas datos");
                    JOptionPane.showMessageDialog(null, ex);


                }


            }


        });
    }
}
