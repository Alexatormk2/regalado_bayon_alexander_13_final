import org.mariadb.jdbc.Connection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultaProveedorDireccion {
    JPanel panelConsutlarDireccionProve;
    private JButton buttonBuscar;
    private JTextField textBuscarCodigoProveedor;
    private JTextField textNombre;
    private JTextField textApellido;
    private JComboBox comboProveedorCodigo;
    private JTextField textCodigo;
    private JTextField textDireccion;
    String direccion;
    String codigoVer;
    int contador = 0;
    Proveedores[] ListaConsultasProve = new Proveedores[100];

    public ConsultaProveedorDireccion() {
        buttonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textCodigo.setText("");
                textApellido.setText("");
                textNombre.setText("");
                textDireccion.setText("");
                Connection conexion = null;
                if (comboProveedorCodigo != null) {
                    comboProveedorCodigo.removeAllItems();


                }
                direccion = textBuscarCodigoProveedor.getText().toUpperCase();
                if (direccion.equals("")) {
                    JOptionPane.showMessageDialog(null, "Error  datos vacios");


                } else {
                    try {

                        Class.forName("org.mariadb.jdbc.Driver");

                        conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");
                        PreparedStatement pstmt = conexion.prepareStatement("SELECT  * FROM PROVEEDORES WHERE upper( direccion) like ? ");
                        pstmt.setString(1, "%" + direccion + "%");
                        pstmt.executeQuery();
                        while (pstmt.getResultSet().next()) {


                            comboProveedorCodigo.addItem(pstmt.getResultSet().getInt(1));
                            Proveedores proveedores = new Proveedores(pstmt.getResultSet().getInt(1), pstmt.getResultSet().getString(2), pstmt.getResultSet().getString(3), pstmt.getResultSet().getString(4));
                            ListaConsultasProve[contador] = proveedores;

                            contador++;

                        }


                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,"Error en la conexion o en la consulta por favor revise","Error",JOptionPane.ERROR_MESSAGE);
                        JOptionPane.showMessageDialog(null,ex);

                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null,"Error en la clase  por favor revise la configuracion del run o si esa clase tiene static para que se vea","Error",JOptionPane.ERROR_MESSAGE);
                        JOptionPane.showMessageDialog(null,ex);
                    } catch (Exception ea) {
                        JOptionPane.showMessageDialog(null, ea, "Error  datos vacios", JOptionPane.ERROR_MESSAGE);


                    }
                }


            }
        });
        comboProveedorCodigo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (comboProveedorCodigo == null) {
                        System.out.println(" combo igual a null");

                    } else {
                        if (comboProveedorCodigo.getSelectedIndex() < 0) {

                            System.out.println(" combo igual a 0");
                        }
                        codigoVer = String.valueOf(comboProveedorCodigo.getSelectedItem());

                        textCodigo.setText(String.valueOf(ListaConsultasProve[comboProveedorCodigo.getSelectedIndex()].codigo));
                        textApellido.setText(ListaConsultasProve[comboProveedorCodigo.getSelectedIndex()].apellido);
                        textNombre.setText(ListaConsultasProve[comboProveedorCodigo.getSelectedIndex()].nombre);
                        textDireccion.setText(ListaConsultasProve[comboProveedorCodigo.getSelectedIndex()].direccion);

                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Selecciona un dato del combo box ");

                }


            }
        });
    }
}
