package ec.edu.uce.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.CuentaBancaria;




@Repository
@Transactional
public class CuentaBancariaRepoImpl implements ICuentaBancariaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cuentaBancaria);
	}

	@Override
	public CuentaBancaria read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CuentaBancaria.class, id);
	}

	@Override
	public void update(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuentaBancaria);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		CuentaBancaria cuentaBorrar=this.read(id);
		this.entityManager.remove(cuentaBorrar);
	}

	@Override
	public CuentaBancaria buscarCuentaCedula(String cedula) {
		TypedQuery<CuentaBancaria> myQuery=this.entityManager.createQuery("SELECT c FROM CuentaBancaria c JOIN  c.cuentaHabiente ch WHERE ch.cedula=:valor", CuentaBancaria.class);
		myQuery.setParameter("valor", cedula);
	
		//carga de relacionamientos
		
		return myQuery.getSingleResult();// TODO Auto-generated method stub
		
	}

	@Override
	public CuentaBancaria buscarNumeroCuenta(String numero) {
		TypedQuery<CuentaBancaria> myQuery=this.entityManager.createQuery("Select c From CuentaBancaria c where c.numero=:valor", CuentaBancaria.class);
		myQuery.setParameter("valor", numero);
		return myQuery.getSingleResult();
	}

}
