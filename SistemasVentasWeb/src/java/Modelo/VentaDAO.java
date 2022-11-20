package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    int r;
    
    public String generarSerie(){
        String numeroSerie = "";
        String sql = "select max(NumeroSerie) from ventas";
        try {
            con = cn.Conexion();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                numeroSerie = rs.getString(1);
            }
            
        } catch (Exception e) {
        }
        return numeroSerie;
    }
    
    public String idVentas(){
        String idventas="";
        String sql = "select max(IdVentas) from ventas";
        try {
            con = cn.Conexion();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                idventas = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idventas;
    }
    
    public int guardarVenta(Venta ve){
        String sql = "insert into ventas(IdCliente, IdEmpledo, NumeroSerie, FechaVentas, Monto, Estado)values(?, ?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, ve.getId_cliente());
            stmt.setInt(2, ve.getId_empleado());
            stmt.setString(3, ve.getNumSerie());
            stmt.setString(4, ve.getFecha());
            stmt.setDouble(5, ve.getMonto());
            stmt.setString(6, ve.getEstado());
            stmt.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public int guardarDetalleVenta(Venta venta){
        String sql = "insert into detalle_ventas(IdVentas, IdProducto, Cantidad, PrecioVenta)values(?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, venta.getId());
            stmt.setInt (2, venta.getId_producto());
            stmt.setInt (3, venta.getCantidad());
            stmt.setDouble(4, venta.getPrecio());
            stmt.executeUpdate();
        } catch (Exception e) {
        }
            return r;
    }

}
