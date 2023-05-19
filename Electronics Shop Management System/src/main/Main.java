package main;

import java.awt.EventQueue;
import screen.*;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import database.Database;

public class Main {
	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application and connect to database
	 */
	public Main() {
		Database.connect();
		initialize();		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1413, 812);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		SidePanel sidePanel = new SidePanel();
		frame.getContentPane().add(sidePanel);
		sidePanel.setLayout(new BorderLayout(0, 0));
		
		MainPanel mainPanel = new MainPanel();
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));
		

	}
}
