package ec.edu.uce.modelo;

import java.math.BigDecimal;

public class CuentaHabienteVIP {

	private String cedula;
	private String nombre;
	private String apellido;
	private String numeroCuenta;
	private String tipoCuenta;
	private BigDecimal saldo;
	//get y set
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return cedula + "-" + nombre + "-" + apellido
				+ "-" + numeroCuenta + "-" + tipoCuenta + "-$" + saldo;
	}


	
	
}
