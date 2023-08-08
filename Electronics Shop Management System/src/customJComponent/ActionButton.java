package customJComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ActionButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean mousePress;

	public ActionButton() {
		setContentAreaFilled(false);
		setBorder(null);
		setFocusable(false);
		setBorder(new EmptyBorder(3,3,3,3));
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				mousePress = true;
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				mousePress = false;
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g.create();
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int width = getWidth();
		int height = getHeight();
		int size = Math.min(width, height);
		int x = (width-size)/2;
		int y = (height-size)/2;
		if (mousePress) {
			g2D.setColor(new Color(158,158,158));
		} else {
			g2D.setColor(new Color(199,199,199));
		}
		g2D.fill(new Ellipse2D.Double(x, y, size, size));
		g2D.dispose();
		super.paintComponent(g);
	}
}
