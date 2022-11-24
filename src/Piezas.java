public class Piezas {

    String codigo;
    String Nombre;
    double precio;
    String descrpcion;

    public Piezas(String codigo, String nombre, double precio, String descrpcion) {
        this.codigo = codigo;
        Nombre = nombre;
        this.precio = precio;
        this.descrpcion = descrpcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescrpcion() {
        return descrpcion;
    }

    public void setDescrpcion(String descrpcion) {
        this.descrpcion = descrpcion;
    }
}
