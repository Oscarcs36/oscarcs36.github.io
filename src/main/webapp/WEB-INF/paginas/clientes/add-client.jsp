<div class="modal" id="agregarClienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Cliente</h5>
                <button class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <form action="${pageContext.request.contextPath}/ServletControlador?accion=agregarCliente" method="post"
                  class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" name="nombre" class="form-control" id="nombre" required>
                    </div>

                    <div class="form-group">
                        <label for="apellidos">Apellidos</label>
                        <input type="text" name="apellidos" class="form-control" id="apellidos">
                    </div>

                    <div class="form-group">
                        <label for="correo">Correo</label>
                        <input type="email" name="correo" class="form-control" id="correo" required>
                    </div>

                    <div class="form-group">
                        <label for="telefono">Telefono</label>
                        <input type="text" name="telefono" class="form-control" id="telefono" required>
                    </div>

                    <div class="form-group">
                        <label for="saldo">Saldo</label>
                        <input type="number" name="saldo" class="form-control" id="saldo" required>
                    </div>
                </div>

                <div class="modal-footer">
                    <input type="submit" value="Guardar" class="btn btn-primary">
                </div>
            </form>

        </div>
    </div>
</div>