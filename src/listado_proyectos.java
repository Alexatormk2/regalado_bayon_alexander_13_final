import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class listado_proyectos {
    private JLabel lavel123;
    private JTextField textRegistrosNumber;
    private JLabel label12asds;
    private JTextField textNombre;
    private JTextField textCodigoProyecto;
    private JLabel labelcodigo;
    private JTextField textMaxREG;
    private JButton buttonCargarDatos;
    private JTextField textCiudad;
    private JButton buttonUltimoReg;
    private JButton button_reg_adelante;
    private JButton button_reg_anterior;
    private JButton buttonPrimerReg;
     JPanel panelListaProyecto;
    int contador = 0;
    int valorBuscador = 0;

    public listado_proyectos() {

        buttonCargarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;

                try {
                    Class.forName("org.mariadb.jdbc.Driver");
                    conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");

                    Statement sentencia = conexion.createStatement();
                    ResultSet resul = sentencia.executeQuery("SELECT * FROM PROYECTOS;");
                    while (resul.next()) {
                        //EMPLEADOS:	1-DNI VARCHAR, 2-NOMBRE VARCHAR, 3-APELLIDO VARCHAR, 4-FECHA_NACIMIENTO VARCHAR, 5-FECHA_CONTRATACION VARCHAR, 6-NACIONALIDAD VARCHAR, 7-CARGO VARCHAR, 8-AGENCIA VARCHAR
                        System.out.println("- CODIGO: " + resul.getString(1) + ", Nombre: " + resul.getString(2) + ",Ciudad: " + resul.getString(3));
                        Proyectos proyectos1 = new Proyectos(resul.getInt(1), resul.getString(2), resul.getString(3));
                        ventana_principal.ListadoProyectos[contador] = proyectos1;
                        contador++;
                        if (contador == 100) {
                            break;
                        }
                    }

                    textRegistrosNumber.setText("0");
                    textMaxREG.setText(String.valueOf(contador - 1));
                    valorBuscador = 0;
                    textCodigoProyecto.setText(String.valueOf(ventana_principal.ListadoProyectos[0].codigo));
                    textCiudad.setText(ventana_principal.ListadoProyectos[0].ciudad);
                    textNombre.setText(ventana_principal.ListadoProyectos[0].nombre);


                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null,"Error en la clase  por favor revise la configuracion del run o si esa clase tiene static para que se vea","Error",JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null,ex);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Error en la conexion o en la consulta por favor revise","Error",JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null,ex);
                }


            }
        });
        button_reg_adelante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (ventana_principal.ListadoProyectos[valorBuscador] == null || valorBuscador == contador - 1) {
                        JOptionPane.showMessageDialog(null, "No hay mas valores guardados", "INFO", JOptionPane.INFORMATION_MESSAGE);


                    } else if (valorBuscador < contador) {
                        valorBuscador++;

                        textRegistrosNumber.setText(String.valueOf(valorBuscador));
                        textCodigoProyecto.setText(String.valueOf(ventana_principal.ListadoProyectos[valorBuscador].codigo));
                        textCiudad.setText(ventana_principal.ListadoProyectos[valorBuscador].ciudad);
                        textNombre.setText(ventana_principal.ListadoProyectos[valorBuscador].nombre);

                    }


                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Error no se puede continuar no hay mas datos", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);


                }


            }
        });
        button_reg_anterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (ventana_principal.ListadoProyectos[valorBuscador] == null || valorBuscador == contador || valorBuscador == 0) {
                        JOptionPane.showMessageDialog(null, "No hay mas valores guardados", "INFO", JOptionPane.INFORMATION_MESSAGE);


                    } else if (valorBuscador < contador) {
                        valorBuscador--;

                        textRegistrosNumber.setText(String.valueOf(valorBuscador));
                        textCodigoProyecto.setText(String.valueOf(ventana_principal.ListadoProyectos[valorBuscador].codigo));
                        textCiudad.setText(ventana_principal.ListadoProyectos[valorBuscador].ciudad);
                        textNombre.setText(ventana_principal.ListadoProyectos[valorBuscador].nombre);

                    }


                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Error no se puede continuar no hay mas datos", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);


                }
            }
        });
        buttonUltimoReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (ventana_principal.ListadoProyectos[valorBuscador] == null || valorBuscador == contador - 1) {
                        JOptionPane.showMessageDialog(null, "No hay mas valores guardados", "INFO", JOptionPane.INFORMATION_MESSAGE);


                    } else if (valorBuscador < contador) {
                        valorBuscador = contador - 1;

                        textRegistrosNumber.setText(String.valueOf(valorBuscador));
                        textCodigoProyecto.setText(String.valueOf(ventana_principal.ListadoProyectos[valorBuscador].codigo));
                        textCiudad.setText(ventana_principal.ListadoProyectos[valorBuscador].ciudad);
                        textNombre.setText(ventana_principal.ListadoProyectos[valorBuscador].nombre);

                    }


                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Error no se puede continuar no hay mas datos", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);


                }
            }
        });
        buttonPrimerReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    if (ventana_principal.ListadoProyectos[valorBuscador] == null || valorBuscador == 0) {
                        JOptionPane.showMessageDialog(null, "No hay mas valores guardados", "INFO", JOptionPane.INFORMATION_MESSAGE);
                        textRegistrosNumber.setText(String.valueOf(valorBuscador - 1));

                    } else if (valorBuscador < contador) {
                        valorBuscador = 0;

                        textRegistrosNumber.setText(String.valueOf(valorBuscador));
                        textCodigoProyecto.setText(String.valueOf(ventana_principal.ListadoProyectos[valorBuscador].codigo));
                        textCiudad.setText(ventana_principal.ListadoProyectos[valorBuscador].ciudad);
                        textNombre.setText(ventana_principal.ListadoProyectos[valorBuscador].nombre);

                    }


                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Error no se puede continuar no hay mas datos", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);


                }
            }
        });

    }
}
