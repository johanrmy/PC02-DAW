<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Producto" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Producto</title>
</head>
<body>
<jsp:useBean id="lista_productos" class="java.util.ArrayList" scope="request"></jsp:useBean>
<a href="SListado">Volver al menu</a>
<% Producto p = (Producto)lista_productos.get(0); %>
<form action="SActualizar" method=post>
	<table>
	<tr>
		<td>
		<input type="hidden" name="idProducto" value=<%= p.getIdProducto() %>>
		</td>
	</tr>
	<tr>
		<td>
		Nombre:
		</td>
		<td>
		<input type="text" name="nombre" value=<%= p.getNombre() %>>
		</td>
	</tr>
	<tr>
		<td>
		Stock:
		</td>
		<td>
			<input type="number" name="stock" value=<%= p.getStock() %>>
		</td>
	</tr>
		<tr>
		<td>
		Precio de Compra:
		</td>
		<td>
			<input type="number" name="pCompra" value=<%= p.getpCompra() %>>
		</td>
	</tr>
		<tr>
		<td>
		Precio de Venta:
		</td>
		<td>
			<input type="number" name="pVenta" value=<%= p.getpVenta() %>>
		</td>
	</tr>
	<tr>
		<td>
			<input type="submit" value="Actualizar">
		</td>
	</tr>
	</table>
</form>
</body>
</html>
</body>
</html>