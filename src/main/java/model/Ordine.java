package model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import util.StatoOrdine;

@Entity
@Table(name = "ordine")
public class Ordine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ordine")
	private long id_ordine;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_utente")
	private Utente utente;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "istante_ordine")
	private LocalDateTime istante_ordine;
	
	@Column(name = "stato_ordine")
	private StatoOrdine stato_ordine;
	
	@Column(name = "totale")
	private float totale;

	public Ordine(long id_ordine, Utente utente, LocalDateTime istante_ordine, StatoOrdine stato_ordine, float totale) {
		super();
		this.id_ordine = id_ordine;
		this.utente = utente;
		this.istante_ordine = istante_ordine;
		this.stato_ordine = stato_ordine;
		this.totale = totale;
	}

	public long getId_ordine() {
		return id_ordine;
	}

	public void setId_ordine(long id_ordine) {
		this.id_ordine = id_ordine;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public LocalDateTime getIstante_ordine() {
		return istante_ordine;
	}

	public void setIstante_ordine(LocalDateTime istante_ordine) {
		this.istante_ordine = istante_ordine;
	}

	public StatoOrdine getStato_ordine() {
		return stato_ordine;
	}

	public void setStato_ordine(StatoOrdine stato_ordine) {
		this.stato_ordine = stato_ordine;
	}

	public float getTotale() {
		return totale;
	}

	public void setTotale(float totale) {
		this.totale = totale;
	}

	@Override
	public String toString() {
		return "Ordine [id_ordine=" + id_ordine + ", utente=" + utente + ", istante_ordine=" + istante_ordine
				+ ", stato_ordine=" + stato_ordine + ", totale=" + totale + "]";
	}
	
	
	
}
