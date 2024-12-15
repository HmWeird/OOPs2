package business;

public class Volkshochschulkurs {

	private String kursname;
	private float kursbeitrag;
	private String wochentag;
	private String startuhrzeit;
	private String[] vorkenntnisse;

	public Volkshochschulkurs(String kursname, float kursbeitrag, String wochentag, String startuhrzeit,
			String[] vorkenntnisse) {
		if(vorkenntnisse==null) {
			throw new IllegalArgumentException ("Vorkenntnisse duerfen nicht null sein.");
		}
		
		this.kursname = kursname;
		this.kursbeitrag = kursbeitrag;
		this.wochentag = wochentag;
		this.startuhrzeit = startuhrzeit;
		this.vorkenntnisse = vorkenntnisse;
	}

	// Getters and Setters
	public String getKursname() {
		return kursname;
	}

	public void setKursname(String kursname) {
		this.kursname = kursname;
	}

	public float getKursbeitrag() {
		return kursbeitrag;
	}

	public void setKursbeitrag(float kursbeitrag) {
		this.kursbeitrag = kursbeitrag;
	}

	public String getWochentag() {
		return wochentag;
	}

	public void setWochentag(String wochentag) {
		this.wochentag = wochentag;
	}

	public String getStartuhrzeit() {
		return startuhrzeit;
	}

	public void setStartuhrzeit(String startuhrzeit) {
		this.startuhrzeit = startuhrzeit;
	}

	public String[] getVorkenntnisse() {
		return vorkenntnisse;
	}

	public void setVorkenntnisse(String[] vorkenntnisse) {
		this.vorkenntnisse = vorkenntnisse;
	}

	// Utility Methods
	public String getVorkenntnisseAlsString(char trenner) {
		StringBuilder ergebnis = new StringBuilder();
		for (int i = 0; i < vorkenntnisse.length; i++) {
			ergebnis.append(vorkenntnisse[i]);
			if (i < vorkenntnisse.length - 1)
				ergebnis.append(trenner);
		}
		return ergebnis.toString();
	}

	public String gibKursDetailsZurueck(char trenner) {
		return kursname + trenner + kursbeitrag + trenner + wochentag + trenner + startuhrzeit + trenner
				+ getVorkenntnisseAlsString(trenner);
	}
}
