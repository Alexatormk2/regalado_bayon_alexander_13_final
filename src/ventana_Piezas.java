import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventana_Piezas {
JPanel PanelPieza;
    private JButton buttonConsultasPIezas;
    private JButton buttongestionPiezas;

    public ventana_Piezas() {
        buttongestionPiezas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_principal.frameGestionPiezas.setVisible(true);
            }
        });
    }
}
