package org;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "gestion", schema = "empresa", catalog = "")
@IdClass(GestionEntityPK.class)
public class GestionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CodigoGestion")
    private String codigoGestion;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODPROVEEDOR")
    private String codproveedor;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODPIEZA")
    private String codpieza;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODPROYECTO")
    private String codproyecto;
    @Basic
    @Column(name = "CANTIDAD")
    private Integer cantidad;

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
        return Objects.equals(codigoGestion, that.codigoGestion) && Objects.equals(codproveedor, that.codproveedor) && Objects.equals(codpieza, that.codpieza) && Objects.equals(codproyecto, that.codproyecto) && Objects.equals(cantidad, that.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoGestion, codproveedor, codpieza, codproyecto, cantidad);
    }
}
