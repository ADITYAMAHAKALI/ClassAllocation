package com.liberty.admin;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import javax.swing.UIManager;

public class Manage extends JFrame {
	final String admin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage frame = new Manage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Manage() {
		this.admin = "";
	}
	/**
	 * Create the frame.
	 */
	public Manage(String admin) {
		
		this.admin = admin;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(0, 191, 255));
		
		JLabel lblNewLabel = new JLabel("Welcome " + admin);
		lblNewLabel.setBounds(143, 25, 153, 16);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Manage Schools and centers");
		btnNewButton.setForeground(UIManager.getColor("InternalFrame.borderShadow"));
		btnNewButton.setBounds(94, 103, 222, 29);
		getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SchoolManagement ms = new SchoolManagement();
				ms.setVisible(true);
				
			}
			
		});
		
		JButton btnNewButton_1 = new JButton("Manage Building And Rooms");
		btnNewButton_1.setForeground(UIManager.getColor("InternalFrame.borderHighlight"));
		btnNewButton_1.setBounds(94, 156, 222, 29);
		getContentPane().add(btnNewButton_1);

	}
}
