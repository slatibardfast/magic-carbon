package carbon.plot;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

/*
 *  Display Plots
 * 
 * @ author Will Grey
 * 
 * @ version 2015-04-04
 * 
 */

public class DisplayImage  {

	public DisplayImage(final String image) {
		 
		JPanel panel = addImageToPanel(image);
        addImageToFrame(panel);  

		 }

	private JPanel addImageToPanel(final String img) {
	
		ImageIcon image = new ImageIcon(img);
		JLabel label = new JLabel(image);
		JPanel panel = new JPanel(new BorderLayout());
		panel.add( label, BorderLayout.CENTER );
		return panel;
	
	}

	private void addImageToFrame(JPanel panel) {
		
		JFrame frame =new JFrame();  
		  frame.add(panel);  
		  frame.setSize(600,400);  
		  frame.setVisible(true);
	}  
		
}
