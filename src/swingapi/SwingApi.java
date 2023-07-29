package swingapi;

import java.awt.EventQueue;
import java.sql.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class SwingApi {
	static Connection conn=null;
	public  static String n ;
	public static String en ;
	public static String ph ;
	public static String  pas ;

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField knn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingApi window = new SwingApi();
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
	public SwingApi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CLIENT MANAGEMENT SYSTEM ");
		lblNewLabel.setBounds(86, 30, 340, 26);
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setBounds(106, 75, 75, 13);
		lblNewLabel_1.setForeground(new Color(0, 255, 64));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("EMAIL ID");
		lblNewLabel_2.setBounds(106, 107, 75, 13);
		lblNewLabel_2.setForeground(new Color(0, 255, 64));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PHN. NO.");
		lblNewLabel_3.setBounds(106, 136, 75, 13);
		lblNewLabel_3.setForeground(new Color(0, 255, 64));
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PASSWORD");
		lblNewLabel_4.setBounds(106, 165, 75, 13);
		lblNewLabel_4.setForeground(new Color(0, 255, 64));
		frame.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(228, 72, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(228, 104, 96, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(228, 133, 96, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("SIGN UP");
		btnNewButton.setBounds(190, 214, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				n = textField.getText();
				en = textField_1.getText();	
				ph = textField_2.getText();
				pas = knn.getText();
				
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/honey" , "root" , ""); 
				PreparedStatement ps = conn.prepareStatement("insert into fish values(?,?,?,?)");
				ps.setString(1, n);
				ps.setString(2, en);
				ps.setString(3 , ph);
				ps.setString(4, pas);
				
				ps.executeUpdate();
						
							JOptionPane.showMessageDialog(null ,"dear client , you have succesfully registered into thr portal");
			  	}
				catch(Exception g) {
					g.printStackTrace();
				}
				
				
				
				
				
				if (pas.length() < 8) 
				{
					JOptionPane.showMessageDialog( null , "password must be of eight digit or more");
				}
				 
				textField.setEnabled(false);
				textField_2.setEnabled(false);
				textField_1.setEnabled(false);
				knn.setEnabled(false);
				JOptionPane.showMessageDialog( null , "welcome " + n + " to our client management system portal");
				
				login obj = new login ();
				obj.setVisible(true);
				
				
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		knn = new JPasswordField();
		knn.setBounds(228, 162, 96, 19);
		frame.getContentPane().add(knn);
	}
}
