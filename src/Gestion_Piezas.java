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
    private JTextField textProveedoresDireccion;
    private JLabel label6;
    private JTextField textProveedoresApellido;
    private JLabel label4;
    private JTextField textProveedoresNombre;
    private JLabel label3;
    private JTextField textProveedorCodigo;
    private JLabel label2;
    private JLabel label1;
    private JButton buttonListadoPiezas;

    public Gestion_Piezas() {
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {

                    String codigo = textProveedorCodigo.getText();


                    String nombre = textProveedoresNombre.getText();

                   Double Precio  = Double.valueOf(textProveedoresApellido.getText());

                    String direccion = textProveedoresDireccion.getText();
                    //revisar que la longitud este bien controlada mediante if y else if
                    //revisar codigo
                    if (codigo.length() != 6) {

                        JOptionPane.showMessageDialog(null, "Error longitud de codigo superada o dato vacio por favor  vuelve a dar el dato tiene que ser de 6 caracteres max");
                        textProveedorCodigo.setText("");


//revisar nombre
                    } else if (nombre.length() > 20 || nombre.length() < 2) {

                        JOptionPane.showMessageDialog(null, "Error longitud de nombre superada o muy corto o vacio por favor vuelve a dar el dato,tiene que ser entre 3 a 20 caracteres max ");
                        textProveedoresNombre.setText("");

                        //revisar Precio
                    } else if (Precio== 0 || Precio > 60) {
                        JOptionPane.showMessageDialog(null, "Precio deber ser mayor  a 0 y menor a 60");
                        textProveedoresApellido.setText("");

                    } else if (direccion.length() > 40 || direccion.length() < 10) {

                        JOptionPane.showMessageDialog(null, "Error longitud de dirrecion superada o muy corto o vacio por favor vuelve a dar el dato,tiene que ser entre 10 a 40 caracteres max");
                        textProveedoresDireccion.setText("");

                    } else {
                        Connection conexion = null;

                        Class.forName("org.mariadb.jdbc.Driver");
                        conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");
                        PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO `piezas`(CODIGO, NOMBRE , PRECIO , DESCRIPCION) VALUES (?, ?, ?, ?)");
                        pstmt.setString(1, codigo);
                        pstmt.setString(2, nombre);
                        pstmt.setDouble(3, Precio);
                        pstmt.setString(4, direccion);

                        pstmt.executeUpdate();
                    }
                } catch (SQLDataException ex) {
                    System.out.println("hubo un error en los datos de la query sql revisalo:  " + ex);

                } catch (ClassNotFoundException ew) {
                    System.out.println("La clase no fue encontrada revisa la config del run por favor  " + ew);
                } catch (SQLException ej) {
                    System.out.println("Exception a la hora de la conexion  " + ej);
                }catch (NumberFormatException eo){
                    System.out.println("Se esperaba un valor numerico por favor vuelva a dar el dato del campo precio " );
                    JOptionPane.showMessageDialog(null,  eo);

                }

            }

        });
    }
}
