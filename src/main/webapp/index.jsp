<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : 23 may. de 2023, 21:58:44
    Author     : Cristhian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
  </head>
  <body>
  <center>
    <fieldset>
      <p>SEGUNDO PARCIAL TEM-742</p>
      <p><b>Nombre: </b>Cristhian Lima Blanco</p>
      <p><b>Carnet: </b>9254419 LP.</p>
    </fieldset>
  </center>
  <div>
    <h1 align="center">Gestion de productos</h1>
    <a href="?action=add">Nuevo producto</a>
    
    
    <table align="center" border="1" cellpadding="10" cellspacing="0">
      <thead>
        <tr>
          <th>ID</th>
          <th>Descripcion</th>
          <th>Cantidad</th>
          <th>Precio Unitario</th>
          <th>Categoria</th>
          <th colspan="2">Accion</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var="producto" items="${productos}">
        <tr>
          <td>${producto.id}</td>
          <td>${producto.descripcion}</td>
          <td>${producto.cantidad}</td>
          <td>${producto.precio} Bs.</td>
          <td>${producto.categoria}</td>
          <td><a href="?action=edit&id=${producto.id}">Editar</a></td>
          <td><a href="?action=delete&id=${producto.id}">Eliminar</a> </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>
