package main;

import java.util.ArrayList;

public class ContoCorrente {
	
	private int IDConto;
	public static int numeroUltimoConto = 1000;	
	private float saldo;
	private ArrayList<Integer> transazioniUtente = new ArrayList<Integer>();
	
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
    	
	public void mostraTransazioni() {
		
		for( int i = 0; i < transazioniUtente.size(); i++ ) {
			
			System.out.println("Transaz. "+ (i+1) + ": " + transazioniUtente.get(i));
			
		}	
		System.out.println("\n\n");
	}
	
	public int getIDConto() {
		
		return IDConto;
		
	}	
	
	public float getSaldo() {
		
		return saldo;
	}
}

