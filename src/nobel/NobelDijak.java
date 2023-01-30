package nobel;

public class NobelDijak {

	private int ev;
	private String dijTipus;
	private String kersztNev;
	private String vezetekNev;

	public NobelDijak(int ev, String dijTipus, String kersztNev, String vezetekNev) {
		this.ev = ev;
		this.dijTipus = dijTipus;
		this.kersztNev = kersztNev;
		this.vezetekNev = vezetekNev;
	}

	public int getEv() {
		return ev;
	}

	public void setEv(int ev) {
		this.ev = ev;
	}

	public String getDijTipus() {
		return dijTipus;
	}

	public void setDijTipus(String dijTipus) {
		this.dijTipus = dijTipus;
	}

	public String getKersztNev() {
		return kersztNev;
	}

	public void setKersztNev(String kersztNev) {
		this.kersztNev = kersztNev;
	}

	public String getVezetekNev() {
		return vezetekNev;
	}

	public void setVezetekNev(String vezetekNev) {
		this.vezetekNev = vezetekNev;
	}

	@Override
	public String toString() {
		return "Díjazás éve: " + this.ev + ", díj típusa: " + this.dijTipus + ", keresztnév: " + this.kersztNev
				+ ", vezetéknév: " + this.vezetekNev;
	}

}
