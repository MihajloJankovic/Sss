package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dao.DaoAppointment;
import Dao.DaoUser;
import sss.model.Appointment;
import sss.model.Coach;
import sss.model.User;

public class UserAppointments extends JFrame {

	private JPanel contentPane;

	DaoUser daoUser = new DaoUser();
	DaoAppointment daoAp = new DaoAppointment();
	 private JTable kompozicijeTabela;
	 private JTable table;
	static User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAppointments frame = new UserAppointments(user);
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
	public UserAppointments(User pera) throws SQLException {
		this.user = pera;
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		Object[][] data = {};
		List<Appointment> s = new ArrayList<Appointment>();
		s = daoAp.getAllByUser(user.getId());
		String[] zaglavlja = new String[] {"id", "Date and time","Coach","price"};
		Object[][] sadrzaj = new Object[s.size()][zaglavlja.length];
		
		for(int i=0; i< s.size(); i++) {
			
			sadrzaj[i][0] = s.get(i).getId();
			sadrzaj[i][1] = s.get(i).getStartDateTime().toString();
			sadrzaj[i][2] = daoUser.getOne(s.get(i).getCoach().getId()).getFirstname();
			sadrzaj[i][3] = s.get(i).getPrice();
			
			
			
		}
		
		DefaultTableModel tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		contentPane.setLayout(new BorderLayout(0, 0));
		kompozicijeTabela = new JTable(tableModel);
		JScrollPane scrollPane= new  JScrollPane(kompozicijeTabela);
		contentPane.add(scrollPane);
	}

}
