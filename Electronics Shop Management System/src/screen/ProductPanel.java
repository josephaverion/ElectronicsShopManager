package screen;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import customJComponent.CustomJButton;

public class ProductPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Use class variable for the product and brand? or just use add to combobox method

	/**
	 * Create the panel.
	 */
	public ProductPanel() {
		setBackground(Color.WHITE);
		setBounds(227, 0, 1180, 773);
		setLayout(null);
		
		JLabel topBorder = new JLabel();
		topBorder.setBackground(new Color(0, 255, 128));
		topBorder.setOpaque(true);
		topBorder.setBounds(0, 0, 1170, 53);
		add(topBorder);
		
		JLabel bottomBorder = new JLabel();
		bottomBorder.setOpaque(true);
		bottomBorder.setBackground(new Color(0, 255, 128));
		bottomBorder.setBounds(0, 720, 1170, 53);
		add(bottomBorder);
		
		JPanel categoryManager = new JPanel();
		categoryManager.setBackground(new Color(255, 255, 255));
		categoryManager.setBounds(21, 76, 1130, 621);
		add(categoryManager);
		categoryManager.setLayout(new CardLayout(0, 0));
		
		JPanel addPanel = new JPanel();
		addPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addPanel.setBackground(Color.WHITE);
		categoryManager.add(addPanel);
		addPanel.setLayout(null);
		
		addPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addPanel.setBounds(21, 76, 1130, 621);
		addPanel.setBackground(Color.WHITE);
		addPanel.setLayout(null);
		
		JTextField categoryTxt = new JTextField();
		categoryTxt.setBounds(342, 209, 274, 20);
		categoryTxt.setColumns(10);
		addPanel.add(categoryTxt);
		
		
		JLabel nameLabel = new JLabel("Product Name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameLabel.setBounds(342, 178, 104, 20);
		addPanel.add(nameLabel);
		
		JComboBox<String> availability = new JComboBox<String>();
		availability.setOpaque(false);
		availability.setBackground(new Color(255, 255, 255));
		availability.setModel(new DefaultComboBoxModel<String>(new String[] {"Available", "Not Available"}));
		availability.setBounds(662, 271, 120, 22);
		addPanel.add(availability);
		
		JLabel statusLabel = new JLabel("Status");
		statusLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		statusLabel.setBounds(662, 240, 104, 20);
		addPanel.add(statusLabel);
		
		CustomJButton addButton = new CustomJButton();
		addButton.setText("Add");
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addButton.setFocusable(false);
		addButton.setColorOver(new Color(0, 240, 145));
		addButton.setColorClick(new Color(32, 255, 166));
		addButton.setColor(new Color(0, 211, 127));
		addButton.setBorderColor(Color.WHITE);
		addButton.setBackground(new Color(0, 211, 127));
		addButton.setBounds(340, 328, 97, 41);
		addPanel.add(addButton);
		
		JLabel quantityLabel = new JLabel("Quantity");
		quantityLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		quantityLabel.setBounds(662, 178, 104, 20);
		addPanel.add(quantityLabel);
		
		JTextField quantityTxt = new JTextField();
		quantityTxt.setColumns(10);
		quantityTxt.setBounds(663, 209, 75, 20);
		addPanel.add(quantityTxt);
		
		JLabel categoryLabel = new JLabel("Category");
		categoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		categoryLabel.setBounds(342, 240, 104, 20);
		addPanel.add(categoryLabel);
		
		JComboBox<String> category = new JComboBox<String>();
		category.setOpaque(false);
		category.setBackground(Color.WHITE);
		category.setBounds(342, 271, 120, 22);
		addPanel.add(category);
		
		JLabel brandLabel = new JLabel("Brand");
		brandLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		brandLabel.setBounds(496, 240, 104, 20);
		addPanel.add(brandLabel);
		
		JComboBox<String> brand = new JComboBox<String>();
		brand.setOpaque(false);
		brand.setBackground(Color.WHITE);
		brand.setBounds(496, 271, 120, 22);
		addPanel.add(brand);
		
		JTextField priceTxt = new JTextField();
		priceTxt.setColumns(10);
		priceTxt.setBounds(783, 209, 75, 20);
		addPanel.add(priceTxt);
		
		JLabel priceLabel = new JLabel("Price");
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		priceLabel.setBounds(785, 178, 104, 20);
		addPanel.add(priceLabel);
		
		JPanel overviewPanel = new JPanel();
		overviewPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		overviewPanel.setBackground(Color.WHITE);
		categoryManager.add(overviewPanel);
		overviewPanel.setLayout(null);
		
		overviewPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		overviewPanel.setBounds(21, 76, 1130, 621);
		overviewPanel.setBackground(Color.WHITE);
		overviewPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 176, 1086, 334);
		overviewPanel.add(scrollPane);
		
		JTable categoryTable = new JTable();
		scrollPane.setViewportView(categoryTable);
		
		JPanel editPanel = new JPanel();
		editPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		editPanel.setBackground(Color.WHITE);
		categoryManager.add(editPanel);
		editPanel.setLayout(null);
		
		editPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		editPanel.setBounds(21, 76, 1130, 621);
		editPanel.setBackground(Color.WHITE);
		editPanel.setLayout(null);

		JTextField categoryTxt2 = new JTextField();
		categoryTxt2.setBounds(342, 209, 274, 20);
		categoryTxt2.setColumns(10);
		editPanel.add(categoryTxt2);
		
		JLabel nameLabel2 = new JLabel("Product Name");
		nameLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameLabel2.setBounds(342, 178, 104, 20);
		editPanel.add(nameLabel2);
		
		JComboBox<String> availability2 = new JComboBox<String>();
		availability2.setOpaque(false);
		availability2.setBackground(new Color(255, 255, 255));
		availability2.setModel(new DefaultComboBoxModel<String>(new String[] {"Available", "Not Available"}));
		availability2.setBounds(662, 271, 120, 22);
		editPanel.add(availability2);
		
		JLabel statusLabel2 = new JLabel("Status");
		statusLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		statusLabel2.setBounds(662, 240, 104, 20);
		editPanel.add(statusLabel2);
		
		
		CustomJButton editButton = new CustomJButton();
		editButton.setText("Edit");
		editButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editButton.setFocusable(false);
		editButton.setColorOver(new Color(0, 240, 145));
		editButton.setColorClick(new Color(32, 255, 166));
		editButton.setColor(new Color(0, 211, 127));
		editButton.setBorderColor(Color.WHITE);
		editButton.setBackground(new Color(0, 211, 127));
		editButton.setBounds(340, 369, 97, 41);
		editPanel.add(editButton);
		
		JTextField idTxt = new JTextField();
		idTxt.setColumns(10);
		idTxt.setBounds(342, 335, 85, 20);
		editPanel.add(idTxt);
		
		JLabel idLabel = new JLabel("Product ID");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabel.setBounds(342, 304, 104, 20);
		editPanel.add(idLabel);
		
		JLabel quantityLabel2 = new JLabel("Quantity");
		quantityLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		quantityLabel2.setBounds(662, 178, 104, 20);
		editPanel.add(quantityLabel2);
		
		JTextField quantityTxt2 = new JTextField();
		quantityTxt2.setColumns(10);
		quantityTxt2.setBounds(663, 209, 75, 20);
		editPanel.add(quantityTxt2);
		
		JLabel categoryLabel2 = new JLabel("Category");
		categoryLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		categoryLabel2.setBounds(342, 240, 104, 20);
		editPanel.add(categoryLabel2);
		
		JComboBox<String> category2 = new JComboBox<String>();
		category2.setOpaque(false);
		category2.setBackground(Color.WHITE);
		category2.setBounds(342, 271, 120, 22);
		editPanel.add(category2);
		
		JLabel brandLabel2 = new JLabel("Brand");
		brandLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		brandLabel2.setBounds(496, 240, 104, 20);
		editPanel.add(brandLabel2);
		
		JComboBox<String> brand2 = new JComboBox<String>();
		brand2.setOpaque(false);
		brand2.setBackground(Color.WHITE);
		brand2.setBounds(496, 271, 120, 22);
		editPanel.add(brand2);
		
		JLabel priceLabel2 = new JLabel("Price");
		priceLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		priceLabel2.setBounds(785, 178, 104, 20);
		editPanel.add(priceLabel2);
		
		JTextField priceTxt2 = new JTextField();
		priceTxt2.setColumns(10);
		priceTxt2.setBounds(783, 209, 75, 20);
		editPanel.add(priceTxt2);
		
		JButton addPanelButton = new JButton("Add");
		addPanelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				overviewPanel.setVisible(false);
				editPanel.setVisible(false);
				addPanel.setVisible(true);
			}
		});
		
		addPanelButton.setFocusable(false);
		addPanelButton.setBounds(21, 695, 89, 26);
		add(addPanelButton);
		
		JButton overviewPanelButton = new JButton("Overview");
		overviewPanelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPanel.setVisible(false);
				editPanel.setVisible(false);
				overviewPanel.setVisible(true);
			}
		});
		overviewPanelButton.setFocusable(false);
		overviewPanelButton.setBounds(108, 695, 89, 26);
		add(overviewPanelButton);
		
		JButton editPanelButton = new JButton("Edit");
		editPanelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPanel.setVisible(false);
				overviewPanel.setVisible(false);
				editPanel.setVisible(true);
			}
		});
		editPanelButton.setFocusable(false);
		editPanelButton.setBounds(196, 695, 89, 26);
		add(editPanelButton);
	}
}
