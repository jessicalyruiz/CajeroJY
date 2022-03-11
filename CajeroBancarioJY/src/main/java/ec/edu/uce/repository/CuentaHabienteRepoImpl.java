package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.CuentaHabiente;



@Repository
@Transactional
public class CuentaHabienteRepoImpl implements ICuentaHabienteRepo {
	private static final Logger LOG = LoggerFactory.getLogger(CuentaBancariaRepoImpl.class);

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

	@Override
	public List<CuentaHabiente> listaClientes() {
		TypedQuery<CuentaHabiente> myQuery=this.entityManager.createQuery("Select c From CuentaHabiente c", CuentaHabiente.class);
		List<CuentaHabiente> listaClientes= myQuery.getResultList();
		for (CuentaHabiente cuentaHabiente : listaClientes) {
			LOG.info("cuentas" +cuentaHabiente.getCuentas());
			LOG.info("retiros"+cuentaHabiente.getRetiros());
		}
		return myQuery.getResultList();
	}
}
