package screen;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import customJComponent.CustomJButton;
import screen.CategoryPanel;
import database.Database;

public class SidePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public SidePanel() {
		setBackground(new Color(0, 211, 127));
		setBounds(0, 0, 228, 773);
		
		setLayout(null);
		
		CustomJButton homeButton = new CustomJButton();
		
		homeButton.setBackground(new Color(0, 211, 127));
		
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database.updateTables();
				MainPanel.setPanel(MainPanel.PANELS.HOME);
			}
		});
		
		JLabel homeImg = new JLabel(new ImageIcon(this.getClass().getResource("/home.png")));
		JLabel homeLabel = new JLabel("Home", SwingConstants.CENTER);
		homeLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		homeButton.setLayout(new BorderLayout());
		homeButton.add(homeImg, BorderLayout.WEST);
		homeButton.add(homeLabel, BorderLayout.CENTER);
		homeButton.setBounds(25, 260, 179, 60);
		homeButton.setFocusable(false);
		homeButton.setColor(new Color(0, 211, 127));
		homeButton.setBorderColor(new Color(0, 211, 127));
		homeButton.setColorOver(new Color(0, 240, 145));
		homeButton.setColorClick(new Color(32, 255, 166));
		add(homeButton);
		
		CustomJButton categoryButton = new CustomJButton();
		categoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database.updateTables();
				MainPanel.setPanel(MainPanel.PANELS.CATEGORY);
			}
		});
		JLabel categoryImg = new JLabel(new ImageIcon(this.getClass().getResource("/category.png")));
		JLabel categoryLabel = new JLabel("Category", SwingConstants.CENTER);
		categoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		categoryButton.setLayout(new BorderLayout());
		categoryButton.add(categoryImg, BorderLayout.WEST);
		categoryButton.add(categoryLabel, BorderLayout.CENTER);
		categoryButton.setFocusable(false);
		categoryButton.setColorOver(new Color(0, 240, 145));
		categoryButton.setColorClick(new Color(32, 255, 166));
		categoryButton.setColor(new Color(0, 211, 127));
		categoryButton.setBorderColor(new Color(0, 211, 127));
		categoryButton.setBackground(new Color(0, 211, 127));
		categoryButton.setBounds(25, 316, 179, 60);
		add(categoryButton);
		
		CustomJButton brandButton = new CustomJButton();
		brandButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database.updateTables();
				MainPanel.setPanel(MainPanel.PANELS.BRAND);
			}
		});
		JLabel brandImg = new JLabel(new ImageIcon(this.getClass().getResource("/brand.png")));
		JLabel brandLabel = new JLabel("Brand", SwingConstants.CENTER);
		brandLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		brandButton.setLayout(new BorderLayout());
		brandButton.add(brandImg, BorderLayout.WEST);
		brandButton.add(brandLabel, BorderLayout.CENTER);
		brandButton.setFocusable(false);
		brandButton.setColorOver(new Color(0, 240, 145));
		brandButton.setColorClick(new Color(32, 255, 166));
		brandButton.setColor(new Color(0, 211, 127));
		brandButton.setBorderColor(new Color(0, 211, 127));
		brandButton.setBackground(new Color(0, 211, 127));
		brandButton.setBounds(25, 378, 179, 60);
		add(brandButton);
		
		CustomJButton productButton = new CustomJButton();
		productButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database.updateTables();
				MainPanel.setPanel(MainPanel.PANELS.PRODUCT);
			}
		});
		JLabel productImg = new JLabel(new ImageIcon(this.getClass().getResource("/product.png")));
		JLabel productLabel = new JLabel("Product", SwingConstants.CENTER);
		productLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		productButton.setLayout(new BorderLayout());
		productButton.add(productImg, BorderLayout.WEST);
		productButton.add(productLabel, BorderLayout.CENTER);
		productButton.setFocusable(false);
		productButton.setColorOver(new Color(0, 240, 145));
		productButton.setColorClick(new Color(32, 255, 166));
		productButton.setColor(new Color(0, 211, 127));
		productButton.setBorderColor(new Color(0, 211, 127));
		productButton.setBackground(new Color(0, 211, 127));
		productButton.setBounds(25, 436, 179, 60);
		add(productButton);
		
		CustomJButton ordersButton = new CustomJButton();
		ordersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database.updateTables();
				MainPanel.setPanel(MainPanel.PANELS.ORDERS);
			}
		});
		JLabel ordersImg = new JLabel(new ImageIcon(this.getClass().getResource("/orders.png")));
		JLabel ordersLabel = new JLabel("Orders", SwingConstants.CENTER);
		ordersLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ordersButton.setLayout(new BorderLayout());
		ordersButton.add(ordersImg, BorderLayout.WEST);
		ordersButton.add(ordersLabel, BorderLayout.CENTER);
		ordersButton.setFocusable(false);
		ordersButton.setColorOver(new Color(0, 240, 145));
		ordersButton.setColorClick(new Color(32, 255, 166));
		ordersButton.setColor(new Color(0, 211, 127));
		ordersButton.setBorderColor(new Color(0, 211, 127));
		ordersButton.setBackground(new Color(0, 211, 127));
		ordersButton.setBounds(25, 497, 179, 60);
		add(ordersButton);
		
		JLabel title = new JLabel();
		title.setVerticalTextPosition(SwingConstants.BOTTOM);
		title.setBounds(10, 144, 208, 60);
		add(title);
		String titleText = "<html>";
		titleText += "<center>Electronics Shop<br></center>";
		titleText += "<center>Management System</center>";
		title.setText(titleText);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel titleImg = new JLabel(new ImageIcon(this.getClass().getResource("/electronics.png")));
		titleImg.setBounds(10, 22, 208, 122);
		add(titleImg);
		
		

	}
}
