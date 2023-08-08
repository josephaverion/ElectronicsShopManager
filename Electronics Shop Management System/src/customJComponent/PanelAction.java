package customJComponent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.*;

public class PanelAction extends JPanel {

	/**
	 * Create the panel.
	 */
	private ActionButton cmdEdit;
	private ActionButton cmdDelete;
	private ActionButton cmdView;
	
	
	public PanelAction() {
		cmdEdit = new ActionButton();
		cmdEdit.setIcon(new ImageIcon(PanelAction.class.getResource("/icons8-edit-16.png")));
		cmdEdit.setBounds(20, 11, 23, 23);
		add(cmdEdit);
		
		cmdDelete = new ActionButton();
		cmdDelete.setIcon(new ImageIcon(PanelAction.class.getResource("/icons8-delete-16.png")));
		cmdDelete.setBounds(53, 11, 23, 23);
		add(cmdDelete);
		
		cmdView = new ActionButton();
		cmdView.setIcon(new ImageIcon(PanelAction.class.getResource("/icons8-view-16.png")));
		cmdView.setBounds(86, 11, 23, 23);
		add(cmdView);
		
		
	}
	
	public void initEvent(TableActionEvent event, int row) {
		cmdEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				event.onEdit(row);
			}
		});
		
		cmdDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				event.onDelete(row);
			}
		});
		
		cmdView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				event.onView(row);
			}
		});
	}

}
