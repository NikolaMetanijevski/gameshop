package rs.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rs.dao.DAO;
import rs.model.Osoba;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIme;
	private JTextField textFieldGodiste;
	private JLabel lblIme;
	private JCheckBox chckbxStudent;
	
	private ArrayList<Osoba> osobe;
	private JButton btnIspisSvih;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		osobe = new ArrayList<Osoba>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});
		btnReset.setBounds(180, 174, 89, 23);
		contentPane.add(btnReset);
		
		textFieldIme = new JTextField();
		textFieldIme.setBounds(48, 29, 86, 20);
		contentPane.add(textFieldIme);
		textFieldIme.setColumns(10);
		
		textFieldGodiste = new JTextField();
		textFieldGodiste.setBounds(48, 79, 86, 20);
		contentPane.add(textFieldGodiste);
		textFieldGodiste.setColumns(10);
		
		chckbxStudent = new JCheckBox("Student");
		chckbxStudent.setBounds(48, 108, 97, 23);
		contentPane.add(chckbxStudent);
		
		lblIme = new JLabel("Ime");
		lblIme.setBounds(48, 11, 141, 14);
		contentPane.add(lblIme);
		
		JLabel lblGodiste = new JLabel("Godiste");
		lblGodiste.setBounds(48, 59, 127, 14);
		contentPane.add(lblGodiste);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ime = textFieldIme.getText();
				String godiste = textFieldGodiste.getText();
				
				if(ime != null && ime.trim().length()>0 && godiste != null && godiste.trim().length()>0) {
					try {
						int g = Integer.parseInt(godiste);
						
						boolean isStudent = chckbxStudent.isSelected();
						
						Osoba o = new Osoba(ime, g, isStudent);
						osobe.add(o);
						
						DAO dao = new DAO();
						dao.insertOsoba(o);
						
						JOptionPane.showMessageDialog(null, "Kreirana osoba:\n"+o);
						clearFields();
						
					}catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Godiste mora biti broj");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja");
				}
			}
		});
		btnInsert.setBounds(48, 174, 89, 23);
		contentPane.add(btnInsert);
		
		btnIspisSvih = new JButton("ISPIS SVIH");
		btnIspisSvih.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String ispis="PODACI O OSOBAMA\n";
				
				for (Osoba osoba : osobe) {
					ispis+="\t"+osoba+"\n";
					
				}
				JOptionPane.showMessageDialog(null, ispis);
			}
		});
		btnIspisSvih.setBounds(180, 28, 89, 23);
		contentPane.add(btnIspisSvih);
		
		
	}
	
	private void clearFields() {
		textFieldIme.setText("");
		textFieldGodiste.setText("");
		chckbxStudent.setSelected(false);
	}
}
