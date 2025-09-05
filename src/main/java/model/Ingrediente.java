package model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingrediente")
public class Ingrediente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ingrediente")
	private Long id_ingrediente;
	
	@Column(name = "nome")
	String nome;
	
	@Column(name = "disponibile")
	boolean disponibile;
	
	@OneToMany(mappedBy = "ingrediente")
	private Set<Prodotto> prodotti;
	
	public Ingrediente() {
		
	}

	public Ingrediente(String nome, boolean disponibile, Set<Prodotto> prodotti) {
		super();
		this.nome = nome;
		this.disponibile = disponibile;
		this.prodotti = prodotti;
	}

	public Ingrediente(Long id_ingrediente, String nome, boolean disponibile, Set<Prodotto> prodotti) {
		super();
		this.id_ingrediente = id_ingrediente;
		this.nome = nome;
		this.disponibile = disponibile;
		this.prodotti = prodotti;
	}

	public Long getId_ingrediente() {
		return id_ingrediente;
	}

	public void setId_ingrediente(Long id_ingrediente) {
		this.id_ingrediente = id_ingrediente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isDisponibile() {
		return disponibile;
	}

	public void setDisponibile(boolean disponibile) {
		this.disponibile = disponibile;
	}
	
	

	public Set<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(Set<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	@Override
	public String toString() {
		return "Ingrediente [nome=" + nome + ", disponibile=" + disponibile + "]";
	}
	
	

}
