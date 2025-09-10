package service.prodottoIngrediente;

import java.util.List;

import dao.prodottoIngrediente.IProdottoIngredienteDao;
import jakarta.persistence.EntityManager;
import model.ProdottoIngrediente;

public class ProdottoIngredienteService implements IProdottoIngredienteService {

	private final EntityManager entityManager;
	private final IProdottoIngredienteDao prodottoIngredienteDao;
	
	public ProdottoIngredienteService(EntityManager entityManager, IProdottoIngredienteDao prodottoIngredienteDao) {
		this.entityManager = entityManager;
		this.prodottoIngredienteDao = prodottoIngredienteDao;
	}

	@Override
	public List<ProdottoIngrediente> findAll() {
		return this.prodottoIngredienteDao.findAll();
	}

	@Override
	public ProdottoIngrediente findById(Long id) {
		return this.prodottoIngredienteDao.findById(id);
	}

	@Override
	public void create(ProdottoIngrediente entity) {
		if (entity.getId_prodotto_ingrediente() == null) {
			try {
				this.entityManager.getTransaction().begin();
				this.prodottoIngredienteDao.persist(entity);
				this.entityManager.getTransaction().commit();
			} catch (Exception e) {
				this.entityManager.getTransaction().rollback();
				e.printStackTrace();
			}
		}
	}

	@Override
	public ProdottoIngrediente update(ProdottoIngrediente entity) {
		ProdottoIngrediente updated = null;
		if(entity.getId_prodotto_ingrediente() != null) {
			try {
				this.entityManager.getTransaction().begin();
				updated = this.prodottoIngredienteDao.merge(entity);
				this.entityManager.getTransaction().commit();
			}catch(Exception e) {
				this.entityManager.getTransaction().rollback();
				e.printStackTrace();
			}
		}
		return updated;
	}

	@Override
	public void delete(ProdottoIngrediente entity) {
		try {
			this.entityManager.getTransaction().begin();
			this.prodottoIngredienteDao.remove(entity);
			this.entityManager.getTransaction().commit();
		} catch (Exception e) {
			this.entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		
	}

}
