package com.liberty.user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ManageCourse extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageCourse frame = new ManageCourse();
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
	public ManageCourse(String user) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Manage your courses" + user);
		lblNewLabel.setBounds(142, 6, 200, 16);
		getContentPane().add(lblNewLabel);
	}

	public ManageCourse() {
		getContentPane().setLayout(null);
		//getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage your courses");
		lblNewLabel.setBounds(142, 6, 200, 16);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Course");
		btnNewButton.setBounds(17, 37, 117, 29);
		getContentPane().add(btnNewButton);
		
		
		// TODO Auto-generated constructor stub
		
	}

}
