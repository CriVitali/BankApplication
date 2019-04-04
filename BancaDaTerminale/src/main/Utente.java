package main;

import java.util.ArrayList;

public class Utente {
	   
	public ArrayList<ContoCorrente> arrayConti = new ArrayList<ContoCorrente>();
	private String Nome;
	private int IDUtente;
	private String Password;
	public static int numeroUltimoUtente = 10000;
	
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
		
		for( int i = 0; i < arrayConti.size(); i++ ) {
			
			System.out.println( (i+1) + " - ID CONTO: " + arrayConti.get(i).getIDConto() + " SALDO: " + arrayConti.get(i).getSaldo());
			
		}
	}	
	
	public int getIDUtente(){
		
		return IDUtente;
		
	}
	
	public String getNome(){
		
		return Nome;
		
	}
}

