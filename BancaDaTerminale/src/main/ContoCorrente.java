package main;

public class ContoCorrente {
	
	public int IDConto;
	public static int numeroUltimoConto = 1000;	
	public float saldo;
	public int[] transazioniUtente = new int[10];
	public int count, i;
	
	public ContoCorrente(float saldo) {
		
		this.saldo = saldo;
		IDConto = numeroUltimoConto++;
		
	}
	
	public void deposita( int valore ) {
		
		this.saldo += valore;
		transazioniUtente[count++] = valore;
	}
	
	public void ritira( int valore ) {
		
		if( saldo >= valore ) {
			
			this.saldo -= valore;
			transazioniUtente[count++] = -valore;
			
		}else{
			
			System.out.println("Non hai abbastanza credito");
		}
	}
    
	public void mostraSaldo() {
		
		System.out.println("Il saldo disponibile è: " + saldo );
	}
	
	public void mostraTransazioni() {
		
		for( i = 0; i < transazioniUtente.length; i++ ) {
			
			System.out.println( i+1 +"° transazione: " +  transazioniUtente[i]);
			
		}	
	}
}

