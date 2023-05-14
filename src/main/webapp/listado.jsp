<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Producto" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Productos</title>
</head>
<body>
<jsp:useBean id="lista_productos" class="java.util.ArrayList" scope="request"></jsp:useBean>
<a href="registro.jsp">Registrar Producto</a>
<table>
	<tr>
		<th>Código</th>
		<th>Nombre</th>
		<th>Precio</th>
		<th>Stock</th>
	</tr>
	<tr>
	<%
		Producto p = new Producto();
		for(int i=0;i<lista_productos.size();i++){
			p = (Producto)lista_productos.get(i);
	%>
		<td><%=p.getIdProducto() %></td>
		<td><%=p.getNombre() %></td>
		<td><%=p.getStock() %></td>
		<td><%=p.getpCompra() %></td>
		<td><%=p.getpVenta() %></td>
		<td><a href="SEditar?idProducto=<%=p.getIdProducto() %>"><button>Editar</button></a></td>
		<td><a href="SEliminar?idProducto=<%=p.getIdProducto() %>"><button>Eliminar</button></a></td>
	</tr>
	<%} %>
</table>
</body>
</html>