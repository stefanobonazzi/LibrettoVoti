package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {

	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}
	
	public boolean add(Voto v) {
		if(!this.isDuplicato(v) && !this.isConflitto(v)) {
			this.voti.add(v);
			return true;
		}
		
		return false;
	}

	/**
	 * Restituisce un libretto nuovo con i soli voti con cui si chiama
	 * il metodo.
	 * @param punti Punteggio che si vuole filtrare.
	 * @return Libretto 
	 */
	public Libretto filtraPunti(int punti) {
		Libretto l = new Libretto();
		
		for(Voto v: this.voti)
			if(v.getPunti() == punti)
				l.add(v);
		
		return l;
	}
	
	/**
	 * Restituisce il punteggio dell'esame di cui specifico il nome.
	 * @param nomeEsame nome dell'esame.
	 * @return punteggio numerico, oppure {@code null} se l'esame non esiste.
	 */
	public Integer puntiEsame(String nomeEsame) {
		for(Voto v: this.voti)
			if(v.getNome().compareTo(nomeEsame) == 0)
				return v.getPunti();
		
		//return -1;		//Per evitare che ci si dimentichi di controllare il valore di return ci proteggiamo in anticipo.
		return null;
		//throw new IllegalArgumentException("Corso non trovato");
	}
	
	public boolean isDuplicato(Voto v) {
		for(Voto v1: this.voti)
			if(v1.equals(v))
				return true;
		
		return false;
	}
	
	public boolean isConflitto(Voto v) {
		Integer punti = this.puntiEsame(v.getNome());
		if(punti != null && punti != v.getPunti())
			return true;
		
		return false;
	}
	
	public Libretto miglioraLibretto() {
		Libretto l = new Libretto();
		Voto prov = null;
		
		for(Voto v: this.voti) {
			if(v.getPunti() >= 18 && v.getPunti() <= 29)
				prov = new Voto(v.getNome(), v.getPunti()+1);
			if(v.getPunti() >= 24 && v.getPunti() <= 28)
				prov.setPunti(prov.getPunti()+1);
			if(v.getPunti() == 30)
				prov = new Voto(v.getNome(), v.getPunti());
			l.add(prov);
		}
		
		return l;
	}
	
	public Libretto ordineAlfabetico() {
		TreeMap<String, Voto> m = new TreeMap<String, Voto>();
		Libretto lib = new Libretto();
		
		for(Voto v: this.voti)
			m.put(v.getNome(), v);
		
		for(Voto v1: m.values())
			lib.add(v1);
		
		return lib;
	}
	
	public Libretto ordineDiVoto() {
		LinkedList<Voto> l = new LinkedList<Voto>(this.voti);
		Libretto lib = new Libretto();
		
		Collections.sort(l);
		for(Voto v: l)
			lib.add(v);
		
		return lib;
	}
	
	public Libretto cancellaVotiMinodiDi(int i) {
		Libretto lib = new Libretto();
		
		for(Voto v: this.voti)
			if(v.getPunti() >= 24)
				lib.add(v);
		
		return lib;
	}
	
	public List<Voto> getVoti() {
		return this.voti;
	}
	
	@Override
	public String toString() {
		return this.voti.toString();
	}
	
}
