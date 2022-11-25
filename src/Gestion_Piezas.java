import org.mariadb.jdbc.Connection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class Gestion_Piezas {
    private JButton limpiarButtonProve;
    private JButton insertarButton;
    private JButton modificarButtonProve;
    private JButton eliminarButtonProve;
    private JTextField textPiezasDescripcion;
    private JLabel label6;
    private JTextField textPiezasPrecio;
    private JLabel label4;
    private JTextField textPiezasNombre;
    private JLabel label3;
    private JTextField textPiezasCodigo;
    private JLabel label2;
    private JLabel label1;
    private JButton buttonListadoPiezas;
     JPanel panelGestionPiezas;

    public Gestion_Piezas() {
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {

                    String codigo = textPiezasCodigo.getText();


                    String nombre = textPiezasNombre.getText();

                    double Precio = Double.parseDouble(textPiezasPrecio.getText());

                    String descripcion = textPiezasDescripcion.getText();
                    //revisar que la longitud este bien controlada mediante if y else if
                    //revisar codigo
                    if (codigo.length() != 6) {

                        JOptionPane.showMessageDialog(null, "Error longitud de codigo superada o dato vacio por favor  vuelve a dar el dato tiene que ser de 6 caracteres max","Erro",JOptionPane.ERROR_MESSAGE);
                        textPiezasCodigo.setText("");


//revisar nombre
                    } else if (nombre.length() > 20 || nombre.length() < 2) {

                        JOptionPane.showMessageDialog(null, "Error longitud de nombre superada o muy corto o vacio por favor vuelve a dar el dato,tiene que ser entre 3 a 20 caracteres max ","Erro",JOptionPane.ERROR_MESSAGE);
                        textPiezasNombre.setText("");

                        //revisar Precio
                    } else if (Precio == 0 || Precio > 60) {
                        JOptionPane.showMessageDialog(null, "Precio deber ser mayor  a 0 y menor a 60","Erro",JOptionPane.ERROR_MESSAGE);
                        textPiezasPrecio.setText("");

                    }  else {
                        Connection conexion = null;

                        Class.forName("org.mariadb.jdbc.Driver");
                        conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");
                        PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO `piezas`(CODIGO, NOMBRE , PRECIO , DESCRIPCION) VALUES (?, ?, ?, ?)");
                        pstmt.setString(1, codigo);
                        pstmt.setString(2, nombre);
                        pstmt.setDouble(3, Precio);
                        pstmt.setString(4, descripcion);

                        pstmt.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Insert hecho correctamente","Info",JOptionPane.INFORMATION_MESSAGE);
                        textPiezasCodigo.setText("");
                        textPiezasNombre.setText("");
                        textPiezasDescripcion.setText("");
                        textPiezasPrecio.setText("0");
                    }
                } catch (SQLDataException ex) {
                    System.out.println("hubo un error en los datos de la query sql o la conexion revisalo:  " + ex);
                    JOptionPane.showMessageDialog(null, "hubo un error en los datos de la query sql o la conexion revisalo:  ","Error",JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex,"Error",JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ew) {
                    System.out.println("La clase no fue encontrada revisa la config del run por favor  " + ew);
                    JOptionPane.showMessageDialog(null, "La clase no fue encontrada revisa la config del run por favor  ","Error",JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ew,"Error",JOptionPane.ERROR_MESSAGE);

                } catch (SQLException ej) {
                    System.out.println("Exception a la hora de la conexion revisa los datos de la conexion tnato como el puerto como el usuario  " + ej);

                    JOptionPane.showMessageDialog(null, "Exception a la hora de la conexion revisa los datos de la conexion tnato como el puerto como el usuario  ","Error",JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ej,"Error",JOptionPane.ERROR_MESSAGE);

                } catch (NumberFormatException eo) {
                    System.out.println("Se esperaba un valor numerico por favor vuelva a dar el dato del campo precio ");

                    JOptionPane.showMessageDialog(null, "Se esperaba un valor numerico por favor vuelva a dar el dato del campo precio ","Erro",JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, eo,"Error",JOptionPane.ERROR_MESSAGE);

                }

            }

        });
        limpiarButtonProve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPiezasCodigo.setText("");
                textPiezasNombre.setText("");
                textPiezasDescripcion.setText("");
                textPiezasPrecio.setText("0");
            }
        });
        buttonListadoPiezas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_principal.frameListadoPiezas.setVisible(true);
            }
        });
    }
}
