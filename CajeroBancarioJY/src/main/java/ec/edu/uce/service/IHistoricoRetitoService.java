package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import ec.edu.uce.modelo.HistoricoRetiros;

public interface IHistoricoRetitoService {

	public void create(HistoricoRetiros historicoRetiros);
	public HistoricoRetiros read(Integer id); 
	public void update(HistoricoRetiros historicoRetiros); 
	public void delete(Integer id);
	
	public List<HistoricoRetiros> listaRetiros(); 
	
	public Stream<String> reporteRetiros(LocalDateTime fechaRetiro, BigDecimal monto);
}
