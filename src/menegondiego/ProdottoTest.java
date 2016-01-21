package menegondiego;

public class ProdottoTest {

	public static void main(String[] args) {
		Data da=new Data();
		Data d=new Data(17,1,2016);
		Alimentari p1= new Alimentari("111","pasta",1,d);
		NonAlimentari p2= new NonAlimentari("112","fogli",0.50,"carta");
		System.out.println(p1.toString());
		

		p1.scontaPrezzo(da);
		System.out.println(p1.toString());
		
		

		p2.scontaPrezzo();
		System.out.println(p2.toString());
	}

}
