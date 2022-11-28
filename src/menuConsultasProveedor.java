import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuConsultasProveedor {
    private JButton buttonCodigo;
    private JButton buttonNombre;
    private JButton buttonDireccion;
     JPanel panelMenuProve;

    public menuConsultasProveedor() {
        buttonCodigo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_principal.frameConsultasProveedorCodigo.setVisible(true);
            }
        });
        buttonNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_principal.frameConsultasProveedorNombre.setVisible(true);
            }
        });
        buttonDireccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_principal.frameConsultarProveedorDireccion.setVisible(true);
            }
        });
    }
}
