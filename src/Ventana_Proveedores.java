import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana_Proveedores  {
    private JButton buttonGestionProveedores;
    private JButton buttonConsultaProveedores;
    JPanel PanelProveedores;

    public Ventana_Proveedores() {
        buttonGestionProveedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_principal.frameGestionProvedores.setVisible(true);
            }
        });
    }
}
