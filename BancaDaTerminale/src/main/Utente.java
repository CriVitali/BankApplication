package main;

import java.util.ArrayList;

public class Utente {
	   
	public ArrayList<ContoCorrente> arrayConti = new ArrayList<ContoCorrente>();
	public String Nome;
	public int IDUtente;
	public String Password;
	public static int numeroUltimoUtente = 10000;
	public int count, i;
	
	public Utente(String Nome, String Password) {
		
		this.Nome = Nome;
		this.Password = Password;
		this.IDUtente = numeroUltimoUtente++;
		
	}
	
	public void aggiungiConto( ContoCorrente nuovoConto ) {
		
		arrayConti.add(nuovoConto);
	}
	
	public boolean validaPIN( String pass ) {
		
		if( Password.equals(pass) )			
			return true;
		else
			return false; 
	}
	
	public void mostraConti() {
		
		for (ContoCorrente i : arrayConti) {
			
		      System.out.println(i.IDConto);
		      System.out.println(i.saldo);
		}	
	}	
}

