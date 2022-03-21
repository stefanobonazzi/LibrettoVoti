package it.polito.tdp.librettovoti.model;

import java.util.*;
import it.polito.tdp.librettovoti.db.LibrettoDAO;

public class Libretto {
	
	public Libretto() {
	}
	
	public boolean add(Voto v) {
		LibrettoDAO dao = new LibrettoDAO();
		boolean b = dao.createVoto(v);
		return b;
	}
	
	public List<Voto> getVoti() {
		LibrettoDAO dao = new LibrettoDAO();
		return dao.readAllVoto();
	}
	
}
