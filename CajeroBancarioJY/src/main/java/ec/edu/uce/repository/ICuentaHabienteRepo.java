package ec.edu.uce.repository;

import ec.edu.uce.modelo.CuentaHabiente;

public interface ICuentaHabienteRepo {

	public void create(CuentaHabiente cuentaHabiente);
	public CuentaHabiente read(Integer id); 
	public void update(CuentaHabiente cuentaHabiente); 
	public void delete(Integer id); 
}
