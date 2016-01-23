package menegondiego;

import java.util.GregorianCalendar;

public class Alimentari extends Prodotto {

	Data ds=new Data();

	public Alimentari(String cb, String desc, double pr, Data ds) {
		super(cb, desc, pr);
		this.ds = ds;
	}

	@Override
	public String toString() {
		return super.toString() + " ds= " + ds;
	}

	double scontaPrezzo() {
		if (ds.getDifference(new Data()) < 10) {
			super.setPr(getPr() * 80/100);
		} else {
			super.setPr(getPr() * 95/100);
		}
		return pr;
	}

}
