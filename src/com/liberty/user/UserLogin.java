package com.liberty.user;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.awt.Color;

public class UserLogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
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
	public UserLogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("User Login");
		lblNewLabel.setBounds(150, 16, 113, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setBounds(55, 64, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(171, 59, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setBounds(55, 111, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(171, 106, 130, 26);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("user type");
		lblNewLabel_3.setBounds(55, 152, 61, 16);
		contentPane.add(lblNewLabel_3);
	
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		comboBox.setForeground(UIManager.getColor("FormattedTextField.foreground"));
		comboBox.setBounds(171, 148, 130, 27);
		comboBox.addItem("Faculty");
		comboBox.addItem("Instructor");
		comboBox.addItem("Student");
		
		contentPane.add(comboBox);
		
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(255, 222, 173));
		btnNewButton.setForeground(UIManager.getColor("InternalFrame.borderHighlight"));
		btnNewButton.setBounds(161, 198, 182, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String category = (String) comboBox.getSelectedItem();
				Connection conn = null;
				PreparedStatement pst = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/classallocation","root","Amkisgr8$");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String uname = textField.getText();
				String pswd = passwordField.getText();
				ResultSet rs = null;
				String query ;
				if(category=="Faculty") {
					query = "Select * from faculty where funame = \"" + uname + "\" and password = \"" + pswd + "\"";

				}else if(category=="Instructor") {
					query = "Select * from instructor where alias = \"" + uname + "\" and password = \"" + pswd + "\"";
				}else {
					query = "Select * from student where uname = \"" + uname + "\" and password = \"" + pswd + "\"";
				}
				System.out.println(query);
				try {
					pst = conn.prepareStatement(query);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					 rs = pst.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(category=="Faculty") {
					try {
						while(rs.next()) {
							System.out.println("Approve Courses");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}else if(category=="Instructor") {
					try {
						while(rs.next()) {
							System.out.println("Request Courses");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					try {
						while(rs.next()) {
							System.out.println("Manage courses");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
			
		});
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setForeground(UIManager.getColor("InternalFrame.borderShadow"));
		btnNewButton_1.setBounds(23, 198, 117, 29);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SelectRegistrationType frame = new SelectRegistrationType();
				frame.setVisible(true);
			}
			
		});
		
		
	}

}
