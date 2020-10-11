package rs.model.pom;

public class RacuniOsobe {
	private int id_racun, id_osoba, cena;
	private String ime;
	private int godiste;
	public int getId_racun() {
		return id_racun;
	}
	public void setId_racun(int id_racun) {
		this.id_racun = id_racun;
	}
	public int getId_osoba() {
		return id_osoba;
	}
	public void setId_osoba(int id_osoba) {
		this.id_osoba = id_osoba;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public int getGodiste() {
		return godiste;
	}
	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}
	public RacuniOsobe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RacuniOsobe(int id_racun, int id_osoba, int cena, String ime, int godiste) {
		super();
		this.id_racun = id_racun;
		this.id_osoba = id_osoba;
		this.cena = cena;
		this.ime = ime;
		this.godiste = godiste;
	}
	@Override
	public String toString() {
		return "RacuniOsobe [id_racun=" + id_racun + ", id_osoba=" + id_osoba + ", cena=" + cena + ", ime=" + ime
				+ ", godiste=" + godiste + "]";
	}
	
	
}
