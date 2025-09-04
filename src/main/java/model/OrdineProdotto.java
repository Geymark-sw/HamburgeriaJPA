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
@Table(name = "ordine_prodotto")
public class OrdineProdotto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ordine_prodotto")
	private long id_ordine_prodotto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ordine")
	private Ordine ordine;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_prodotto")
	private Prodotto prodotto;
	
	@Column(name = "quantita_prodotto")
	private int quantita_prodotto;

	public long getId_ordine_prodotto() {
		return id_ordine_prodotto;
	}

	public void setId_ordine_prodotto(long id_ordine_prodotto) {
		this.id_ordine_prodotto = id_ordine_prodotto;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	public int getQuantita_prodotto() {
		return quantita_prodotto;
	}

	public void setQuantita_prodotto(int quantita_prodotto) {
		this.quantita_prodotto = quantita_prodotto;
	}

	@Override
	public String toString() {
		return "OrdineProdotto [id_ordine_prodotto=" + id_ordine_prodotto + ", ordine=" + ordine + ", prodotto="
				+ prodotto + ", quantita_prodotto=" + quantita_prodotto + "]";
	}
	
	
	
}
