package Naman;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class WaitersAdd extends JFrame {

	private JPanel contentPane;
	String url="jdbc:mysql://localhost:3306/r";
	String uname="root";
	String pass="naman123";
	private JTextField name;
	private JTextField age;
	private JTextField salary;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WaitersAdd frame = new WaitersAdd();
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
	public WaitersAdd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWaiterName = new JLabel("Waiter Name");
		lblWaiterName.setHorizontalAlignment(SwingConstants.CENTER);
		lblWaiterName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWaiterName.setBounds(0, 28, 156, 45);
		contentPane.add(lblWaiterName);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(25, 73, 96, 20);
		contentPane.add(name);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAge.setBounds(86, 28, 156, 45);
		contentPane.add(lblAge);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(149, 73, 48, 20);
		contentPane.add(age);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(166, 28, 156, 45);
		contentPane.add(lblGender);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.addItem("M");
		comboBox.addItem("F");
//		comboBox.addItem("Male");
		
		comboBox.setBounds(221, 72, 101, 22);
		contentPane.add(comboBox);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalary.setBounds(296, 28, 156, 45);
		contentPane.add(lblSalary);
		
		salary = new JTextField();
		salary.setColumns(10);
		salary.setBounds(330, 73, 96, 20);
		contentPane.add(salary);
		
		JButton btnAddWaiter = new JButton("Add waiter");
		btnAddWaiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query="insert into waiter(NAME,AGE,GENDER,SALARY,BUSY) values(?,?,?,?,0);" ;
				try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection con=DriverManager.getConnection(url, uname, pass);
		        PreparedStatement st=con.prepareStatement(query);
		        
//		        st.setInt(1, Integer.parseInt(Id.getText()) );
		        st.setString(1, name.getText());
		        st.setInt(2, Integer.parseInt(age.getText()) );
		        st.setInt(4, Integer.parseInt(salary.getText()) );
		        st.setString(3, comboBox.getSelectedItem().toString() );
		        
		        
		        
		       int n = st.executeUpdate();
//		       rs.next();
//		       String name=rs.getString(2);
//		       System.out.println(name);
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			JOptionPane.showMessageDialog(null,"Waiter details added Successfully!");
			
			name.setText(null);
			age.setText(null);
			salary.setText(null);
			
			
//			name.setText(null);
			}
		});
		btnAddWaiter.setForeground(Color.WHITE);
		btnAddWaiter.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddWaiter.setBackground(Color.BLACK);
		btnAddWaiter.setBounds(287, 122, 139, 45);
		contentPane.add(btnAddWaiter);
		
		JButton btnShowDetails = new JButton("Close");
		btnShowDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnShowDetails.setForeground(Color.RED);
		btnShowDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnShowDetails.setBackground(Color.BLACK);
		btnShowDetails.setBounds(287, 180, 139, 45);
		contentPane.add(btnShowDetails);
	}
}
