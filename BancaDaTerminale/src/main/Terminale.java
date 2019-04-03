package main;

import java.util.Scanner;
import java.util.ArrayList; 

public class Terminale {

	public ArrayList<Utente> arrayUtenti = new ArrayList<Utente>();
	public int IDUtenteCorrente;
	public int IDUContoScelto;	
	public int scelta, exitAdmin, exitClient, count;
	
	
	public void mostraMenuAdmin() {
		
		while( exitAdmin == 0 ) {
			
			Scanner myObj1 = new Scanner(System.in); 
			
			System.out.println(
					
					 "1. Aggiungi utente\n"
					+ "2. Aggiungi conto corrente\n"
					+ "3. Apri menu cliente\n"
					+ "4. Exit"
			);		
			
			int scelta = myObj1.nextInt();
			
			switch(scelta) {
			   
				case 1:
				    
					Scanner myObj2 = new Scanner(System.in);
					System.out.println("Enter Name and Password: ");					
					String Name = myObj2.nextLine();
					String Password = myObj2.nextLine(); 
					
					arrayUtenti.add( new Utente( Name, Password ) );
					
				break;
				
				case 2:
			        
					Scanner myObj3 = new Scanner(System.in);
					mostraUtenti();
					System.out.println("Scegliere l'utente (1-n): ");
					int n = myObj3.nextInt();
					System.out.println("Inserire saldo iniziale: ");
					float valore = myObj3.nextFloat(); 
					
					arrayUtenti.get(n).aggiungiConto(new ContoCorrente( valore ));
					
				break;
					
				case 3:
					
					mostraMenuCliente();
					
		 		break;
			
				case 4:
					
					exitAdmin = 1;
					
				break;
			
			} 
		}
	} 
	
	
	public void mostraMenuCliente() {
		
		Scanner myObj0 = new Scanner(System.in);		
		System.out.println("Inserisci Id utente: ");
		IDUtenteCorrente = myObj0.nextInt();
		System.out.println("Inserisci Password: ");
		String password = myObj0.nextLine();
		// valida utente, se supera l autenticazione allora prosegui
		// fai scegliere il conto su cui operare (IDUContoScelto)
		
		while( exitClient == 1 ) {
			
			Scanner myObj1 = new Scanner(System.in); 			
			System.out.println(
					
					"1. Deposita\n"
					+ "2. Ritira\n"
					+ "3. Mostra Saldo\n"
					+ "4. Mostra Transazioni\n"
					+ "5. Cambia Conto"  // scegli n-esimo conto. conti[n]
					+ "6. Exit"
			);		
			
			int scelta = myObj1.nextInt();
			
			switch(scelta) {
			   
				case 1:
				    
					Scanner myObj2 = new Scanner(System.in);			
					System.out.println("Inserisci valore da depositare");
					int valore1 = myObj2.nextInt();		
					//(conto di utente autenticato).deposita(valore)
					
				break;
				
				case 2:
			
					Scanner myObj3 = new Scanner(System.in);			
					System.out.println("Inserisci valore da ritirare: ");
					int valore2 = myObj3.nextInt();
					//(conto di utente autenticato).ritira(valore)
					
				break;
					
				case 3:
					//(conto di utente autenticato).mostraSaldo()
				break;
				
				case 4:
					//(conto di utente autenticato).mostraTransazioni()
				break;
			
				case 5:
					// Visualizza conti, richiedi quale scegliere 1-n?
					// il conto su cui operare sara' arrayConti[n]
				break;
				
				case 6:
					exitClient = 1;
				break;
				
			} 
		} 
	} 
	
	public void mostraUtenti() {
		
		for( int i = 0; i < arrayUtenti.size(); i++ ) {
			
			System.out.println( "Utente " + i + ": " + arrayUtenti.get(i).IDUtente + " " + arrayUtenti.get(i).Nome);
			
		}
	}
	
} 
