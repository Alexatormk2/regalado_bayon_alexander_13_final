package DB;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GestionEntityPK implements Serializable {
    @Column(name = "CodigoGestion")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoGestion;
    @Column(name = "CODPROVEEDOR")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codproveedor;
    @Column(name = "CODPIEZA")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codpieza;
    @Column(name = "CODPROYECTO")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codproyecto;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GestionEntityPK that = (GestionEntityPK) o;
        return codigoGestion == that.codigoGestion && codproveedor == that.codproveedor && codpieza == that.codpieza && codproyecto == that.codproyecto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoGestion, codproveedor, codpieza, codproyecto);
    }
}
