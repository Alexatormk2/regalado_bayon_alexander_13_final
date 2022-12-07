import DB.ProveedoresEntity;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.mariadb.jdbc.Connection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Gestion_Proveedores {
    JPanel panelGestionProveedores;
    private JButton limpiarButtonProve;
    private JButton insertarButton;
    private JButton modificarButtonProve;
    private JButton eliminarButtonProve;
    private JTextField textProveedorCodigo;
    private JTextField textProveedoresDireccion;
    private JTextField textProveedoresNombre;
    private JTextField textProveedoresApellido;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label6;
    private JButton buttonListadoProveedores;
    private JButton insertarHibernateButton;

    public Gestion_Proveedores() {
        buttonListadoProveedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ventana_principal.frameListadoProveedores.setVisible(true);

            }
        });
        limpiarButtonProve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textProveedorCodigo.setText("");
                textProveedoresApellido.setText("");
                textProveedoresDireccion.setText("");
                textProveedoresNombre.setText("");
            }
        });
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {

                    int codigo = Integer.parseInt(textProveedorCodigo.getText().toUpperCase());


                    String nombre = textProveedoresNombre.getText();

                    String apellido = textProveedoresApellido.getText();

                    String direccion = textProveedoresDireccion.getText();
                    //revisar que la longitud este bien controlada mediante if y else if
                    //revisar codigo
                    String revisar = String.valueOf(codigo);
                    if (revisar.length() != 6) {

                        JOptionPane.showMessageDialog(null, "Error longitud de codigo superada o dato vacio por favor  vuelve a dar el dato tiene que ser de 6 caracteres max", "Error", JOptionPane.ERROR_MESSAGE);
                        textProveedorCodigo.setText("");


//revisar nombre
                    } else if (nombre.length() > 20 || nombre.length() < 2) {

                        JOptionPane.showMessageDialog(null, "Error longitud de nombre superada o muy corto o vacio por favor vuelve a dar el dato,tiene que ser entre 3 a 20 caracteres max ", "Error", JOptionPane.ERROR_MESSAGE);
                        textProveedoresNombre.setText("");

                        //revisar apellido
                    } else if (apellido.length() > 30 || apellido.length() < 2) {
                        JOptionPane.showMessageDialog(null, "Error longitud de apellido superada o muy corto o vacio por favor vuelve a dar el dato,tiene que ser entre 3 a 30 caracteres max", "Error", JOptionPane.ERROR_MESSAGE);
                        textProveedoresApellido.setText("");

                    } else if (direccion.length() > 40 || direccion.length() < 10) {

                        JOptionPane.showMessageDialog(null, "Error longitud de dirrecion superada o muy corto o vacio por favor vuelve a dar el dato,tiene que ser entre 10 a 40 caracteres max", "Error", JOptionPane.ERROR_MESSAGE);
                        textProveedoresDireccion.setText("");

                    } else {
                        Connection conexion = null;

                        Class.forName("org.mariadb.jdbc.Driver");
                        conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");
                        PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO `proveedores`(CODIGO, NOMBRE , APELLIDO , DIRECCION) VALUES (?, ?, ?, ?)");
                        pstmt.setInt(1, codigo);
                        pstmt.setString(2, nombre);
                        pstmt.setString(3, apellido);
                        pstmt.setString(4, direccion);

                        pstmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Insert hecho correctamente", "Info", JOptionPane.INFORMATION_MESSAGE);
                        textProveedorCodigo.setText("");
                        textProveedoresApellido.setText("");
                        textProveedoresDireccion.setText("");
                        textProveedoresNombre.setText("");

                    }
                } catch (SQLDataException ex) {
                    System.out.println("hubo un error en los datos de la query sql revisalo:  " + ex);
                    JOptionPane.showMessageDialog(null, "hubo un error en los datos de la query sql o la conexion revisalo:  ", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);

                } catch (ClassNotFoundException ew) {
                    System.out.println("La clase no fue encontrada revisa la config del run por favor  " + ew);
                    JOptionPane.showMessageDialog(null, "La clase no fue encontrada revisa la config del run por favor  ", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ew, "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ej) {
                    System.out.println("Exception a la hora de la conexion revisa los datos de la conexion tnato como el puerto como el usuario  " + ej);

                    JOptionPane.showMessageDialog(null, "Exception a la hora de la conexion revisa los datos de la conexion tnato como el puerto como el usuario  ", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ej, "Error", JOptionPane.ERROR_MESSAGE);

                }

            }
        });
        eliminarButtonProve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;


                PreparedStatement preparedStmt;
                try {
                    Class.forName("org.mariadb.jdbc.Driver");

                    conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");


                    String query = "delete from  PROVEEDORES where CODIGO = ?";

                    preparedStmt = conexion.prepareStatement(query);

                    preparedStmt.setInt(1, Integer.parseInt(String.valueOf(textProveedorCodigo.getText())));


                    preparedStmt.executeUpdate();
                    textProveedorCodigo.setText("");
                    textProveedoresApellido.setText("");
                    textProveedoresDireccion.setText("");
                    textProveedoresNombre.setText("");
                    JOptionPane.showMessageDialog(null, "Borrado con exito", "Info", JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Se han borrado las gestiones asociadas al dato borrado", "Info", JOptionPane.INFORMATION_MESSAGE);


                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Error en la clase  por favor revise la configuracion del run o si esa clase tiene static para que se vea", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex, "Error codigo no existente o error en la consulta o conexion revise por favor", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex);
                }

            }
        });
        modificarButtonProve.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {


                ventana_principal.modificarProve.setVisible(true);

            }
        });


        insertarHibernateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(textProveedorCodigo.getText().toUpperCase());


                String nombre = textProveedoresNombre.getText();

                String apellido = textProveedoresApellido.getText();

                String direccion = textProveedoresDireccion.getText();

                Session session = HibernateUtil.sessionFactory.openSession();


                String revisar = String.valueOf(codigo);


                //revisar que la longitud este bien controlada mediante if y else if
                //revisar codigo
                if (revisar.length() != 6) {

                    JOptionPane.showMessageDialog(null, "Error longitud de codigo superada o dato vacio por favor  vuelve a dar el dato tiene que ser de 6 caracteres max", "Error", JOptionPane.ERROR_MESSAGE);
                    textProveedorCodigo.setText("");


//revisar nombre
                } else if (nombre.length() > 20 || nombre.length() < 2) {

                    JOptionPane.showMessageDialog(null, "Error longitud de nombre superada o muy corto o vacio por favor vuelve a dar el dato,tiene que ser entre 3 a 20 caracteres max ", "Error", JOptionPane.ERROR_MESSAGE);
                    textProveedoresNombre.setText("");

                    //revisar apellido
                } else if (apellido.length() > 30 || apellido.length() < 2) {
                    JOptionPane.showMessageDialog(null, "Error longitud de apellido superada o muy corto o vacio por favor vuelve a dar el dato,tiene que ser entre 3 a 30 caracteres max", "Error", JOptionPane.ERROR_MESSAGE);
                    textProveedoresApellido.setText("");

                } else if (direccion.length() > 40 || direccion.length() < 10) {

                    JOptionPane.showMessageDialog(null, "Error longitud de dirrecion superada o muy corto o vacio por favor vuelve a dar el dato,tiene que ser entre 10 a 40 caracteres max", "Error", JOptionPane.ERROR_MESSAGE);
                    textProveedoresDireccion.setText("");

                } else {
                    try {

                        Transaction tx = session.beginTransaction();
                        ProveedoresEntity proveedores = new ProveedoresEntity();
                        proveedores.setNombre(nombre);
                        proveedores.setCodigo(codigo);
                        proveedores.setApellido(apellido);
                        proveedores.setDireccion(direccion);
                        session.save(proveedores);
                        tx.commit();
                    } catch (ConstraintViolationException de) {
                        JOptionPane.showMessageDialog(null, "Duplicado detectado", "Error", JOptionPane.ERROR_MESSAGE);
                        JOptionPane.showMessageDialog(null, de.getMessage());
                        JOptionPane.showMessageDialog(null, de.getErrorCode());
                        JOptionPane.showMessageDialog(null, de.getSQLException().getMessage());
                    }
                    session.close();

                    JOptionPane.showMessageDialog(null, "Insertado correctamente", "Info", JOptionPane.INFORMATION_MESSAGE);


                }

            }
        });
    }
}
