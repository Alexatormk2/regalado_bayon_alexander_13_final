import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuConsultasProyectos {
    JPanel panelMenuProyectos;
    private JButton buttonCodigo;
    private JButton buttonNombre;
    private JButton buttonDireccion;

    public MenuConsultasProyectos() {
        buttonCodigo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_principal.frameProyectosCodigo.setVisible(true);
            }
        });
        buttonNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_principal.frameProyectosNombre.setVisible(true);
            }
        });
        buttonDireccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_principal.frameProyectosCiudad.setVisible(true);
            }
        });
    }
}
