package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.HistoricoRetiros;



@Repository
@Transactional
public class HistoricoRetitoRepoImpl implements IHistoricoRetitoRepo {

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
}
