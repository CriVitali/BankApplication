package main;

import java.util.ArrayList;

public class ContoCorrente {
	
	public int IDConto;
	public static int numeroUltimoConto = 1000;	
	public float saldo;
	public ArrayList<Integer> transazioniUtente = new ArrayList<Integer>();
	public int count;
	
	public ContoCorrente(float saldo) {
		
		this.saldo = saldo;
		IDConto = numeroUltimoConto++;
		
	}
	
	public void deposita( int valore ) {
		
		this.saldo += valore;
		transazioniUtente.add(valore);
	}
	
	public void ritira( int valore ) {
		
		if( saldo >= valore ) {
			
			this.saldo -= valore;
			transazioniUtente.add(-valore);
			
		}else{
			
			System.out.println("Non hai abbastanza credito");
		}
	}
    
	public void mostraSaldo() {
		
		System.out.println("Il saldo disponibile è: " + saldo );
	}
	
	public void mostraTransazioni() {
		
		for( int i = 0; i < transazioniUtente.size(); i++ ) {
			
			System.out.println( i+1 +"° transazione: " +  transazioniUtente.get(i));
			
		}			
	}
}

