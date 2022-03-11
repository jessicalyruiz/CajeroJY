package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.modelo.HistoricoRetiros;

public interface IHistoricoRetitoRepo {

	public void create(HistoricoRetiros historicoRetiros);
	public HistoricoRetiros read(Integer id); 
	public void update(HistoricoRetiros historicoRetiros); 
	public void delete(Integer id);
	
	
	public List<HistoricoRetiros> listaRetiros();
}
