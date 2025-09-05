package service.utente;

import java.util.List;

import dao.utente.IUtenteDao;
import jakarta.persistence.EntityManager;
import model.Utente;

public class UtenteService implements IUtenteService{
	
	private final EntityManager entityManager;
	private final IUtenteDao utenteDao;

	public UtenteService(EntityManager entityManager, IUtenteDao utenteDao) {
		this.entityManager = entityManager;
		this.utenteDao = utenteDao;
	}
	
	@Override
	public List<Utente> findAll() {
		
		return this.utenteDao.findAll();
	}

	@Override
	public Utente findById(Long id) {
		
		return this.utenteDao.findById(id);
	}

	@Override
	public void create(Utente entity) {
		if(entity.getId_utente() == null) { //Qui il valore dell'id deve essere nullo perché viene autogenerato in modo incrementale dal DB
			try {
				this.entityManager.getTransaction().begin();
				this.utenteDao.persist(entity);
				this.entityManager.getTransaction().commit();
			}catch(Exception e) {
				this.entityManager.getTransaction().rollback();
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Utente update(Utente entity) {
		Utente updated = null;
		if(entity.getId_utente() != null) { //Qui l'id non deve essere nullo perchè l'entita è già esistente sul DB
			try {
				this.entityManager.getTransaction().begin();
				updated = this.utenteDao.merge(entity);
				this.entityManager.getTransaction().commit();
			}catch(Exception e) {
				this.entityManager.getTransaction().rollback();
				e.printStackTrace();
			}
		}
		return updated;
	}

	@Override
	public void delete(Utente entity) {
		try {
			this.entityManager.getTransaction().begin();
			this.utenteDao.remove(entity);
			this.entityManager.getTransaction().commit();
		}catch(Exception e) {
			this.entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		
	}

}
