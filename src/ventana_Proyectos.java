import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventana_Proyectos {
     JPanel PanelProyectos;
    private JButton buttonGestionProyectos;
    private JButton buttonConsultaProyectos;

    public ventana_Proyectos() {
        buttonGestionProyectos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_principal.frameGestionPoyectos.setVisible(true);


            }
        });
    }
}
