package demo009.misc;

import demo009.ApplicationContext;
import demo009.model.Lager;
import demo009.model.Niederlassung;
import demo009.model.Warenart;

public class DisplayService {

	public static void anzeigenNiederlassungen(ApplicationContext context) {
		
		System.out.println("======= Niederlassungen");
		System.out.println("Ort 	Warenart 	Status Anforderung 	gesendete Fuhrwerke\tArbeiter");
		for(int i = 0; i < context.getNiederlassungen().size(); i++) {
			Niederlassung nl = context.getNiederlassungen().get(i);											
			
			int anzahlGeplanteFuhrwerke = nl.wurdeAngefordert()==true?context.getGeplanteFuhrwerke().get(nl):0;
			// Anzahl Fuhrwerke wird wenn Transport angefordert wurde auf geforderte Menge gesetzt, sonst auf 0
			
			if(nl.wurdeAngefordert() == true) {		// Produktion angefordert?
				System.out.println(nl.getOrt() + "\t"+ nl.getWarenartString() + "\t\t" + (nl.wurdeAngefordert()?"angefordert":"nicht angefordert")
						+ "\t\t\t\t" + anzahlGeplanteFuhrwerke + "\t" + nl.getArbeiter());
			}
			else {
				System.out.println(nl.getOrt() + "\t"+ nl.getWarenartString() + "\t\t" + (nl.wurdeAngefordert()?"angefordert":"nicht angefordert")
						+ "\t\t\t" + anzahlGeplanteFuhrwerke + "\t" + nl.getArbeiter());	// ein \t weniger aus optischen Gründen (bei Ausgabe Niederlassungen)
			}
			
			
		}
		System.out.println("============================");
	}
	
	public static void anzeigenLager(ApplicationContext context) {
		
		System.out.println("======= Lagerbestand");
		Lager l = context.getLager();
		for(Warenart wa: l.getEingelagerteWaren()) {							// for each Warenart, die gerade mit einer Menge > 0 im Lager eingelagert sind
			System.out.println(wa.toString() + ": " + l.getBestand(wa));		// Anzahl der Wareneinheiten, die im Lager von der jeweiligen Warenart vorhanden sind
		}
		System.out.println("============================");
	}
	
	public static void anzeigenGuthaben(ApplicationContext context) {
		
		System.out.println("======= Finanzen");
		System.out.println("Guthaben (in Talern): " + context.getGuthaben());
		System.out.println("============================");
	}
	
}
