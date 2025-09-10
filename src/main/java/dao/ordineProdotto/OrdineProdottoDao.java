package dao.ordineProdotto;

import java.util.List;

import jakarta.persistence.EntityManager;
import model.OrdineProdotto;

public class OrdineProdottoDao implements IOrdineProdottoDao{
	
	private final EntityManager entityManager;
	
	public OrdineProdottoDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<OrdineProdotto> findAll() {
		return this.entityManager.createQuery("FROM ordine_prodotto", OrdineProdotto.class).getResultList();
	}

	@Override
	public OrdineProdotto findById(Long id) {
		return this.entityManager.find(OrdineProdotto.class, id);
	}

	@Override
	public void persist(OrdineProdotto elemento) {
		this.entityManager.persist(elemento);
	}

	@Override
	public OrdineProdotto merge(OrdineProdotto elemento) {
		return this.entityManager.merge(elemento);
	}

	@Override
	public void remove(OrdineProdotto daCancellare) {
		this.entityManager.remove(daCancellare);
		
	}

}
