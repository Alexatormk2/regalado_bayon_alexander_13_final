package DB;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "piezas", schema = "empresa", catalog = "")
public class PiezasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODIGO")
    private String codigo;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "PRECIO")
    private double precio;
    @Basic
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PiezasEntity that = (PiezasEntity) o;
        return Double.compare(that.precio, precio) == 0 && Objects.equals(codigo, that.codigo) && Objects.equals(nombre, that.nombre) && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, precio, descripcion);
    }
}
