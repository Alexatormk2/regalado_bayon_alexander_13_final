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

public class Gestion_proyectos {
    private JButton limpiarButtonProve;
    private JButton insertarButton;
    private JButton modificarButtonProve;
    private JButton eliminarButtonProve;
    private JTextField textProyectosCiudad;
    private JLabel label4;
    private JTextField textProyectosNombre;
    private JLabel label3;
    private JTextField textProyectosCodigo;
    private JLabel label2;
    private JLabel label1;
    JPanel PanelGestionProyectos;
    private JButton buttonListadoProyectos;
    private JButton insertatHibernateButton;


    public Gestion_proyectos() {

        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {

                    int codigo = Integer.parseInt(textProyectosCodigo.getText().toUpperCase());


                    String nombre = textProyectosNombre.getText();

                    String ciudad = textProyectosCiudad.getText();

                    //revisar que la longitud este bien controlada mediante if y else if
                    //revisar codigo
                    String revisar = String.valueOf(codigo);
                    if (revisar.length() != 6) {

                        JOptionPane.showMessageDialog(null, "Error longitud de codigo superada o dato vacio por favor  vuelve a dar el dato tiene que ser de 6 caracteres max", "Error", JOptionPane.ERROR_MESSAGE);
                        textProyectosCodigo.setText("");


//revisar nombre
                    } else if (nombre.length() > 20 || nombre.length() < 2) {

                        JOptionPane.showMessageDialog(null, "Error longitud de nombre superada o muy corto o vacio por favor vuelve a dar el dato,tiene que ser entre 3 a 20 caracteres max ", "Error", JOptionPane.ERROR_MESSAGE);
                        textProyectosNombre.setText("");

                        //revisar ciudad
                    } else if (ciudad.length() > 40 || ciudad.length() < 5) {
                        JOptionPane.showMessageDialog(null, "Error longitud de ciudad superada o muy corto o vacio por favor vuelve a dar el dato,tiene que ser entre 5 a 40 caracteres max", "Error", JOptionPane.ERROR_MESSAGE);
                        textProyectosCiudad.setText("");

                    } else {


                        Connection conexion = null;


                        Class.forName("org.mariadb.jdbc.Driver");
                        conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");
                        PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO `proyectos`(CODIGO, NOMBRE ,CIUDAD ) VALUES (?, ?, ? )");
                        pstmt.setInt(1, codigo);
                        pstmt.setString(2, nombre);
                        pstmt.setString(3, ciudad);


                        pstmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Insert hecho correctamente", "Info", JOptionPane.INFORMATION_MESSAGE);
                        textProyectosCodigo.setText("");

                        textProyectosCiudad.setText("");
                        textProyectosNombre.setText("");

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

                } catch (Throwable se) {
                    JOptionPane.showMessageDialog(null, "Error de auto cerrable de hibernate  ", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, se, "Error", JOptionPane.ERROR_MESSAGE);


                }


            }
        });
        limpiarButtonProve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textProyectosCodigo.setText("");
                textProyectosNombre.setText("");
                textProyectosCiudad.setText("");
            }
        });
        buttonListadoProyectos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_principal.frameListadoProyectos.setVisible(true);
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


                    String query = "delete from  PROYECTOS where CODIGO = ?";

                    preparedStmt = conexion.prepareStatement(query);

                    preparedStmt.setString(1, String.valueOf(textProyectosCodigo.getText()));


                    preparedStmt.executeUpdate();
                    textProyectosCodigo.setText("");
                    textProyectosNombre.setText("");
                    textProyectosCiudad.setText("");
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
        insertatHibernateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Session session = HibernateUtil.sessionFactory.openSession();
                int codigo = Integer.parseInt(textProyectosCodigo.getText().toUpperCase());

                String revisar = String.valueOf(codigo);
                String nombre = textProyectosNombre.getText();

                String ciudad = textProyectosCiudad.getText();

                //revisar que la longitud este bien controlada mediante if y else if
                //revisar codigo
                if (revisar.length() != 6) {

                    JOptionPane.showMessageDialog(null, "Error longitud de codigo superada o dato vacio por favor  vuelve a dar el dato tiene que ser de 6 caracteres max", "Error", JOptionPane.ERROR_MESSAGE);
                    textProyectosCodigo.setText("");


//revisar nombre
                } else if (nombre.length() > 20 || nombre.length() < 2) {

                    JOptionPane.showMessageDialog(null, "Error longitud de nombre superada o muy corto o vacio por favor vuelve a dar el dato,tiene que ser entre 3 a 20 caracteres max ", "Error", JOptionPane.ERROR_MESSAGE);
                    textProyectosNombre.setText("");

                    //revisar ciudad
                } else if (ciudad.length() > 40 || ciudad.length() < 5) {
                    JOptionPane.showMessageDialog(null, "Error longitud de ciudad superada o muy corto o vacio por favor vuelve a dar el dato,tiene que ser entre 5 a 40 caracteres max", "Error", JOptionPane.ERROR_MESSAGE);
                    textProyectosCiudad.setText("");

                } else {
                    try {

                        Transaction tx = session.beginTransaction();
                        ProyectosEntity proyectos = new ProyectosEntity();
                        proyectos.setNombre(nombre);
                        proyectos.setCiudad(ciudad);
                        proyectos.setCodigo(codigo);
                        session.save(proyectos);
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
        modificarButtonProve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_principal.frameModificarProyectos.setVisible(true);
            }
        });
    }
}
