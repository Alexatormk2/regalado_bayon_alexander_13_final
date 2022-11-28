import org.mariadb.jdbc.Connection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultaProveedores {
    JPanel PanelConsultaProveedores;
    private JButton buttonBuscar;
    private JTextField textBuscarCodigoProveedor;
    private JComboBox<String> comboProveedorCodigo;
    private JTextField textNombre;
    private JTextField textApellido;
    private JTextField textCodigo;
    private JTextField textDireccion;
    String codigo;
    String codigoVer;
    int contador = 0;
    Proveedores[] ListaConsultasProve = new Proveedores[100];

    public ConsultaProveedores() {
        buttonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;
                if (comboProveedorCodigo != null) {
                    comboProveedorCodigo.removeAllItems();
                } codigo = textBuscarCodigoProveedor.getText().toUpperCase();
if (codigo.equals("")){
    JOptionPane.showMessageDialog(null,  "Error  datos vacios");


}

else {
    try {
        Class.forName("org.mariadb.jdbc.Driver");

        conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");
        PreparedStatement pstmt = conexion.prepareStatement("SELECT  * FROM PROVEEDORES WHERE codigo like ? ");
        pstmt.setString(1, codigo + "%");
        pstmt.executeQuery();
        while (pstmt.getResultSet().next()) {


            comboProveedorCodigo.addItem(pstmt.getResultSet().getString(1));
            Proveedores proveedores = new Proveedores(pstmt.getResultSet().getString(1), pstmt.getResultSet().getString(2), pstmt.getResultSet().getString(3), pstmt.getResultSet().getString(4));
            ListaConsultasProve[contador] = proveedores;

            contador++;

        }


    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex, "Error la consulta esta  mal escrita o algun dato de la conexion esta mal", JOptionPane.ERROR_MESSAGE);


    } catch (ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(null, ex, "Error  de clase, no se pudo encontrar", JOptionPane.ERROR_MESSAGE);

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
if (comboProveedorCodigo.getSelectedIndex() <0){

    System.out.println(" combo igual a 0");
}
                        codigoVer = String.valueOf(comboProveedorCodigo.getSelectedItem());

                        textCodigo.setText(ListaConsultasProve[comboProveedorCodigo.getSelectedIndex()].codigo);
                        textApellido.setText(ListaConsultasProve[comboProveedorCodigo.getSelectedIndex()].apellido);
                        textNombre.setText(ListaConsultasProve[comboProveedorCodigo.getSelectedIndex()].nombre);
                        textDireccion.setText(ListaConsultasProve[comboProveedorCodigo.getSelectedIndex()].direccion);

                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex, "Error  combobox,vacio", JOptionPane.ERROR_MESSAGE);

                }


            }
        });
    }
}
