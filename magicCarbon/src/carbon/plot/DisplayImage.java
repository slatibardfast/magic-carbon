package carbon.plot;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*
 *  Display Plots
 * 
 * @ author Will Grey
 * 
 * @ version 2015-04-04
 * 
 */

public class DisplayImage  {
	
	JFrame frame =new JFrame();  
	
	public DisplayImage(String image) throws IOException {
		 
		JPanel panel = addImageToPanel(image);
        addImageToFrame(panel);  

		 }

	private JPanel addImageToPanel(String img) throws IOException {
		
		BufferedImage bufferedImage = ImageIO.read(new File(img));
	   ImageIcon image = new ImageIcon(bufferedImage);
		JLabel label = new JLabel(image);
		JPanel panel = new JPanel(new BorderLayout());
	    panel.add(label, BorderLayout.CENTER );
		return panel;
	
	}

	private void addImageToFrame(JPanel panel) {
	
		  frame.setContentPane(panel);  
		  frame.setSize(600,400);  
		  frame.setVisible(true);
		 
	}  
		
}
