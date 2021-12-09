
package modelo;


public class Ventas {
    int idVentas;
    int idCliente;
    int idVendedor;
    String noFactura;
    String fecha;
    double monto;
    String estado;

    public Ventas() {
    }

    public Ventas(int idVentas, int idCliente, int idVendedor, String noFactura, String fecha, double monto, String estado) {
        this.idVentas = idVentas;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.noFactura = noFactura;
        this.fecha = fecha;
        this.monto = monto;
        this.estado = estado;
    }

    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(String noFactura) {
        this.noFactura = noFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
