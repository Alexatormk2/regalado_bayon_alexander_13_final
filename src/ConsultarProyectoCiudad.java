import org.mariadb.jdbc.Connection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultarProyectoCiudad {
     JPanel PanelCiudadProyecto;
    private JButton buttonBuscar;
    private JTextField textBuscar;
    private JTextField textNombre;
    private JTextField textCiudad;
    private JComboBox comboProyectosCodigo;
    private JTextField textCodigo;


    String ciudad;
    String codigoVer;
    int contador = 0;
    Proyectos[] ListaConsultasProyecto = new Proyectos[100];

    public ConsultarProyectoCiudad() {
        buttonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textCodigo.setText("");
                textNombre.setText("");
                textCiudad.setText("");
                Connection conexion = null;
                if (comboProyectosCodigo != null) {
                    comboProyectosCodigo.removeAllItems();


                }
                ciudad = textBuscar.getText().toUpperCase();
                if (ciudad.equals("")) {
                    JOptionPane.showMessageDialog(null, "Error  datos vacios");


                } else {
                    try {

                        Class.forName("org.mariadb.jdbc.Driver");

                        conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");
                        PreparedStatement pstmt = conexion.prepareStatement("SELECT  * FROM Prpyectos WHERE upper( ciudad) like ? ");
                        pstmt.setString(1, "%" + ciudad + "%");
                        pstmt.executeQuery();
                        while (pstmt.getResultSet().next()) {


                            comboProyectosCodigo.addItem(pstmt.getResultSet().getInt(1));
                            Proyectos proyectos = new Proyectos(pstmt.getResultSet().getInt(1), pstmt.getResultSet().getString(2), pstmt.getResultSet().getString(3));
                            ListaConsultasProyecto[contador] = proyectos;

                            contador++;

                        }


                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error en la clase  por favor revise la configuracion del run o si esa clase tiene static para que se vea", "Error", JOptionPane.ERROR_MESSAGE);
                        JOptionPane.showMessageDialog(null, ex);

                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, ex, "Error  de clase, no se pudo encontrar", JOptionPane.ERROR_MESSAGE);

                    } catch (Exception ea) {
                        JOptionPane.showMessageDialog(null, ea, "Error  datos vacios", JOptionPane.ERROR_MESSAGE);


                    }
                }
            }
        });
        comboProyectosCodigo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (comboProyectosCodigo == null) {
                        System.out.println(" combo igual a null");

                    } else {
                        if (comboProyectosCodigo.getSelectedIndex() < 0) {

                            System.out.println(" combo igual a 0");
                        }
                        codigoVer = String.valueOf(comboProyectosCodigo.getSelectedItem());

                        textCodigo.setText(String.valueOf(ListaConsultasProyecto[comboProyectosCodigo.getSelectedIndex()].codigo));
                        textCiudad.setText(ListaConsultasProyecto[comboProyectosCodigo.getSelectedIndex()].ciudad);
                        textNombre.setText(ListaConsultasProyecto[comboProyectosCodigo.getSelectedIndex()].nombre);


                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error en la conexion o en la consulta por favor revise", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
    }
}
