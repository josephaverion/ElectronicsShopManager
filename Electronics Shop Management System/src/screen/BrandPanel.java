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

public class BrandPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("serial")
	public BrandPanel() {
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
		
		JPanel brandManager = new JPanel();
		brandManager.setBackground(new Color(255, 255, 255));
		brandManager.setBounds(21, 76, 1130, 621);
		add(brandManager);
		brandManager.setLayout(new CardLayout(0, 0));
		
		JPanel addPanel = new JPanel();
		addPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addPanel.setBackground(Color.WHITE);
		brandManager.add(addPanel);
		addPanel.setLayout(null);
		
		addPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addPanel.setBounds(21, 76, 1130, 621);
		addPanel.setBackground(Color.WHITE);
		addPanel.setLayout(null);
		
		JTextField brandTxt = new JTextField();
		brandTxt.setBounds(342, 242, 274, 20);
		brandTxt.setColumns(10);
		addPanel.add(brandTxt);
		
		
		JLabel nameLabel = new JLabel("Brand Name");
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
		brandManager.add(overviewPanel);
		overviewPanel.setLayout(null);
		
		overviewPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		overviewPanel.setBounds(21, 76, 1130, 621);
		overviewPanel.setBackground(Color.WHITE);
		overviewPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 176, 1086, 334);
		
		overviewPanel.add(scrollPane);
		
		JTable brandTable = new JTable();
		brandTable.setRowHeight(40);
		scrollPane.setViewportView(brandTable);
		brandTable.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID", "Name", "Availabile", "Action"
			}
		) {

			boolean[] columnEditables = new boolean[] {
				false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		DefaultTableModel model = (DefaultTableModel) brandTable.getModel();
		
		JPanel editPopup = new JPanel();
		
		editPopup.setBounds(100, 100, 571, 300);
		editPopup.setBackground(new Color(255, 255, 255));
		editPopup.setBorder(new EmptyBorder(5, 5, 5, 5));

		editPopup.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		editPopup.setLayout(null);
		
		JLabel editTitlePopup = new JLabel("Edit Brand Information");
		editTitlePopup.setFont(new Font("Tahoma", Font.PLAIN, 24));
		editTitlePopup.setBounds(159, 11, 423, 63);
		editPopup.add(editTitlePopup);
		
		JTextField nameTextFieldPopup = new JTextField();
		nameTextFieldPopup.setColumns(10);
		nameTextFieldPopup.setBounds(46, 130, 274, 20);
		editPopup.add(nameTextFieldPopup);
		
		JLabel nameLabelPopup = new JLabel("Brand Name");
		nameLabelPopup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameLabelPopup.setBounds(46, 105, 104, 20);
		editPopup.add(nameLabelPopup);
		
		JLabel statusLabelPopup = new JLabel("Status");
		statusLabelPopup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		statusLabelPopup.setBounds(397, 105, 104, 20);
		editPopup.add(statusLabelPopup);
		
		JComboBox<String> availabilityPopup = new JComboBox<String>();
		availabilityPopup.setOpaque(false);
		availability.setBackground(new Color(255, 255, 255));
		availabilityPopup.setModel(new DefaultComboBoxModel<String>(new String[] {"Available", "Not Available"}));
		availabilityPopup.setBounds(397, 129, 120, 22);
		editPopup.add(availabilityPopup);	
		
		editPopup.setLocation(201, 125);
		editPopup.setVisible(false);
		overviewPanel.add(editPopup);
		overviewPanel.setComponentZOrder(editPopup, 0);
		TableActionEvent event = new TableActionEvent() {
			public void onEdit(int row) {
				// work on: add randomized ID???
				editPopup.setVisible(true);		
				scrollPane.setWheelScrollingEnabled(false);
				overviewPanel.setComponentZOrder(editPopup, 0);
				brandTable.setEnabled(false);
				
				Integer bId = (Integer) model.getValueAt(row, 0);
				String[] columns = {"brand_name", "brand_availability"};
				Object[] objectData = Database.getEntry(columns, "brands", "brand_id", bId);
				String[] data = Arrays.copyOf(objectData, objectData.length, String[].class);
				if (data == null) {
					JOptionPane.showMessageDialog(null, "Brand Doesn't Exist");
					return;
				}
				nameTextFieldPopup.setText(data[0]);
				String bavailible = "";
				bavailible = data[1].equals("YES") ? "Available" : "Not Available";

				availabilityPopup.setSelectedItem(bavailible);
			}
			
			public void onDelete(int row) {
				if (brandTable.isEditing()) {
					brandTable.getCellEditor().stopCellEditing();
				}
				int bId = (Integer) model.getValueAt(row, 0);
				Database.deleteEntry("brands", "brand_id", bId, model, row);
			}
			
			public void onView(int row) {
				System.out.println("View row: " + row);
			}
		};
		
		Database.refreshTables(model, "brands");
		brandTable.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
		brandTable.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event));
		
		CustomJButton cancelButtonPopup = new CustomJButton();
		cancelButtonPopup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editPopup.setVisible(false);		
				scrollPane.setWheelScrollingEnabled(true);
				brandTable.setEnabled(true);
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
		cancelButtonPopup.setBounds(408, 189, 97, 41);
		editPopup.add(cancelButtonPopup);
		
		CustomJButton editButtonPopup = new CustomJButton();
		editButtonPopup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bname = nameTextFieldPopup.getText().trim();
				if (bname.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Type Something");
					return;
				}
				String bavailible = availabilityPopup.getSelectedItem().equals("Available") ? "YES" : "NO";
				int row = brandTable.getSelectedRow();
				// use this for the edit button
				int bId = (Integer) model.getValueAt(row, 0);
				String[] columns = {"brand_name", "brand_availability"};
				Object[] toEdit = {bname, bavailible};
				Database.editEntry(columns, toEdit, "brands", "brand_id", bId);		
				JOptionPane.showMessageDialog(null, "Brand Edited!");
				
				editPopup.setVisible(false);		
				scrollPane.setWheelScrollingEnabled(true);
				brandTable.setEnabled(true);
				Database.refreshTables(model, "brands");
				brandTable.setRowSelectionInterval(row, row);
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
		editButtonPopup.setBounds(278, 189, 97, 41);
		editPopup.add(editButtonPopup);
		
		CustomJButton addButton = new CustomJButton();
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bname = brandTxt.getText().trim();
				if(bname.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Type Something");
					return;
				}
				String bavailible = availability.getSelectedItem().equals("Available") ? "YES" : "NO";
				String[] columns = {"brand_name", "brand_availability"};
				Object[] toAdd = {bname, bavailible};
				
				Database.addEntry(columns, toAdd, "brands");
				Database.refreshTables(model, "brands");
				brandTxt.setText("");
				JOptionPane.showMessageDialog(null, "Brand Added!");
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
