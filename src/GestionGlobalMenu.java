import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionGlobalMenu {
    JPanel PanelGestion;
    private JButton gestionarButton;
    private JButton listarButton;

    public GestionGlobalMenu() {
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_principal.frameGestionListar.setVisible(true);
            }
        });
        gestionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_principal.frameGestionCrear.setVisible(true);
            }
        });
    }
}
