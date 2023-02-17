package screen;

import java.awt.*;


import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	protected static HomePanel homePanel; 
	protected static CategoryPanel categoryPanel;
	protected static BrandPanel brandPanel;
	protected static ProductPanel productPanel;
	protected static OrdersPanel ordersPanel;
	
	protected static JPanel currentPanel;

	public MainPanel() {
		//setBackground(new Color(175, 248, 200));
		setBackground(Color.WHITE);
		setBounds(227, 0, 1180, 773);
		setLayout(new CardLayout(0, 0));
		

		homePanel = new HomePanel();
		add(homePanel);
		
		categoryPanel = new CategoryPanel();
		add(categoryPanel);
		
		brandPanel = new BrandPanel();
		add(brandPanel);
		
		productPanel = new ProductPanel();
		add(productPanel);
		
		ordersPanel = new OrdersPanel();
		add(ordersPanel);
		
		
		
		currentPanel = homePanel;
	}
	
	public enum PANELS {
		HOME, CATEGORY, BRAND, PRODUCT, ORDERS
	}
	
	public static void setPanel(PANELS panel) {
		switch(panel) {
		case HOME:
			currentPanel.setVisible(false);
			homePanel.setVisible(true);
			currentPanel = homePanel;
			break;
		case CATEGORY:
			currentPanel.setVisible(false);
			categoryPanel.setVisible(true);
			currentPanel = categoryPanel;
			break;
		case BRAND:
			currentPanel.setVisible(false);
			brandPanel.setVisible(true);
			currentPanel = brandPanel;
			break;
		case PRODUCT:
			currentPanel.setVisible(false);
			productPanel.setVisible(true);
			currentPanel = productPanel;
			break;
		case ORDERS:
			currentPanel.setVisible(false);
			ordersPanel.setVisible(true);
			currentPanel = ordersPanel;
			break;
		default:
			System.out.println("Error");
			break;
		}
	}
}
