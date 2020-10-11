package rs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import rs.model.Osoba;
import rs.model.pom.RacuniOsobe;

public class DAO {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Warframe!994");
	}

	
	public ArrayList<Osoba> getOsobe() throws ClassNotFoundException, SQLException {
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU
		ArrayList<Osoba> lista = new ArrayList<Osoba>();

		connect();
		preparedStatement = connect.prepareStatement("select * from osoba");

		// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
		//preparedStatement.setString(1, o.getJmbg());
		
		preparedStatement.execute();
		
		//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
		resultSet = preparedStatement.getResultSet();
		
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String ime = resultSet.getString("ime");
			int godiste = resultSet.getInt("godiste");

			Osoba o = new Osoba(ime, godiste, false);

			lista.add(o);
		}
		//****KRAJ		KRAJ OBRADE ResultSet-a	
		
		close();
		return lista;
	}

	public void insertOsoba(Osoba o) throws ClassNotFoundException, SQLException {
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU

		connect();
		preparedStatement = connect.prepareStatement("insert into osoba(ime, godiste) values (?,?)");

		// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
		preparedStatement.setString(1, o.getIme());
		preparedStatement.setInt(2, o.getGodiste());
		
		preparedStatement.execute();
		
		//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
		//****KRAJ		KRAJ OBRADE ResultSet-a	
		
		close();
	}
	
	public void deleteOsobaById(int id) throws ClassNotFoundException, SQLException {
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU

		connect();
		preparedStatement = connect.prepareStatement("delete from osoba where id = ?");

		// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
		preparedStatement.setInt(1, id);
		
		preparedStatement.execute();
		
		//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
		//****KRAJ		KRAJ OBRADE ResultSet-a	
		
		close();
	}

	
	public ArrayList<RacuniOsobe> getRacuniOsoba() throws ClassNotFoundException, SQLException {
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU
		ArrayList<RacuniOsobe> lista = new ArrayList<RacuniOsobe>();

		connect();
		preparedStatement = connect.prepareStatement("SELECT * FROM racun JOIN osoba on racun.id_osoba = osoba.id");

		// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
		//preparedStatement.setString(1, o.getJmbg());
		
		preparedStatement.execute();
		
		//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
		resultSet = preparedStatement.getResultSet();
		
		while (resultSet.next()) {
			int id_racun = resultSet.getInt("id");
			int id_osoba = resultSet.getInt("id_osoba");
			int cena = resultSet.getInt("cena");
			String ime = resultSet.getString("ime");
			int godiste = resultSet.getInt("godiste");

			RacuniOsobe o = new RacuniOsobe(id_racun,id_osoba,cena,ime,godiste);

			lista.add(o);
		}
		//****KRAJ		KRAJ OBRADE ResultSet-a	
		
		close();
		return lista;
	}
	
	
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
