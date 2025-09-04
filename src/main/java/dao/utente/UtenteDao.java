package dao.utente;

import java.util.List;

import dao.IBaseDao;
import jakarta.persistence.EntityManager;
import model.Utente;

public class UtenteDao implements IBaseDao{
	
	private final EntityManager entityManager;
	
	public UtenteDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Utente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean persist(Object elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object merge(Object elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Object daCancellare) {
		// TODO Auto-generated method stub
		return false;
	}

}
