package view;

import java.awt.EventQueue;

import Dao.DaoUser;
import Dao.DaoCoach;
import Dao.DaoReport;
import sss.model.Report;
import sss.model.User;
import sss.model.Client;
import sss.model.Coach;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class OneReport extends JFrame {
	private static Report report;
	private JPanel contentPane;
	private JTextField FieldHeight;
	private JTextField FieldWeight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OneReport frame = new OneReport(report);
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
	public OneReport(Report report) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Close report");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(129, 217, 182, 36);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	
			}
		});
		
		JLabel lblNewLabel = new JLabel("Report");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(193, 10, 84, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Report date:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 53, 71, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Height:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(10, 102, 71, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Weight:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(10, 125, 71, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Goals:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(10, 148, 37, 13);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Available props:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_5.setBounds(10, 171, 91, 13);
		contentPane.add(lblNewLabel_1_5);
		
		
		
		JLabel LabelDate = new JLabel(report.getDate().toString());
		LabelDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelDate.setBounds(129, 53, 71, 13);
		contentPane.add(LabelDate);
		
		//fale komponente koje bi prikazale visinu i tezinu, 
		//ne znam da li ce se props i goals prikazati ispravno
		
		JLabel LabelGoals = new JLabel(report.getGoals().toString());
		LabelGoals.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelGoals.setBounds(129, 149, 297, 13);
		contentPane.add(LabelGoals);
		
		JLabel LabelProps = new JLabel(report.getProps().toString());
		LabelProps.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelProps.setBounds(129, 172, 297, 13);
		contentPane.add(LabelProps);
		
		JLabel lblNewLabel_1 = new JLabel("Health status:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 76, 91, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel LabelHealth = new JLabel(report.getHealthStatus());
		LabelHealth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelHealth.setBounds(129, 76, 297, 13);
		contentPane.add(LabelHealth);
		
		
	}
}
