package menegondiego;

public class Alimentari extends Prodotto {

	Data ds;

	public Alimentari(String cb, String desc, double pr, Data ds) {
		super(cb, desc, pr);
		this.ds = ds;
	}

	@Override
	public String toString() {
		return super.toString() + " ds= " + ds;
	}

	double scontaPrezzo(Data d) {
		if (ds.getDifference(d) < 10) {
			setPr(this.pr - ((this.pr / 100) * 20));
		} else {
			setPr(this.pr - ((this.pr / 100) * 5));
		}
		return pr;
	}

}
