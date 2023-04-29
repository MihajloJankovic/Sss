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

import Dao.DaoAppointment;
import Dao.DaoUser;
import sss.model.Appointment;
import sss.model.Coach;
import sss.model.User;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UserReservationView extends JFrame {

	private JPanel contentPane;
	DaoUser daoUser = new DaoUser();
	DaoAppointment daoAp = new DaoAppointment();
	 private JTable kompozicijeTabela;
	 private JTable table;
	static User user ;
	private JMenuBar menuBar;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserReservationView frame = new UserReservationView(user);
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
	public UserReservationView(User pera) throws SQLException {
		this.user = pera;
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		btnNewButton = new JButton("Reserve");
	
		menuBar.add(btnNewButton);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		Object[][] data = {};
		List<Appointment> s = new ArrayList<Appointment>();
		s = daoAp.getAllReal();
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int red = kompozicijeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Chose a row in a table first.", "Error", JOptionPane.WARNING_MESSAGE);
				}else {
					String ID = tableModel.getValueAt(red, 0).toString();
					
					try {
						
						daoAp.Reserve(user.getId(),ID);
						String st = "Secsesfull";
						JOptionPane.showMessageDialog(null, st);
						dispose();
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
	
					
					
				}
			}
		});
	}

}
