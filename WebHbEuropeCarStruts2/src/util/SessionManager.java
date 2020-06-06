package util;

import model.session.Utente;

public class SessionManager {
	private static SessionManager instance;
	
	private Utente utente;
	
	
	private SessionManager() {
		
	}	
	
	public static SessionManager getInstance() {
		if(instance==null)
			instance = new SessionManager();
		
		return instance;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	
	

}
