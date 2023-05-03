<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Editar Cliente</title>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css2?family=Dosis:wght@500&family=Montserrat&family=Quicksand:wght@700&display=swap" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/header.jsp"/>

        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificarCliente&idCliente=${cliente.idCliente}" method="post" class="was-validated">

            <jsp:include page="/WEB-INF/paginas/comunes/button-nav-edit.jsp"/>

            <section>
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-header">
                                    <h3 style="font-family: 'Dosis', sans-serif;">Editar Cliente</h3>
                                </div>

                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" name="nombre" class="form-control" id="nombre" value="${cliente.nombre}" required>
                                    </div>

                                    <div class="form-group">
                                        <label for="apellidos">Apellidos</label>
                                        <input type="text" name="apellidos" class="form-control" id="apellidos" value="${cliente.apellidos}">
                                    </div>

                                    <div class="form-group">
                                        <label for="correo">Correo</label>
                                        <input type="email" name="correo" class="form-control" id="correo" value="${cliente.correo}" required>
                                    </div>

                                    <div class="form-group">
                                        <label for="telefono">Telefono</label>
                                        <input type="text" name="telefono" class="form-control" id="telefono" value="${cliente.telefono}" required>
                                    </div>

                                    <div class="form-group">
                                        <label for="saldo">Saldo</label>
                                        <input type="number" name="saldo" class="form-control" id="saldo" value="${cliente.saldo}" required>
                                    </div>
                                </div>

                                <div class="card-footer">
                                    <button type="submit" class="btn btn-success btn-block">
                                        <i class="fas fa-check"></i> Guardar Cliente
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>

        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/7c51acf510.js" crossorigin="anonymous"></script>
    </body>
</html>
