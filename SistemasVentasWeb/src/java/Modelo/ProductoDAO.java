package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    int r;
    
    
    //CRUD
    
    public List listar(){
        String sql = "select * from producto";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Producto pt = new Producto();
                pt.setId(rs.getInt(1));
                pt.setNombre(rs.getString(2));
                pt.setPrecio(rs.getDouble(3));
                pt.setStock(rs.getInt(4));
                pt.setEstado(rs.getString(5));
                lista.add(pt);
            }
        } catch (Exception e) {
        }
        return lista;
}
    
     public int agregar(Producto pt){
        String sql = "insert into producto(Nombres, Precio, Stock, Estado)values(?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, pt.getNombre());
            stmt.setDouble(2, pt.getPrecio());
            stmt.setInt(3, pt.getStock());
            stmt.setString(4, pt.getEstado());
            stmt.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
     public Producto listarId(int id){
        Producto pdt = new Producto();
        String sql = "select * from producto where IdProducto="+id;
        try {
            con = cn.Conexion();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                pdt.setNombre(rs.getString(2));
                pdt.setPrecio(rs.getDouble(3));
                pdt.setStock(rs.getInt(4));
                pdt.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return pdt;
     }
     public int actualizar(Producto pt){
          String sql = "update producto set Nombre=?, Precio=?, Stock=?, Estado=? where IdProducto=?";
        try {
            con = cn.Conexion();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, pt.getNombre());
            stmt.setDouble(2, pt.getPrecio());
            stmt.setInt(3, pt.getStock());
            stmt.setString(4, pt.getEstado());
            stmt.setInt(5, pt.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
     
     public void delete(int id){
        String sql = "delete from producto where IdProducto="+id;
        try {
            con = cn.Conexion();
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }
}

