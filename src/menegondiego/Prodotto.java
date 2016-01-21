package menegondiego;

public class Prodotto {
	String cb;
	String desc;
	double pr;

	public String getCb() {
		return cb;
	}

	public void setCb(String cb) {
		this.cb = cb;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPr() {
		return pr;
	}

	public void setPr(double pr) {
		this.pr = pr;
	}

	public Prodotto(String cb, String desc, double pr) {
		super();
		this.cb = cb;
		this.desc = desc;
		this.pr = pr;
	}

	public Prodotto(Prodotto p) {
		this.cb = p.cb;
		this.desc = p.desc;
		this.pr = p.pr;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "Prodotto [cb=" + cb + ", desc=" + desc + ", pr=" + pr + "]";
	}
	
	double scontaPrezzo() {
		return pr;
	}

}
