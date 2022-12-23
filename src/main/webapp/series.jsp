<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
        <script src="https://kit.fontawesome.com/99495b31d6.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <title>Lista de Series</title>
    </head>
    
    <body class="bg-dark">
        
        <jsp:include page="WEB-INF/paginas/comunes/cabecera.jsp"></jsp:include>
        
        <jsp:include page="WEB-INF/paginas/comunes/botonesNavegacion.jsp"></jsp:include>
        
        <!-- LISTA DE SERIES -->
        <jsp:include page="WEB-INF/paginas/operaciones/listarSeries.jsp"></jsp:include>
        
        
        <jsp:include page="WEB-INF/paginas/comunes/piePagina.jsp"></jsp:include>    
        <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html>
