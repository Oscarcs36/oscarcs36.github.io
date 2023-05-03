<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<section id="clientes" class="mt-5" style="margin-left: 150px">
    <div class="container">
        <div class="row">
            <div class="col-8">
                <div class="card">
                    <div class="card-header">
                        <h3 style="font-family: 'Dosis', sans-serif;">Listado de clientes</h3>
                    </div>

                    <table class="table table-striped text-center" >
                        <thead class="table-dark">
                        <tr style="font-family: 'Quicksand', sans-serif; font-size: 19px">
                            <th>#</th>
                            <th>Nombre</th>
                            <th>Saldo</th>
                            <th></th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="clientes" items="${clientes}">
                            <tr style="font-family: 'Montserrat', sans-serif;">
                                <td>${clientes.idCliente}</td>
                                <td>${clientes.nombre} ${clientes.apellidos}</td>
                                <td>
                                    <fmt:formatNumber value="${clientes.saldo}" type="currency"/>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/ServletControlador?accion=editarCliente&idCliente=${clientes.idCliente}" type="button" class="btn btn-secondary">
                                        <i class="fa-solid fa-angles-right" style="color: #ffffff;"></i>
                                        Editar
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="col-sm-4" style="font-family: 'Montserrat', sans-serif;">
                <div class="card text-center text-white bg-danger py-2">
                    <div class="card-body">
                        <h3 class="card-tittle">Saldo total</h3>
                        <h4 class="display-4">
                            <fmt:formatNumber value="${saldoTotal}" type="currency"/>
                        </h4>
                    </div>
                </div>
                <br>
                <div class="card text-center text-white py-2" style="background-color: #1ab038">
                    <div class="card-body">
                        <h3 class="card-tittle">Total Clientes</h3>
                        <h4 class="display-4">
                            <i class="fa-solid fa-users" style="color: #ffffff;"></i>
                            <span>${totalClientes}</span>
                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/paginas/clientes/add-client.jsp"/>