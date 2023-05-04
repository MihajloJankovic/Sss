package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dao.DaoCoach;
import Dao.DaoUser;

import sss.model.*;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class RealAdminView extends JFrame {

	private JPanel contentPane;
	private static User pera;
	private JTable table;
	 DaoCoach daocoach = new DaoCoach();
	 DaoUser daoUser = new DaoUser();
	 private JTable kompozicijeTabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RealAdminView frame = new RealAdminView(pera);
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
	 * @throws ClassNotFoundException 
	 */
	public RealAdminView(User pera) throws SQLException, ClassNotFoundException {
		this.pera = pera;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		Object[][] data = {};
		List<Coach> s = new ArrayList<Coach>();
		s = daocoach.getAllforApproval();
		String[] zaglavlja = new String[] {"Name", "Surname","Email","Degree"};
		Object[][] sadrzaj = new Object[s.size()][zaglavlja.length];
		
		for(int i=0; i< s.size(); i++) {
			Coach Clan1 = s.get(i);
			User a = daoUser.getOne(Clan1.getId());
			sadrzaj[i][0] = a.getFirstname();
			sadrzaj[i][1] = a.getLastname();
			sadrzaj[i][2] = a.getEmail();
			sadrzaj[i][3] = Clan1.getDegree();
			
			
		}
		contentPane.setLayout(new BorderLayout(0, 0));
		
		DefaultTableModel tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		kompozicijeTabela = new JTable(tableModel);
		contentPane.add(kompozicijeTabela);
		JButton btnNewButton = new JButton("Accept");
		menuBar.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int red = kompozicijeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Chose a row in a table first.", "Error", JOptionPane.WARNING_MESSAGE);
				}else {
					String ID = tableModel.getValueAt(red, 2).toString();
					User p;
					Coach a;
					try {
						p = daoUser.finduser(ID);
						
						a = daocoach.getOne(p.getId());
						daocoach.Approve(a.getId());
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
	
					
					
				}
			}
		});
	
		JButton btnNewButton_1 = new JButton("Decline");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int red = kompozicijeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Chose a row in a table first.", "Error", JOptionPane.WARNING_MESSAGE);
				}else {
					String ID = tableModel.getValueAt(red, 2).toString();
					User p;
					Coach a;
					try {
						p = daoUser.finduser(ID);
						
						a = daocoach.getOne(p.getId());
						daocoach.Decline(a.getId());
						daoUser.Delete(a.getId());
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
	
					
					
				}
			}
		});
		menuBar.add(btnNewButton_1);
		
	}
}
