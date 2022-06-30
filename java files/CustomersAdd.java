package Manav;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JCheckBox;

public class CustomersAdd extends JFrame {
	 public static int count;
	int y;
	private JLabel item1_count,item2_count,item3_count,item4_count,item5_count,item6_count,item7_count,item8_count;
	private JPanel contentPane;
	private JCheckBox Item1;
	private JCheckBox Item2;
	private JCheckBox Item3;
	private JCheckBox Item4;
	private JCheckBox Item7;
	private JCheckBox Item5;
	private JCheckBox Item8;
	private JCheckBox Item6;
	
	int item1_qty,item2_qty,item3_qty,item4_qty,item5_qty,item6_qty,item7_qty,item8_qty;
	String url="jdbc:mysql://localhost:3306/r";
	String uname="root";
	String pass="naman123";
	private JTextField name;
	private JTextField no_of_customers;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomersAdd frame = new CustomersAdd();
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
	public CustomersAdd() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerApplication = new JLabel("Customer Application");
		lblCustomerApplication.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCustomerApplication.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerApplication.setBounds(10, 0, 552, 45);
		contentPane.add(lblCustomerApplication);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCustomerName.setBounds(10, 72, 197, 45);
		contentPane.add(lblCustomerName);
		
		JButton btnNewButton = new JButton("Add customer");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query="insert into customers (CUSTOMER_ID,NAME,CST_NO) values (?,?,?)" ;
				try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection con=DriverManager.getConnection(url, uname, pass);
		        PreparedStatement st=con.prepareStatement(query);
		        
//		        st.setInt(1, Integer.parseInt(Id.getText()) );
//		        System.out.println(x);
		        st.setInt(1,count);
		         y = count;
		        
