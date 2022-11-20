<br>
<div class="container text-center">
    <div class="row">
        <div class="col-md-4 mx-auto">
            <div class="card">
                <div class="card-header">
                    <h4>Ingresa tu usuario</h4>
                </div>
                <div class="card-body">
                    <form name ="formUsuario" action="Validar" class="" method="POST">
                        <img src="img/avatar.svg" width="150" height="auto">
                        <hr>
                        <div class="form-group">
                            <label for="usuario"><h5><i class="fas fa-user" style="margin-right: 10px;"></i>Usuario</h5></label>
                            <input type="text" class="form-control" name="txtUser"  placeholder="Escribe tu usuario..." />
                        </div>
                        <div class="form-group">
                            <label for="password"><h5><i class="fas fa-solid fa-key" style="margin-right: 10px"></i>Contraseña</h5></label>
                            <input type="password" class="form-control" name="txtPass" placeholder="Escribe tu contraseña..." />
                        </div>

                        <button type="submit" name="accion" value="ingresar" class="btn btn-success btn-block">Ingresar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>