package ec.edu.uce.repository;

import java.math.BigDecimal;
import java.util.List;

import ec.edu.uce.modelo.CuentaHabiente;

public interface ICuentaHabienteRepo {

	public void create(CuentaHabiente cuentaHabiente);
	public CuentaHabiente read(Integer id); 
	public void update(CuentaHabiente cuentaHabiente); 
	public void delete(Integer id); 
	
	public List<CuentaHabiente> listaClientes();
}
