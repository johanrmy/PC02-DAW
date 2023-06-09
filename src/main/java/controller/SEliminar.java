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
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SEliminar extends HttpServlet {
	public PreparedStatement pst;
	public String msg;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Conexion c = new Conexion();
		Connection conn = c.conexion();
		int idProducto = Integer.parseInt(request.getParameter("idProducto"));
		try {
			pst = conn.prepareStatement("DELETE FROM producto WHERE idProducto=?");
			pst.setInt(1, idProducto);
			pst.executeUpdate();
			RequestDispatcher rd = request.getRequestDispatcher("SListado");
			rd.forward(request, response);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al eliminar producto");
		}
	}
}