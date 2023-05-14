<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de Producto</title>
</head>
<body>
<a href="SListado">Volver al menu</a>
<form action="SRegistro" method=get>
	<table>
	<tr>
		<td>
		Nombre:
		</td>
		<td>
		<input type="text" name="nombre">
		</td>
	</tr>
	<tr>
		<td>
		Stock:
		</td>
		<td>
			<input type="number" name="stock">
		</td>
	</tr>
		<tr>
		<td>
		Precio de Compra:
		</td>
		<td>
			<input type="number" name="pCompra">
		</td>
	</tr>
		<tr>
		<td>
		Precio de Venta:
		</td>
		<td>
			<input type="number" name="pVenta">
		</td>
	</tr>
	<tr>
		<td>
			<input type="submit" value="Registrar">
		</td>
	</tr>
	</table>
</form>
</body>
</html>