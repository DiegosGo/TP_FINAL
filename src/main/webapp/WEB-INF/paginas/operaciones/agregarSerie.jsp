<div class="modal fade" id="agregarSerieModal" tabindex="-1" aria-labeledby="agregarSerieModal" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header text-bg-light ">
                <h5 class="modal-title">Agregar Serie</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"> </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/servletControlador?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body ">
                    <div class="form-group">
                        <label for="nombre" >Titulo</label>
                        <input type="text" class="form-control" name="nombre" required/>
                    </div>
                    <div class="form-group">
                        <label for="lanzamiento" >Lanzamiento</label>
                        <input type="number" class="form-control" name="lanzamiento" required/>
                    </div>
                    <div class="form-group">
                        <label for="temporada" >Temporadas</label>
                        <input type="number" class="form-control" name="temporadas" required/>
                    </div>
                    <div class="form-group">
                        <label for="plataforma" >Plataforma</label>
                        <input type="text" class="form-control" name="plataforma" required/>
                    </div>
                </div>
                
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">
                        Guardar
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>