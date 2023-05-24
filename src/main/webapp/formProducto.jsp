<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
      <c:if test="${producto == null}">Nuevo</c:if>
      <c:if test="${producto != null}">Editar</c:if>
        Producto
      </title>
    </head>

    <body>
      <div align="center">

        <h1 align="center">
        <c:if test="${producto == null}">Nuevo</c:if>
        <c:if test="${producto != null}">Editar</c:if>
          Producto
        </h1>
        <form action="" method="POST">
          <div>
            <label for="descripcion">Descripcion</label>
            <input type="hidden" name="id" value="${producto.id}"/>
            <input type="text" name="descripcion" value="${producto.descripcion}">
        </div>
        <div>
          <label for="cantidad">Cantidad</label>
          <input type="number" name="cantidad" value="${producto.cantidad}">
        </div>
        <div>
          <label for="precio">Precio</label>
          <input type="number" name="precio" value="${producto.precio}">
        </div>
        <div>
          <label for="categoria">Categoria</label>
          <input type="text" name="categoria" value="${producto.categoria}">
        </div>
        <div>
          <a href="/almacen">Cancelar y volver</a>
          <input type="submit" value="Enviar"/>
        </div>
        
      </form>

    </div>
  </body>
</html>
