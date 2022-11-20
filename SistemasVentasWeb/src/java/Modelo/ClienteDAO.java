package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    int r;
    
    
    public Cliente buscar(String dni){
        Cliente c = new Cliente();
        String sql = "select * from cliente where Dni="+dni;
        try {
            con = cn.Conexion();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNombres(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return c;
    }
    
    //CRUD
    
    public List listar(){
        String sql = "select * from cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Cliente cl = new Cliente();
                cl.setId(rs.getInt(1));
                cl.setDni(rs.getString(2));
                cl.setNombres(rs.getString(3));
                cl.setDireccion(rs.getString(4));
                cl.setEstado(rs.getString(5));
                lista.add(cl);
            }
        } catch (Exception e) {
        }
        return lista;
}
    
     public int agregar(Cliente cl){
        String sql = "insert into cliente(Dni, Nombres, Direccion, Estado)values(?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cl.getDni());
            stmt.setString(2, cl.getNombres());
            stmt.setString(3, cl.getDireccion());
            stmt.setString(4, cl.getEstado());
            stmt.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
     public Cliente listarId(int id){
        Cliente clt = new Cliente();
        String sql = "select * from cliente where IdCliente="+id;
        try {
            con = cn.Conexion();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                clt.setDni(rs.getString(2));
                clt.setNombres(rs.getString(3));
                clt.setDireccion(rs.getString(4));
                clt.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return clt;
     }
     public int actualizar(Cliente cl){
          String sql = "update cliente set Dni=?, Nombres=?, Direccion=?, Estado=? where IdCliente=?";
        try {
            con = cn.Conexion();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cl.getDni());
            stmt.setString(2, cl.getNombres());
            stmt.setString(3, cl.getDireccion());
            stmt.setString(4, cl.getEstado());
            stmt.setInt(5, cl.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
     
     public void delete(int id){
        String sql = "delete from cliente where IdCliente="+id;
        try {
            con = cn.Conexion();
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }
}
