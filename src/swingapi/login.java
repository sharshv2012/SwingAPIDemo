package swingapi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login extends JFrame {
	public String eidd ; 
	public String pass ;
	private JPanel contentPane;
	private JTextField eid;
	private JPasswordField hnn;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN - CLIENT MANAGEMENT SYSTEM");
		lblNewLabel.setForeground(new Color(255, 0, 255));
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.ITALIC, 18));
		lblNewLabel.setBounds(31, 10, 383, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email - ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(73, 84, 86, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(73, 134, 86, 21);
		contentPane.add(lblNewLabel_2);
		
		eid = new JTextField();
		eid.setBounds(223, 84, 96, 19);
		contentPane.add(eid);
		eid.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				eidd = eid.getText();
				pass = hnn.getText();
				eid.setEnabled(false);
				hnn.setEnabled(false);
				textField.setText("thanks for login");
				
				
				
				if (eidd.equals(SwingApi.en) && pass.equals(SwingApi.pas) ) 
				{
					JOptionPane.showMessageDialog(null , "YOU ARE SUCESSFULLY LOGED IN THANK YOU");
				}
				else 
				{
					JOptionPane.showMessageDialog(null , "WRONG ID OR PASSWORD");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(158, 200, 85, 21);
		contentPane.add(btnNewButton);
		
		hnn = new JPasswordField();
		hnn.setBounds(223, 137, 96, 19);
		contentPane.add(hnn);
		
		textField = new JTextField();
		textField.setBounds(116, 171, 165, 19);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
