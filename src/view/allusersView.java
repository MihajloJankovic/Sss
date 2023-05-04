package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dao.DaoUser;
import sss.model.Appointment;
import sss.model.Coach;
import sss.model.User;

import java.awt.GridBagLayout;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import java.awt.GridBagConstraints;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class allusersView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DaoUser a = new DaoUser();
	static Coach coach;
	private JMenuBar menuBar;
	 private JTable kompozicijeTabela;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					allusersView frame = new allusersView(coach);
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
	public allusersView(Coach pera) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.coach = pera;
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("User Reports");
		
		menuBar.add(btnNewButton);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{};
		gbl_contentPane.rowWeights = new double[]{};
		contentPane.setLayout(gbl_contentPane);
		
		Object[][] data = {};
		List<User> s = new ArrayList<User>();
		s = a.getAllCustomerscouach(coach.getId());
		String[] zaglavlja = new String[] {"id", "FirstName","LastName","Email"};
		Object[][] sadrzaj = new Object[s.size()][zaglavlja.length];
		
		for(int i=0; i< s.size(); i++) {
			
			sadrzaj[i][0] = s.get(i).getId();
			sadrzaj[i][1] = s.get(i).getFirstname();
			sadrzaj[i][2] = s.get(i).getLastname();
			sadrzaj[i][3] = s.get(i).getEmail();
			
			
			
		}
		
		DefaultTableModel tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		contentPane.setLayout(new BorderLayout(0, 0));
		kompozicijeTabela = new JTable(tableModel);
		JScrollPane scrollPane= new  JScrollPane(kompozicijeTabela);
		contentPane.add(scrollPane);
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 2;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int red = kompozicijeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Chose a row in a table first.", "Error", JOptionPane.WARNING_MESSAGE);
				}else {
					String ID = tableModel.getValueAt(red, 0).toString();
					
					try {
						
						User ab =  a.getOne(Integer.valueOf(ID));
						AllReports cpp = new AllReports(ab);
						cpp.setVisible(true);
						
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
	
					
					
				}
				
				
			}
		});
	}

}
