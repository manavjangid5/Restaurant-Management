package Naman;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
public class restaurant {
	public static int x = 1;
	private JFrame frame;
	String url="jdbc:mysql://localhost:3306/r";
	String uname="root";
	String pass="naman123";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					restaurant window = new restaurant();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public restaurant() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 919, 754);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manager");
		lblNewLabel.setBounds(151, 150, 409, 28);
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to the Restaurant Database");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 27));
		lblNewLabel_1.setBounds(30, 11, 737, 90);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Add customer");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				CustomersAdd frame2 = new CustomersAdd();
				CustomersAdd.count = x;
				frame2.show();
			
			}
			
		});
		btnNewButton.setBounds(40, 199, 160, 48);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAddWaiter = new JButton("Add Waiter");
		btnAddWaiter.setForeground(Color.WHITE);
		btnAddWaiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WaitersAdd frame3 = new WaitersAdd();
				frame3.show();
				
				
			}
		});
		btnAddWaiter.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnAddWaiter.setBackground(Color.BLACK);
		btnAddWaiter.setBounds(220, 199, 160, 48);
		frame.getContentPane().add(btnAddWaiter);
		
		JLabel lblManageTable = new JLabel("Manage Table");
		lblManageTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblManageTable.setForeground(Color.BLACK);
		lblManageTable.setFont(new Font("Arial", Font.BOLD, 24));
		lblManageTable.setBackground(Color.GRAY);
		lblManageTable.setBounds(139, 304, 409, 28);
		frame.getContentPane().add(lblManageTable);
		
		JButton btnGenerateBill = new JButton("Generate Bill");
		btnGenerateBill.setForeground(Color.WHITE);
		btnGenerateBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerateBill frame4 = new GenerateBill();
				frame4.show();
				
			}
		});
		btnGenerateBill.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnGenerateBill.setBackground(Color.BLACK);
		btnGenerateBill.setBounds(40, 343, 160, 48);
		frame.getContentPane().add(btnGenerateBill);
		
		JButton btnShowMenu = new JButton("Show Menu");
		btnShowMenu.setForeground(Color.WHITE);
		btnShowMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Menu frame5 = new Menu();String query="select TABLE_ID from tables where status in (1);" ;
				try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
//			        String query = "Select * from Menu";
			     // Create a connection to the database
			        Connection conn = DriverManager.getConnection(url, uname, pass);

			        // Just pass the connection and the table name to printTable()
			        DBTablePrinter.printTable(conn, "MENU");
//			
					} catch(Exception e1) {
						e1.printStackTrace();
					}
//				JOptionPane.showMessageDialog(null,"Customer details added Successfully!");
//				frame5.show();
				
			}
		});
		btnShowMenu.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnShowMenu.setBackground(Color.BLACK);
		btnShowMenu.setBounds(402, 199, 160, 48);
		frame.getContentPane().add(btnShowMenu);
		
		JButton btnShowWaiters = new JButton("Show Waiters");
		btnShowWaiters.setForeground(Color.WHITE);
		btnShowWaiters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
//			        String query = "Select * from Menu";
			     // Create a connection to the database
			        Connection conn = DriverManager.getConnection(url, uname, pass);

			        // Just pass the connection and the table name to printTable()
			        DBTablePrinter.printTable(conn, "Waiter");
//			
					} catch(Exception e1) {
						e1.printStackTrace();
					}
				
			}
			
		});
		btnShowWaiters.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnShowWaiters.setBackground(Color.BLACK);
		btnShowWaiters.setBounds(580, 199, 160, 48);
		frame.getContentPane().add(btnShowWaiters);
	}
}
