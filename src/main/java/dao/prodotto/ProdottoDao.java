package dao.prodotto;

import java.util.List;

import jakarta.persistence.EntityManager;
import model.Prodotto;

public class ProdottoDao implements IProdottoDao{

	private final EntityManager entityManager;
	
	
	public ProdottoDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Prodotto> findAll() {
		return this.entityManager.createQuery("FROM prodotto", Prodotto.class).getResultList();
	}

	@Override
	public Prodotto findById(Long id) {
		return this.entityManager.find(Prodotto.class, id);
	}

	@Override
	public void persist(Prodotto elemento) {
		this.entityManager.persist(elemento);
		
	}

	@Override
	public Prodotto merge(Prodotto elemento) {
		return this.entityManager.merge(elemento);
	}

	@Override
	public void remove(Prodotto daCancellare) {
		this.entityManager.remove(daCancellare);
		
	}
	
	
	
}
