package menegondiego;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.List;

public class ListaSpesa {
	private Prodotto lista[];
	private int numPr=0;
	private int maxPr=100;
	private boolean tf;
	
	public ListaSpesa(boolean tf){
		numPr=0;
		maxPr=100;
		this.tf=tf;
		lista = new Prodotto[this.maxPr];
	}
	
	public void AggiungiProdotto(Prodotto p,boolean tf) throws java.lang.Exception{
		if(numPr<maxPr){
			if(tf){
				p.scontaPrezzo();
			}
			lista[numPr]=p;
			numPr++;
		}else{
			throw Exception("La lista è piena");
		}
	}
	public void eliminaProdotto(int pos){
		for(int i=pos; i<100; i++){
			lista[i]=lista[i++];
		} numPr--;
	}

    private Exception Exception(String string) {
		System.out.println(string);
		return null;
	}
    
    public double CalcolaSpesa(){
    	double tot=0;
    	int i;
    	for(i=0;i<numPr;i++){
    		tot=tot+this.lista[i].getPr();
    	}
    	System.out.println("Il prezzo è "+tot);
    	return tot;
    }
    
    public void salvaScontrino(List l){
    	int i=0;
    	String message;
    	//scrittura sul file
    	BufferedWriter fWrite;
    	try {
    		fWrite=new BufferedWriter(new FileWriter("carrello.txt")); //, true per APPEND
    		for(i=0;i<l.getItemCount();i++){
    		message = l.getItem(i);
    		fWrite.write(message);
    		fWrite.newLine();
    		}
    		fWrite.close();
    	} catch (IOException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}
    }
}
