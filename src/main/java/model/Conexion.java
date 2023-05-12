package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String db = "jdbc:mysql://localhost/inventario";
	private String user = "root";
	private String pwd = "";
	private Connection conn;
	public Connection conexion() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(db, user, pwd);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Base de datos no encontrada");
		}catch(ClassNotFoundException e2) {
			JOptionPane.showMessageDialog(null, "Driver no encontrado");
		}
		return conn;
	}
}
