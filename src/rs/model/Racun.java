package rs.model;

public class Racun {
	private int id, id_osoba, cena;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public Racun(int id_osoba, int cena) {
		super();
		this.id_osoba = id_osoba;
		this.cena = cena;
	}


	public Racun() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Racun [id=" + id + ", id_osoba=" + id_osoba + ", cena=" + cena + "]";
	}
	
	
}
