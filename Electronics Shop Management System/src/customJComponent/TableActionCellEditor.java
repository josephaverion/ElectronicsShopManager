package customJComponent;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableActionCellEditor extends DefaultCellEditor {
	
	private TableActionEvent event;
	
	public TableActionCellEditor(TableActionEvent event) {
		super(new JCheckBox());
		this.event = event;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Component getTableCellEditorComponent(JTable jtable, Object o, boolean isSelected, int row, int column) {
		PanelAction action = new PanelAction();
		action.initEvent(event, row);
		action.setBackground(jtable.getSelectionBackground());
		return action;
	}
}
