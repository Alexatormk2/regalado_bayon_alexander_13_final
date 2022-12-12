package DB;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "gestion", schema = "empresa")
@IdClass(GestionEntityPK.class)
public class GestionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CodigoGestion")
    private int codigoGestion;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODPROVEEDOR")
    private int codproveedor;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODPIEZA")
    private int codpieza;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODPROYECTO")
    private int codproyecto;
    @Basic
    @Column(name = "CANTIDAD")
    private Integer cantidad;

    public int getCodigoGestion() {
        return codigoGestion;
    }

    public void setCodigoGestion(int codigoGestion) {
        this.codigoGestion = codigoGestion;
    }

    public int getCodproveedor() {
        return codproveedor;
    }

    public void setCodproveedor(int codproveedor) {
        this.codproveedor = codproveedor;
    }

    public int getCodpieza() {
        return codpieza;
    }

    public void setCodpieza(int codpieza) {
        this.codpieza = codpieza;
    }

    public int getCodproyecto() {
        return codproyecto;
    }

    public void setCodproyecto(int codproyecto) {
        this.codproyecto = codproyecto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GestionEntity that = (GestionEntity) o;
        return codigoGestion == that.codigoGestion && codproveedor == that.codproveedor && codpieza == that.codpieza && codproyecto == that.codproyecto && Objects.equals(cantidad, that.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoGestion, codproveedor, codpieza, codproyecto, cantidad);
    }
}
