package menegondiego;

public class ListaSpesaTest {

	public static void main(String[] args) {
		ListaSpesa ls=new ListaSpesa(true);
		Data d=new Data(19,1,2016);
		Alimentari p1= new Alimentari("111","pasta",5,d);
		NonAlimentari p2= new NonAlimentari("112","fogli",2,"carta");
		try {
		
		} catch (Exception e) {
			
		}
		ls.CalcolaSpesa();
	}

}
