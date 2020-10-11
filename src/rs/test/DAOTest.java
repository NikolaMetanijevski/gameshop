package rs.test;

import java.sql.SQLException;

import rs.dao.DAO;
import rs.model.Osoba;

public class DAOTest {

	public static void main(String[] args) {
		DAO dao = new DAO();
		
		try {
			System.out.println(dao.getOsobe());
			
			//Osoba o = new Osoba("Jovan", 2000, false);
			
			//dao.insertOsoba(o);
			//dao.deleteOsobaById(3);
			System.out.println(dao.getRacuniOsoba());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
