
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentasDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r=0;
    public String idVentas(){
        String idv="";
        String sql="select max(IdVentas) from ventas";
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                idv = rs.getString(1);
                
            }
        } catch (Exception e) {
        }
        return idv;
    }
    public int guardarVentas(Ventas v){
        Ventas objVentas=new Ventas();
        String sql="insert into ventas (IdCliente,IdVendedor,NumeroVentas,FechaVentas,Monto,Estado) values(?,?,?,?,?,?) ";
        try {
          con=cn.Conectar();
          ps=con.prepareStatement(sql);
          ps.setInt(1,v.getIdCliente());
          ps.setInt(2,v.getIdVendedor());
          ps.setString(3,v.getNoFactura());
          ps.setString(4,v.getFecha());
          ps.setDouble(5,v.getMonto());
          ps.setString(6,v.getEstado());
          r=ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public int guardarDetalleVentas(DetalleVentas dv){
        String sql = "insert into detalle_ventas (Ventas_IdVentas,Producto_IdProducto,Cantidad,PrecioVenta)values(?,?,?,?)";
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, dv.getIdVentas());
            ps.setInt(2, dv.getIdProducto());
            ps.setInt(3, dv.getCantidad());
            ps.setDouble(4, dv.getPrecioVenta());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
