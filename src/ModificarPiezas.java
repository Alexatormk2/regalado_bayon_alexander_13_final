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

public class ModificarPiezas {
    JPanel PanelModificarPiezas;
    private JButton guardarProve;
    private JTextField textDatoEditado;
    private JComboBox comboCodigoEdit;
    private JComboBox comboCampo;
    private JButton buttonCargarDatos;
    static String codigoVer;

    public ModificarPiezas() {
        guardarProve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                Connection conexion = null;

                PreparedStatement preparedStmt;


                try {

                    Class.forName("org.mariadb.jdbc.Driver");


                    conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");
                    double precio;
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
                    if (comboCampo.getSelectedItem().equals("Precio")) {
                        input = Objects.requireNonNull(comboCodigoEdit.getSelectedItem()).toString();

                        System.out.println(input);
                        dato = Objects.requireNonNull(comboCampo.getSelectedItem()).toString();
                        System.out.println(dato);


                        precio = Double.parseDouble(textDatoEditado.getText());
                        resul2 = sentencia.execute("UPDATE  Piezas SET " + dato + " = \"" + precio + "\" WHERE CODIGO = \"" + input + "\";");
                    }

                    input = Objects.requireNonNull(comboCodigoEdit.getSelectedItem()).toString();

                    System.out.println(input);
                    dato = Objects.requireNonNull(comboCampo.getSelectedItem()).toString();
                    System.out.println(dato);
                    datoNuevo = textDatoEditado.getText();


                    resul2 = sentencia.execute("UPDATE  Piezas SET " + dato + " = \"" + datoNuevo + "\" WHERE CODIGO = \"" + input + "\";");
                    JOptionPane.showMessageDialog(null, "Se editaron los datos", "OK", JOptionPane.INFORMATION_MESSAGE);
                    ventana_principal.modificarProve.setVisible(false);

                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Error el el codigo en la clase por favor revise", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en la consulta por favor revise", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ok) {


                    JOptionPane.showMessageDialog(null, "Error se esperaba un numero", "Error", JOptionPane.ERROR_MESSAGE);

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
                    PreparedStatement pstmt = conexion.prepareStatement("SELECT  * FROM Piezas ");

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
    }
}
