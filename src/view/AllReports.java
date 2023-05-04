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
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AllReports extends JFrame {
	DaoReport daoReport=new DaoReport();
	static User user;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllReports frame = new AllReports();
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
	public AllReports() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		List<Report> r=new ArrayList<Report>();
		r=daoReport.getAllByUser(user.getId());
		
		JLabel lblNewLabel = new JLabel("Client reports");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 20, 114, 36);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 66, 585, 276);
		contentPane.add(scrollPane);
	}
}
