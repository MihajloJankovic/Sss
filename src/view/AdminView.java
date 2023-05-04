package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import Dao.DaoCoach;
import Dao.DaoPay;
import sss.model.Language;
import sss.model.User;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class AdminView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static User pera;
	private JTextField textField_3;
	DaoPay daopay = new DaoPay();
	DaoCoach coach= new DaoCoach();
	private static final DecimalFormat decfor = new DecimalFormat("0.00");  

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView frame = new AdminView(pera);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AdminView(User pera) throws SQLException {
		this.pera = pera;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JCalendar dob=new JCalendar();
		
		dob.setLocation(655, 35);
		dob.setSize(206, 152);
		contentPane.add(dob);
		 

		
		textField = new JTextField();
		textField.setBounds(470, 10, 132, 52);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(String.valueOf(decfor.format(daopay.IncomeToday())));
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(470, 72, 132, 52);
		contentPane.add(textField_1);
		
		
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(470, 134, 132, 52);
		contentPane.add(textField_2);
		textField_1.setText(String.valueOf(decfor.format(daopay.IncomeWeek()))); 
		textField_2.setText(String.valueOf(decfor.format(daopay.Month()))); 
	
		
	DefaultListModel  listModel1 = new DefaultListModel();
		
		List<String> s1 =  daopay.BestCoaches();
		for (String a : s1) {
			
			listModel1.addElement(a);
		}
		
		JList list = new JList(listModel1);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(227, 251, 189, 139);
		contentPane.add(list);
		
		DefaultListModel  listModel = new DefaultListModel();
		
		List<String> s =  coach.getAllbyRating();
		for (String a : s) {
			
			listModel.addElement(a);
		}
		
		JList list_1 = new JList(listModel);
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setBounds(10, 251, 189, 139);
		contentPane.add(list_1);
		
		JLabel lblNewLabel = new JLabel("Best Coaches by Rank :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(29, 202, 160, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblBestCoachesBy = new JLabel("Best Coaches by Income :");
		lblBestCoachesBy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBestCoachesBy.setBounds(250, 202, 160, 35);
		contentPane.add(lblBestCoachesBy);
		
		JLabel lblNewLabel_1 = new JLabel("Icome Today :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(327, 17, 123, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Icome This Week :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(301, 79, 160, 33);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Icome This Month :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(301, 141, 176, 33);
		contentPane.add(lblNewLabel_1_3);
		
		JButton btnNewButton_1 = new JButton("Show");
		
		btnNewButton_1.setBounds(707, 383, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JCalendar dob_1 = new JCalendar();
		dob_1.setBounds(655, 221, 206, 152);
		contentPane.add(dob_1);
	
		
		JLabel lblNewLabel_2 = new JLabel("Start Date");
		lblNewLabel_2.setBounds(669, 10, 94, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("End date");
		lblNewLabel_3.setBounds(669, 198, 94, 13);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(684, 435, 134, 33);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
			
				String date = dob.getDate().toString();
				String dateA = dob_1.getDate().toString();
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");          

				String bb = null;
				String aa = null;
				

				 bb = format1.format(dob.getDate());
				 aa = format1.format(dob_1.getDate());
				   
		    
		    	textField_3.setText(String.valueOf(daopay.IncomeiNTERVAL(bb, aa)));
		        
			}
		});
	}
}
