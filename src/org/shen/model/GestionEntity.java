package org.shen.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "gestion", schema = "empresa", catalog = "")
@IdClass(GestionEntityPK.class)
public class GestionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODPROVEEDOR", nullable = false, length = 6)
    private String codproveedor;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODPIEZA", nullable = false, length = 6)
    private String codpieza;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODPROYECTO", nullable = false, length = 6)
    private String codproyecto;
    @Basic
    @Column(name = "CANTIDAD", nullable = true, precision = 0)
    private Integer cantidad;

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
        return Objects.equals(codproveedor, that.codproveedor) && Objects.equals(codpieza, that.codpieza) && Objects.equals(codproyecto, that.codproyecto) && Objects.equals(cantidad, that.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codproveedor, codpieza, codproyecto, cantidad);
    }
}
