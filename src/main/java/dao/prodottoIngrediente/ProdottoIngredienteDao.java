package dao.prodottoIngrediente;

import java.util.List;

import jakarta.persistence.EntityManager;
import model.ProdottoIngrediente;

public class ProdottoIngredienteDao implements IProdottoIngredienteDao{
	
	private final EntityManager entityManager;
	
	public ProdottoIngredienteDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<ProdottoIngrediente> findAll() {
		return this.entityManager.createQuery("FROM prodotto_ingrediente", ProdottoIngrediente.class).getResultList();
	}

	@Override
	public ProdottoIngrediente findById(Long id) {
		return this.entityManager.find(ProdottoIngrediente.class, id);
	}

	@Override
	public void persist(ProdottoIngrediente elemento) {
		this.entityManager.persist(elemento);
		
	}

	@Override
	public ProdottoIngrediente merge(ProdottoIngrediente elemento) {
		return this.entityManager.merge(elemento);
	}

	@Override
	public void remove(ProdottoIngrediente daCancellare) {
		this.entityManager.remove(daCancellare);
		
	}

}
