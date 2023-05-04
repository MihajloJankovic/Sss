package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.DaoReport;
import sss.model.Report;
import sss.model.User;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class UserVIew extends JFrame {

	private JPanel contentPane;
	private static User user;
	private DaoReport daorepo= new DaoReport();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserVIew frame = new UserVIew(user);
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
	public UserVIew(User pera) {
		this.user= pera;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("New Report");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				NewReport cpp = new NewReport(user);
				cpp.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(148, 100, 125, 56);
		Report report =  daorepo.getOne(user.getId());
			if(LocalDate.now().isAfter(report.getDate().plusDays(0)))
				{
		
		contentPane.add(btnNewButton);
		
		
		
		
				}
			
		JButton btnReserveAppointment = new JButton("Reserve Appointment");
		btnReserveAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserReservationView cpp;
				try {
					cpp = new UserReservationView(user);
					cpp.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}
		});
		btnReserveAppointment.setBounds(125, 183, 172, 56);
		contentPane.add(btnReserveAppointment);
		
		JButton btnMyAppointments = new JButton("My Appointments");
		btnMyAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UserAppointments cpp;
				try {
					cpp = new UserAppointments(user);
					cpp.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}
		});
		btnMyAppointments.setBounds(125, 21, 172, 56);
		contentPane.add(btnMyAppointments);
	}
}
