package carbon.JPanelTools;

import java.awt.GridLayout;
import javax.swing.*;
import java.util.*;

/**
 * Creates a radio button panel
 * 
 * @author Will Grey
 * 
 * @version 2015-04-04
 * 
 * This is free and unencumbered software released into the public domain.
 *  For more information, please refer to <http://unlicense.org/>
 */ 

public class JRadioPanelGroup {
   
	public JPanel createRadioButtonPanel(List<JRadioButton>radioButtons, String title) {
		 
		int numButtons=radioButtons.size();
	
		ButtonGroup group = new ButtonGroup();
		JPanel radioButtonPanel = new JPanel(new GridLayout(0, 1));
		radioButtonPanel.add(new JLabel(title));
		
		for (int i=0; i<numButtons;i++){
		
			 group.add(radioButtons.get(i));
			 radioButtonPanel.add(radioButtons.get(i));
		
		}
		
		radioButtons.get(0).setSelected(true);
		radioButtonPanel.add(new JLabel(""));
		 radioButtonPanel.setBorder(BorderFactory.createEtchedBorder());
		 return radioButtonPanel;
	}
	
}
