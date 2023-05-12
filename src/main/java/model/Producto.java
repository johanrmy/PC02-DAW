package model;

public class Producto {
private String idProducto;
private String nombre;
private int stock;
private double pCompra;
private double pVenta;
public Producto(String idProducto, String nombre, int stock, double pCompra, double pVenta) {
	super();
	this.idProducto = idProducto;
	this.nombre = nombre;
	this.stock = stock;
	this.pCompra = pCompra;
	this.pVenta = pVenta;
}
public Producto() {}
public String getIdProducto() {
	return idProducto;
}
public void setIdProducto(String idProducto) {
	this.idProducto = idProducto;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public double getpCompra() {
	return pCompra;
}
public void setpCompra(double pCompra) {
	this.pCompra = pCompra;
}
public double getpVenta() {
	return pVenta;
}
public void setpVenta(double pVenta) {
	this.pVenta = pVenta;
}
}
