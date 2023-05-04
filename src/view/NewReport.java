package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.DaoReport;
import sss.model.Goal;
import sss.model.Props;
import sss.model.User;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class NewReport extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static User user ;
	private DaoReport daorep = new DaoReport();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewReport frame = new NewReport(user);
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
	public NewReport(User pera) {
		this.user = pera;
	
		setBounds(100, 100, 445, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(136, 43, 137, 46);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(136, 138, 137, 46);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(100, 233, 218, 46);
		contentPane.add(textField_2);
		
		JList list = new JList();

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(23, 315, 155, 90);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"INCRASE_BODY_MASS","BULKING_BODY","CARDIO","UPPER_LOWER_BACK_MUSCLES","CHEST_MUSCLES"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setBounds(226, 315, 155, 90);
		contentPane.add(list_1);
		list_1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"MATS","WEIGHTS","JUMPROPE","PRACTICE_BARS","CARDIO_TRACK","ELASTIC_BAND","AEROBICS_BALLS","MEDICINE_BALL"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JButton btnNewButton = new JButton("Submit Report");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Props> props = new ArrayList<Props>(); 
				List<Goal> goals = new ArrayList<Goal>(); 
				
				for (Object goal :list.getSelectedValues() ) {
						goals.add(Goal.valueOf((String) goal));
				}
				for (Object goal :list_1.getSelectedValues() ) {
					props.add(Props.valueOf((String) goal));
			}
				try {
					daorep.Save(Double.valueOf(textField.getText()), Double.valueOf(textField_1.getText()),textField_2.getText(),user.getId(), goals,props);
					String st = "Secsesfull";
					JOptionPane.showMessageDialog(null, st);
					TimeUnit.SECONDS.sleep(1);
					dispose();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(136, 443, 137, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("height");
		lblNewLabel.setBounds(57, 59, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblWeight = new JLabel("weight");
		lblWeight.setBounds(57, 154, 45, 13);
		contentPane.add(lblWeight);
		
		JLabel lblHeathStatus = new JLabel("Heath Status");
		lblHeathStatus.setBounds(34, 249, 45, 13);
		contentPane.add(lblHeathStatus);
		
		JLabel lblNewLabel_1 = new JLabel("Goals");
		lblNewLabel_1.setBounds(74, 292, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Props");
		lblNewLabel_1_1.setBounds(282, 292, 45, 13);
		contentPane.add(lblNewLabel_1_1);
	}
}
