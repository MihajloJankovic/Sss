package sss;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.DaoUser;
import sss.model.Adress;
import sss.model.Language;
import sss.model.User;
import view.login;
import view.register;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.Console;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class main extends JFrame {
	DaoUser userdao = new DaoUser();

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1002, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				    login cppp = new login();
					cppp.setVisible(true);
					setVisible(false); //you can't see me!
					dispose(); //Destroy the JFrame object
					
//			
//				List<Language> secondaryLanguages = new ArrayList<Language>();
//				secondaryLanguages.add(Language.ENGLISH);
//				secondaryLanguages.add(Language.GERMAN);
//				Adress a = new Adress("ulica","65", "beska","Srbija");
//				User pera = new User("Petar","Peric","email@gmail.com","06930303",a,"532242425254",secondaryLanguages,Language.SERBIAN);
//			
//				try {
//					userdao.SaveCustomer(pera);
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(375, 97, 190, 85);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				   register cppp;
				try {
					cppp = new register();
					cppp.setVisible(true);
					setVisible(false); //you can't see me!
					dispose(); //Destroy the JFrame object
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			
			
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(375, 267, 190, 85);
		contentPane.add(btnNewButton_1);
	}

}
