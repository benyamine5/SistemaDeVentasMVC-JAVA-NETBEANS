
package modelo;

public class Productos {
    int idProducto;
    String nombre_Producto;
    double Precio;
    int stock;
    String estado;

    public Productos() {
    }

    public Productos(int idProducto, String nombre_Producto, double Precio, int stock, String estado) {
        this.idProducto = idProducto;
        this.nombre_Producto = nombre_Producto;
        this.Precio = Precio;
        this.stock = stock;
        this.estado = estado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre_Producto() {
        return nombre_Producto;
    }

    public void setNombre_Producto(String nombre_Producto) {
        this.nombre_Producto = nombre_Producto;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
