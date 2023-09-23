package screen;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import customJComponent.CustomJButton;
import customJComponent.TableActionCellEditor;
import customJComponent.TableActionCellRender;
import customJComponent.TableActionEvent;
import database.Database;

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
		
		JTextField productTxt = new JTextField();
		productTxt.setBounds(342, 209, 274, 20);
		productTxt.setColumns(10);
		addPanel.add(productTxt);
		
		
		JLabel nameLabel = new JLabel("Product Name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameLabel.setBounds(342, 178, 104, 20);
		addPanel.add(nameLabel);
				
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
		category.setModel(new DefaultComboBoxModel<String>(Database.getColumn("categories", "category_name")));
		category.setOpaque(false);
		category.setBackground(Color.WHITE);
		category.setBounds(342, 271, 120, 22);
		addPanel.add(category);
		
		JLabel brandLabel = new JLabel("Brand");
		brandLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		brandLabel.setBounds(496, 240, 104, 20);
		addPanel.add(brandLabel);
		
		JComboBox<String> brand = new JComboBox<String>();
		brand.setModel(new DefaultComboBoxModel<String>(Database.getColumn("brands", "brand_name")));
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
		
		JPanel editPopup = new JPanel();
		
		editPopup.setBounds(200, 125, 571, 300);
		editPopup.setBackground(new Color(255, 255, 255));
		editPopup.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		editPopup.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		editPopup.setLayout(null);
		
		JLabel editTitlePopup = new JLabel("Edit Product Information");
		editTitlePopup.setFont(new Font("Tahoma", Font.PLAIN, 24));
		editTitlePopup.setBounds(159, 11, 423, 63);
		editPopup.add(editTitlePopup);
		
		JTextField nameTextFieldPopup = new JTextField();
		nameTextFieldPopup.setColumns(10);
		nameTextFieldPopup.setBounds(46, 117, 149, 20);
		editPopup.add(nameTextFieldPopup);
		
		JLabel nameLabelPopup = new JLabel("Product Name");
		nameLabelPopup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameLabelPopup.setBounds(46, 86, 104, 20);
		editPopup.add(nameLabelPopup);
		
		JLabel categoryLabelPopup = new JLabel("Category");
		categoryLabelPopup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		categoryLabelPopup.setBounds(46, 148, 104, 20);
		editPopup.add(categoryLabelPopup);
		
		JComboBox<String> categoryPopup = new JComboBox<String>();
		categoryPopup.setOpaque(false);
		categoryPopup.setModel(new DefaultComboBoxModel<String>(new String[] {"Available", "Not Available"}));
		categoryPopup.setBounds(46, 179, 120, 22);
		editPopup.add(categoryPopup);	
		
		editPopup.setLocation(201, 125);
		editPopup.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 176, 1086, 334);
		
		overviewPanel.add(scrollPane);
		
		JTable productTable = new JTable();
		productTable.setRowHeight(40);
		scrollPane.setViewportView(productTable);
		productTable.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID", "Name", "Quantity", "Price", "Category", "Brand", "Action"
			}
		) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		DefaultTableModel model = (DefaultTableModel) productTable.getModel();

		overviewPanel.setComponentZOrder(editPopup, 0);
		CustomJButton cancelButtonPopup = new CustomJButton();
		cancelButtonPopup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editPopup.setVisible(false);		
				scrollPane.setWheelScrollingEnabled(true);
				productTable.setEnabled(true);
			}
		});
		
		
		
		cancelButtonPopup.setText("Cancel");
		cancelButtonPopup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cancelButtonPopup.setFocusable(false);
		cancelButtonPopup.setColorOver(new Color(0, 240, 145));
		cancelButtonPopup.setColorClick(new Color(32, 255, 166));
		cancelButtonPopup.setColor(new Color(0, 211, 127));
		cancelButtonPopup.setBorderColor(Color.WHITE);
		cancelButtonPopup.setBackground(new Color(0, 211, 127));
		cancelButtonPopup.setBounds(438, 229, 97, 41);
		editPopup.add(cancelButtonPopup);
		
		JTextField quantityTextFieldPopup = new JTextField();
		quantityTextFieldPopup.setColumns(10);
		quantityTextFieldPopup.setBounds(226, 117, 86, 20);
		editPopup.add(quantityTextFieldPopup);
		
		JTextField priceTextFieldPopup = new JTextField();
		priceTextFieldPopup.setColumns(10);
		priceTextFieldPopup.setBounds(344, 117, 86, 20);
		editPopup.add(priceTextFieldPopup);
		
		JComboBox<String> brandPopup = new JComboBox<String>();
		brandPopup.setOpaque(false);
		brandPopup.setBounds(192, 179, 120, 22);
		editPopup.add(brandPopup);
		
		JLabel brandLabelPopup = new JLabel("Brand");
		brandLabelPopup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		brandLabelPopup.setBounds(192, 148, 104, 20);
		editPopup.add(brandLabelPopup);
		
		JLabel quantityLabelPopup = new JLabel("Quantity");
		quantityLabelPopup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		quantityLabelPopup.setBounds(226, 85, 66, 20);
		editPopup.add(quantityLabelPopup);
		
		JLabel priceLabelPopup = new JLabel("Price");
		priceLabelPopup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		priceLabelPopup.setBounds(344, 85, 66, 20);
		editPopup.add(priceLabelPopup);
		
		overviewPanel.add(editPopup);
		
		TableActionEvent event = new TableActionEvent() {
			public void onEdit(int row) {
				// work on: add randomized ID???
				editPopup.setVisible(true);		
				scrollPane.setWheelScrollingEnabled(false);
				overviewPanel.setComponentZOrder(editPopup, 0);
				productTable.setEnabled(false);
				
				Integer pId = (Integer) model.getValueAt(row, 0);
				String[] columns = {"product_name", "product_quantity", "product_price", "product_category", "product_brand"};
				Object[] objectData = Database.getEntry(columns, "products", "product_id", pId);
				String[] data = Arrays.copyOf(objectData, objectData.length, String[].class);
				if (data == null) {
					JOptionPane.showMessageDialog(null, "Product Doesn't Exist");
					return;
				}
				nameTextFieldPopup.setText(data[0]);
				quantityTextFieldPopup.setText(data[1]);
				priceTextFieldPopup.setText(data[2]);
				categoryPopup.setSelectedItem(data[3]);
				brandPopup.setSelectedItem(data[4]);
				categoryPopup.setModel(new DefaultComboBoxModel<String>(Database.getColumn("categories", "category_name")));
				brandPopup.setModel(new DefaultComboBoxModel<String>(Database.getColumn("brands", "brand_name")));
			}
			
			public void onDelete(int row) {
				if (productTable.isEditing()) {
					productTable.getCellEditor().stopCellEditing();
				}
				int pId = (Integer) model.getValueAt(row, 0);
				Database.deleteEntry("products", "product_id", pId, model, row);
			}
			
			public void onView(int row) {
				System.out.println("View row: " + row);
			}
		};
		
		Database.refreshTables(model, "products");
		productTable.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
		productTable.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
		
		CustomJButton editButtonPopup = new CustomJButton();
		editButtonPopup.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String pname = nameTextFieldPopup.getText().trim();
				if(pname.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Type Something For Product Name");
					return;
				}
				String quantity = quantityTextFieldPopup.getText().trim();
				if(quantity.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Type Something For Product Quantity");
					return;
				}
				String price = priceTextFieldPopup.getText().trim();
				if(price.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Type Something For Product Price");
					return;
				}
				
				int row = productTable.getSelectedRow();
		
				int pId = (Integer) model.getValueAt(row, 0);
				String pcategory = category.getSelectedItem().toString();
				String pbrand = brand.getSelectedItem().toString();
				String[] columns = {"product_name", "product_price","product_quantity", "product_category", "product_brand"};
				Object[] toEdit = {pname, Integer.valueOf(price), Integer.valueOf(quantity), pcategory, pbrand};
				
				Database.editEntry(columns, toEdit, "products", "product_id", pId);		
				JOptionPane.showMessageDialog(null, "Product Edited!");
						
				editPopup.setVisible(false);		
				scrollPane.setWheelScrollingEnabled(true);
				productTable.setEnabled(true);
				Database.refreshTables(model, "products");
				productTable.setRowSelectionInterval(row, row);		
			}
		});
		
		editButtonPopup.setText("Done");
		editButtonPopup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editButtonPopup.setFocusable(false);
		editButtonPopup.setColorOver(new Color(0, 240, 145));
		editButtonPopup.setColorClick(new Color(32, 255, 166));
		editButtonPopup.setColor(new Color(0, 211, 127));
		editButtonPopup.setBorderColor(Color.WHITE);
		editButtonPopup.setBackground(new Color(0, 211, 127));
		editButtonPopup.setBounds(317, 229, 97, 41);
		editPopup.add(editButtonPopup);
		
		CustomJButton addButton = new CustomJButton();
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pname = productTxt.getText().trim();
				if(pname.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Type Something For Product Name");
					return;
				}
				String quantity = quantityTxt.getText().trim();
				if(quantity.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Type Something For Product Quantity");
					return;
				}
				String price = priceTxt.getText().trim();
				if(price.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Type Something For Product Price");
					return;
				}
				
				String pcategory = category.getSelectedItem().toString();
				String pbrand = brand.getSelectedItem().toString();
				String[] columns = {"product_name", "product_price","product_quantity", "product_category", "product_brand"};
				Object[] toAdd = {pname, Integer.valueOf(price), Integer.valueOf(quantity), pcategory, pbrand};
				
				Database.addEntry(columns, toAdd, "products");
				Database.refreshTables(model, "products");
				priceTxt.setText("");
				JOptionPane.showMessageDialog(null, "Product Added!");
			}
		});
		
		addButton.setText("Add");
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addButton.setFocusable(false);
		addButton.setColorOver(new Color(0, 240, 145));
		addButton.setColorClick(new Color(32, 255, 166));
		addButton.setColor(new Color(0, 211, 127));
		addButton.setBorderColor(Color.WHITE);
		addButton.setBackground(new Color(0, 211, 127));
		addButton.setBounds(340, 315, 97, 41);
		addPanel.add(addButton);
		
		JButton addPanelButton = new JButton("Add");
		addPanelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				overviewPanel.setVisible(false);
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
				overviewPanel.setVisible(true);
			}
		});
		overviewPanelButton.setFocusable(false);
		overviewPanelButton.setBounds(108, 695, 89, 26);
		add(overviewPanelButton);
	}
}
