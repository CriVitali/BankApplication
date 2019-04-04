package main;

import java.util.Scanner;
import java.util.ArrayList; 

public class Terminale {

	private ArrayList<Utente> arrayUtenti = new ArrayList<Utente>();
	private Utente utenteCorrente;
	private int IDUtenteCorrente;
	private int exitAdmin, exitClient, autorizzato, n;
	private String pass;
	
	
	public void mostraMenuAdmin() {
				
		System.out.println("... MENU ADMIN ...\n -> premi 1-4\n");
		
		while( exitAdmin == 0 ) {
			
			Scanner scan1 = new Scanner(System.in); 
			
			System.out.println(
					
					 " 1. Aggiungi utente\n"
					+ " 2. Aggiungi conto corrente\n"
					+ " 3. Apri menu cliente\n"
					+ " 4. Exit"
			);		
			
			int scelta = scan1.nextInt();
			
			switch(scelta) {
			   
				case 1:
				    
					Scanner scan2 = new Scanner(System.in);
					System.out.println("Nome nuovo cliente: ");					
					String Name = scan2.nextLine();
					System.out.println("Password: ");
					String Password = scan2.nextLine(); 
					
					arrayUtenti.add( new Utente( Name, Password ) );
					System.out.println("\nUtente inserito!\n\n");
					
				break;
				
				case 2:
			        
					Scanner scan3 = new Scanner(System.in);					
					System.out.println("\nScegliere l'utente (1-n): ");
					mostraUtenti();
					int n = scan3.nextInt();
					System.out.println("\nInserire saldo iniziale: ");
					float valore = scan3.nextFloat(); 
					
					arrayUtenti.get(n-1).aggiungiConto(new ContoCorrente( valore ));
					System.out.println("\nConto aggiunto!\n\n");
					
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
		
		System.out.println("\n\n... LOGIN CLIENTE ... ");
				
		Scanner scan4 = new Scanner(System.in);		
		System.out.println("\nInserisci Id utente: ");
		IDUtenteCorrente = scan4.nextInt();
		System.out.println("\nInserisci Password: ");
		Scanner scan5 = new Scanner(System.in);
		pass = scan5.nextLine();

		// ricerca utente, verifica identità, se supera l autenticazione 
		// fai scegliere il conto su cui operare (IDUContoScelto)
		for ( Utente i : arrayUtenti ) {
			
		      if( i.getIDUtente() == IDUtenteCorrente && i.validaPIN(pass)) {

		    		  autorizzato = 1;
		    		  System.out.println("\nAccesso Autorizzato!\n\n");	
		    		  System.out.println("Scegli il conto su cui operare (1-n): ");
		    		  i.mostraConti();	
		    		  Scanner scan6 = new Scanner(System.in);
		    		  n = scan6.nextInt();
		    		  n = n-1;
		    		  utenteCorrente = i;		    			
   
		      }        
		}
		
		if( autorizzato == 0) {
			
			System.out.println("\nAccesso non autorizzato");
			mostraMenuCliente();
			
		}
	
		while( exitClient == 0 && autorizzato == 1 ) {
			
			System.out.println("\n\n ... MENU CLIENTE ...\n  -> premi 1-5");
			System.out.println("Utente corrente: " + utenteCorrente.getNome() );
			System.out.println("Saldo: " + utenteCorrente.arrayConti.get(n).getSaldo());
			Scanner scan7 = new Scanner(System.in); 			
			System.out.println(
					
					"\n 1. Deposita\n"
					+ " 2. Ritira\n"
					+ " 3. Mostra Transazioni\n"
					+ " 4. Cambia Conto\n"  
					+ " 5. Exit"
			);		
			
			int scelta = scan7.nextInt();
			
			switch(scelta) {
			   
				case 1:
				    
					Scanner scan8 = new Scanner(System.in);			
					System.out.println("Inserisci valore da depositare: ");
					int valore1 = scan8.nextInt();
					utenteCorrente.arrayConti.get(n).deposita(valore1); 				
					
				break;
				
				case 2:
			
					Scanner scan9 = new Scanner(System.in);			
					System.out.println("Inserisci valore da ritirare: ");
					int valore2 = scan9.nextInt();
					utenteCorrente.arrayConti.get(n).ritira(valore2);
					
				break;					
			
				case 3:
					
					utenteCorrente.arrayConti.get(n).mostraTransazioni();
					
				break;
			
				case 4:
					
					// Visualizza conti, richiedi quale scegliere 1-n?

					utenteCorrente.mostraConti();  
		    		System.out.println("Scegli il conto su cui operare (1-n): ");
		    		Scanner scan10 = new Scanner(System.in);		
		    		n = scan10.nextInt();
		    		n = n-1;
		    		System.out.println("Hai scelto: " + utenteCorrente.arrayConti.get(n).getIDConto() );
		    			    		  
				break;
				
				case 5:
					
					exitClient = 1;
					
				break;
				
			} 
		} 
	} 
	
	public void mostraUtenti() {
		
		for( int i = 0; i < arrayUtenti.size(); i++ ) {
			
			System.out.println( (i+1)+ "-   ID:" + arrayUtenti.get(i).getIDUtente() + "  NOME:" + arrayUtenti.get(i).getNome());
			
		}
	}
	
} 
