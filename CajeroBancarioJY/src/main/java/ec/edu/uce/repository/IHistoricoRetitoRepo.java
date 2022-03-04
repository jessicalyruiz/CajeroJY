package ec.edu.uce.repository;

import ec.edu.uce.modelo.HistoricoRetiros;

public interface IHistoricoRetitoRepo {

	public void create(HistoricoRetiros historicoRetiros);
	public HistoricoRetiros read(Integer id); 
	public void update(HistoricoRetiros historicoRetiros); 
	public void delete(Integer id);
}
