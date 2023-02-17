package customJComponent;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;

public class CustomJButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean over;
	private Color color;
	private Color colorOver;
	private Color colorClick;
	private Color borderColor;
	private MouseListener ml;
	
	public CustomJButton() {
		setContentAreaFilled(false);
		setBorder(null);
		setFocusable(false);
		
		ml = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(colorOver);
				over = true;
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(color);
				over = false;
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				setBackground(colorClick);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(over) {
					setBackground(colorOver);
				} else {
					setBackground(color);
				}
			}
		};
		
		if(isEnabled()) {
			enable();
		}
	}
	
	public void enable() {
		addMouseListener(ml);
		
	}
	
	public void disable() {
		removeMouseListener(ml);
	}
	
	public boolean isOver() {
		return over;
	}

	public void setColor(Color color) {
		this.color = color;
		setBackground(color);
	}
	
	public Color getColor() {
		return color;
	}

	public void setColorOver(Color colorOver) {
		this.colorOver = colorOver;
	}
	
	public Color getColorOver() {
		return colorOver;
	}

	public void setColorClick(Color colorClick) {
		this.colorClick = colorClick;
	}
	
	public Color getColorClick() {
		return colorClick;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}
	
	public Color getBorderColor() {
		return borderColor;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2D.setColor(borderColor);
		g2D.fillRect(0, 0, getWidth(), getHeight());
		g2D.setColor(getBackground());
		g2D.fillRect(2, 2, getWidth() - 4, getHeight() - 4);
		super.paintComponent(g);
	}
}
