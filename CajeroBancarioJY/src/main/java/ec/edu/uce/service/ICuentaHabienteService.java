package ec.edu.uce.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import ec.edu.uce.modelo.CuentaHabiente;
import ec.edu.uce.modelo.CuentaHabienteVIP;

public interface ICuentaHabienteService {

	public void create(CuentaHabiente cuentaHabiente);
	public CuentaHabiente read(Integer id); 
	public void update(CuentaHabiente cuentaHabiente); 
	public void delete(Integer id);
	
	public List<CuentaHabiente> listaClientes();
	public Stream<CuentaHabienteVIP> reporteClientesVIP(BigDecimal saldo);
}
