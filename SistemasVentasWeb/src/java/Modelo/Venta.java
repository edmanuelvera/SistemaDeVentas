package Modelo;

public class Venta {
    int id;
    int item;
    int id_cliente;
    int id_empleado;
    int id_producto;
    String numSerie;
    String dProducto;
    String fecha;
    Double precio;
    int cantidad;
    Double total;
    Double monto;
    String estado;

    public Venta() {
    }

    public Venta(int id, int item, int id_cliente, int id_empleado, int id_producto, String numSerie, String dProducto, String fecha, Double precio, int cantidad, Double total, Double monto, String estado) {
        this.id = id;
        this.item = item;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
        this.id_producto = id_producto;
        this.numSerie = numSerie;
        this.dProducto = dProducto;
        this.fecha = fecha;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
        this.monto = monto;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getdProducto() {
        return dProducto;
    }

    public void setdProducto(String dProducto) {
        this.dProducto = dProducto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
 
    
    
}