<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/68bd6542c8.js" crossorigin="anonymous"></script>
        <title>Empleados</title>
    </head>
    <body>

        <!-- Card para agregar empleados -->
        <div class="d-flex">
            <div class="card col-sm-4 text-center" >
                <div class="card-body">
                    <form action="ServletControlador?menu=Empleado" method="POST">
                        <div class="form-group">
                            <label>LLAVE</label>
                            <input type="text" value="${empleado.getDni()}" name="txtDni" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>NOMBRE</label>
                            <input type="text" value="${empleado.getNombres()}" name="txtNombres" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>TELEFONO</label>
                            <input type="text" value="${empleado.getTelefono()}"name="txtTelefono" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>ESTADO</label>
                            <input type="text" value="${empleado.getEstado()}"name="txtEstado" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>USUARIO</label>
                            <input type="text" value="${empleado.getUser()}" name="txtUsuario" class="form-control"/>
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-dark"/>
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-secondary"/>
                    </form>
                </div>
            </div>
        <!-- Tablas de información recolectada -->
        <div class="col-sm-8">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>LLAVE</th>
                        <th>NOMBRES</th>
                        <th>TELEFONO</th>
                        <th>ESTADO</th>
                        <th>USUARIO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                   <c:forEach var="em" items="${empleados}">
                    <tr>
                        <td>${em.getId()}</td>
                        <td>${em.getDni()}</td>
                        <td>${em.getNombres()}</td>
                        <td>${em.getTelefono()}</td>
                        <td>${em.getEstado()}</td>
                        <td>${em.getUser()}</td>
                        <td>
                            <a style="border: none; font-size: 20px" class="btn btn-outline-dark" href="ServletControlador?menu=Empleado&accion=Editar&id=${em.getId()}"><i class="fas fa-solid fa-pen-nib"></i></a>
                            
                            <a style="border: none; font-size: 20px" class="btn btn-outline-dark" href="ServletControlador?menu=Empleado&accion=Eliminar&id=${em.getId()}"><i class="fas fa-sharp fa-solid fa-trash"></i></a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        </div>
    </body>
</html>
