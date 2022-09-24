package com.liberty.admin;

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
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.UIManager;

public class SchoolManagement extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SchoolManagement frame = new SchoolManagement();
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
	public SchoolManagement() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0, 191, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// display all schools available in the database 
		
		Connection conn = null;
		PreparedStatement pst =null;
		String sname = JOptionPane.showInputDialog("Enter the name of the new School to add");
		String Query = "Select * from school";
		ResultSet rs = null;
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
		// now i Want to create an array list of these buttons 
		ArrayList<JLabel> slist = new ArrayList<>();
		try {
			pst = conn.prepareStatement(Query);
			rs = pst.executeQuery();
			int x = 100;
			int y = 75;
			int width = 300;
			int height = 15;
			while(rs.next()) {
				if(rs.getString(2)!="null") {
				JLabel temp = new JLabel(rs.getString(2));
				temp.setForeground(UIManager.getColor(Color.magenta));
				temp.setBounds(x, y, width, height);
				contentPane.add(temp);
				slist.add(temp);
				y+=20;
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("Manage Schools");
		lblNewLabel.setBounds(153, 19, 101, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add School");
		btnNewButton.setForeground(Color.blue);
		btnNewButton.setBounds(38, 47, 331, 29);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				// TODO Auto-generated method stub
				Connection conn = null;
				PreparedStatement pst =null;
				String sname = JOptionPane.showInputDialog("Enter the name of the new School to add");
				String Query = "Insert into school(sname) value(\"" + sname + "\")";
				
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
				try {
					pst = conn.prepareStatement(Query);
					pst.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
			}
				
		});
		
	}

}
