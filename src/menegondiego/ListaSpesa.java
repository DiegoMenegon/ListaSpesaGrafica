package menegondiego;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

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
			throw Exception("La lista � piena");
		}
	}
	public void eliminaProdotto(int pos){
		for(int i=pos; i<numPr; i++){
			lista[i]=lista[i++];
		} 
		if(numPr>0){
			numPr--;
		}
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
    	System.out.println("Il prezzo � "+tot);
    	tot=Math.floor(tot*100);
    	return tot/100;
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
    
    public void carica(List l,Shell shell){
    	Alimentari p;
    	NonAlimentari p1;
    	BufferedReader lettore;
    	String riga = "";
    	String testo[];
    	String data[];
    	try {
    		FileDialog fileDialog = new FileDialog(shell);
			fileDialog.setFilterExtensions(new String[]{"*.txt", "*.csv", "*.*"}); //opzionale
			String fileScelto = fileDialog.open();

    		lettore = new BufferedReader(new FileReader(fileScelto));
    		riga = lettore.readLine();
    		 while (riga != null) {
    			
    			testo = riga.split(" ");
    			if(testo[3].contains("/")){
    				data=testo[3].split("/");
    				Data d=new Data(Integer.valueOf(data[0]),Integer.valueOf(data[1]),Integer.valueOf(data[2]));
    				p=new Alimentari(testo[0],testo[1],Double.valueOf(testo[2]),d);
    				lista[numPr]=p;
        			numPr++;
        			l.add(p.toString());
    			}else{
    				p1=new NonAlimentari(testo[0],testo[1],Double.valueOf(testo[2]),testo[3]);
    				lista[numPr]=p1;
        			numPr++;
        			l.add(p1.toString());
    			}
    			
    			riga = lettore.readLine();
    			
    		}
    		 JOptionPane.showMessageDialog(null,"Caricamento effettuato correttamente","Caricamento effettuato",JOptionPane.INFORMATION_MESSAGE);
    		
    	} catch (IOException e1) {
    		// TODO Auto-generated catch block
    		JOptionPane.showMessageDialog(null,"File non trovato","Errore",JOptionPane.ERROR_MESSAGE);
    		e1.printStackTrace();
    	}
    }
}
