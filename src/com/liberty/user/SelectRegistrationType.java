package com.liberty.user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.UIManager;

public class SelectRegistrationType extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectRegistrationType frame = new SelectRegistrationType();
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
	public SelectRegistrationType() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 222, 173));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Registration Type");
		lblNewLabel.setBounds(149, 29, 168, 16);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(149, 89, 152, 27);
		comboBox.addItem("Faculty");
		comboBox.addItem("Instructor");
		comboBox.addItem("Student");
		
		contentPane.add(comboBox);
		
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setForeground(UIManager.getColor("InternalFrame.borderShadow"));
		btnNewButton.setBounds(161, 147, 117, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String utype = comboBox.getSelectedItem().toString();
				// TODO Auto-generated method stub
				if(utype =="Faculty") {
					try {
						RegisterFaculty frame = new RegisterFaculty();
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else if(utype =="Instructor") {
					try {
						RegisterInstructor frame = new RegisterInstructor();
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					//student
					try {
						RegisterStudent frame = new RegisterStudent();
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
			
		});
		
	}

}
