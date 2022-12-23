<section id="actions" class="py-4 mb-4 bg-dark" >
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-md-3">
                <a href="index.jsp" class="btn btn-light btn-block mx-auto">
                    <i class="fas fa-arrow-left"></i>
                    Regresar a inicio
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block mx-auto">
                    <i class="fas fa-check"></i>
                    Guardar Modificación
                </button>
            </div>
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/servletControlador?accion=eliminar&id=${serie.id}"
                   class="btn btn-danger btn-block mx-auto">
                   <i  class="fas fa-trash"></i>
                   Eliminar Serie
                </a>
            </div>
        </div>
    </div>
</section>