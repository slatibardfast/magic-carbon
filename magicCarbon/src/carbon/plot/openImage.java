package carbon.plot;

import javax.swing.JFrame;

public class openImage  {

	public openImage(final String img) {
		 
		  MyCanvas m=new MyCanvas(); 
		  m.fileName(img); 
		  JFrame f=new JFrame();  
		  f.add(m);  
		  f.setSize(600,400);  
		  f.setVisible(true);  

		 }  
	
	
}
