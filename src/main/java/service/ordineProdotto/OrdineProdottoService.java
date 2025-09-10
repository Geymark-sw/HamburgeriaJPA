package service.ordineProdotto;

import java.util.List;

import dao.ordineProdotto.IOrdineProdottoDao;
import jakarta.persistence.EntityManager;
import model.OrdineProdotto;

public class OrdineProdottoService implements IOrdineProdottoService {

	private final EntityManager entityManager;
	private final IOrdineProdottoDao ordineProdottoDao;
	
	public OrdineProdottoService(EntityManager entityManager, IOrdineProdottoDao ordineProdottoDao) {
		this.entityManager = entityManager;
		this.ordineProdottoDao = ordineProdottoDao;
	}

	@Override
	public List<OrdineProdotto> findAll() {
		return this.ordineProdottoDao.findAll();
	}

	@Override
	public OrdineProdotto findById(Long id) {
		return this.ordineProdottoDao.findById(id);
	}

	@Override
	public void create(OrdineProdotto entity) {
		if (entity.getId_ordine_prodotto() == null) {
			try {
				this.entityManager.getTransaction().begin();
				this.ordineProdottoDao.persist(entity);
				this.entityManager.getTransaction().commit();
			} catch (Exception e) {
				this.entityManager.getTransaction().rollback();
				e.printStackTrace();
			}
		}
	}

	@Override
	public OrdineProdotto update(OrdineProdotto entity) {
		OrdineProdotto updated = null;
		if(entity.getId_ordine_prodotto() != null) {
			try {
				this.entityManager.getTransaction().begin();
				updated = this.ordineProdottoDao.merge(entity);
				this.entityManager.getTransaction().commit();
			}catch(Exception e) {
				this.entityManager.getTransaction().rollback();
				e.printStackTrace();
			}
		}
		return updated;
	}

	@Override
	public void delete(OrdineProdotto entity) {
		try {
			this.entityManager.getTransaction().begin();
			this.ordineProdottoDao.remove(entity);
			this.entityManager.getTransaction().commit();
		} catch (Exception e) {
			this.entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		
	}

}
