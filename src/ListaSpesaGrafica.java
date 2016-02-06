import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import menegondiego.Alimentari;
import menegondiego.Data;
import menegondiego.ListaSpesa;
import menegondiego.NonAlimentari;

import org.eclipse.swt.widgets.Text;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.events.TouchListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.events.TouchEvent;
import java.awt.Graphics;

public class ListaSpesaGrafica {

	protected Shell shell;
	private Text cod;
	private Text pro;
	private Text pre;
	private Text g;
	private Text m;
	private Text a;
	private Text mat;
	int n=9999999;
	boolean nalimentare=false;
	boolean alimentare = false;
	Alimentari p;
	NonAlimentari p1;
	String cb;
	String desc;
	double prezzo;
	boolean tf=false;
	String ma;
	ListaSpesa ls = new ListaSpesa(tf);
	private Text tot;
	int i;
	int pr=0;
	boolean c=false;
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ListaSpesaGrafica window = new ListaSpesaGrafica();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	String className = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	static{
		try{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e){}
		}
	
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(702, 332);
		shell.setText("SpesApp");
		Color green = new Color(null,218,253,218);
		shell.setBackground(green);
		
		cod = new Text(shell, SWT.BORDER);
		cod.setBounds(10, 36, 100, 21);
		
		Label lblCodiceProdotto = new Label(shell, SWT.NONE);
		lblCodiceProdotto.setBounds(10, 15, 100, 15);
		lblCodiceProdotto.setText("Codice prodotto");
		lblCodiceProdotto.setBackground(green);
		
		pro = new Text(shell, SWT.BORDER);
		pro.setBounds(166, 36, 76, 21);
		
		Label lblProdotto = new Label(shell, SWT.NONE);
		lblProdotto.setBounds(166, 15, 55, 15);
		lblProdotto.setText("Prodotto");
		lblProdotto.setBackground(green);
		
		pre = new Text(shell, SWT.BORDER);
		pre.setBounds(310, 36, 76, 21);
		
		Label lblPrezzo = new Label(shell, SWT.NONE);
		lblPrezzo.setBounds(309, 15, 55, 15);
		lblPrezzo.setText("Prezzo");
		lblPrezzo.setBackground(green);
		
		Label lblG = new Label(shell, SWT.NONE);
		lblG.setBounds(149, 88, 8, 15);
		lblG.setText("G");
		lblG.setBackground(green);
		
		Label lblM = new Label(shell, SWT.NONE);
		lblM.setText("M");
		lblM.setBounds(205, 88, 16, 15);
		lblM.setBackground(green);
		
		Label lblA = new Label(shell, SWT.NONE);
		lblA.setText("A");
		lblA.setBounds(275, 88, 16, 15);
		lblA.setBackground(green);
		
		Label lblMateriale = new Label(shell, SWT.NONE);
		lblMateriale.setBounds(144, 117, 55, 15);
		lblMateriale.setText("Materiale");
		lblMateriale.setBackground(green);
		
