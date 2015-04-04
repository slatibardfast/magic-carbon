package carbon.JPanelTools;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Merges 2 panels side by side into
 *  a single panel.
 * 
 * @author Will Grey
 * 
 * @version 2015-04-04
 * 
 */

public class JSideCatPanel {

	public JPanel sideCatPanel(JPanel panel1, JPanel panel2) {
		final JPanel panel = new JPanel(new BorderLayout());
		panel.add(panel1,BorderLayout.WEST);
		panel.add(panel2,BorderLayout.CENTER);
		 panel.setBorder(BorderFactory.createEtchedBorder());
		return panel;
	}

	
}
