import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import menegondiego.Alimentari;
import menegondiego.Data;
import menegondiego.ListaSpesa;
import menegondiego.NonAlimentari;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ListaSpesaGrafica {

	protected Shell shell;
	private Text cod;
	private Text pro;
	private Text pre;
	private Text g;
	private Text m;
	private Text a;
	private Text mat;
	boolean nalimentare=false;
	boolean alimentare = false;
	Alimentari p;
	NonAlimentari p1;
	String cb;
	String desc;
	double prezzo;
	boolean tf=true;
	String ma;
	ListaSpesa ls = new ListaSpesa(tf);
	private Text tot;
	
	

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
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		cod = new Text(shell, SWT.BORDER);
		cod.setBounds(10, 36, 100, 21);
		
		Label lblCodiceProdotto = new Label(shell, SWT.NONE);
		lblCodiceProdotto.setBounds(10, 15, 100, 15);
		lblCodiceProdotto.setText("Codice prodotto");
		
		pro = new Text(shell, SWT.BORDER);
		pro.setBounds(166, 36, 76, 21);
		
		Label lblProdotto = new Label(shell, SWT.NONE);
		lblProdotto.setBounds(166, 15, 55, 15);
		lblProdotto.setText("Prodotto");
		
		pre = new Text(shell, SWT.BORDER);
		pre.setBounds(310, 36, 76, 21);
		
		Label lblPrezzo = new Label(shell, SWT.NONE);
		lblPrezzo.setBounds(309, 15, 55, 15);
		lblPrezzo.setText("Prezzo");
		
		Button btnAlimentare = new Button(shell, SWT.RADIO);
		btnAlimentare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				 nalimentare=false;
				 alimentare = true;
			}
		});
		btnAlimentare.setBounds(10, 87, 90, 16);
		btnAlimentare.setText("Alimentare");
		
		Button btnNonAlimentare = new Button(shell, SWT.RADIO);
		btnNonAlimentare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				 nalimentare=true;
				 alimentare = false;
			}
		});
		btnNonAlimentare.setBounds(10, 116, 100, 16);
		btnNonAlimentare.setText("Non alimentare");
		
		Button btnTesseraFedelt = new Button(shell, SWT.CHECK);
		btnTesseraFedelt.setBounds(10, 152, 103, 16);
		btnTesseraFedelt.setText("Tessera Fedelt\u00E0");
		
		Button btnAggiungiProdotto = new Button(shell, SWT.NONE);
		btnAggiungiProdotto.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(alimentare==true){
					cb=cod.getText();
					desc=pro.getText();
					prezzo=Double.valueOf(pre.getText());
					Data d=new Data(Integer.valueOf(g.getText()),Integer.valueOf(m.getText()),Integer.valueOf(a.getText()));
					p=new Alimentari(cb,desc,prezzo,d);
					try {
						ls.AggiungiProdotto(p);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				if(nalimentare==true){
					cb=cod.getText();
					desc=pro.getText();
					prezzo=Double.valueOf(pre.getText());
					ma=mat.getText();
					p1=new NonAlimentari(cb,desc,prezzo,ma);
					try {
						ls.AggiungiProdotto(p1);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnAggiungiProdotto.setBounds(10, 195, 118, 25);
		btnAggiungiProdotto.setText("Aggiungi Prodotto");
		
		g = new Text(shell, SWT.BORDER);
		g.setBounds(166, 87, 29, 21);
		
		m = new Text(shell, SWT.BORDER);
		m.setBounds(222, 87, 29, 21);
		
		a = new Text(shell, SWT.BORDER);
		a.setBounds(293, 87, 49, 21);
		
		Label lblG = new Label(shell, SWT.NONE);
		lblG.setBounds(144, 88, 16, 15);
		lblG.setText("G");
		
		Label lblM = new Label(shell, SWT.NONE);
		lblM.setText("M");
		lblM.setBounds(205, 88, 16, 15);
		
		Label lblA = new Label(shell, SWT.NONE);
		lblA.setText("A");
		lblA.setBounds(275, 88, 16, 15);
		
		mat = new Text(shell, SWT.BORDER);
		mat.setBounds(205, 114, 76, 21);
		
		Label lblMateriale = new Label(shell, SWT.NONE);
		lblMateriale.setBounds(144, 117, 55, 15);
		lblMateriale.setText("Materiale");
		
		Button btnCalcolaTotale = new Button(shell, SWT.NONE);
		btnCalcolaTotale.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tot.setText(""+ls.CalcolaSpesa());
			}
		});
		btnCalcolaTotale.setBounds(166, 195, 85, 25);
		btnCalcolaTotale.setText("Calcola totale");
		
		tot = new Text(shell, SWT.BORDER);
		tot.setBounds(310, 195, 76, 21);
		
		Label lblTot = new Label(shell, SWT.NONE);
		lblTot.setBounds(275, 200, 29, 15);
		lblTot.setText("TOT");

	}
}
