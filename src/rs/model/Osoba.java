package rs.model;

public class Osoba {
	private String ime;
	private int godiste;
	private boolean isStudent;
	
	public Osoba(String ime, int godiste, boolean isStudent) {
		super();
		this.ime = ime;
		this.godiste = godiste;
		this.isStudent = isStudent;
	}
	public Osoba() {
		super();
		// TODO Auto-generated constructor stub
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
	public boolean isStudent() {
		return isStudent;
	}
	public void setStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}
	@Override
	public String toString() {
		return "Osoba [ime=" + ime + ", godiste=" + godiste + ", isStudent=" + isStudent + "]";
	}
	
	
}
