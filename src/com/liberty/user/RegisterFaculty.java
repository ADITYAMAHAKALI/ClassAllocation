package com.liberty.user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.UIManager;

public class RegisterFaculty extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFaculty frame = new RegisterFaculty();
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
	public RegisterFaculty() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 222, 173));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Faculty Registration");
		lblNewLabel.setBounds(151, 19, 125, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("fname");
		lblNewLabel_1.setBounds(48, 60, 97, 16);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(182, 55, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("username");
		lblNewLabel_2.setBounds(48, 88, 94, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(182, 83, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("password");
		lblNewLabel_3.setBounds(46, 116, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(182, 111, 130, 26);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setForeground(UIManager.getColor("InternalFrame.borderHighlight"));
		btnNewButton.setBounds(127, 208, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Select School");
		lblNewLabel_4.setBounds(46, 173, 99, 16);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(182, 168, 130, 27);
		contentPane.add(comboBox_1);
		
		
		//fetching all schools
		
		 Connection conn = null;
		 PreparedStatement pst =null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/classallocation","root","Amkisgr8$");
		final String Query = "Select * from school";
		pst = conn.prepareStatement(Query);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			comboBox_1.addItem(rs.getString(2));
		}

		JLabel lblNewLabel_6 = new JLabel("Confirm Password");
		lblNewLabel_6.setBounds(46, 145, 127, 16);
		contentPane.add(lblNewLabel_6);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(182, 140, 130, 26);
		contentPane.add(passwordField_1);
		
		String school = comboBox_1.getSelectedItem().toString();
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textField.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Please type faculty name");
					return;
				}
				if(textField_1.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Please type username");
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
				String Query = "select id from school where sname = \"" + school + "\"";
				int id = 0;
				try {
					pst = conn.prepareStatement(Query);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					ResultSet rs = pst.executeQuery();
					while(rs.next()) {
						id = rs.getInt(1);
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				Query = "insert into faculty(funame,fname,password,sid) value(?,?,?,?)" ;
				try {
					pst = conn.prepareStatement(Query);
					pst.setString(1,textField.getText());
					pst.setString(2,textField_1.getText());
					pst.setString(3,passwordField.getText());
					pst.setInt(4,id);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					pst.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				UserLogin frame = new UserLogin();
				frame.setVisible(true);
			}
			
		});
		
	}
}
