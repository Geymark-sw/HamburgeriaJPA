package dao.utente;

import java.util.List;

import dao.IBaseDao;
import jakarta.persistence.EntityManager;
import model.Utente;

public class UtenteDao implements IUtenteDao{
	
	private final EntityManager entityManager;
	
	public UtenteDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Utente> findAll() {
		return this.entityManager.createQuery("FROM utente", Utente.class).getResultList();
	}

	@Override
	public Utente findById(Long id) {
		return this.entityManager.find(Utente.class, id);
	}

	@Override
	public void persist(Utente elemento) {
		this.entityManager.persist(elemento);
	}

	@Override
	public Utente merge(Utente elemento) {
		return this.entityManager.merge(elemento);
	}

	@Override
	public void remove(Utente daCancellare) {
		this.entityManager.remove(daCancellare);
	}

	


}
