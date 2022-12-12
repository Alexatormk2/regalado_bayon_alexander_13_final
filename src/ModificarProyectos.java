import DB.ProveedoresEntity;
import DB.ProyectosEntity;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;
import org.mariadb.jdbc.client.result.ResultSetMetaData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ModificarProyectos {
    JPanel PanelModificarProyectos;
    private JButton guardarProve;
    private JTextField textDatoEditado;
    private JComboBox comboCodigoEdit;
    private JComboBox comboCampo;
    private JButton buttonCargarDatos;
    private JButton guardarHibernateButton;
    static String codigoVer;

    public ModificarProyectos() {
        guardarProve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                Connection conexion = null;

                PreparedStatement preparedStmt;


                try {

                    Class.forName("org.mariadb.jdbc.Driver");


                    conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");

                    Statement sentencia = conexion.createStatement();
                    ResultSet resul;
                    String input;
                    String dato;
                    String datoNuevo;
                    boolean resul2;
                    String name;
                    String type;
                    PreparedStatement pstmt;
                    ResultSetMetaData rsmd;


                    input = Objects.requireNonNull(comboCodigoEdit.getSelectedItem()).toString();

                    System.out.println(input);
                    dato = Objects.requireNonNull(comboCampo.getSelectedItem()).toString();
                    System.out.println(dato);
                    datoNuevo = textDatoEditado.getText();


                    resul2 = sentencia.execute("UPDATE  Proyectos SET " + dato + " = \"" + datoNuevo + "\" WHERE CODIGO = \"" + input + "\";");
                    JOptionPane.showMessageDialog(null, "Se editaron los datos", "OK", JOptionPane.INFORMATION_MESSAGE);
                    ventana_principal.modificarProve.setVisible(false);

                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Error el el codigo en la clase por favor revise", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en la consulta por favor revise", "Error", JOptionPane.ERROR_MESSAGE);
                }


            }
        });

        comboCodigoEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (comboCodigoEdit == null) {
                        System.out.println(" combo igual a null");

                    } else {
                        if (comboCodigoEdit.getSelectedIndex() < 0) {

                            System.out.println(" combo igual a 0");
                        }
                        codigoVer = String.valueOf(comboCodigoEdit.getSelectedItem());

                        ;

                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Selecciona un codigo del combo box ");

                }


            }
        });
        comboCampo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    if (comboCampo == null) {
                        System.out.println(" combo igual a null");

                    } else {
                        if (comboCampo.getSelectedIndex() < 0) {

                            System.out.println(" combo igual a 0");
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Selecciona un campo del combo box ");

                }

            }
        });
        buttonCargarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Connection conexion = null;

                PreparedStatement preparedStmt;
                try {

                    Class.forName("org.mariadb.jdbc.Driver");

                    conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");
                    PreparedStatement pstmt = conexion.prepareStatement("SELECT  * FROM Proyectos ");

                    pstmt.executeQuery();
                    while (pstmt.getResultSet().next()) {
                        comboCodigoEdit.addItem(pstmt.getResultSet().getString(1));

                    }


                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex, "Error la consulta esta  mal escrita o algun dato de la conexion esta mal", JOptionPane.ERROR_MESSAGE);


                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex, "Error  de clase, no se pudo encontrar", JOptionPane.ERROR_MESSAGE);

                } catch (Exception ea) {
                    JOptionPane.showMessageDialog(null, ea, "Error  datos vacios", JOptionPane.ERROR_MESSAGE);


                }

            }
        });
        guardarHibernateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo;
                int input;
                String dato;
                String datoNuevo;

                Session session = HibernateUtil.sessionFactory.openSession();
                Transaction tx = session.beginTransaction();
                ProyectosEntity proyectos = new ProyectosEntity();
                try {


                    input = Integer.parseInt(Objects.requireNonNull(comboCodigoEdit.getSelectedItem()).toString());
                    proyectos = session.load(ProyectosEntity.class, input);

                    System.out.println(input);
                    dato = Objects.requireNonNull(comboCampo.getSelectedItem()).toString();
                    System.out.println(dato);


                    datoNuevo = String.valueOf((textDatoEditado.getText()));
                    if (comboCampo.getSelectedItem().equals("Nombre")) {


                        proyectos.setNombre(datoNuevo);


                    } else if (comboCampo.getSelectedItem().equals("Ciudad")) {
                        proyectos.setCiudad(datoNuevo);

                    }

                    session.update(proyectos);
                    tx.commit();
                    JOptionPane.showMessageDialog(null, "Modificado con exito", "OK", JOptionPane.ERROR_MESSAGE);


                } catch (ConstraintViolationException de) {
                    JOptionPane.showMessageDialog(null, "Duplicado detectado", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, de.getMessage());
                    JOptionPane.showMessageDialog(null, de.getErrorCode());
                    JOptionPane.showMessageDialog(null, de.getSQLException().getMessage());
                }
            }
        });
    }
}