		        count=count+1;
		        restaurant.x = count;
		        st.setString(2, name.getText());
//		        st.setInt(2, Integer.parseInt(table_no.getText()) );
		        st.setInt(3, Integer.parseInt(no_of_customers.getText()) );
		        
		        
		       int n = st.executeUpdate();
//		       rs.next();
//		       String name=rs.getString(2);
//		       System.out.println(name);
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			JOptionPane.showMessageDialog(null,"Customer details added Successfully!");
			
			
//			name.setText(null);
			}
			
		});
		btnNewButton.setBounds(43, 170, 139, 45);
		contentPane.add(btnNewButton);
		
		name = new JTextField();
		name.setBounds(46, 114, 96, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblMembers = new JLabel("Members");
		lblMembers.setHorizontalAlignment(SwingConstants.CENTER);
		lblMembers.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMembers.setBounds(172, 72, 197, 45);
		contentPane.add(lblMembers);
		
		no_of_customers = new JTextField();
		no_of_customers.setForeground(Color.BLACK);
		no_of_customers.setColumns(10);
		no_of_customers.setBounds(230, 114, 96, 20);
		contentPane.add(no_of_customers);
		
		JButton btnShowDetails = new JButton("Close");
		btnShowDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
				
			}
		});
		btnShowDetails.setForeground(Color.RED);
		btnShowDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnShowDetails.setBackground(Color.BLACK);
		btnShowDetails.setBounds(480, 414, 139, 45);
		contentPane.add(btnShowDetails);
		
		Item1 = new JCheckBox("Paneer Tikka Ajwaini");
		Item1.setBounds(43, 236, 151, 23);
		contentPane.add(Item1);
		
		 Item2 = new JCheckBox("Bhutta Amritsari");
		Item2.setBounds(223, 236, 130, 23);
		contentPane.add(Item2);
		
		 Item3 = new JCheckBox("Vegetable Salt and Pepper");
		Item3.setBounds(463, 236, 197, 23);
		contentPane.add(Item3);
		
		Item4 = new JCheckBox("Khumb Palak ka Shorba'");
		Item4.setBounds(32, 313, 176, 23);
		contentPane.add(Item4);
		
		Item7 = new JCheckBox("Paneer Zafrani");
		Item7.setBounds(32, 393, 110, 23);
		contentPane.add(Item7);
		
		Item5 = new JCheckBox("Grilled Eggplant and Zucchini Salad");
		Item5.setBounds(226, 313, 235, 23);
		contentPane.add(Item5);
		
		Item8 = new JCheckBox("Garlic Naan");
		Item8.setBounds(230, 393, 99, 23);
		contentPane.add(Item8);
		
		Item6 = new JCheckBox("Dahi Bhalla");
		Item6.setBounds(463, 313, 99, 23);
		contentPane.add(Item6);
		
		 item1_count = new JLabel("1");
		item1_count.setHorizontalAlignment(SwingConstants.CENTER);
		item1_count.setBounds(74, 263, 49, 14);
		contentPane.add(item1_count);
		
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				int item1_qty = Integer.parseInt(item1_count.getName())+1;
				 item1_qty = Integer.parseInt(item1_count.getText()) + 1;
				item1_count.setText(String.valueOf(item1_qty));
				
			}
		});
		btnNewButton_1.setBounds(115, 259, 49, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("-");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Integer.parseInt(item1_count.getText())  == 0) {
					return;
				}
				item1_qty= Integer.parseInt(item1_count.getText()) -1;
				item1_count.setText(String.valueOf(item1_qty));
				
			}
		});
		btnNewButton_1_1.setBounds(31, 259, 49, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("order");
		btnNewButton_2.setBackground(Color.GREEN);
		btnNewButton_2.setForeground(Color.BLACK);
		
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(Item1.isSelected()) {
						int id = 1;
						String query="insert into orders values  (?,?,?)" ;
						try {
				        Class.forName("com.mysql.cj.jdbc.Driver");
				        Connection con=DriverManager.getConnection(url, uname, pass);
				        PreparedStatement st=con.prepareStatement(query);
				        
//				        st.setInt(1, Integer.parseInt(Id.getText()) );
//				        System.out.println(x);
				        st.setInt(1,id);

				        

				        st.setInt(2, y);
//				        st.setInt(2, Integer.parseInt(table_no.getText()) );
				        st.setInt(3, item1_qty);
//				        System.out.println(item1_qty);
				        
				        
				       int n = st.executeUpdate();
//				       rs.next();
//				       String name=rs.getString(2);
//				       System.out.println(name);
						} catch(Exception e1) {
							e1.printStackTrace();
						}
					
					
					
					
					}
			}
		});
		btnNewButton_2.setBounds(60, 285, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1_2 = new JButton("+");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 item2_qty = Integer.parseInt(item2_count.getText()) + 1;
					item2_count.setText(String.valueOf(item2_qty));
			}
		});
		btnNewButton_1_2.setBounds(290, 259, 49, 23);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_2_1 = new JButton("order");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Item2.isSelected()) {
					int id = 2;
					String query="insert into orders values  (?,?,?)" ;
					try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con=DriverManager.getConnection(url, uname, pass);
			        PreparedStatement st=con.prepareStatement(query);
			        
//			        st.setInt(1, Integer.parseInt(Id.getText()) );
//			        System.out.println(x);
			        st.setInt(1,id);

			        

			        st.setInt(2, y);
//			        st.setInt(2, Integer.parseInt(table_no.getText()) );
			        st.setInt(3, item2_qty);
//			        System.out.println(item2_qty);
			        
			        
			       int n = st.executeUpdate();
//			       rs.next();
//			       String name=rs.getString(2);
//			       System.out.println(name);
					} catch(Exception e1) {
						e1.printStackTrace();
					}
				
				
				
				
				}
			}
		});
		btnNewButton_2_1.setForeground(Color.BLACK);
		btnNewButton_2_1.setBackground(Color.GREEN);
		btnNewButton_2_1.setBounds(235, 285, 89, 23);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_1_1_1 = new JButton("-");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(item2_count.getText())  == 0) {
					return;
				}
				item2_qty= Integer.parseInt(item2_count.getText()) -1;
				item2_count.setText(String.valueOf(item2_qty));
			}
		});
		btnNewButton_1_1_1.setBounds(206, 259, 49, 23);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_3 = new JButton("+");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 item3_qty = Integer.parseInt(item3_count.getText()) + 1;
					item3_count.setText(String.valueOf(item3_qty));
			}
		});
		btnNewButton_1_3.setBounds(535, 259, 49, 23);
		contentPane.add(btnNewButton_1_3);
		
		JButton btnNewButton_2_2 = new JButton("order");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Item3.isSelected()) {
					int id = 3;
					String query="insert into orders values  (?,?,?)" ;
					try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con=DriverManager.getConnection(url, uname, pass);
			        PreparedStatement st=con.prepareStatement(query);
			        
//			        st.setInt(1, Integer.parseInt(Id.getText()) );
//			        System.out.println(x);
			        st.setInt(1,id);

			        

			        st.setInt(2, y);
//			        st.setInt(2, Integer.parseInt(table_no.getText()) );
			        st.setInt(3, item3_qty);
//			        System.out.println(item3_qty);
			        
			       int n = st.executeUpdate();
//			       rs.next();
//			       String name=rs.getString(2);
//			       System.out.println(name);
					} catch(Exception e1) {
						e1.printStackTrace();
					}
				
				
				
				
				}
			}
		});
		btnNewButton_2_2.setForeground(Color.BLACK);
		btnNewButton_2_2.setBackground(Color.GREEN);
		btnNewButton_2_2.setBounds(480, 285, 89, 23);
		contentPane.add(btnNewButton_2_2);
		
		JButton btnNewButton_1_1_2 = new JButton("-");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(item3_count.getText())  == 0) {
					return;
				}
				item3_qty= Integer.parseInt(item3_count.getText()) -1;
				item3_count.setText(String.valueOf(item3_qty));
				
			}
		});
		btnNewButton_1_1_2.setBounds(451, 259, 49, 23);
		contentPane.add(btnNewButton_1_1_2);
		
		JButton btnNewButton_1_4 = new JButton("+");
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 item4_qty = Integer.parseInt(item4_count.getText()) + 1;
					item4_count.setText(String.valueOf(item4_qty));
					 
			}
		});
		btnNewButton_1_4.setBounds(115, 341, 49, 23);
		contentPane.add(btnNewButton_1_4);
		
		JButton btnNewButton_2_3 = new JButton("order");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Item4.isSelected()) {
					int id = 4;
					String query="insert into orders values  (?,?,?)" ;
					try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con=DriverManager.getConnection(url, uname, pass);
			        PreparedStatement st=con.prepareStatement(query);
			        
//			        st.setInt(1, Integer.parseInt(Id.getText()) );
//			        System.out.println(x);
			        st.setInt(1,id);

			        

			        st.setInt(2, y);
//			        st.setInt(2, Integer.parseInt(table_no.getText()) );
			        st.setInt(3, item4_qty);
//			        System.out.println(item4_qty);
			        
			       int n = st.executeUpdate();
//			       rs.next();
//			       String name=rs.getString(2);
//			       System.out.println(name);
					} catch(Exception e1) {
						e1.printStackTrace();
					}
				
				
				
				
				}
			}
		});
		btnNewButton_2_3.setForeground(Color.BLACK);
		btnNewButton_2_3.setBackground(Color.GREEN);
		btnNewButton_2_3.setBounds(60, 367, 89, 23);
		contentPane.add(btnNewButton_2_3);
		
		JButton btnNewButton_1_1_3 = new JButton("-");
		btnNewButton_1_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(item4_count.getText())  == 0) {
					return;
				}
				item4_qty= Integer.parseInt(item4_count.getText()) -1;
				item4_count.setText(String.valueOf(item4_qty));
			}
		});
		btnNewButton_1_1_3.setBounds(31, 341, 49, 23);
		contentPane.add(btnNewButton_1_1_3);
		
		JButton btnNewButton_1_5 = new JButton("+");
		btnNewButton_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 item5_qty = Integer.parseInt(item5_count.getText()) + 1;
					item5_count.setText(String.valueOf(item5_qty));
			}
		});
		btnNewButton_1_5.setBounds(290, 341, 49, 23);
		contentPane.add(btnNewButton_1_5);
		
		JButton btnNewButton_2_4 = new JButton("order");
		btnNewButton_2_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Item5.isSelected()) {
					int id = 5;
					String query="insert into orders values  (?,?,?)" ;
					try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con=DriverManager.getConnection(url, uname, pass);
			        PreparedStatement st=con.prepareStatement(query);
			        
//			        st.setInt(1, Integer.parseInt(Id.getText()) );
//			        System.out.println(x);
			        st.setInt(1,id);

			        

			        st.setInt(2, y);
//			        st.setInt(2, Integer.parseInt(table_no.getText()) );
			        st.setInt(3, item5_qty);
//			        System.out.println(item5_qty);
			        
			       int n = st.executeUpdate();
//			       rs.next();
//			       String name=rs.getString(2);
//			       System.out.println(name);
					} catch(Exception e1) {
						e1.printStackTrace();
					}
				
				
				
				
				}
			}
		});
		btnNewButton_2_4.setForeground(Color.BLACK);
		btnNewButton_2_4.setBackground(Color.GREEN);
		btnNewButton_2_4.setBounds(235, 367, 89, 23);
		contentPane.add(btnNewButton_2_4);
		
		JButton btnNewButton_1_1_4 = new JButton("-");
		btnNewButton_1_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(item5_count.getText())  == 0) {
					return;
				}
				item5_qty= Integer.parseInt(item5_count.getText()) -1;
				item5_count.setText(String.valueOf(item5_qty));
			}
		});
		btnNewButton_1_1_4.setBounds(206, 341, 49, 23);
		contentPane.add(btnNewButton_1_1_4);
		
		JButton btnNewButton_1_6 = new JButton("+");
		btnNewButton_1_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 item6_qty = Integer.parseInt(item6_count.getText()) + 1;
					item6_count.setText(String.valueOf(item6_qty));
			}
		});
		btnNewButton_1_6.setBounds(535, 341, 49, 23);
		contentPane.add(btnNewButton_1_6);
		
		JButton btnNewButton_2_5 = new JButton("order");
		btnNewButton_2_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Item6.isSelected()) {
					int id = 6;
					String query="insert into orders values  (?,?,?)" ;
					try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con=DriverManager.getConnection(url, uname, pass);
			        PreparedStatement st=con.prepareStatement(query);
			        
//			        st.setInt(1, Integer.parseInt(Id.getText()) );
//			        System.out.println(x);
			        st.setInt(1,id);

			        

			        st.setInt(2, y);
//			        st.setInt(2, Integer.parseInt(table_no.getText()) );
			        st.setInt(3, item6_qty);
			        
//			        System.out.println(item6_qty);
			       int n = st.executeUpdate();
//			       rs.next();
//			       String name=rs.getString(2);
//			       System.out.println(name);
					} catch(Exception e1) {
						e1.printStackTrace();
					}
				
				
				
				
				}
			}
		});
		btnNewButton_2_5.setForeground(Color.BLACK);
		btnNewButton_2_5.setBackground(Color.GREEN);
		btnNewButton_2_5.setBounds(480, 367, 89, 23);
		contentPane.add(btnNewButton_2_5);
		
		JButton btnNewButton_1_1_5 = new JButton("-");
		btnNewButton_1_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(item6_count.getText())  == 0) {
					return;
				}
				item6_qty= Integer.parseInt(item6_count.getText()) -1;
				item6_count.setText(String.valueOf(item6_qty));
			}
		});
		btnNewButton_1_1_5.setBounds(451, 341, 49, 23);
		contentPane.add(btnNewButton_1_1_5);
		
		JButton btnNewButton_1_7 = new JButton("+");
		btnNewButton_1_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 item7_qty = Integer.parseInt(item7_count.getText()) + 1;
					item7_count.setText(String.valueOf(item7_qty));
			}
		});
		btnNewButton_1_7.setBounds(115, 423, 49, 23);
		contentPane.add(btnNewButton_1_7);
		
		JButton btnNewButton_2_6 = new JButton("order");
		btnNewButton_2_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Item7.isSelected()) {
					int id = 7;
					String query="insert into orders values  (?,?,?)" ;
					try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con=DriverManager.getConnection(url, uname, pass);
			        PreparedStatement st=con.prepareStatement(query);
			        
//			        st.setInt(1, Integer.parseInt(Id.getText()) );
//			        System.out.println(x);
			        st.setInt(1,id);

			        

			        st.setInt(2, y);
//			        st.setInt(2, Integer.parseInt(table_no.getText()) );
			        st.setInt(3, item7_qty);
			        
			        System.out.println(item7_qty);
			       int n = st.executeUpdate();
//			       rs.next();
//			       String name=rs.getString(2);
//			       System.out.println(name);
					} catch(Exception e1) {
						e1.printStackTrace();
					}
				
				
				
				
				}
			}
		});
		btnNewButton_2_6.setForeground(Color.BLACK);
		btnNewButton_2_6.setBackground(Color.GREEN);
		btnNewButton_2_6.setBounds(60, 449, 89, 23);
		contentPane.add(btnNewButton_2_6);
		
		JButton btnNewButton_1_1_6 = new JButton("-");
		btnNewButton_1_1_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(item7_count.getText())  == 0) {
					return;
				}
				item7_qty= Integer.parseInt(item7_count.getText()) -1;
				item7_count.setText(String.valueOf(item7_qty));
			}
		});
		btnNewButton_1_1_6.setBounds(31, 423, 49, 23);
		contentPane.add(btnNewButton_1_1_6);
		
		JButton btnNewButton_1_8 = new JButton("+");
		btnNewButton_1_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 item8_qty = Integer.parseInt(item8_count.getText()) + 1;
					item8_count.setText(String.valueOf(item8_qty));
			}
		});
		btnNewButton_1_8.setBounds(290, 423, 49, 23);
		contentPane.add(btnNewButton_1_8);
		
		JButton btnNewButton_2_7 = new JButton("order");
		btnNewButton_2_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Item8.isSelected()) {
					int id = 8;
					String query="insert into orders values  (?,?,?)" ;
					try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con=DriverManager.getConnection(url, uname, pass);
			        PreparedStatement st=con.prepareStatement(query);
			        
//			        st.setInt(1, Integer.parseInt(Id.getText()) );
//			        System.out.println(x);
			        st.setInt(1,id);

			        

			        st.setInt(2, y);
//			        st.setInt(2, Integer.parseInt(table_no.getText()) );
			        st.setInt(3, item8_qty);
			        
//			        System.out.println(item8_qty);
			       int n = st.executeUpdate();
//			       rs.next();
//			       String name=rs.getString(2);
//			       System.out.println(name);
					} catch(Exception e1) {
						e1.printStackTrace();
					}
				
				
				
				
				}
			}
		});
		btnNewButton_2_7.setForeground(Color.BLACK);
		btnNewButton_2_7.setBackground(Color.GREEN);
		btnNewButton_2_7.setBounds(235, 449, 89, 23);
		contentPane.add(btnNewButton_2_7);
		
		JButton btnNewButton_1_1_7 = new JButton("-");
		btnNewButton_1_1_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(item8_count.getText())  == 0) {
					return;
				}
				item8_qty= Integer.parseInt(item8_count.getText()) -1;
				item8_count.setText(String.valueOf(item8_qty));
			}
		});
		btnNewButton_1_1_7.setBounds(206, 423, 49, 23);
		contentPane.add(btnNewButton_1_1_7);
		
		 item2_count = new JLabel("1");
		item2_count.setHorizontalAlignment(SwingConstants.CENTER);
		item2_count.setBounds(249, 266, 49, 14);
		contentPane.add(item2_count);
		
		 item3_count = new JLabel("1");
		item3_count.setHorizontalAlignment(SwingConstants.CENTER);
		item3_count.setBounds(494, 263, 49, 14);
		contentPane.add(item3_count);
		
		 item4_count = new JLabel("1");
		item4_count.setHorizontalAlignment(SwingConstants.CENTER);
		item4_count.setBounds(74, 345, 49, 14);
		contentPane.add(item4_count);
		
		item5_count = new JLabel("1");
		item5_count.setHorizontalAlignment(SwingConstants.CENTER);
		item5_count.setBounds(249, 345, 49, 14);
		contentPane.add(item5_count);
		
		item6_count = new JLabel("1");
		item6_count.setHorizontalAlignment(SwingConstants.CENTER);
		item6_count.setBounds(494, 343, 49, 14);
		contentPane.add(item6_count);
		
		item7_count = new JLabel("1");
		item7_count.setHorizontalAlignment(SwingConstants.CENTER);
		item7_count.setBounds(74, 430, 49, 14);
		contentPane.add(item7_count);
		
		item8_count = new JLabel("1");
		item8_count.setHorizontalAlignment(SwingConstants.CENTER);
		item8_count.setBounds(249, 430, 49, 14);
		contentPane.add(item8_count);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText(null);
				no_of_customers.setText(null);
			}
		});
		btnClear.setForeground(Color.RED);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.setBackground(Color.BLACK);
		btnClear.setBounds(235, 170, 139, 45);
		contentPane.add(btnClear);
	}
}
