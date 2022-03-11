package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

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

	@Override
	public Stream<String> reporteRetiros(LocalDateTime fechaRetiro, BigDecimal monto) {
		// TODO Auto-generated method stub
		List<HistoricoRetiros>listaRetiros=this.listaRetiros();
		//filtro por  fecha de retiro y monto de retiro,
		Stream<HistoricoRetiros> filtro=listaRetiros.stream().filter(h->h.getFecha().isBefore(fechaRetiro)||h.getMonto().compareTo(monto)==1);
		Stream<String> formato=filtro.map((h)->{return h.getCuentaHabienteR().getCedula()+"-"+h.getCuentaHabienteR().getNombre()+"-"+h.getCuentaHabienteR().getApellido()+"-$"+h.getMonto()+"-"+h.getFecha().format(DateTimeFormatter.ISO_DATE);});
		return formato;
	}
	

	@Override
	public List<HistoricoRetiros> listaRetiros() {
		// TODO Auto-generated method stub
		return this.historicoRepo.listaRetiros();
	}
}
