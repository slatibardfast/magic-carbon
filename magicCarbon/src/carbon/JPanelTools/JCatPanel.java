package carbon.JPanelTools;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * Concatonates 2 panels into a single panel
 * 
 * @author Will Grey
 * 
 * @version 2015-04-04
 * 
 */

public class JCatPanel {

	public JPanel catPanel(JPanel panel1, JPanel panel2) {
		final JPanel panel = new JPanel(new BorderLayout());
		panel.add(panel1,BorderLayout.NORTH);
		panel.add(panel2,BorderLayout.SOUTH);
		return panel;
	}

	
}
