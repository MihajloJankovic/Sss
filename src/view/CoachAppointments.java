package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import sss.model.Appointment;
import sss.model.Coach;
import sss.model.User;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Dao.DaoAppointment;
import Dao.DaoUser;

public class CoachAppointments extends JFrame {

	private JPanel contentPane;
	private static Coach coach;
	DaoUser daoUser = new DaoUser();
	DaoAppointment daoAp = new DaoAppointment();
	 private JTable kompozicijeTabela;
	 private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoachAppointments frame = new CoachAppointments(coach);
					frame.setVisible(true);
					 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CoachAppointments(Coach pera) {
		this.coach = pera;

		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		Object[][] data = {};
		List<Appointment> s = new ArrayList<Appointment>();
		s = daoAp.getAll(coach.getId());
		String[] zaglavlja = new String[] {"id", "Date and time ","Client","Reserved","Canaceled","price"};
		Object[][] sadrzaj = new Object[s.size()][zaglavlja.length];
		
		for(int i=0; i< s.size(); i++) {
			
		
			sadrzaj[i][0] = s.get(i).getId();
			sadrzaj[i][1] = s.get(i).getStartDateTime().toString();
			sadrzaj[i][2] = s.get(i).getClient().getUser().getFirstname();
			sadrzaj[i][3] = s.get(i).isReserved();
			sadrzaj[i][4] = s.get(i).isCanceled();
			sadrzaj[i][5] = s.get(i).getPrice();
			
			
		}
		
		DefaultTableModel tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		contentPane.setLayout(new BorderLayout(0, 0));
		kompozicijeTabela = new JTable(tableModel);
		JScrollPane scrollPane= new  JScrollPane(kompozicijeTabela);
		contentPane.add(scrollPane);
	}

}
