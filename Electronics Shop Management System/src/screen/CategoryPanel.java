package screen;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.CardLayout;


import customJComponent.CustomJButton;
import customJComponent.TableActionCellEditor;
import customJComponent.TableActionCellRender;
import customJComponent.TableActionEvent;
import database.Database;

import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class CategoryPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTable categoryTable;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("serial")
	public CategoryPanel() {
		setBackground(Color.WHITE);
		setBounds(227, 0, 1180, 773);
		setLayout(null);
		
		JLabel topBorder = new JLabel();
		topBorder.setOpaque(true);
		topBorder.setBackground(new Color(0, 255, 128));
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
		categoryTxt.setBounds(342, 242, 274, 20);
		categoryTxt.setColumns(10);
		addPanel.add(categoryTxt);
		
		JLabel nameLabel = new JLabel("Category Name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameLabel.setBounds(342, 217, 104, 20);
		addPanel.add(nameLabel);
		
		JComboBox<String> availability = new JComboBox<String>();
		availability.setOpaque(false);
		availability.setBackground(new Color(255, 255, 255));
		availability.setModel(new DefaultComboBoxModel<String>(new String[] {"Available", "Not Available"}));
		availability.setBounds(693, 241, 120, 22);
		addPanel.add(availability);
		
		JLabel statusLabel = new JLabel("Status");
		statusLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		statusLabel.setBounds(693, 217, 104, 20);
		addPanel.add(statusLabel);
		
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
		

	
		categoryTable = new JTable();
		categoryTable.setRowHeight(40);
		scrollPane.setViewportView(categoryTable);
		categoryTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Availability", "Action"
			}
		) {

			boolean[] columnEditables = new boolean[] {
				false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		TableActionEvent event = new TableActionEvent() {
			public void onEdit(int row) {
				System.out.println("Edit row: " + row);
			}
			
			public void onDelete(int row) {
				System.out.println("Delete row: " + row);
			}
			
			public void onView(int row) {
				System.out.println("View row: " + row);
			}
		};
		DefaultTableModel model = (DefaultTableModel) CategoryPanel.categoryTable.getModel();
		Database.refreshTables(model);
		categoryTable.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
		categoryTable.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event));
		
		
		CustomJButton addButton = new CustomJButton();
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cname = categoryTxt.getText().trim();
				if(cname.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Type Something");
					return;
				}
				String cavailible = availability.getSelectedItem().equals("Available") ? "YES" : "NO";
				//Database.addCategory(cname, cavailible);
				String[] columns = {"category_name", "category_availability"};
				ArrayList<Object> toAdd = new ArrayList<Object>();
				toAdd.add(cname);
				toAdd.add(cavailible);
				Database.addEntry(columns, toAdd, "categories");
				Database.refreshTables(model);
				categoryTxt.setText("");
				JOptionPane.showMessageDialog(null, "Category Added!");
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
		addButton.setBounds(340, 280, 97, 41);
		addPanel.add(addButton);
		
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
		categoryTxt2.setBounds(342, 242, 274, 20);
		categoryTxt2.setColumns(10);
		editPanel.add(categoryTxt2);
		
		
		JLabel nameLabel2 = new JLabel("Category Name");
		nameLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameLabel2.setBounds(342, 217, 104, 20);
		editPanel.add(nameLabel2);
		
		JComboBox<String> availability2 = new JComboBox<String>();
		availability2.setOpaque(false);
		availability2.setBackground(new Color(255, 255, 255));
		availability2.setModel(new DefaultComboBoxModel<String>(new String[] {"Available", "Not Available"}));
		availability2.setBounds(693, 241, 120, 22);
		editPanel.add(availability2);
		
		JLabel statusLabel2 = new JLabel("Status");
		statusLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		statusLabel2.setBounds(693, 217, 104, 20);
		editPanel.add(statusLabel2);
		
		JTextField idTxt = new JTextField();
		
		idTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				String cId = idTxt.getText();
				String[] data = Database.getCategory(cId);
				if (data == null) {
					JOptionPane.showMessageDialog(null, "Category Doesn't Exist");
					return;
				}
				categoryTxt2.setText(data[0]);
				String cavailible = "";
				cavailible = data[1].equals("YES") ? "Available" : "Not Available";

				availability2.setSelectedItem(cavailible);
			}
		});
		
		idTxt.setColumns(10);
		idTxt.setBounds(342, 186, 85, 20);
		editPanel.add(idTxt);
		
		JLabel idLabel = new JLabel("Search By Category ID");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabel.setBounds(342, 155, 156, 20);
		editPanel.add(idLabel);
		
		CustomJButton editButton = new CustomJButton();
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cname = categoryTxt2.getText().trim();
				if (cname.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Type Something");
					return;
				}
				String cavailible = availability2.getSelectedItem().equals("Available") ? "YES" : "NO";
				int cId = Integer.parseInt(idTxt.getText());
				Database.editCategory(cname, cavailible, cId);
				//Database.refreshTables();
				categoryTxt.setText("");
				JOptionPane.showMessageDialog(null, "Category Edited!");
			}
		});
		editButton.setText("Edit");
		editButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editButton.setFocusable(false);
		editButton.setColorOver(new Color(0, 240, 145));
		editButton.setColorClick(new Color(32, 255, 166));
		editButton.setColor(new Color(0, 211, 127));
		editButton.setBorderColor(Color.WHITE);
		editButton.setBackground(new Color(0, 211, 127));
		editButton.setBounds(340, 280, 97, 41);
		editPanel.add(editButton);
		
		CustomJButton deleteButton = new CustomJButton();
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cId = Integer.parseInt(idTxt.getText());
				Database.deleteCategory(cId);
				// Database.refreshTables();
				categoryTxt.setText("");
				JOptionPane.showMessageDialog(null, "Category Deleted!");
			}
		});
		deleteButton.setText("Delete");
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteButton.setFocusable(false);
		deleteButton.setColorOver(new Color(0, 240, 145));
		deleteButton.setColorClick(new Color(32, 255, 166));
		deleteButton.setColor(new Color(0, 211, 127));
		deleteButton.setBorderColor(Color.WHITE);
		deleteButton.setBackground(new Color(0, 211, 127));
		deleteButton.setBounds(475, 280, 97, 41);
		editPanel.add(deleteButton);
		
		JButton addPanelButton = new JButton("Add");
		addPanelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Database.refreshTables();
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
				//Database.refreshTables();
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
				//Database.refreshTables();
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
