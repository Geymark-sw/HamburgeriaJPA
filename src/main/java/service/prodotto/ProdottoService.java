package service.prodotto;

import java.util.List;

import dao.prodotto.IProdottoDao;
import jakarta.persistence.EntityManager;
import model.Prodotto;

public class ProdottoService implements IProdottoService{

	private final EntityManager entityManager;
	private final IProdottoDao prodottoDao;
	
	public ProdottoService(EntityManager entityManager, IProdottoDao prodottoDao) {
		this.entityManager = entityManager;
		this.prodottoDao = prodottoDao;
	}

	@Override
	public List<Prodotto> findAll() {
		return this.prodottoDao.findAll();
	}

	@Override
	public Prodotto findById(Long id) {
		return this.prodottoDao.findById(id);
	}

	@Override
	public void create(Prodotto entity) {
		if (entity.getId_prodotto() == null) {
			try {
				this.entityManager.getTransaction().begin();
				this.prodottoDao.persist(entity);
				this.entityManager.getTransaction().commit();
			} catch (Exception e) {
				this.entityManager.getTransaction().rollback();
				e.printStackTrace();
			}
		}
	}

	@Override
	public Prodotto update(Prodotto entity) {
		Prodotto updated = null;
		if(entity.getId_prodotto() != null) {
			try {
				this.entityManager.getTransaction().begin();
				updated = this.prodottoDao.merge(entity);
				this.entityManager.getTransaction().commit();
			}catch(Exception e) {
				this.entityManager.getTransaction().rollback();
				e.printStackTrace();
			}
		}
		return updated;
	}

	@Override
	public void delete(Prodotto entity) {
		try {
			this.entityManager.getTransaction().begin();
			this.prodottoDao.remove(entity);
			this.entityManager.getTransaction().commit();
		} catch (Exception e) {
			this.entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		
	}
	
}