		Button btnAlimentare = new Button(shell, SWT.RADIO);
		btnAlimentare.setBackground(green);
		btnAlimentare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				 nalimentare=false;
				 alimentare = true;
				 mat.setEnabled(false);
				 g.setEnabled(true);
				 m.setEnabled(true);
				 a.setEnabled(true);
				 lblA.setEnabled(true);
				 lblG.setEnabled(true);
				 lblM.setEnabled(true);
				 lblMateriale.setEnabled(false);
				 
				 
			}
		});
		btnAlimentare.setBounds(10, 87, 90, 16);
		btnAlimentare.setText("Alimentare");
		
		Button btnNonAlimentare = new Button(shell, SWT.RADIO);
		btnNonAlimentare.setBackground(green);
		btnNonAlimentare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				 nalimentare=true;
				 alimentare = false;
				 mat.setEnabled(true);
				 g.setEnabled(false);
				 m.setEnabled(false);
				 a.setEnabled(false);
				 lblA.setEnabled(false);
				 lblG.setEnabled(false);
				 lblM.setEnabled(false);
				 lblMateriale.setEnabled(true);
				 
			}
		});
		btnNonAlimentare.setBounds(10, 116, 100, 16);
		btnNonAlimentare.setText("Non alimentare");
		
		int dialogButton = JOptionPane.showConfirmDialog (null, "Hai la tessera?","ATTENZIONE", JOptionPane.YES_NO_OPTION); 
        if(dialogButton == JOptionPane.NO_OPTION) {
        	System.out.println(dialogButton);
        	tf=false;
        }else{
        	System.out.println(dialogButton);
        	tf=true;
        }
        
		List list = new List(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				n=list.getSelectionIndex();
			}
		});
		list.setBounds(405, 10, 271, 273);
		
		Button btnAggiungiProdotto = new Button(shell, SWT.NONE);
		btnAggiungiProdotto.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(alimentare==true){
					System.out.println("Alimentare");
					System.out.println(tf);
					try {
						if(cod.getText().contains(" ")||pro.getText().contains(" ")){
							JOptionPane.showMessageDialog(null,"Dati non validi","Errore",JOptionPane.ERROR_MESSAGE);
						}else{
							cb=cod.getText();
							desc=pro.getText();
							prezzo=Double.valueOf(pre.getText());
							Data d=new Data(Integer.valueOf(g.getText()),Integer.valueOf(m.getText()),Integer.valueOf(a.getText()));
							p=new Alimentari(cb,desc,prezzo,d);
							ls.AggiungiProdotto(p,tf);
							list.add(p.toString());
							pr++;
							tot.setText(""+ls.CalcolaSpesa());
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"Dati non validi","Errore",JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
				}else{
					if(cod.getText().contains(" ")||pro.getText().contains(" ")||mat.getText().contains(" ")){
						JOptionPane.showMessageDialog(null,"Dati non validi","Errore",JOptionPane.ERROR_MESSAGE);
					}else{
						System.out.println("Nonalimentare");
						System.out.println(tf);
						try {
							cb=cod.getText();
							desc=pro.getText();
							prezzo=Double.valueOf(pre.getText());
							ma=mat.getText();
							if(ma.contains("1")||ma.contains("2")||ma.contains("3")||ma.contains("4")||ma.contains("5")||ma.contains("6")||ma.contains("7")||ma.contains("8")||ma.contains("9")||ma.contains("0")){
								JOptionPane.showMessageDialog(null,"Dati non validi","Errore",JOptionPane.ERROR_MESSAGE);
							}else{
								System.out.println(ma);
								if(ma.length()>0){
									p1=new NonAlimentari(cb,desc,prezzo,ma);
									ls.AggiungiProdotto(p1,tf);
									list.add(p1.toString());
									pr++;
								}else{
									JOptionPane.showMessageDialog(null,"Dati non validi","Errore",JOptionPane.ERROR_MESSAGE);
								}
							}
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null,"Dati non validi","Errore",JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}
					}    	
				}
			}
		});
		btnAggiungiProdotto.setBounds(10, 195, 118, 25);
		btnAggiungiProdotto.setText("Aggiungi Prodotto");
		
		g = new Text(shell, SWT.BORDER);
		g.setBounds(163, 85, 23, 21);
		
		m = new Text(shell, SWT.BORDER);
		m.setBounds(227, 85, 24, 21);
		
		a = new Text(shell, SWT.BORDER);
		a.setBounds(293, 87, 35, 21);
		
		
		mat = new Text(shell, SWT.BORDER);
		mat.setBounds(205, 114, 76, 21);
		
		
		
		Label tot = new Label(shell, SWT.NONE);
		tot.setBounds(310, 263, 76, 22);
		tot.setText("0.0");
		tot.setBackground(green);
		
		Button btnCalcolaTotale = new Button(shell, SWT.NONE);
		btnCalcolaTotale.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tot.setText(" " +ls.CalcolaSpesa());
			}
		});
		btnCalcolaTotale.setBounds(10, 258, 118, 25);
		btnCalcolaTotale.setText("Calcola totale");
		
		Label lblTot = new Label(shell, SWT.NONE);
		lblTot.setBounds(275, 263, 29, 15);
		lblTot.setText("TOT");
		lblTot.setBackground(green);
		
		Button btnEliminaProdotto = new Button(shell, SWT.NONE);
		btnEliminaProdotto.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
					if(n<=pr){
						System.out.println("sel");
						ls.eliminaProdotto(n);
						list.remove(n);
						n=n+99999;
					}else{
						System.out.println("ult");
						list.remove(pr-1);
						ls.eliminaProdotto(pr-1);
					}
					pr--;
				}catch(Exception c){
					JOptionPane.showMessageDialog(null,"Lista vuota","Errore",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnEliminaProdotto.setBounds(10, 227, 118, 25);
		btnEliminaProdotto.setText("Elimina Prodotto");
		
		Button btnSalvaCarrello = new Button(shell, SWT.NONE);
		btnSalvaCarrello.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
					
					ls.salvaScontrino(list);
					JOptionPane.showMessageDialog(null,"Hai salvato la tua lista","Salvataggio effettuato",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnSalvaCarrello.setBounds(167, 227, 84, 25);
		btnSalvaCarrello.setText("Salva carrello");
		
		Button svuota = new Button(shell, SWT.NONE);
		svuota.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				list.removeAll();
				ls=new ListaSpesa(tf);
				tot.setText(""+ls.CalcolaSpesa());
			}
		});
		svuota.setBounds(166, 258, 85, 25);
		svuota.setText("Svuota carrello");
		
		Button btnCaricaCarrello = new Button(shell, SWT.NONE);
		btnCaricaCarrello.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				list.removeAll();
				ls=new ListaSpesa(tf);
				ls.carica(list,shell);
				tot.setText(""+ls.CalcolaSpesa());
			}
		});
		btnCaricaCarrello.setBounds(166, 195, 85, 25);
		btnCaricaCarrello.setText("Carica carrello");
		
		

	}
}
