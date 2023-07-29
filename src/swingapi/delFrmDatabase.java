package swingapi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.sql.*;
public class delFrmDatabase extends JFrame {

	private JPanel contentPane;
	private JTextField j1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delFrmDatabase frame = new delFrmDatabase();
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
	public delFrmDatabase() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Your Email ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(32, 71, 122, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Deleting User From Admin");
		lblNewLabel_1.setForeground(new Color(128, 255, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(137, 21, 196, 24);
		contentPane.add(lblNewLabel_1); 
		
		j1 = new JTextField();
		j1.setBounds(237, 77, 96, 19);
		contentPane.add(j1);
		j1.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/honey" , "root" , "");
				Statement st = con.createStatement();
				st.executeUpdate("DELETE FROM fish WHERE EMAIL='"+j1.getText()+"'");
				JOptionPane.showMessageDialog(null , "USER DELETED FROM THE ADMIN POTAL");
				con.close();				}
			    catch(Exception ex) {
				  Logger.getLogger(delFrmDatabase.class.getName()).log(Level.SEVERE , null , ex);
			  }
			}
		});
		btnNewButton.setBounds(165, 156, 85, 21);
		contentPane.add(btnNewButton);
	}
}
