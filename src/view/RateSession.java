package view;
//za musteriju
//ovo pise da treba u specifikaciji projekta. Da li ce se podaci sa ove stranice cuvati negde, ne znam
//importi prekopirani iz prethodno postojecih komponenti, verovatno imaju viska
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
import Dao.DaoCoach;
import Dao.DaoUser;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

public class RateSession extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static Coach coach;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RateSession frame = new RateSession(coach.getId());//nisam siguran da li je ovo tacno
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
	public RateSession(int idCoach) { 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rate your experience during the last session");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 28, 341, 43);
		contentPane.add(lblNewLabel);
		
		JRadioButton RatingBtn1 = new JRadioButton("1");
		buttonGroup.add(RatingBtn1);
		RatingBtn1.setBounds(56, 77, 103, 21);
		contentPane.add(RatingBtn1);
		
		JRadioButton RatingBtn2 = new JRadioButton("2");
		buttonGroup.add(RatingBtn2);
		RatingBtn2.setBounds(56, 100, 103, 21);
		contentPane.add(RatingBtn2);
		
		JRadioButton RatingBtn3 = new JRadioButton("3");
		buttonGroup.add(RatingBtn3);
		RatingBtn3.setBounds(56, 123, 103, 21);
		contentPane.add(RatingBtn3);
		
		JRadioButton RatingBtn4 = new JRadioButton("4");
		buttonGroup.add(RatingBtn4);
		RatingBtn4.setBounds(56, 146, 103, 21);
		contentPane.add(RatingBtn4);
		
		JRadioButton rdbtnNewRadRatingBtn5ioButton_4 = new JRadioButton("5");
		buttonGroup.add(rdbtnNewRadRatingBtn5ioButton_4);
		rdbtnNewRadRatingBtn5ioButton_4.setBounds(56, 169, 103, 21);
		contentPane.add(rdbtnNewRadRatingBtn5ioButton_4);
		
		JButton SubmitBtn = new JButton("Submit rating");
		
		
		
		SubmitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ocena;
				if(RatingBtn1.isSelected()) {		//verovatno postoji elegantniji nacin da se ovo odradi
					ocena=1;
				} else if(RatingBtn2.isSelected()) {
					ocena=2;
				} else if(RatingBtn3.isSelected()) {
					ocena=3;
				} else if(RatingBtn4.isSelected()) {
					ocena=4;
				} else {
					ocena=5;
				}
				
				//SaveRating(idCoach, ocena); verovatno propustam nesto jako ocigledno, ali nikako ne uspevam da ovo formulisem
												//bez toga da izbaci error
				setVisible(false);	
				//dispose(); nznm da li je neophodno
			}
		});
		SubmitBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		SubmitBtn.setBounds(117, 214, 150, 43);
		contentPane.add(SubmitBtn);
	}
}
