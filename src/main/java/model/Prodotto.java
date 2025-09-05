package model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import util.TipoProdotto;

@Entity
@Table(name = "prodotto")
public class Prodotto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prodotto")
	private long id_prodotto;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "prezzo")
	private float prezzo;
	
	@Column(name = "tipo")
	private TipoProdotto tipo;
	
	@OneToMany(mappedBy = "prodotto")
	private Set<Ordine> ordini;
	
	@OneToMany(mappedBy = "prodotto")
	private Set<Ingrediente> ingredienti;
	
	

	public Prodotto() {
		super();
	}

	public Prodotto(String nome, String descrizione, float prezzo, TipoProdotto tipo, Set<Ordine> ordini, Set<Ingrediente> ingredienti) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.tipo = tipo;
		this.ordini = ordini;
		this.ingredienti = ingredienti;
	}

	public Prodotto(long id_prodotto, String nome, String descrizione, float prezzo, TipoProdotto tipo, Set<Ordine> ordini, Set<Ingrediente> ingredienti) {
		super();
		this.id_prodotto = id_prodotto;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.tipo = tipo;
		this.ordini = ordini;
		this.ingredienti = ingredienti;
	}

	public long getId_prodotto() {
		return id_prodotto;
	}

	public void setId_prodotto(long id_prodotto) {
		this.id_prodotto = id_prodotto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public TipoProdotto getTipo() {
		return tipo;
	}

	public void setTipo(TipoProdotto tipo) {
		this.tipo = tipo;
	}
	
	

	public Set<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(Set<Ordine> ordini) {
		this.ordini = ordini;
	}

	public Set<Ingrediente> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(Set<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}

	@Override
	public String toString() {
		return "Prodotto [id_prodotto=" + id_prodotto + ", nome=" + nome + ", descrizione=" + descrizione + ", prezzo="
				+ prezzo + ", tipo=" + tipo + "]";
	}
	
	
	
}
