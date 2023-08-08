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

public class OrdersPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtorderId;

	/**
	 * Create the panel.
	 */
	public OrdersPanel() {
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
		
		JTextField dateTxt = new JTextField();
		dateTxt.setBounds(341, 172, 147, 20);
		dateTxt.setColumns(10);
		addPanel.add(dateTxt);
		
		
		JLabel dateLabel = new JLabel("Date");
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateLabel.setBounds(341, 141, 45, 20);
		addPanel.add(dateLabel);
		
		CustomJButton addproductButton = new CustomJButton();
		addproductButton.setText("Add Product");
		addproductButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addproductButton.setFocusable(false);
		addproductButton.setColorOver(new Color(0, 240, 145));
		addproductButton.setColorClick(new Color(32, 255, 166));
		addproductButton.setColor(new Color(0, 211, 127));
		addproductButton.setBorderColor(Color.WHITE);
		addproductButton.setBackground(new Color(0, 211, 127));
		addproductButton.setBounds(339, 278, 106, 41);
		addPanel.add(addproductButton);
		
		CustomJButton deleteproductButton = new CustomJButton();
		deleteproductButton.setText("Delete Product");
		deleteproductButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteproductButton.setFocusable(false);
		deleteproductButton.setColorOver(new Color(0, 240, 145));
		deleteproductButton.setColorClick(new Color(32, 255, 166));
		deleteproductButton.setColor(new Color(0, 211, 127));
		deleteproductButton.setBorderColor(Color.WHITE);
		deleteproductButton.setBackground(new Color(0, 211, 127));
		deleteproductButton.setBounds(481, 278, 125, 41);
		addPanel.add(deleteproductButton);
		
		CustomJButton addorderButton = new CustomJButton();
		addorderButton.setText("Add Order");
		addorderButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addorderButton.setFocusable(false);
		addorderButton.setColorOver(new Color(0, 240, 145));
		addorderButton.setColorClick(new Color(32, 255, 166));
		addorderButton.setColor(new Color(0, 211, 127));
		addorderButton.setBorderColor(Color.WHITE);
		addorderButton.setBackground(new Color(0, 211, 127));
		addorderButton.setBounds(339, 507, 97, 41);
		addPanel.add(addorderButton);
		
		JLabel customerLabel = new JLabel("Customer Name");
		customerLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		customerLabel.setBounds(525, 141, 104, 20);
		addPanel.add(customerLabel);
		
		JTextField customerTxt = new JTextField();
		customerTxt.setColumns(10);
		customerTxt.setBounds(525, 172, 212, 20);
		addPanel.add(customerTxt);
		
		JLabel productLabel = new JLabel("Product");
		productLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		productLabel.setBounds(341, 203, 104, 20);
		addPanel.add(productLabel);
		
		JComboBox<String> product = new JComboBox<String>();
		product.setOpaque(false);
		product.setBackground(Color.WHITE);
		product.setBounds(341, 234, 120, 22);
		addPanel.add(product);
		
		JLabel priceLabel = new JLabel("Price");
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		priceLabel.setBounds(495, 203, 104, 20);
		addPanel.add(priceLabel);
		
		JTextField priceTxt = new JTextField();
		priceTxt.setEnabled(false);
		priceTxt.setColumns(10);
		priceTxt.setBounds(495, 235, 111, 20);
		addPanel.add(priceTxt);
		
		JTextField quantityTxt = new JTextField();
		quantityTxt.setColumns(10);
		quantityTxt.setBounds(640, 235, 97, 20);
		addPanel.add(quantityTxt);
		
		JLabel quantityLabel = new JLabel("Quantity");
		quantityLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		quantityLabel.setBounds(640, 203, 104, 20);
		addPanel.add(quantityLabel);
		
		JTextField totalTxt = new JTextField();
		totalTxt.setColumns(10);
		totalTxt.setBounds(775, 235, 97, 20);
		addPanel.add(totalTxt);
		
		JLabel totalLabel = new JLabel("Total");
		totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		totalLabel.setBounds(775, 203, 104, 20);
		addPanel.add(totalLabel);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(341, 362, 685, 122);
		addPanel.add(scrollPane1);
		
		JTable currorderTable = new JTable();
		scrollPane1.setViewportView(currorderTable);
		
		JLabel orderLabel = new JLabel("Order");
		orderLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		orderLabel.setBounds(341, 331, 104, 20);
		addPanel.add(orderLabel);
		
		JLabel idLabelAdd = new JLabel("Search By Product ID");
		idLabelAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabelAdd.setBounds(341, 86, 162, 20);
		addPanel.add(idLabelAdd);
		
		JTextField idTxtAdd = new JTextField();
		idTxtAdd.setColumns(10);
		idTxtAdd.setBounds(341, 117, 85, 20);
		addPanel.add(idTxtAdd);
		
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
		
		JTable allordersTable = new JTable();
		scrollPane.setViewportView(allordersTable);
		
		JPanel editPanel = new JPanel();
		editPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		editPanel.setBackground(Color.WHITE);
		categoryManager.add(editPanel);
		editPanel.setLayout(null);
		
		JTextField dateTxt2 = new JTextField();
		dateTxt2.setBounds(341, 115, 147, 20);
		dateTxt2.setColumns(10);
		editPanel.add(dateTxt2);
		
		
		JLabel dateLabel2 = new JLabel("Date");
		dateLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateLabel2.setBounds(341, 84, 45, 20);
		editPanel.add(dateLabel2);
		
		CustomJButton addproductButton2 = new CustomJButton();
		addproductButton2.setText("Add Product");
		addproductButton2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addproductButton2.setFocusable(false);
		addproductButton2.setColorOver(new Color(0, 240, 145));
		addproductButton2.setColorClick(new Color(32, 255, 166));
		addproductButton2.setColor(new Color(0, 211, 127));
		addproductButton2.setBorderColor(Color.WHITE);
		addproductButton2.setBackground(new Color(0, 211, 127));
		addproductButton2.setBounds(339, 221, 106, 41);
		editPanel.add(addproductButton2);
		
		CustomJButton deleteproductButton2 = new CustomJButton();
		deleteproductButton2.setText("Delete Product");
		deleteproductButton2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteproductButton2.setFocusable(false);
		deleteproductButton2.setColorOver(new Color(0, 240, 145));
		deleteproductButton2.setColorClick(new Color(32, 255, 166));
		deleteproductButton2.setColor(new Color(0, 211, 127));
		deleteproductButton2.setBorderColor(Color.WHITE);
		deleteproductButton2.setBackground(new Color(0, 211, 127));
		deleteproductButton2.setBounds(481, 221, 125, 41);
		editPanel.add(deleteproductButton2);
		
		CustomJButton editorderButton = new CustomJButton();
		editorderButton.setText("Edit Order");
		editorderButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editorderButton.setFocusable(false);
		editorderButton.setColorOver(new Color(0, 240, 145));
		editorderButton.setColorClick(new Color(32, 255, 166));
		editorderButton.setColor(new Color(0, 211, 127));
		editorderButton.setBorderColor(Color.WHITE);
		editorderButton.setBackground(new Color(0, 211, 127));
		editorderButton.setBounds(339, 507, 97, 41);
		editPanel.add(editorderButton);
		
		JLabel customerLabel2 = new JLabel("Customer Name");
		customerLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		customerLabel2.setBounds(525, 84, 104, 20);
		editPanel.add(customerLabel2);
		
		JTextField customerTxt2 = new JTextField();
		customerTxt2.setColumns(10);
		customerTxt2.setBounds(525, 115, 212, 20);
		editPanel.add(customerTxt2);
		
		JLabel productLabel2 = new JLabel("Product");
		productLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		productLabel2.setBounds(341, 146, 104, 20);
		editPanel.add(productLabel2);
		
		JComboBox<String> product2 = new JComboBox<String>();
		product2.setOpaque(false);
		product2.setBackground(Color.WHITE);
		product2.setBounds(341, 177, 120, 22);
		editPanel.add(product2);
		
		JLabel priceLabel2 = new JLabel("Price");
		priceLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		priceLabel2.setBounds(495, 146, 104, 20);
		editPanel.add(priceLabel2);
		
		JTextField priceTxt2 = new JTextField();
		priceTxt2.setEnabled(false);
		priceTxt2.setColumns(10);
		priceTxt2.setBounds(495, 178, 111, 20);
		editPanel.add(priceTxt2);
		
		JTextField quantityTxt2 = new JTextField();
		quantityTxt2.setColumns(10);
		quantityTxt2.setBounds(640, 178, 97, 20);
		editPanel.add(quantityTxt2);
		
		JLabel quantityLabel2 = new JLabel("Quantity");
		quantityLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		quantityLabel2.setBounds(640, 146, 104, 20);
		editPanel.add(quantityLabel2);
		
		JTextField totalTxt2 = new JTextField();
		totalTxt2.setColumns(10);
		totalTxt2.setBounds(775, 178, 97, 20);
		editPanel.add(totalTxt2);
		
		JLabel totalLabel2 = new JLabel("Total");
		totalLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		totalLabel2.setBounds(775, 146, 104, 20);
		editPanel.add(totalLabel2);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(341, 362, 685, 122);
		editPanel.add(scrollPane2);
		
		JTable currorderTable2 = new JTable();
		scrollPane2.setViewportView(currorderTable2);
		
		JLabel orderLabel2 = new JLabel("Order");
		orderLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		orderLabel2.setBounds(341, 331, 104, 20);
		editPanel.add(orderLabel2);
		
		JLabel idLabelAdd2 = new JLabel("Search By Product ID");
		idLabelAdd2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabelAdd2.setBounds(341, 29, 162, 20);
		editPanel.add(idLabelAdd2);
		
		JTextField idTxtAdd2 = new JTextField();
		idTxtAdd2.setColumns(10);
		idTxtAdd2.setBounds(341, 60, 85, 20);
		editPanel.add(idTxtAdd2);
		
		CustomJButton deleteorderButton = new CustomJButton();
		deleteorderButton.setText("Delete Order");
		deleteorderButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteorderButton.setFocusable(false);
		deleteorderButton.setColorOver(new Color(0, 240, 145));
		deleteorderButton.setColorClick(new Color(32, 255, 166));
		deleteorderButton.setColor(new Color(0, 211, 127));
		deleteorderButton.setBorderColor(Color.WHITE);
		deleteorderButton.setBackground(new Color(0, 211, 127));
		deleteorderButton.setBounds(481, 507, 97, 41);
		editPanel.add(deleteorderButton);
		
		JLabel orderidlabel = new JLabel("Search By Order ID");
		orderidlabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		orderidlabel.setBounds(341, 273, 162, 20);
		editPanel.add(orderidlabel);
		
		txtorderId = new JTextField();
		txtorderId.setColumns(10);
		txtorderId.setBounds(341, 304, 85, 20);
		editPanel.add(txtorderId);
		
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
