package Modelo;

import Config.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    int r;
    
    public Empleado validar(String user, String dni){
        Empleado em = new Empleado();
        String sql = "select * from empleado where User=? and Dni=? ";
        try {
            con = cn.Conexion();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user);
            stmt.setString(2, dni);
            rs = stmt.executeQuery();
            while(rs.next()){
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNombres(rs.getString("Nombres"));
            }
        } catch (Exception e) {
        }
        return em;
    }
    
    //CRUD
    
   public List listar(){
        String sql = "select * from empleado";
        List<Empleado> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Empleado em = new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNombres(rs.getString(3));
                em.setTelefono(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                lista.add(em);
            }
        } catch (Exception e) {
        }
        return lista;
    }
   
   public int agregar(Empleado em){
        String sql = "insert into empleado(Dni, Nombres, Telefono, Estado, User)values(?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, em.getDni());
            stmt.setString(2, em.getNombres());
            stmt.setString(3, em.getTelefono());
            stmt.setString(4, em.getEstado());
            stmt.setString(5, em.getUser());
            stmt.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
   
   public Empleado listarId(int id){
        Empleado emp = new Empleado();
        String sql = "select * from empleado where IdEmpleado="+id;
        try {
            con = cn.Conexion();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                emp.setDni(rs.getString(2));
                emp.setNombres(rs.getString(3));
                emp.setTelefono(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return emp;
    }
   
    public int actualizar(Empleado em){
          String sql = "update empleado set Dni=?, Nombres=?, Telefono=?, Estado=?, User=? where IdEmpleado=?";
        try {
            con = cn.Conexion();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, em.getDni());
            stmt.setString(2, em.getNombres());
            stmt.setString(3, em.getTelefono());
            stmt.setString(4, em.getEstado());
            stmt.setString(5, em.getUser());
            stmt.setInt(6, em.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
     public void delete(int id){
        String sql = "delete from empleado where IdEmpleado="+id;
        try {
            con = cn.Conexion();
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }
}
