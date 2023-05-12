package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Conexion;
import model.Producto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import model.*;


public class SListado extends HttpServlet {
	public ResultSet data;
	public Statement sen;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Conexion c = new Conexion();
		Connection conn = c.conexion();
		ArrayList lista = new ArrayList();
		try {
			sen = conn.createStatement();
			data = sen.executeQuery("SELECT * FROM producto");
			while(data.next()) {
				Producto p = new Producto();
				p.setIdProducto(data.getString(1));
				p.setNombre(data.getString(2));
				p.setStock(data.getInt(3));
				p.setpCompra(data.getDouble(4));
				p.setpVenta(0);
				lista.add(p);
			}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Error en la consulta");
			}
		request.setAttribute("lista_productos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("listado.jsp");
		rd.forward(request, response);
	}
}
