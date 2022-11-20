
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/68bd6542c8.js" crossorigin="anonymous"></script>


        <title>Registrar Venta</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-4">
                <div class="card">
                    <form action="ServletControlador?menu=RegistrarVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-7 d-flex">
                                    <input type="text" name="codigoCliente" value="${c.getDni()}" class="form-control" placeholder="Codigo"/>
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-dark"/>
                                </div>

                                <div class="col-sm-6">
                                    <input type="text" name="nombresCliente" value="${c.getNombres()}" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Datos de producto</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-7 d-flex">
                                    <input type="text" name="codigoProducto" class="form-control" placeholder="Codigo"/>
                                    <input type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-dark"/>
                                </div>

                                <div class="col-sm-6">
                                    <input type="text" name="nombresProducto" value="${producto.getNombre()}"class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-7 d-flex">
                                    <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" placeholder="$/0.00"/>
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" name="cantidad" value="1" class="form-control"/>
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" name="stock"  value="${producto.getStock()}" placeholder="Stock" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="submit" name="accion" value="Agregar" class="btn btn-dark"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-4 ml-auto">
                            <i style="font-size: 20px"class="fas fa-solid fa-magnifying-glass"></i>
                            <input type="text" name="nSerie" value="${nserie}" class="form-control"/>
                        </div>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>N°</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Total</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getId_producto()}</td>
                                        <td>${list.getdProducto()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <td>${list.getCantidad()}</td>
                                        <td>${list.getTotal()}</td>
                                        <td style="color:white">
                                            <a class="btn btn-dark">Editar</a>
                                            <a class="btn btn-secondary">Eliminar</a>

                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a class="btn btn-dark" href="ServletControlador?menu=RegistrarVenta&accion=GenerarVenta">Generar Venta</a>
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-secondary"/>
                        </div>
                        <div class="col-sm-4 ml-auto">
                            <input type="text" nombre="txtTotal" value="$${totalpagar}" class="form-control"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
