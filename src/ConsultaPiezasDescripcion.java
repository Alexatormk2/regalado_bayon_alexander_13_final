import org.mariadb.jdbc.Connection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultaPiezasDescripcion {
     JPanel panelConsultaPiezasDecripcion;
    private JButton buttonBuscar;
    private JTextField textBuscarCodigoProveedor;
    private JTextField textNombre;
    private JTextField textPrecio;
    private JComboBox comboProveedorCodigo;
    private JTextField textCodigo;
    private JTextField textDescripcion;




    String descripcion;
    String codigoVer;
    int contador = 0;
    Piezas[] ListaConsultasPieza = new Piezas[100];


    public ConsultaPiezasDescripcion() {


        buttonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textCodigo.setText("");
                textPrecio.setText("");
                textNombre.setText("");
                textDescripcion.setText("");
                Connection conexion = null;
                if (comboProveedorCodigo != null) {
                    comboProveedorCodigo.removeAllItems();


                }
                descripcion = textBuscarCodigoProveedor.getText().toUpperCase();
                if (descripcion.equals("")) {
                    JOptionPane.showMessageDialog(null, "Error  datos vacios");


                } else {
                    try {

                        Class.forName("org.mariadb.jdbc.Driver");

                        conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");
                        PreparedStatement pstmt = conexion.prepareStatement("SELECT  * FROM PIEZAS WHERE upper(descripcion) like ? ");
                        pstmt.setString(1, "%" + descripcion + "%");
                        pstmt.executeQuery();
                        while (pstmt.getResultSet().next()) {


                            comboProveedorCodigo.addItem(pstmt.getResultSet().getString(1));
                            Piezas pieza = new Piezas(pstmt.getResultSet().getString(1), pstmt.getResultSet().getString(2), pstmt.getResultSet().getDouble(3), pstmt.getResultSet().getString(4));
                            ListaConsultasPieza[contador] = pieza;

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

                        textCodigo.setText(ListaConsultasPieza[comboProveedorCodigo.getSelectedIndex()].codigo);
                        textDescripcion.setText(ListaConsultasPieza[comboProveedorCodigo.getSelectedIndex()].descrpcion);
                        textNombre.setText(ListaConsultasPieza[comboProveedorCodigo.getSelectedIndex()].Nombre);
                        textPrecio.setText(String.valueOf(ListaConsultasPieza[comboProveedorCodigo.getSelectedIndex()].precio));

                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Selecciona un dato del combo box ");

                }


            }
        });


    }

}
