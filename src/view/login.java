package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.toedter.calendar.JCalendar;

import Dao.DaoCoach;
import Dao.DaoUser;
import sss.model.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class login extends JFrame {
	DaoUser userdao = new DaoUser();
	DaoCoach c = new DaoCoach();

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(71, 75, 84, 37);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(169, 78, 189, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
	

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					User pera = userdao.finduser(textField.getText());
					if(pera != null)
					{
						if(pera.getType() == type.OWNER)
						{
							AdminView cpp = new AdminView(pera);
							cpp.setVisible(true);
							setVisible(false); //you can't see me!
							dispose();
						}
						if(pera.getType() == type.ADMIN)
						{
							RealAdminView cpp = new RealAdminView(pera);
							cpp.setVisible(true);
							setVisible(false); //you can't see me!
							dispose();
						}
						if(pera.getType() == type.CUSTOMER)
						{
							
						
							
							UserVIew cpp = new UserVIew(pera);
							cpp.setVisible(true);
							setVisible(false); //you can't see me!
							dispose();
						}
						if(pera.getType() == type.COACH)
						{
							Coach pera1 = c.getOne(pera.getId());
							CoachView cpp = new CoachView(pera1);
							cpp.setVisible(true);
							setVisible(false); //you can't see me!
							dispose();
						}
					  
					}
					else {
						
						JOptionPane.showMessageDialog(null, "Not Existing Email");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(146, 175, 114, 47);
		contentPane.add(btnNewButton);
	}
}
