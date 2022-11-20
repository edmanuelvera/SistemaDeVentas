<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/68bd6542c8.js" crossorigin="anonymous"></script>
        <title>Clientes</title>
    </head>
    <body>

        <div class="d-flex">
            <div class="col-sm-8">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>DNI</th>
                        <th>NOMBRES</th>
                        <th>DIRECCION</th>
                        <th>ESTADO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cl" items="${clientes}">
                    <tr>
                        <td>${cl.getId()}</td>
                        <td>${cl.getDni()}</td>
                        <td>${cl.getNombres()}</td>
                        <td>${cl.getDireccion()}</td>
                        <td>${cl.getEstado()}</td>
                        <td>
                            <a style="border: none; font-size: 20px" class="btn btn-outline-dark" href="ServletControlador?menu=Clientes&accion=Editar&id=${cl.getId()}"><i class="fas fa-solid fa-pen-nib"></i></a>
                            
                            <a style="border: none; font-size: 20px" class="btn btn-outline-dark" href="ServletControlador?menu=Clientes&accion=Eliminar&id=${cl.getId()}"><i class="fas fa-sharp fa-solid fa-trash"></i></a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
         </div>
         
  
         <div class="card col-sm-4 text-center">
                <div class="card-body">
                    <form action="ServletControlador?menu=Clientes" method="POST">
                        <div class="form-group">
                            <label>DNI</label>
                            <input type="text" value="${cliente.getDni()}" name="txtDniC" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>NOMBRE</label>
                            <input type="text" value="${cliente.getNombres()}" name="txtNombresC" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>DIRECCION</label>
                            <input type="text" value="${cliente.getDireccion()}"name="txtDireccionC" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>ESTADO</label>
                            <input type="text" value="${cliente.getEstado()}"name="txtEstadoC" class="form-control"/>
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-dark"/>
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-secondary"/>
                    </form>
                </div>
         </div>
</div>