package main;

public class Utente {
	   
	public ContoCorrente[] arrayConti = new ContoCorrente[5];
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
		
		arrayConti[count++] = nuovoConto;
	}
	
	public boolean validaPIN( String pass ) {
		
		if( Password.equals(pass) )			
			return true;
		else
			return false; 
	}
	
	public void mostraConti() {
		
		while( arrayConti[i] != null ) {
			
			System.out.println( "Id " + (i+1) + "° conto: " + arrayConti[i++].IDConto );
		}	
	}	
}

