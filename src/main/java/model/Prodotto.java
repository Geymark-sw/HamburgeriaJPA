package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import util.Tipo;

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
	private Tipo tipo;
	
}
