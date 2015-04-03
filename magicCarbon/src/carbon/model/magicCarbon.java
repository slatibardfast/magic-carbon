package carbon.model;

/**********
*
* magicarbon (Model of Global AtmospherIc Carbon)
*
* A simple carbon budget model 
*
* @author William Grey
*
* @version 2014-08-22
*
**********/



//import java.io.IOException;
//import openImage;

import javax.swing.*;
import carbon.plot.*;

public class magicCarbon  extends PlotTimeSeries{

private static final long serialVersionUID = 1L;

public static void main(final String[] args){
    	 
	 SwingUtilities.invokeLater(new Runnable(){
	 public void run(){ new WindowSetUp();
	 
	 }
 });
  
 }

}
