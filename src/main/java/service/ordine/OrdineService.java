package service.ordine;

import java.util.List;

import dao.ordine.IOrdineDao;
import jakarta.persistence.EntityManager;
import model.Ordine;

public class OrdineService implements IOrdineService{
	
	private final EntityManager entityManager;
	private final IOrdineDao ordineDao;
	
	public OrdineService(EntityManager entityManager, IOrdineDao ordineDao) {
		this.entityManager = entityManager;
		this.ordineDao = ordineDao;
	}

	@Override
	public List<Ordine> findAll() {
		return this.ordineDao.findAll();
	}

	@Override
	public Ordine findById(Long id) {
		return this.ordineDao.findById(id);
	}

	@Override
	public void create(Ordine entity) {
		if (entity.getId_ordine() == null) {
			try {
				this.entityManager.getTransaction().begin();
				this.ordineDao.persist(entity);
				this.entityManager.getTransaction().commit();
			} catch (Exception e) {
				this.entityManager.getTransaction().rollback();
				e.printStackTrace();
			}
		}
	}

	@Override
	public Ordine update(Ordine entity) {
		Ordine updated = null;
		if(entity.getId_ordine() != null) {
			try {
				this.entityManager.getTransaction().begin();
				updated = this.ordineDao.merge(entity);
				this.entityManager.getTransaction().commit();
			}catch(Exception e) {
				this.entityManager.getTransaction().rollback();
				e.printStackTrace();
			}
		}
		return updated;
	}

	@Override
	public void delete(Ordine entity) {
		try {
			this.entityManager.getTransaction().begin();
			this.ordineDao.remove(entity);
			this.entityManager.getTransaction().commit();
		} catch (Exception e) {
			this.entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		
	}

}
