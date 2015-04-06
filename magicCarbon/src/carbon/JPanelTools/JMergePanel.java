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
 * This is free and unencumbered software released into the public domain.
 *  For more information, please refer to <http://unlicense.org/>
 */

public class JMergePanel {

	public JPanel createMergedPanel(List<JPanel>panels) {
		 
	//	 int numPanels=panels.size();
	
		JPanel leftPanel = new JPanel(new GridLayout(0, 1));
		JPanel rightPanel = new JPanel(new GridLayout(0, 1));
		JPanel bottomPanel = new JPanel(new GridLayout(0, 1));
		JCatPanel  mergePanel  = new JCatPanel();
		JSideCatPanel  sideMergePanel  = new JSideCatPanel();
		
		for (int i=0; i<3;i++){
			bottomPanel = mergePanel.catPanel(leftPanel, panels.get(i));
			leftPanel=bottomPanel;
			
		}
		leftPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		
        for (int i=3; i<7;i++){
			
			bottomPanel = mergePanel.catPanel(rightPanel, panels.get(i));
			rightPanel=bottomPanel;
			
		}
		rightPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	
		 return sideMergePanel.sideCatPanel(leftPanel,rightPanel);
	}
	
}
