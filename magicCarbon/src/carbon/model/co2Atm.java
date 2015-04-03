package carbon.model;

/******************
*
* magicarbon (Model of Global AtmospherIc Carbon)
*
* CO2 concentration in ppm between 1959 and 2014
* from NOAA Mauna Loa observatory record from:
* http://co2now.org/Current-CO2/CO2-Now/noaa-mauna-loa-co2-data.html
* 
* A simple carbon budget model 
*
* @author William Grey
*
* @version 2014-03-23
*
********************/



public class co2Atm {

//	public double[] co2Atm() {
        
	public static final double [] co2e = new double []{
				315.97,316.91,317.64,318.45,318.99,319.62,320.04,321.38,322.16,323.04,
				324.62,325.68,326.32,327.45,329.68,330.18,331.08,332.05,333.78,335.41,
				336.78,338.68,340.10,341.44,343.03,344.58,346.04,347.39,349.16,351.56,
		        353.07,354.35,355.57,356.38,357.07,358.82,360.80,362.59,363.71,366.65,
		        368.33,369.52,371.13,373.22,375.77,377.49,379.80,381.90,383.76,385.59,
		        387.37,389.85,391.63,393.82,396.48,398.55};
/*		
		int i=0;
		String[] ls;
		
		try {
        		        
        	ReadFile file = new ReadFile("/home/william/code/java/magicCarbon/data/co2-1959-2014");
        	String[] aryLines = file.OpenFile();
        
        	for(i=0; i< aryLines.length; i++){
    			ls = aryLines[i].split("\t");
    			co2e[i] = Double.parseDouble(ls[1]);
   // 			System.out.println(ls[0] + " " + co2e[i]);	
    			}
    		
        }
        
        catch (IOException e){
        	System.out.println(e.getMessage());
        }
        
*/        	
//		return co2e;     
//    }
	
	
}
