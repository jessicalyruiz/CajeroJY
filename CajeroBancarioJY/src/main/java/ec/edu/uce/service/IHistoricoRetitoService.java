package ec.edu.uce.service;

import ec.edu.uce.modelo.HistoricoRetiros;

public interface IHistoricoRetitoService {

	public void create(HistoricoRetiros historicoRetiros);
	public HistoricoRetiros read(Integer id); 
	public void update(HistoricoRetiros historicoRetiros); 
	public void delete(Integer id);
}
