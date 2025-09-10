package util;

import dao.ingrediente.IIngredienteDao;
import dao.ingrediente.IngredienteDao;
import dao.ordine.IOrdineDao;
import dao.ordine.OrdineDao;
import dao.ordineProdotto.IOrdineProdottoDao;
import dao.ordineProdotto.OrdineProdottoDao;
import dao.prodotto.IProdottoDao;
import dao.prodotto.ProdottoDao;
import dao.prodottoIngrediente.IProdottoIngredienteDao;
import dao.prodottoIngrediente.ProdottoIngredienteDao;
import dao.utente.IUtenteDao;
import dao.utente.UtenteDao;
import jakarta.persistence.EntityManager;
import service.ingrediente.IIngredienteService;
import service.ingrediente.IngredienteService;
import service.ordine.IOrdineService;
import service.ordine.OrdineService;
import service.ordineProdotto.IOrdineProdottoService;
import service.ordineProdotto.OrdineProdottoService;
import service.prodotto.IProdottoService;
import service.prodotto.ProdottoService;
import service.prodottoIngrediente.IProdottoIngredienteService;
import service.prodottoIngrediente.ProdottoIngredienteService;
import service.utente.IUtenteService;
import service.utente.UtenteService;

public class SingletonsFactory {

	// Singleton Entity manager
	private static EntityManager entityManager;

	// Singleton dei DAO
	private static IUtenteDao utenteDao;
	private static IProdottoDao prodottoDao;
	private static IOrdineDao ordineDao;
	private static IIngredienteDao ingredienteDao;
	private static IProdottoIngredienteDao prodottoIngredienteDao;
	private static IOrdineProdottoDao ordineProdottoDao;
	
	// Singleton dei Service
	private static IUtenteService utenteService;
	private static IProdottoService prodottoService;
	private static IOrdineService ordineService;
	private static IIngredienteService ingredienteService;
	private static IProdottoIngredienteService prodottoIngredienteService;
	private static IOrdineProdottoService ordineProdottoService;
	

	//Metodo getEntityManager
	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = JPAUtil.getEntityManager();
		}
		return entityManager;
	}

	//Metodi getDao
	
	public static IUtenteDao getUtenteDao() {
		if (utenteDao == null) {
			utenteDao = new UtenteDao(getEntityManager());
		}
		return utenteDao;
	}

	public static IProdottoDao getProdottoDao() {
		if (prodottoDao == null) {
			prodottoDao = new ProdottoDao(getEntityManager());
		}
		return prodottoDao;
	}

	public static IOrdineDao getOrdineDao() {
		if (ordineDao == null) {
			ordineDao = new OrdineDao(getEntityManager());
		}
		return ordineDao;
	}

	public static IIngredienteDao getIngredienteDao() {
		if (ingredienteDao == null) {
			ingredienteDao = new IngredienteDao(getEntityManager());
		}
		return ingredienteDao;
	}

	public static IProdottoIngredienteDao getProdottoIngredienteDao() {
		if (prodottoIngredienteDao == null) {
			prodottoIngredienteDao = new ProdottoIngredienteDao(getEntityManager());
		}
		return prodottoIngredienteDao;
	}
	
	public static IOrdineProdottoDao getOrdineProdottoDao() {
		if(ordineProdottoDao == null) {
			ordineProdottoDao = new OrdineProdottoDao(getEntityManager());
		}
		return ordineProdottoDao;
	}
	
	//Metodi getService
	
	public static IUtenteService getUtenteService() {
		if (utenteService == null) {
			utenteService = new UtenteService(getEntityManager(),getUtenteDao());
		}
		return utenteService;
	}

	public static IProdottoService getProdottoService() {
		if (prodottoService == null) {
			prodottoService = new ProdottoService(getEntityManager(),getProdottoDao());
		}
		return prodottoService;
	}

	public static IOrdineService getOrdineService() {
		if (ordineService == null) {
			ordineService = new OrdineService(getEntityManager(),getOrdineDao());
		}
		return ordineService;
	}

	public static IIngredienteService getIngredienteService() {
		if (ingredienteService == null) {
			ingredienteService = new IngredienteService(getEntityManager(),getIngredienteDao());
		}
		return ingredienteService;
	}

	public static IProdottoIngredienteService geProdottoIngredienteService() {
		if (prodottoIngredienteService == null) {
			prodottoIngredienteService = new ProdottoIngredienteService(getEntityManager(),getProdottoIngredienteDao());
		}
		return prodottoIngredienteService;
	}
	
	public static IOrdineProdottoService getOrdineProdottoService() {
		if(ordineProdottoService == null) {
			ordineProdottoService = new OrdineProdottoService(getEntityManager(),getOrdineProdottoDao());
		}
		return ordineProdottoService;
	}
}
