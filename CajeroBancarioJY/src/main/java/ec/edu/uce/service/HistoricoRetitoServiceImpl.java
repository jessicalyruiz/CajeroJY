package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.HistoricoRetiros;
import ec.edu.uce.repository.IHistoricoRetitoRepo;



@Service
public class HistoricoRetitoServiceImpl implements IHistoricoRetitoService{

	@Autowired
	private IHistoricoRetitoRepo historicoRepo;

	@Override
	public void create(HistoricoRetiros historicoRetiros) {
		// TODO Auto-generated method stub
		this.historicoRepo.create(historicoRetiros);
	}

	@Override
	public HistoricoRetiros read(Integer id) {
		// TODO Auto-generated method stub
		return this.historicoRepo.read(id);
	}

	@Override
	public void update(HistoricoRetiros historicoRetiros) {
		// TODO Auto-generated method stub
		this.historicoRepo.update(historicoRetiros);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.historicoRepo.delete(id);
	}
}
