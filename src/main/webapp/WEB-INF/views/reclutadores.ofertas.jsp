<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
                    <h4>Reclutadores</h4>

                    <p class="text-left">
                        <a href="${pageContext.request.contextPath}">Home</a> |
                        <a href="${pageContext.request.contextPath}/reclutadores/">Registro</a> |
                        Ofertar |
                        <a href="${pageContext.request.contextPath}/reclutadores/postulantes">Postulantes</a>
                    </p>

                    <core:if test="${not empty param.add}">
                        <div class="alert alert-success my-4">El registro se ha añadido correctamente</div>
                    </core:if>
                </div>

                <div class="col-12">
                    <form:form method="post" modelAttribute="oferta">
                        <form:hidden path="id" />

                        <div class="form-group">
                            <form:label path="fecha">Fecha</form:label>
                            <form:input path="fecha" cssClass="form-control" cssErrorClass="form-control is-invalid" />
                            <form:errors path="fecha" cssClass="invalid-feedback" />
                        </div>

                        <div class="form-group">
                            <form:label path="titulo">Título</form:label>
                            <form:input path="titulo" cssClass="form-control" cssErrorClass="form-control is-invalid" />
                            <form:errors path="titulo" cssClass="invalid-feedback" />
                        </div>

                        <div class="form-group">
                            <form:label path="descripcion">Descripción</form:label>
                            <form:textarea path="descripcion" cssClass="form-control" cssErrorClass="form-control is-invalid" />
                            <form:errors path="descripcion" cssClass="invalid-feedback" />
                        </div>

                        <div class="form-group">
                            <form:label path="salario">Salario</form:label>
                            <form:input path="salario" cssClass="form-control" cssErrorClass="form-control is-invalid" />
                            <form:errors path="salario" cssClass="invalid-feedback" />
                        </div>

                        <div class="form-group">
                            <form:label path="reclutador.id">Reclutador</form:label>
                            <form:select path="reclutador.id" cssClass="form-control">
                                <form:options items="${reclutadores}" itemValue="id" itemLabel="nombreFantasia" />
                            </form:select>
                        </div>

                        <div class="form-group text-right">
                            <button type="reset" class="btn btn-secondary">Limpiar</button>
                            <button type="submit" class="btn btn-primary">Registrar</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.1/umd/popper.min.js" integrity="sha512-ubuT8Z88WxezgSqf3RLuNi5lmjstiJcyezx34yIU2gAHonIi27Na7atqzUZCOoY4CExaoFumzOsFQ2Ch+I/HCw==" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha512-M5KW3ztuIICmVIhjSqXe01oV2bpe248gOxqmlcYrEzAvws7Pw3z6BK0iGbrwvdrUQUhi3eXgtxp5I8PDo9YfjQ==" crossorigin="anonymous"></script>
    </body>
</html>
