package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sss.model.Coach;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CoachView extends JFrame {

	private JPanel contentPane;
	private static Coach coach;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoachView frame = new CoachView(coach);
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
	public CoachView(Coach pera) {
		this.coach = pera;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New Appointment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				newAppointment cpp = new newAppointment(coach);
				cpp.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(22, 27, 134, 21);
		contentPane.add(btnNewButton);
		
		JButton btnMyAppointments = new JButton("My Appointments");
		btnMyAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CoachAppointments cpp = new CoachAppointments(coach);
				cpp.setVisible(true);
			}
		});
		btnMyAppointments.setBounds(235, 27, 134, 21);
		contentPane.add(btnMyAppointments);
		
		JButton btnUserReports = new JButton("User Reports");
		btnUserReports.setBounds(22, 96, 134, 21);
		contentPane.add(btnUserReports);
	}
}
