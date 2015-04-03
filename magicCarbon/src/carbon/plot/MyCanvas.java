package carbon.plot;

import java.awt.*;  
  
public class MyCanvas extends Canvas {  
 	
private static final long serialVersionUID = 1L;

private String fn;
 
 public void fileName(final String fn){

  this.fn=fn;

 }  

 public void paint(final Graphics g) {  
        
  final Toolkit t=Toolkit.getDefaultToolkit();  
  final Image i=t.getImage(fn);  
  g.drawImage(i, 0, 0,this);  
          
 }  
   
} 