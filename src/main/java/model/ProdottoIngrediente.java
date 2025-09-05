package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prodotto_ingrediente")
public class ProdottoIngrediente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prodotto_ingrediente")
	private long id_prodotto_ingrediente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_prodotto")
	private Prodotto prodotto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ingrediente")
	private Ingrediente ingrediente;
	
	@Column(name = "quantita_ingrediente")
	private int quantita_ingrediente;
	
	

	public ProdottoIngrediente() {
		super();
	}

	public ProdottoIngrediente(Prodotto prodotto, Ingrediente ingrediente, int quantita_ingrediente) {
		super();
		this.prodotto = prodotto;
		this.ingrediente = ingrediente;
		this.quantita_ingrediente = quantita_ingrediente;
	}

	public ProdottoIngrediente(long id_prodotto_ingrediente, Prodotto prodotto, Ingrediente ingrediente,
			int quantita_ingrediente) {
		super();
		this.id_prodotto_ingrediente = id_prodotto_ingrediente;
		this.prodotto = prodotto;
		this.ingrediente = ingrediente;
		this.quantita_ingrediente = quantita_ingrediente;
	}

	public long getId_prodotto_ingrediente() {
		return id_prodotto_ingrediente;
	}

	public void setId_prodotto_ingrediente(long id_prodotto_ingrediente) {
		this.id_prodotto_ingrediente = id_prodotto_ingrediente;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public int getQuantita_ingrediente() {
		return quantita_ingrediente;
	}

	public void setQuantita_ingrediente(int quantita_ingrediente) {
		this.quantita_ingrediente = quantita_ingrediente;
	}
	
	

	@Override
	public String toString() {
		return "ProdottoIngrediente [id_prodotto_ingrediente=" + id_prodotto_ingrediente + ", prodotto=" + prodotto
				+ ", ingrediente=" + ingrediente + ", quantita_ingrediente=" + quantita_ingrediente + "]";
	}
	
	
}
