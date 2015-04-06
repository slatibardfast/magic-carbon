package carbon.model;

/**
*
* magicarbon (Model of Global AtmospherIc Carbon)
*
* A simple carbon budget model 
*
* @author Will Grey
*
* @version 2014-08-22
* 
* This is free and unencumbered software released into the public domain.
*  For more information, please refer to <http://unlicense.org/> 
*/

import javax.swing.*;
import carbon.plot.*;

public class MagicCarbon  extends PlotTimeSeries{

private static final long serialVersionUID = 1L;

public static void main(final String[] args){
    	 
	 SwingUtilities.invokeLater(new Runnable(){
	 public void run(){ new WindowSetUp();
	 
	 }
 });
  
 }

}
