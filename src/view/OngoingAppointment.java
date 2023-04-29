package view;
//importi prekopirani iz prethodno postojecih komponenti
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
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

public class OngoingAppointment extends JFrame{
	private JTable Camera2;
	private JTable Camera1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OngoingAppointment frame = new OngoingAppointment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public OngoingAppointment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 420);
		getContentPane().setLayout(null);
		
		JLabel LabelCamera1 = new JLabel("Your camera");
		LabelCamera1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelCamera1.setBounds(131, 37, 156, 13);
		getContentPane().add(LabelCamera1);
		
		JLabel LabelCamera2 = new JLabel("Partner's camera");
		LabelCamera2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelCamera2.setBounds(491, 33, 156, 21);
		getContentPane().add(LabelCamera2);
		
		Camera2 = new JTable();
		Camera2.setBackground(new Color(0, 0, 0));
		Camera2.setBounds(413, 71, 314, 188);
		getContentPane().add(Camera2);
		
		Camera1 = new JTable();
		Camera1.setBackground(Color.BLACK);
		Camera1.setBounds(44, 71, 314, 188);
		getContentPane().add(Camera1);
		
		JButton ButtonEnd = new JButton("End ongoing session");
		ButtonEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RateSession cpp=new RateSession();
				cpp.setVisible(true);
			}
		});
		ButtonEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ButtonEnd.setBounds(277, 296, 218, 50);
		getContentPane().add(ButtonEnd);
	}
}