package com.liberty.user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class RegisterInstructor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterInstructor frame = new RegisterInstructor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public RegisterInstructor() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 222, 173));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Instructor Registration");
		lblNewLabel.setBounds(151, 19, 161, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter student username");
		lblNewLabel_1.setBounds(6, 60, 170, 16);
		contentPane.add(lblNewLabel_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(182, 55, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Instructor Alias");
		lblNewLabel_2.setBounds(6, 88, 136, 16);
		contentPane.add(lblNewLabel_2);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(182, 83, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("password");
		lblNewLabel_3.setBounds(36, 116, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(182, 111, 130, 26);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setForeground(UIManager.getColor("InternalFrame.borderHighlight"));
		btnNewButton.setBounds(127, 208, 117, 29);
		contentPane.add(btnNewButton);
		
		
		//fetching all schools
		
		 Connection conn = null;
		 PreparedStatement pst =null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/classallocation","root","Amkisgr8$");
		

		JLabel lblNewLabel_6 = new JLabel("Confirm Password");
		lblNewLabel_6.setBounds(15, 145, 127, 16);
		contentPane.add(lblNewLabel_6);
		
		JPasswordField passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(182, 140, 130, 26);
		contentPane.add(passwordField_1);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textField.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Please type student name");
					return;
				}
				if(textField_1.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Please type alias");
					return;
				}
				if(passwordField.getPassword().length==0) {
					JOptionPane.showMessageDialog(null, "Please type password");
					return;
				}
				if(passwordField_1.getPassword().length==0) {
					JOptionPane.showMessageDialog(null, "Please enter confirm password");
					return;
				}
				if(passwordField_1.getText().equals(passwordField.getText())==false) {
					JOptionPane.showMessageDialog(null, "password doesn't match");
					return;
				}
				// fetching 
				Connection conn = null;
				PreparedStatement pst =null;
				ResultSet rs = null;
				int id=0;
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
				String Query =" SELECT sid from student where uname= \""+ textField.getText() + "\"" ;
				try {
					pst = conn.prepareStatement(Query);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}	
				try {
					rs = pst.executeQuery();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				try {
					while(rs.next()) {
						id = rs.getInt(1);
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if(id==0) {
					JOptionPane.showMessageDialog(null, "please enter valid student username ");
					return;
				}
				
				Query = "insert into instructor(alias,password,sid) value(?,?,?)";
				try {
					pst = conn.prepareStatement(Query);
					pst.setString(1,textField_1.getText());
					pst.setString(2,passwordField.getText());
					pst.setInt(3,id);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					pst.executeUpdate();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				UserLogin frame = new UserLogin();
				frame.setVisible(true);
				
				
			}
			
		});
		

	}

}
