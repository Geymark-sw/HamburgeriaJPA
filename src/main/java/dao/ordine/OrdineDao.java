package dao.ordine;

import java.util.List;

import jakarta.persistence.EntityManager;
import model.Ordine;

public class OrdineDao implements IOrdineDao{
	
	private final EntityManager entityManager;
	
	public OrdineDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Ordine> findAll() {
		return this.entityManager.createQuery("FROM ordine", Ordine.class).getResultList();
	}

	@Override
	public Ordine findById(Long id) {
		return this.entityManager.find(Ordine.class, id);
	}

	@Override
	public void persist(Ordine elemento) {
		this.entityManager.persist(elemento);
		
	}

	@Override
	public Ordine merge(Ordine elemento) {
		return this.entityManager.merge(elemento);
	}

	@Override
	public void remove(Ordine daCancellare) {
		this.entityManager.remove(daCancellare);
		
	}

}
