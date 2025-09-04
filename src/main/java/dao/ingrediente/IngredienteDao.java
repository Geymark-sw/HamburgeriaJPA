package dao.ingrediente;

import java.util.List;

import jakarta.persistence.EntityManager;
import model.Ingrediente;

public class IngredienteDao implements IIngredienteDao{

	private final EntityManager entityManager;
	
	public IngredienteDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Ingrediente> findAll() {
		return this.entityManager.createQuery("FROM ingrediente", Ingrediente.class).getResultList();
	}

	@Override
	public Ingrediente findById(Long id) {
		return this.entityManager.find(Ingrediente.class, id);
	}

	@Override
	public void persist(Ingrediente elemento) {
		this.entityManager.persist(elemento);
		
	}

	@Override
	public Ingrediente merge(Ingrediente elemento) {
		return this.entityManager.merge(elemento);
	}

	@Override
	public void remove(Ingrediente daCancellare) {
		this.entityManager.remove(daCancellare);
		
	}

}
