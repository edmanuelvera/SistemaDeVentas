<form action="ServletControlador?menu=Producto" method="POST">
    <div class="form-group">
        <label>NOMBRES</label>
        <input type="text" value="${producto.getNombre()}" name="txtNombres" class="form-control"/>
    </div>
    <div class="form-group">
        <label>PRECIO</label>
        <input type="text" value="${producto.getPrecio()}" name="txtPrecio" class="form-control"/>
    </div>
    <div class="form-group">
        <label>STOCK</label>
        <input type="text" value="${producto.getStock()}"name="txtStock" class="form-control"/>
    </div>
    <div class="form-group">
        <label>ESTADO</label>
        <input type="text" value="${producto.getEstado()}"name="txtEstado" class="form-control"/>
    </div>
    <input type="submit" name="accion" value="Actualizar" class="btn btn-dark"/>
</form>