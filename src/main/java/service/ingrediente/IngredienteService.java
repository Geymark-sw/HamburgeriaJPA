package service.ingrediente;

import java.util.List;

import dao.ingrediente.IIngredienteDao;
import jakarta.persistence.EntityManager;
import model.Ingrediente;
import service.IBaseService;

public class IngredienteService implements IIngredienteService{
	
	private final EntityManager entityManager;
	private final IIngredienteDao ingredienteDao;
	
	public IngredienteService(EntityManager entityManager, IIngredienteDao ingredienteDao) {
		this.entityManager = entityManager;
		this.ingredienteDao = ingredienteDao;
	}

	@Override
	public List<Ingrediente> findAll() {
		
		return this.ingredienteDao.findAll();
	}

	@Override
	public Ingrediente findById(Long id) {
		
		return this.ingredienteDao.findById(id);
	}

	@Override
	public void create(Ingrediente entity) {
		if(entity.getId_ingrediente() == null) {
			try {
				this.entityManager.getTransaction().begin();
				this.ingredienteDao.persist(entity);
				this.entityManager.getTransaction().commit();
			}catch(Exception e) {
				this.entityManager.getTransaction().rollback();
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Ingrediente update(Ingrediente entity) {
		Ingrediente updated = null;
		if(entity.getId_ingrediente() != null) {
			try {
				this.entityManager.getTransaction().begin();
				updated = this.ingredienteDao.merge(entity);
				this.entityManager.getTransaction().commit();
			}catch(Exception e) {
				this.entityManager.getTransaction().rollback();
				e.printStackTrace();
			}
		}
		return updated;
	}

	@Override
	public void delete(Ingrediente entity) {
		try {
			this.entityManager.getTransaction().begin();
			this.ingredienteDao.remove(entity);
			this.entityManager.getTransaction().
		}catch(Exception e) {
			this.entityManager.getTransaction().rollback();
		}
	}

}
