package ec.edu.uce.service;

import ec.edu.uce.modelo.CuentaHabiente;

public interface ICuentaHabienteService {

	public void create(CuentaHabiente cuentaHabiente);
	public CuentaHabiente read(Integer id); 
	public void update(CuentaHabiente cuentaHabiente); 
	public void delete(Integer id);
}
