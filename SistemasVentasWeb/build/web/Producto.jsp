<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/68bd6542c8.js" crossorigin="anonymous"></script>


        <title>Productos</title>
    </head>
    <body>

      <!-- Modal para agregar -->  
        
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#agregarProducto">
            <i class="fas fa-solid fa-plus"></i>&nbsp;Agregar nuevo producto
        </button>
        <br> <br>
        <!-- Modal -->
        <div class="modal fade" id="agregarProducto" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header text-center">
                        <h3 class="modal-title fs-5" id="exampleModalLabel">Agregar un nuevo producto</h3>
                        <button type="button" class="btn btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="ServletControlador?menu=Producto" method="POST">
                        <div class="form-group">
                            <label>NOMBRES</label>
                            <input type="text" value="" name="txtNombres" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>PRECIO</label>
                            <input type="text" value="" name="txtPrecio" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>STOCK</label>
                            <input type="text" value=""name="txtStock" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>ESTADO</label>
                            <input type="text" value=""name="txtEstado" class="form-control"/>
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-dark"/>
                    </form>
                    </div> 
                </div>
            </div>
        </div>

                        
                        
        <!-- Tablas de información recolectada -->
        <div class="col-sm-13 mx-auto">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOMBRES</th>
                        <th>PRECIO</th>
                        <th>STOCK</th>
                        <th>ESTADO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pt" items="${productos}">
                    <tr>
                        <td>${pt.getId()}</td>
                        <td>${pt.getNombre()}</td>
                        <td>${pt.getPrecio()}</td>
                        <td>${pt.getStock()}</td>
                        <td>${pt.getEstado()}</td>
                        <td>
                            <a style="border: none; font-size: 20px" class="btn btn-outline-dark" href="ServletControlador?menu=Producto&accion=Editar&id=${pt.getId()}"><i class="fas fa-solid fa-pen-nib"></i></a>

                            <a style="border: none; font-size: 20px" class="btn btn-outline-dark" href="ServletControlador?menu=Producto&accion=Eliminar&id=${pt.getId()}"><i class="fas fa-sharp fa-solid fa-trash"></i></a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>

    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</html>
