package carbon.JPanelTools;

import java.awt.GridLayout;

import javax.swing.*;

import java.util.*;

/**
 * Merges multiple panels into a single panel
 * 
 * @author Will Grey
 * 
 * @version 2015-04-04
 * 
 */

public class JMergePanel {

	public JPanel createMergedPanel(List<JPanel>panels) {
		 
		 int numPanels=panels.size();
		
		JPanel topPanel = new JPanel(new GridLayout(0, 1));
		JPanel bottomPanel = new JPanel(new GridLayout(0, 1));
		JCatPanel  mergePanel  = new JCatPanel();
		
		for (int i=0; i<numPanels;i++){
			
			bottomPanel = mergePanel.catPanel(topPanel, panels.get(i));
			topPanel=bottomPanel;
			
		}
		topPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		 return topPanel;
	}
	
}
