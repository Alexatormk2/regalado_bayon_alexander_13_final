import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuConsultasPiezas {
    private JButton buttonCodigo;
    private JButton buttonNombre;
    private JButton buttonDescripcion;
    JPanel panelMenuPiezas;

    public MenuConsultasPiezas() {
        buttonNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_principal.frameConsultasPiezasNombre.setVisible(true);
            }
        });
        buttonCodigo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_principal.frameConsultasPiezasCodigo.setVisible(true);
            }
        });
        buttonDescripcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_principal.FrameConsultasPiezasDescripcion.setVisible(true);
            }
        });
    }
}
