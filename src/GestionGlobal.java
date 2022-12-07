public class GestionGlobal {

    int codigoGestion;
   int piezasCodigo;
    int proveedoresCodigo;
   int proyectosCodigo;

    double cantidad;


    public GestionGlobal(int codigoGestion, int piezasCodigo, int proveedoresCodigo, int proyectosCodigo, double cantidad) {
        this.codigoGestion = codigoGestion;
        this.piezasCodigo = piezasCodigo;
        this.proveedoresCodigo = proveedoresCodigo;
        this.proyectosCodigo = proyectosCodigo;
        this.cantidad = cantidad;
    }

    public int getCodigoGestion() {
        return codigoGestion;
    }

    public void setCodigoGestion(int codigoGestion) {
        this.codigoGestion = codigoGestion;
    }

    public int getPiezasCodigo() {
        return piezasCodigo;
    }

    public void setPiezasCodigo(int piezasCodigo) {
        this.piezasCodigo = piezasCodigo;
    }

    public int getProveedoresCodigo() {
        return proveedoresCodigo;
    }

    public void setProveedoresCodigo(int proveedoresCodigo) {
        this.proveedoresCodigo = proveedoresCodigo;
    }

    public int getProyectosCodigo() {
        return proyectosCodigo;
    }

    public void setProyectosCodigo(int proyectosCodigo) {
        this.proyectosCodigo = proyectosCodigo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}
