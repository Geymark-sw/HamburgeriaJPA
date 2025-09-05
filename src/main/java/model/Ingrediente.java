package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	public Ingrediente() {
		
	}

	public Ingrediente(String nome, boolean disponibile) {
		super();
		this.nome = nome;
		this.disponibile = disponibile;
	}

	public Ingrediente(Long id_ingrediente, String nome, boolean disponibile) {
		super();
		this.id_ingrediente = id_ingrediente;
		this.nome = nome;
		this.disponibile = disponibile;
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

	@Override
	public String toString() {
		return "Ingrediente [nome=" + nome + ", disponibile=" + disponibile + "]";
	}
	
	

}
