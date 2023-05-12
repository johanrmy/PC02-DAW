package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import model.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SRegistro extends HttpServlet{
	public PreparedStatement pst;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Conexion c = new Conexion();
		Connection conn = c.conexion();
		String nom = request.getParameter("nombre");
		int stock = Integer.parseInt(request.getParameter("stock"));
		double pCompra = Double.parseDouble(request.getParameter("pCompra"));
		double pVenta = Double.parseDouble(request.getParameter("pVenta"));
		try {
			pst = conn.prepareStatement("INSERT INTO producto values(default,?,?,?,?)");
			pst.setString(1, nom);
			pst.setInt(2, stock);
			pst.setDouble(3, pCompra);
			pst.setDouble(4, pVenta);
			pst.executeUpdate();
			RequestDispatcher rd = request.getRequestDispatcher("validar.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al registrar producto");
		}
	}
}
