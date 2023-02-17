package screen;

import java.awt.Color;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HomePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public HomePanel() {
		setBackground(Color.WHITE);
		setBounds(227, 0, 1180, 773);
		setLayout(null);
		
		JLabel totalProductLabel = new JLabel("Total Product");
		totalProductLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalProductLabel.setOpaque(true);
		totalProductLabel.setBackground(new Color(0, 255, 128));
		Image totalProductImage = new ImageIcon(this.getClass().getResource("/product.png")).getImage();
		totalProductLabel.setIcon(new ImageIcon (totalProductImage));
		totalProductLabel.setBounds(309, 216, 147, 77);
		add(totalProductLabel);
		
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
		
		JLabel totalOrdersLabel = new JLabel("Total Orders");
		totalOrdersLabel.setOpaque(true);
		totalOrdersLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalOrdersLabel.setBackground(new Color(0, 255, 128));
		Image totalOrdersImage = new ImageIcon(this.getClass().getResource("/orders.png")).getImage();
		totalOrdersLabel.setIcon(new ImageIcon (totalOrdersImage));
		totalOrdersLabel.setBounds(517, 216, 147, 77);
		add(totalOrdersLabel);
		
		JLabel revenueLabel = new JLabel("Revenue");
		revenueLabel.setOpaque(true);
		revenueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		revenueLabel.setBackground(new Color(0, 255, 128));
		Image revenueImg = new ImageIcon(this.getClass().getResource("/revenue.png")).getImage();
		revenueLabel.setIcon(new ImageIcon (revenueImg));
		revenueLabel.setBounds(724, 216, 147, 77);
		add(revenueLabel);
	}
}
