
package modelo;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProductosDAO implements CRUD{
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public Productos listarID(int id){
        Productos p = new Productos(); 
        String sql = "select * from producto where IdProducto=?";
        try {
            con = cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while (rs.next()) {                
                p.setIdProducto(rs.getInt(1));
                p.setNombre_Producto(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return p;
                
    }
    @Override
    public List listar() {
         List<Productos> lista = new ArrayList<>();
        String sql="select * from producto";
        try {
            con = cn.Conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Productos pr = new Productos();
                pr.setIdProducto(rs.getInt(1));
                pr.setNombre_Producto(rs.getString(2));
                pr.setPrecio(rs.getDouble(3));
                pr.setStock(rs.getInt(4));
                pr.setEstado(rs.getString(5));
                lista.add(pr);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r=0;
        String sql="insert into producto(IdProducto,Nombre_Producto,Precio,Stock,Estado)values(?,?,?,?,?)";
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);   
            ps.setObject(5, o[4]);   
            r= ps.executeUpdate();
        } catch (Exception e) {
            
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
         int r=0;
       String sql = "update producto set Nombre_Producto=?,Precio=?,Stock=?,Estado=? where IdProducto=?";
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
      String sql = "delete from producto where IdProducto=?";
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}
