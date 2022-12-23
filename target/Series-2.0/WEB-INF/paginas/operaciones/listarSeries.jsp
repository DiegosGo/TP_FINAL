<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="es-Ar"/>

<section id="series">
    <div class="container mb-4">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Series</h4>
                    </div>

                    <table class="table table-dark table-hover table-sm">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Lanzamiento</th>
                                <th>Temporada</th>
                                <th>Plataforma</th>
                                <th>Modificar</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="serie" items="${series}" varStatus="status" >
                                <tr>
                                    <td>  ${status.count}</td>
                                    <td>  ${serie.nombre}</td>
                                    <td>  ${serie.lanzamiento}</td>
                                    <td>  ${serie.temporadas}</td>
                                    <td>  ${serie.plataforma}</td>
                                    
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servletControlador?accion=editar&id=${serie.id}" class="btn btn-secondary">
                                           <i class="fa-solid fa-pen"></i>
                                            Editar
                                        </a>
                                    </td>

                                    
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
            
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body" >
                        <h3>Cantidad de Series Totales</h3>
                        <h4 class="display-4"> <i class="fa-solid fa-clapperboard m-2"></i>${totalSeries}</h4>
                    </div>
                </div>
                    
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body" >
                        <h3>Cantidad de Temporadas</h3>
                        <h4 class="display-4"> <i class="fa-solid fa-file-video m-2"></i>${totalTemporadas}</h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/paginas/operaciones/agregarSerie.jsp"/>