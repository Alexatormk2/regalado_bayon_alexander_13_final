package org;

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
    private String codigoGestion;
    @Column(name = "CODPROVEEDOR")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codproveedor;
    @Column(name = "CODPIEZA")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codpieza;
    @Column(name = "CODPROYECTO")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codproyecto;

    public String getCodigoGestion() {
        return codigoGestion;
    }

    public void setCodigoGestion(String codigoGestion) {
        this.codigoGestion = codigoGestion;
    }

    public String getCodproveedor() {
        return codproveedor;
    }

    public void setCodproveedor(String codproveedor) {
        this.codproveedor = codproveedor;
    }

    public String getCodpieza() {
        return codpieza;
    }

    public void setCodpieza(String codpieza) {
        this.codpieza = codpieza;
    }

    public String getCodproyecto() {
        return codproyecto;
    }

    public void setCodproyecto(String codproyecto) {
        this.codproyecto = codproyecto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GestionEntityPK that = (GestionEntityPK) o;
        return Objects.equals(codigoGestion, that.codigoGestion) && Objects.equals(codproveedor, that.codproveedor) && Objects.equals(codpieza, that.codpieza) && Objects.equals(codproyecto, that.codproyecto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoGestion, codproveedor, codpieza, codproyecto);
    }
}
