public class GestionGlobal {

    String codigoGestion;
    String piezasCodigo;
    String proveedoresCodigo;
    String proyectosCodigo;

    double cantidad;


    public GestionGlobal(String codigoGestion, String piezasCodigo, String proveedoresCodigo, String proyectosCodigo, double cantidad) {
        this.piezasCodigo = piezasCodigo;
        this.proveedoresCodigo = proveedoresCodigo;
        this.proyectosCodigo = proyectosCodigo;
        this.cantidad = cantidad;
        this.codigoGestion = codigoGestion;
    }

    public String getCodigoGestion() {
        return codigoGestion;
    }

    public void setCodigoGestion(String codigoGestion) {
        this.codigoGestion = codigoGestion;
    }

    public String getPiezasCodigo() {
        return piezasCodigo;
    }

    public void setPiezasCodigo(String piezasCodigo) {
        this.piezasCodigo = piezasCodigo;
    }

    public String getProveedoresCodigo() {
        return proveedoresCodigo;
    }

    public void setProveedoresCodigo(String proveedoresCodigo) {
        this.proveedoresCodigo = proveedoresCodigo;
    }

    public String getProyectosCodigo() {
        return proyectosCodigo;
    }

    public void setProyectosCodigo(String proyectosCodigo) {
        this.proyectosCodigo = proyectosCodigo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}
