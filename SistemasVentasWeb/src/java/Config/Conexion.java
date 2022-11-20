package Config;

import java.sql.*;

public class Conexion {
    Connection con;
    String url = "jdbc:mysql://localhost:3306/bd_ventas";
    String user = "root";
    String contra = "";
    
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, contra);
        } catch (Exception e) {
        }
        return con;
    }
}
