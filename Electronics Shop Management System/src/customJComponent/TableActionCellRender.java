package customJComponent;

import java.awt.Component;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableActionCellRender extends DefaultTableCellRenderer {
	@Override
	public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSelected, boolean bln1, int row, int column) {
		Component com = super.getTableCellRendererComponent(jtable, o, isSelected, bln1, row, column);
		PanelAction action = new PanelAction();
		if(isSelected == false && row % 2 == 0) {
			action.setBackground(Color.WHITE);
		} else {
			action.setBackground(com.getBackground());
		}
		return action;
	}
}
