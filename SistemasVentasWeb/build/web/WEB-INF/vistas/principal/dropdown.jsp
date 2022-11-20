<div class="dropdown">
    <button style="color: white; border: none; background: none; font-size: 15px
            "class="btn-outline-light dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
       <i class="fas fa-solid fa-user"></i> ${usuario.getNombres()}
    </button>
    <ul style="margin-left: -30px; width: 10px;" class="dropdown-menu text-center">
        <li><img src="img/avatar.svg" width="60px"></li>
        <hr style="border-color: black">
        <li><a style="font-size: 10px"class="dropdown-item">¿Desea salir del <br>sistema Riquero <br>señor ${usuario.getNombres()}?</a></li>
        <br>
        <form action="Validar" method="POST">
            <li><button name="accion" value="salir" style="font-size:12px"class="btn btn-danger" href="#">Salir</button></li>
        </form>
    </ul>
</div>
</nav>