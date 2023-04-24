package view;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.DaoLanguage;
import Dao.DaoUser;
import sss.model.Adress;
import sss.model.Language;
import sss.model.User;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


public class registerCoach extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private DaoLanguage lang;
	JList list_1;
	JList list;
	List<Language> langs = new  ArrayList<Language>();
	DefaultListModel listModel;
	DaoUser user;

	private JButton btnNewButton;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JLabel lblNewLabel_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerCoach frame = new registerCoach();
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
	public registerCoach() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 766);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(181, 25, 155, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(181, 92, 155, 44);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(181, 159, 155, 46);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(181, 221, 155, 46);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(181, 277, 155, 44);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(181, 507, 155, 44);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(97, 40, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblLastname = new JLabel("LastName");
		lblLastname.setBounds(97, 107, 45, 13);
		contentPane.add(lblLastname);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(97, 175, 45, 13);
		contentPane.add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(97, 237, 45, 13);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblAdress = new JLabel("Street");
		lblAdress.setBounds(97, 292, 45, 13);
		contentPane.add(lblAdress);
		
		JLabel lblCreditcardnumber = new JLabel("CreditCardNumber");
		lblCreditcardnumber.setBounds(65, 522, 87, 13);
		contentPane.add(lblCreditcardnumber);
		listModel = new DefaultListModel();
		
		for (Language language : Language.values()) {
			
			listModel.addElement(String.valueOf(language));
		}
		
		list = new JList(listModel);
		list.setBounds(44, 578, 155, 90);
	

		contentPane.add(list);
	
		
		list_1 = new JList(listModel);
		list_1.setBounds(315, 578, 166, 76);
		contentPane.add(list_1);
	
		JLabel lblNewLabel_1 = new JLabel("Main Language");
		lblNewLabel_1.setBounds(65, 555, 87, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Other Languages");
		lblNewLabel_1_1.setBounds(340, 548, 96, 13);
		contentPane.add(lblNewLabel_1_1);
		
		
		
		btnNewButton = new JButton("Add to List");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				langs.add(Language.valueOf(list_1.getSelectedValue().toString()));
			}
		});
		btnNewButton.setBounds(352, 675, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				Adress adresa = new Adress(textField_4.getText(),textField_6.getText(),textField_7.getText(),textField_8.getText());				
				User pera = new User(textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),
						adresa,textField_5.getText(),langs,Language.valueOf(list.getSelectedValue().toString()));
				try {
					user.SaveCustomer(pera);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton_1.setBounds(208, 698, 85, 21);
		contentPane.add(btnNewButton_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(181, 338, 155, 44);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(181, 400, 155, 44);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(181, 454, 155, 44);
		contentPane.add(textField_8);
		
		JLabel lblStreetnumber = new JLabel("StreetNumber");
		lblStreetnumber.setBounds(65, 353, 87, 13);
		contentPane.add(lblStreetnumber);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(83, 415, 45, 13);
		contentPane.add(lblCity);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(83, 469, 45, 13);
		contentPane.add(lblCountry);
		
		textField_9 = new JTextField();
		textField_9.setBounds(485, 25, 224, 44);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Degree or Sertificate");
		lblNewLabel_2.setBounds(346, 32, 135, 29);
		contentPane.add(lblNewLabel_2);
		
		
	
	}

}
