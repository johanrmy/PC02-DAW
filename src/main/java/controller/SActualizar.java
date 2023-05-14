package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Conexion;
import model.Producto;

public class SActualizar extends HttpServlet {
	public PreparedStatement pst;
	public PreparedStatement pst2;
	public ResultSet data;
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
		int idProducto = Integer.parseInt(request.getParameter("idProducto"));
		String nom = request.getParameter("nombre");
		int stock = Integer.parseInt(request.getParameter("stock"));
		double pCompra = Double.parseDouble(request.getParameter("pCompra"));
		double pVenta = Double.parseDouble(request.getParameter("pVenta"));
		try {
			pst = conn.prepareStatement("UPDATE producto SET nombre=?, stock=? , pCompra=?, pVenta=? WHERE idProducto=?");
			pst.setString(1, nom);
			pst.setInt(2, stock);
			pst.setDouble(3, pCompra);
			pst.setDouble(4, pVenta);
			pst.setInt(5, idProducto);
			pst.executeUpdate();
			RequestDispatcher rd = request.getRequestDispatcher("SListado");
			rd.forward(request, response);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al actualizar producto");
		}
	}
}
