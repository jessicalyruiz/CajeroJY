package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.CuentaHabiente;



@Repository
@Transactional
public class CuentaHabienteRepoImpl implements ICuentaHabienteRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void create(CuentaHabiente cuentaHabiente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cuentaHabiente);
	}

	@Override
	public CuentaHabiente read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CuentaHabiente.class, id);
	}

	@Override
	public void update(CuentaHabiente cuentaHabiente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuentaHabiente);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		CuentaHabiente cuentaHabienteBorrar=this.read(id);
		this.entityManager.remove(cuentaHabienteBorrar);
	}
}
