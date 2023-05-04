package view;

import java.awt.EventQueue;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sss.model.Appointment;
import sss.model.Coach;
import timeselector.TimeSelectionField;

import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import com.toedter.calendar.JCalendar;

import Dao.DaoAppointment;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.awt.event.ActionEvent;

public class newAppointment extends JFrame {

	private JPanel contentPane;
	private static Coach coach;
	DaoAppointment ab = new DaoAppointment();
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newAppointment frame = new newAppointment(coach);
					frame.setVisible(true);
					 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LocalDate convertToLocalDateViaInstant(java.util.Date date) {
	    return date.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	/**
	 * Create the frame.
	 */
	public newAppointment(Coach pera ) {
		this.coach = pera;

		setBounds(100, 100, 450, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		com.github.lgooddatepicker.components.TimePicker a = new com.github.lgooddatepicker.components.TimePicker();		
		a.setLocation(274, 58);
		a.setSize(90, 44);
		contentPane.add(a);
		
		JCalendar dob = new JCalendar();
		dob.setBounds(46, 58, 206, 152);
		contentPane.add(dob);
		
		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setBounds(132, 35, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Time");
		lblNewLabel_1.setBounds(297, 35, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(251, 255, 76, 25);
		contentPane.add(spinner);
		
		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setBounds(169, 261, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Make Appoinment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LocalDateTime G = LocalDateTime.of(convertToLocalDateViaInstant(dob.getDate()),a.getTime());
				int currentValue = (Integer)spinner.getValue();
				Appointment aba = new Appointment(G, coach, false, false,currentValue );
				try {
					ab.Save(aba);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(142, 386, 115, 25);
		contentPane.add(btnNewButton);
	

		
}
}
