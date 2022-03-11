package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.uce.CajeroBancarioJyApplication;
import ec.edu.uce.modelo.HistoricoRetiros;



@Repository
@Transactional
public class HistoricoRetitoRepoImpl implements IHistoricoRetitoRepo {

	private static final Logger LOG=  LoggerFactory.getLogger(CajeroBancarioJyApplication.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void create(HistoricoRetiros historicoRetiros) {
		// TODO Auto-generated method stub
		this.entityManager.persist(historicoRetiros);
	}

	@Override
	public HistoricoRetiros read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(HistoricoRetiros.class, id);
	}

	@Override
	public void update(HistoricoRetiros historicoRetiros) {
		// TODO Auto-generated method stub
		this.entityManager.merge(historicoRetiros);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		HistoricoRetiros historicoRetirosBorrar=this.read(id);
		this.entityManager.remove(historicoRetirosBorrar);
	}

	@Override
	public List<HistoricoRetiros> listaRetiros() {
		// TODO Auto-generated method stub
		TypedQuery<HistoricoRetiros> myQuery=this.entityManager.createQuery("Select h from HistoricoRetiros h", HistoricoRetiros.class );
		List<HistoricoRetiros>listaRetiros=myQuery.getResultList();
		for (HistoricoRetiros historicoRetiros : listaRetiros) {
			LOG.info("cuenta"+historicoRetiros.getCuenta());
			LOG.info("cuenta habiente"+historicoRetiros.getCuentaHabienteR());
		}
		return listaRetiros;
	}
}
