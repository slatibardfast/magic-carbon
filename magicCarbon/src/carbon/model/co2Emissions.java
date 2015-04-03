package carbon.model;

/**************
*
* magicarbon (Model of Global AtmospherIc Carbon)
*
* CO2 anthropogenic emissions in Gt/y between 1959 and 2009
* from http://co2now.org
* 
* A simple carbon budget model 
*
* @author William Grey
*
* @version 2014-03-23
*
***************/

public class co2Emissions {

//	public double[] co2Emissions() {
        
	public static final double [] co2e = new double []{
		 3.92,4.03,4.11,4.21,4.36,4.51,4.68,4.84,4.99,5.13,5.34,
		 5.61,5.63,5.72,5.94,5.93,5.91,6.20,6.37,6.38,6.62,
		 6.57,6.41,6.38,6.54,6.75,6.93,7.14,7.27,7.48,7.62,
		 7.60,7.89,7.82,7.69,7.77,7.89,8.00,8.11,8.08,7.98,
		 8.17,8.14,8.03,8.33,8.69,8.97,9.22,9.31,9.45,9.28}; 
/*		
		int i=0;
		String[] ls;
		3.92
		
		try {
        		        
        	ReadFile file = new ReadFile("/home/william/code/java/magicCarbon/data/co2-emissions-1959-2009");
        	String[] aryLines = file.OpenFile();
        
        	for(i=0; i< aryLines.length; i++){
    			ls = aryLines[i].split(" ");
    			co2e[i] = Double.parseDouble(ls[1]);
  //  			System.out.println(ls[0] + " " + co2e[i]);	
    			}
    		
        }
        
        catch (IOException e){
        	System.out.println(e.getMessage());
        }
        
*/
//		return co2e;     
//    }
	
	
}
