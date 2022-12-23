<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
        <script src="https://kit.fontawesome.com/99495b31d6.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <title>Editar Series</title>
    </head>

    <body class="bg-dark">

        <jsp:include page="../comunes/cabecera.jsp"></jsp:include>  

            <form action="${pageContext.request.contextPath}/servletControlador?accion=modificar&id=${serie.id}" method="POST" class="was-validated">
            <jsp:include page="../comunes/botonesNavegacionEditar.jsp"></jsp:include>  

                <section id="details">
                    <div class="container">
                        <div class="row mb-4  justify-content-center">
                            <div class="col-md-4">
                                <div class="card bg-dark text-white">
                                    <div class="card-header">
                                        <h4>Modificar Serie</h4>
                                    </div>
                                    <div class="card-body ">
                                        <div class="form-group">
                                            <label for="nombre" >Titulo</label>
                                            <input type="text" class="form-control" name="nombre" value="${serie.nombre}" required/>
                                        </div>
                                        <div class="form-group">
                                            <label for="lanzamiento" >Lanzamiento</label>
                                            <input type="number" class="form-control" name="lanzamiento" value="${serie.lanzamiento}" required/>
                                        </div>
                                        <div class="form-group">
                                            <label for="temporada" >Temporadas</label>
                                            <input type="number" class="form-control" name="temporadas" value="${serie.temporadas}" required/>
                                        </div>
                                        <div class="form-group">
                                            <label for="plataforma" >Plataforma</label>
                                            <input type="text" class="form-control" name="plataforma" value="${serie.plataforma}" required/>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </form>





        <jsp:include page="../comunes/piePagina.jsp"></jsp:include>    
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html>
