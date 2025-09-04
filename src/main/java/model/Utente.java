package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import util.Ruolo;

@Entity
@Table(name = "utente")
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utente")
	private long id_utente;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "ruolo")
	private Ruolo ruolo;
	
	
	public Utente(long id_utente, String nome, String cognome, String email, String password, Ruolo ruolo) {
		super();
		this.id_utente = id_utente;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.ruolo = ruolo;
	}


	public long getId_utente() {
		return id_utente;
	}


	public void setId_utente(long id_utente) {
		this.id_utente = id_utente;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Ruolo getRuolo() {
		return ruolo;
	}


	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}


	@Override
	public String toString() {
		return "Utente [id_utente=" + id_utente + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email
				+ ", password=" + password + ", ruolo=" + ruolo + "]";
	}
	
	

}
