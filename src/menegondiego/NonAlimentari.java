package menegondiego;

public class NonAlimentari extends Prodotto {
	String m;
	public NonAlimentari(String cb, String desc, double pr, String m) {
		super(cb, desc, pr);
		this.m = m;
	}
	@Override
	public String toString() {
		return super.toString()+", m=" + m + "]";
	}
	
	double scontaPrezzo (){
		if(m.equals("vetro")||m.equals("carta")||m.equals("plastica")){
			setPr(this.pr-((this.pr/100)*10));
		}else{
			setPr(this.pr-((this.pr/100)*5));
		}
		return this.pr;
	}
	
	
}
