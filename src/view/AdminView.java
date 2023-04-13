package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sss.model.User;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.List;
import javax.swing.JLabel;

public class AdminView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static User pera;

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
	 */
	public AdminView(User pera) {
		this.pera = pera;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Coaches");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(29, 35, 160, 56);
		contentPane.add(btnNewButton);
		
		 

		
		textField = new JTextField();
		textField.setBounds(470, 10, 132, 52);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(470, 72, 132, 52);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(470, 134, 132, 52);
		contentPane.add(textField_2);
		
		List list = new List();
		list.setBounds(227, 251, 189, 139);
		contentPane.add(list);
		
		List list_1 = new List();
		list_1.setBounds(20, 230, 189, 139);
		contentPane.add(list_1);
		
		JLabel lblNewLabel = new JLabel("Best Coaches by Rank :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(29, 177, 160, 35);
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
	}
}
