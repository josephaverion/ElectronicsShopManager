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

public class BrandPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
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
		
		CustomJButton addButton = new CustomJButton();
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

		JTextField brandTxt2 = new JTextField();
		brandTxt2.setBounds(342, 242, 274, 20);
		brandTxt2.setColumns(10);
		editPanel.add(brandTxt2);
		
		
		JLabel nameLabel2 = new JLabel("Brand Name");
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
		
		
		CustomJButton editButton = new CustomJButton();
		editButton.setText("Edit");
		editButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editButton.setFocusable(false);
		editButton.setColorOver(new Color(0, 240, 145));
		editButton.setColorClick(new Color(32, 255, 166));
		editButton.setColor(new Color(0, 211, 127));
		editButton.setBorderColor(Color.WHITE);
		editButton.setBackground(new Color(0, 211, 127));
		editButton.setBounds(340, 326, 97, 41);
		editPanel.add(editButton);
		
		JTextField idTxt = new JTextField();
		idTxt.setColumns(10);
		idTxt.setBounds(342, 295, 85, 20);
		editPanel.add(idTxt);
		
		JLabel idLabel = new JLabel("Brand ID");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabel.setBounds(341, 271, 104, 20);
		editPanel.add(idLabel);
		
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
