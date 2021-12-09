package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class VendedoresDAO implements CRUD {

    PreparedStatement ps;
    ResultSet rs;
    Conexion con = new Conexion();
    Connection acceso;
    

    public Vendedores ValidarVendedor(String dni, String user) {
        Vendedores ev = new Vendedores();
        String sql = "select * from vendedor where Dni=? and User=?";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                ev.setId(rs.getInt(1));
                ev.setDni(rs.getString(2));
                ev.setNom(rs.getString(3));
                ev.setTel(rs.getString(4));
                ev.setEstado(rs.getString(5));
                ev.setUser(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return ev;
    }

    @Override
    public List listar() {
      List<Vendedores> listaVendedores = new ArrayList<>();
      String sql= "select * from vendedor";
        try {
            acceso=con.Conectar();
            ps=acceso.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Vendedores objVendedores = new Vendedores();
                objVendedores.setId(rs.getInt(1));
                objVendedores.setDni(rs.getString(2));
                objVendedores.setNom(rs.getString(3));
                objVendedores.setTel(rs.getString(4));
                objVendedores.setEstado(rs.getString(5));
                objVendedores.setUser(rs.getString(6));
                listaVendedores.add(objVendedores);
                
            }
        } catch (Exception e) {
            
        }
        return listaVendedores;
    }

    @Override
    public int add(Object[] o) {
       int r=0;
        String sql="insert into vendedor (Dni,Nombres,Telefono,Estado,User)values(?,?,?,?,?)";
        try {
            acceso=con.Conectar();
            ps=acceso.prepareStatement(sql);
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
       String sql = "update vendedor set Dni=?,Nombres=?,Telefono=?,Estado=?,User=? where IdVendedor=?";
        try {
            acceso=con.Conectar();
            ps=acceso.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
       String sql = "delete from vendedor where IdVendedor=?";
        try {
            acceso=con.Conectar();
            ps=acceso.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        } 
    }
    
}
