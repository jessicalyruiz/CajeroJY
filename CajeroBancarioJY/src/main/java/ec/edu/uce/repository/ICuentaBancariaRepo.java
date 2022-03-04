package ec.edu.uce.repository;

import java.math.BigDecimal;
import java.util.List;

import ec.edu.uce.modelo.CuentaBancaria;

public interface ICuentaBancariaRepo {

	public void create(CuentaBancaria cuentaBancaria);
	public CuentaBancaria read(Integer id); 
	public void update(CuentaBancaria cuentaBancaria); 
	public void delete(Integer id); 
	
	public List<CuentaBancaria>  buscarCuentaCedula(String cedula);
	public CuentaBancaria buscarNumeroCuenta(String numero);
}
