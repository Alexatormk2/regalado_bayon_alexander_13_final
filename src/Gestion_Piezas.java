import DB.PiezasEntity;
import DB.ProyectosEntity;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
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
    private JButton insertarHibernateButton;

    public Gestion_Piezas() {
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {

                    int codigo = Integer.parseInt(textPiezasCodigo.getText().toUpperCase());

                    String revisar = String.valueOf(codigo);
                    String nombre = textPiezasNombre.getText();

                    double Precio = Double.parseDouble(textPiezasPrecio.getText());

                    String descripcion = textPiezasDescripcion.getText();
                    //revisar que la longitud este bien controlada mediante if y else if
                    //revisar codigo
                    if (revisar.length() != 6) {

                        JOptionPane.showMessageDialog(null, "Error longitud de codigo superada o dato vacio por favor  vuelve a dar el dato tiene que ser de 6 caracteres max", "Erro", JOptionPane.ERROR_MESSAGE);
                        textPiezasCodigo.setText("");


//revisar nombre
                    } else if (nombre.length() > 20 || nombre.length() < 2) {

                        JOptionPane.showMessageDialog(null, "Error longitud de nombre superada o muy corto o vacio por favor vuelve a dar el dato,tiene que ser entre 3 a 20 caracteres max ", "Erro", JOptionPane.ERROR_MESSAGE);
                        textPiezasNombre.setText("");

                        //revisar Precio
                    } else if (Precio == 0 || Precio > 60) {
                        JOptionPane.showMessageDialog(null, "Precio deber ser mayor  a 0 y menor a 60", "Erro", JOptionPane.ERROR_MESSAGE);
                        textPiezasPrecio.setText("");

                    } else {
                        Connection conexion = null;

                        Class.forName("org.mariadb.jdbc.Driver");
                        conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");
                        PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO `piezas`(CODIGO, NOMBRE , PRECIO , DESCRIPCION) VALUES (?, ?, ?, ?)");
                        pstmt.setInt(1, codigo);
                        pstmt.setString(2, nombre);
                        pstmt.setDouble(3, Precio);
                        pstmt.setString(4, descripcion);

                        pstmt.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Insert hecho correctamente", "Info", JOptionPane.INFORMATION_MESSAGE);
                        textPiezasCodigo.setText("");
                        textPiezasNombre.setText("");
                        textPiezasDescripcion.setText("");
                        textPiezasPrecio.setText("0");
                    }
                } catch (SQLDataException ex) {
                    System.out.println("hubo un error en los datos de la query sql o la conexion revisalo:  " + ex);
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

                } catch (NumberFormatException eo) {
                    System.out.println("Se esperaba un valor numerico por favor vuelva a dar el dato del campo precio ");

                    JOptionPane.showMessageDialog(null, "Se esperaba un valor numerico por favor vuelva a dar el dato del campo precio ", "Erro", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, eo, "Error", JOptionPane.ERROR_MESSAGE);

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
        eliminarButtonProve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;


                PreparedStatement preparedStmt;
                try {
                    Class.forName("org.mariadb.jdbc.Driver");

                    conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");


                    String query = "delete from  PIEZAS where CODIGO = ?";

                    preparedStmt = conexion.prepareStatement(query);

                    preparedStmt.setString(1, String.valueOf(textPiezasCodigo.getText()));


                    preparedStmt.executeUpdate();
                    textPiezasCodigo.setText("");
                    textPiezasNombre.setText("");
                    textPiezasDescripcion.setText("");
                    textPiezasPrecio.setText("0");
                    JOptionPane.showMessageDialog(null, "Borrado con exito", "Info", JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Se han borrado las gestiones asociadas al dato borrado", "Info", JOptionPane.INFORMATION_MESSAGE);


                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Error en la clase  por favor revise la configuracion del run o si esa clase tiene static para que se vea", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en la conexion o en la consulta por favor revise", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
        modificarButtonProve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                ventana_principal.frameModificarPiezas.setVisible(true);


            }
        });
        modificarButtonProve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        insertarHibernateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Session session = HibernateUtil.sessionFactory.openSession();
                int codigo = Integer.parseInt(textPiezasCodigo.getText().toUpperCase());

                String revisar = String.valueOf(codigo);
                String nombre = textPiezasNombre.getText();

                double Precio = Double.parseDouble(textPiezasPrecio.getText());

                String descripcion = textPiezasDescripcion.getText();
                //revisar que la longitud este bien controlada mediante if y else if
                //revisar codigo
                if (revisar.length() != 6) {

                    JOptionPane.showMessageDialog(null, "Error longitud de codigo superada o dato vacio por favor  vuelve a dar el dato tiene que ser de 6 caracteres max", "Erro", JOptionPane.ERROR_MESSAGE);
                    textPiezasCodigo.setText("");


//revisar nombre
                } else if (nombre.length() > 20 || nombre.length() < 2) {

                    JOptionPane.showMessageDialog(null, "Error longitud de nombre superada o muy corto o vacio por favor vuelve a dar el dato,tiene que ser entre 3 a 20 caracteres max ", "Erro", JOptionPane.ERROR_MESSAGE);
                    textPiezasNombre.setText("");

                    //revisar Precio
                } else if (Precio == 0 || Precio > 60) {
                    JOptionPane.showMessageDialog(null, "Precio deber ser mayor  a 0 y menor a 60", "Erro", JOptionPane.ERROR_MESSAGE);
                    textPiezasPrecio.setText("");

                } else {
                    try {

                        Transaction tx = session.beginTransaction();
                        PiezasEntity piezas = new PiezasEntity();
                        piezas.setNombre(nombre);
                        piezas.setCodigo(codigo);
                        piezas.setDescripcion(descripcion);
                        piezas.setPrecio(Precio);
                        session.save(piezas);
                        tx.commit();
                    } catch (ConstraintViolationException de) {
                        JOptionPane.showMessageDialog(null, "Duplicado detectado", "Error", JOptionPane.ERROR_MESSAGE);
                        JOptionPane.showMessageDialog(null, de.getMessage());
                        JOptionPane.showMessageDialog(null, de.getErrorCode());
                        JOptionPane.showMessageDialog(null, de.getSQLException().getMessage());
                    } catch (NumberFormatException eo) {
                        System.out.println("Se esperaba un valor numerico por favor vuelva a dar el dato del campo precio ");

                        JOptionPane.showMessageDialog(null, "Se esperaba un valor numerico por favor vuelva a dar el dato del campo precio ", "Erro", JOptionPane.ERROR_MESSAGE);
                        JOptionPane.showMessageDialog(null, eo, "Error", JOptionPane.ERROR_MESSAGE);

                    }
                    session.close();

                    JOptionPane.showMessageDialog(null, "Insertado correctamente", "Info", JOptionPane.INFORMATION_MESSAGE);


                }
            }
        });
    }
}
