import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class GestionGlobalCrear {
    JPanel CrearGestion;
    private JButton limpiarButtonProve;
    private JButton insertarButton;
    private JButton eliminarButtonProve;
    private JLabel label6;
    private JTextField textCantidad;
    private JLabel label4;
    private JLabel label3;
    private JLabel label2;
    private JLabel label1;
    private JTextField textGestion;
    private JButton buttonCargar;
    private JComboBox<String> comboPiezas;
    private JComboBox<String> comboProveedores;
    private JComboBox<String> comboProyectos;
    String codigoVer;
    String CodigoVer2;
    String CodigoVer3;
    int contador;

    public GestionGlobalCrear() {
        buttonCargar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Si algunos daots no carga bien ve a suss respectivas ventanas de listado y pulsa cargar datos", "Info", JOptionPane.INFORMATION_MESSAGE);
                ///piezas
                Connection conexion = null;

                try {
                    Class.forName("org.mariadb.jdbc.Driver");
                    conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");

                    Statement sentencia = conexion.createStatement();
                    ResultSet resul = sentencia.executeQuery("SELECT * FROM PIEZAS;");
                    while (resul.next()) {
                        System.out.println("- CODIGO: " + resul.getString(1) + ", Nombre: " + resul.getString(2) + ", Precio: " + resul.getDouble(3) + ",Descripcion: " + resul.getString(4));
                        Piezas piezas = new Piezas(resul.getInt(1), resul.getString(2), resul.getDouble(3), resul.getString(4));

                        ventana_principal.ListaPiezas[contador] = piezas;
                        contador++;
                        if (contador == 100) {
                            break;
                        }
                    }

                    for (int a = 0; a < ventana_principal.ListaPiezas.length; a++) {
                        if (ventana_principal.ListaPiezas[a] == null) {
                            break;
                        } else {
                            comboPiezas.addItem(String.valueOf(ventana_principal.ListaPiezas[a].codigo));
                        }
                    }

                    sentencia = conexion.createStatement();
                    resul = sentencia.executeQuery("SELECT * FROM PROVEEDORES;");
                    while (resul.next()) {
                        //EMPLEADOS:	1-DNI VARCHAR, 2-NOMBRE VARCHAR, 3-APELLIDO VARCHAR, 4-FECHA_NACIMIENTO VARCHAR, 5-FECHA_CONTRATACION VARCHAR, 6-NACIONALIDAD VARCHAR, 7-CARGO VARCHAR, 8-AGENCIA VARCHAR
                        System.out.println("- CODIGO: " + resul.getInt(1) + ", Nombre: " + resul.getString(2) + ", Apellido: " + resul.getString(3) + ",Direccion: " + resul.getString(4));
                        Proveedores proveedores1 = new Proveedores(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4));
                        ventana_principal.Listaproveedores[contador] = proveedores1;
                        contador++;
                        if (contador == 100) {
                            break;
                        }
                    }

                    for (int a = 0; a < ventana_principal.Listaproveedores.length; a++) {
                        if (ventana_principal.Listaproveedores[a] == null) {
                            break;
                        } else {
                            comboProveedores.addItem(String.valueOf(ventana_principal.Listaproveedores[a].codigo));
                        }
                    }

                    sentencia = conexion.createStatement();
                    resul = sentencia.executeQuery("SELECT * FROM PROYECTOS;");
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

                    for (int a = 0; a < ventana_principal.ListadoProyectos.length; a++) {
                        if (ventana_principal.ListadoProyectos[a] == null) {
                            break;
                        } else {
                            comboProyectos.addItem(String.valueOf(ventana_principal.ListadoProyectos[a].codigo));
                        }
                    }

                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null,"Error en la clase  por favor revise la configuracion del run o si esa clase tiene static para que se vea","Error",JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null,ex);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Error en la conexion o en la consulta por favor revise","Error",JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null,ex);
                }

                //proveedores


            }
        });
        comboPiezas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (comboPiezas == null) {
                        System.out.println(" combo igual a null");

                    } else {
                        if (comboPiezas.getSelectedIndex() < 0) {

                            System.out.println(" combo igual a 0");
                        }
                        codigoVer = String.valueOf(comboPiezas.getSelectedItem());


                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Selecciona un dato del combo box ");

                }


            }
        });
        comboProveedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (comboProveedores == null) {
                        System.out.println(" combo igual a null");

                    } else {
                        if (comboProveedores.getSelectedIndex() < 0) {

                            System.out.println(" combo igual a 0");
                        }
                        CodigoVer2 = String.valueOf(comboProveedores.getSelectedItem());


                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Selecciona un dato del combo box ");

                }
            }
        });

        comboProyectos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (comboProyectos == null) {
                        System.out.println(" combo igual a null");

                    } else {
                        if (comboProyectos.getSelectedIndex() < 0) {

                            System.out.println(" combo igual a 0");
                        }
                        CodigoVer3 = String.valueOf(comboProyectos.getSelectedItem());


                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Selecciona un dato del combo box ");

                }
            }
        });
        limpiarButtonProve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textGestion.setText("");
                textCantidad.setText("0");
            }
        });
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {

                   int codigo = Integer.parseInt(textGestion.getText().toUpperCase());


                   int CodigoProveedor = Integer.parseInt(String.valueOf(ventana_principal.Listaproveedores[comboProveedores.getSelectedIndex()].codigo));


                    double Cantidad = Double.parseDouble(textCantidad.getText());

                    int codProyecto = Integer.parseInt(String.valueOf(ventana_principal.ListadoProyectos[comboProyectos.getSelectedIndex()].codigo));
                   int codPriezas = Integer.parseInt(String.valueOf(ventana_principal.ListaPiezas[comboPiezas.getSelectedIndex()].codigo));
                    //revisar que la longitud este bien controlada mediante if y else if
                    //revisar codigo
                    String revisar = String.valueOf(codigo);
                    if (revisar.length() != 6) {

                        JOptionPane.showMessageDialog(null, "Error longitud de codigo superada o dato vacio por favor  vuelve a dar el dato tiene que ser de 6 caracteres max", "Erro", JOptionPane.ERROR_MESSAGE);
                        textGestion.setText("");


//revisar CodigoProveedor
                    } else {
                        Connection conexion = null;

                        Class.forName("org.mariadb.jdbc.Driver");
                        conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");
                        PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO `gestion`(CODIGOGESTION, CODPROVEEDOR , CODPIEZA , CODPROYECTO,CANTIDAD) VALUES (?, ?, ?, ?,?)");
                        pstmt.setInt(1, codigo);
                        pstmt.setInt(2, CodigoProveedor);
                        pstmt.setInt(3, codPriezas);
                        pstmt.setInt(4, codProyecto);
                        pstmt.setDouble(5, Cantidad);
                        textGestion.setText("");
                        textCantidad.setText("0");
                        pstmt.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Insert hecho correctamente", "Info", JOptionPane.INFORMATION_MESSAGE);

                    }
                } catch (SQLDataException ex) {
                    System.out.println("hubo un error en los datos de la query sql o la conexion revisalo:  " + ex);
                    JOptionPane.showMessageDialog(null, "hubo un error en los datos de la query sql o la conexion revisalo:  ", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ew) {
                    System.out.println("La clase no fue encontrada revisa la config del run por favor  " + ew);
                    JOptionPane.showMessageDialog(null, "La clase no fue encontrada revisa la config del run por favor  ", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ew, "Error", JOptionPane.ERROR_MESSAGE);

                } catch (SQLException ej) {
                    System.out.println("Exception a la hora de la conexion revisa los datos de la conexion tnato como el puerto como el usuario  " + ej);

                    JOptionPane.showMessageDialog(null, "Exception a la hora de la conexion revisa los datos de la conexion tnato como el puerto como el usuario  ", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ej, "Error", JOptionPane.ERROR_MESSAGE);

                } catch (NumberFormatException eo) {
                    System.out.println("Se esperaba un valor numerico por favor vuelva a dar el dato del campo precio ");

                    JOptionPane.showMessageDialog(null, "Se esperaba un valor numerico por favor vuelva a dar el dato del campo precio ", "Erro", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, eo, "Error", JOptionPane.ERROR_MESSAGE);

                }


            }
        });
        eliminarButtonProve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Connection conexion = null;


                PreparedStatement preparedStmt;
                try {
                    Class.forName("org.mariadb.jdbc.Driver");

                    conexion = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3386/empresa", "root", "root");


                    String query = "delete from  Gestion where CODIGO = ?";

                    preparedStmt = conexion.prepareStatement(query);

                    preparedStmt.setString(1, String.valueOf(textGestion.getText()));


                    preparedStmt.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Borrado con exito", "Info", JOptionPane.INFORMATION_MESSAGE);


                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex, "Error inesperado pro favor revise el codigo ", JOptionPane.ERROR_MESSAGE);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex, "Error codigo no existente o error en la consulta o conexion revise por favor", JOptionPane.ERROR_MESSAGE);

                }


            }
        });
    }
}
