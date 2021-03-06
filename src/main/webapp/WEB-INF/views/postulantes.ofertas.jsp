<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Con Luquitas Baila el Mono</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha512-MoRNloxbStBcD8z3M/2BmnT+rg4IsMxPkXaGh2zD6LGNNFE80W3onsAhRcMAMrSoyWL9xD7Ert0men7vR8LUZg==" crossorigin="anonymous" />
    </head>

    <body>
        <div class="container my-5">
            <div class="row">
                <div class="col-12">
                    <h1 class="border-bottom pb-2 mb-4">Con Luquitas Baila el Mono</h1>
                    <h4>Postulantes</h4>

                    <p class="text-left">
                        <a href="${pageContext.request.contextPath}">Home</a> |
                        <a href="${pageContext.request.contextPath}/postulantes">Registro</a> |
                        Postular
                    </p>
                </div>

                <div class="col-12">
                    <core:forEach items="${ofertas}" var="oferta">
                        <div class="card mb-4">
                            <div class="card-body">
                                <h5 class="card-title">${oferta.titulo}</h5>
                                <div class="row">
                                    <div class="col-md-4">
                                        <h6 class="card-subtitle mb-2 text-muted">${oferta.reclutador.nombreFantasia}</h6>
                                    </div>

                                    <div class="col-md-4">
                                        <h6 class="card-subtitle mb-2 text-muted">Publicada el: ${oferta.fecha}</h6>
                                    </div>

                                    <div class="col-md-4">
                                        <h6 class="card-subtitle mb-2">$${oferta.salario}</h6>
                                    </div>
                                </div>

                                <p class="card-text">${oferta.descripcion}</p>

                                <button type="button" class="btn btn-primary">Postular!</button>
                            </div>
                        </div>
                    </core:forEach>
                </div>
            </div>
        </div>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.1/umd/popper.min.js" integrity="sha512-ubuT8Z88WxezgSqf3RLuNi5lmjstiJcyezx34yIU2gAHonIi27Na7atqzUZCOoY4CExaoFumzOsFQ2Ch+I/HCw==" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha512-M5KW3ztuIICmVIhjSqXe01oV2bpe248gOxqmlcYrEzAvws7Pw3z6BK0iGbrwvdrUQUhi3eXgtxp5I8PDo9YfjQ==" crossorigin="anonymous"></script>
    </body>
</html>
