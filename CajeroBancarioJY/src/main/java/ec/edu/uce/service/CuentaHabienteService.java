package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.CuentaHabiente;
import ec.edu.uce.repository.ICuentaHabienteRepo;



@Service
public class CuentaHabienteService implements ICuentaHabienteService{

	@Autowired
	private ICuentaHabienteRepo cuentaHabienteRepo;

	@Override
	public void create(CuentaHabiente cuentaHabiente) {
		// TODO Auto-generated method stub
		this.cuentaHabienteRepo.create(cuentaHabiente);
	}

	@Override
	public CuentaHabiente read(Integer id) {
		// TODO Auto-generated method stub
		return this.cuentaHabienteRepo.read(id);
	}

	@Override
	public void update(CuentaHabiente cuentaHabiente) {
		// TODO Auto-generated method stub
		this.cuentaHabienteRepo.update(cuentaHabiente);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.cuentaHabienteRepo.delete(id);
	}
}
