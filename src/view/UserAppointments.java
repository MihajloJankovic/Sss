package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dao.DaoAppointment;
import Dao.DaoCoach;
import Dao.DaoUser;
import sss.model.Appointment;
import sss.model.Coach;
import sss.model.User;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserAppointments extends JFrame {

	private JPanel contentPane;

	DaoUser daoUser = new DaoUser();
	DaoAppointment daoAp = new DaoAppointment();
	 private JTable kompozicijeTabela;
	 private JTable table;
	static User user;
	private JMenuBar menuBar;
	
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	DaoCoach doacoach = new DaoCoach();

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
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		btnNewButton = new JButton("Cancle");
		
		menuBar.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Start");
		
		menuBar.add(btnNewButton_1);
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int red = kompozicijeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Chose a row in a table first.", "Error", JOptionPane.WARNING_MESSAGE);
				}else {
					String ID = tableModel.getValueAt(red, 0).toString();
					
					try {
						
						Appointment ab =  daoAp.getOne(Integer.valueOf(ID));
						if(ab.getStartDateTime().minus(Duration.ofHours(2)).isBefore(LocalDateTime.now()))
						{
							daoAp.CanclePay(ID);
						}
						else
						{
							daoAp.Cancle(ID);
						}
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
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int red = kompozicijeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Chose a row in a table first.", "Error", JOptionPane.WARNING_MESSAGE);
				}else {
					String ID = tableModel.getValueAt(red, 0).toString();
					
					Appointment ab =  daoAp.getOne(Integer.valueOf(ID));
					if(ab.getStartDateTime().minus(Duration.ofHours(1)).isBefore(LocalDateTime.now()))
					{
						OngoingAppointment cpp = new OngoingAppointment(ab.getCoach());
						cpp.setVisible(true);
					
					}
					else
					{
						String st = "Its not yet time come back 1 hour before appointment";
						JOptionPane.showMessageDialog(null, st);
					}
					
					dispose();
					
					
	
					
					
				}
				
			}
		});
	}

}
