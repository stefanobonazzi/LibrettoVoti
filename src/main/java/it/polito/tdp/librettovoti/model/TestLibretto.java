package it.polito.tdp.librettovoti.model;

public class TestLibretto {

	public static void main(String[] args) {

		Libretto lib = new Libretto();
		
		lib.add(new Voto("Analisi I", 26));
		lib.add(new Voto("Fisica I", 22));
		lib.add(new Voto("Analisi II", 25));
		lib.add(new Voto("Fisica II", 22));	
		lib.add(new Voto("Informatica", 25));
		lib.add(new Voto("TDP", 30));
		lib.add(new Voto("PWR", 27));
		lib.add(new Voto("Economia", 28));
		lib.add(new Voto("Diritto", 30));
		lib.add(new Voto("Chimica", 29));
		
		System.out.println("Verifica punto 1:");
		System.out.println(lib);
		
		System.out.println("\nVerifica punto 2:");
		Libretto lib25 = lib.filtraPunti(25);
		System.out.println(lib25);
		
		System.out.println("\nVerifica punto 3:");
		int i = lib.puntiEsame("Analisi I");
		System.out.println(i);
		
		System.out.println("\nVerifica punto 4:");
		boolean verifica = lib.isDuplicato(new Voto("Analisi I", 26));
		System.out.println(verifica);

		System.out.println("\nVerifica punto 5:");
		boolean verifica1 = lib.isConflitto(new Voto("Analisi I", 25));
		System.out.println(verifica1);
		
		System.out.println("\nVerifica punto 6:");
		lib.add(new Voto("Analisi I", 26));
		System.out.println(lib);
		
		System.out.println("\nVerifica punto 7:");
		Libretto lib1 = lib.miglioraLibretto();
		System.out.println(lib);
		System.out.println(lib1);
		
		System.out.println("\nVerifica punto 8:");
		Libretto lib2 = lib.ordineAlfabetico();
		System.out.println(lib2);
		Libretto lib3 = lib.ordineDiVoto();
		System.out.println(lib3);
		
		System.out.println("\nVerifica punto 9:");
		Libretto lib4 = lib.cancellaVotiMinodiDi(24);
		System.out.println(lib4);
		
	}

}
