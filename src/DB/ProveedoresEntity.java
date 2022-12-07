package DB;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "proveedores", schema = "empresa")
public class ProveedoresEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODIGO")
    private int codigo;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic
    @Column(name = "DIRECCION")
    private String direccion;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProveedoresEntity that = (ProveedoresEntity) o;
        return codigo == that.codigo && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(direccion, that.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, apellido, direccion);
    }
}
