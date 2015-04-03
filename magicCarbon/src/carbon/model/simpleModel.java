package carbon.model;

/**
*  
* Simple Airborne fraction model based on the idea that 
* approximately half of emitted carbon remains in the atmosphere
* and the remaining half is absorbed by the terrestrial biosphere
* and oceans.  More precisely both LeQuere (2009) Nature Geosciences 
* and through numerical minimisation against observations of atmospheric
* CO2 the average annual fraction that remains in the atmosphere is 
* approximately 43 per cent.
*
* @author Will Grey
*
* @version 19th March 2015
*
*
*/



public class simpleModel {
	
 //       double C0=315.97;       // Atmospheric CO2 in 1959
 //       int start_year=1959;
 //       int years=51;           // Number of years to run the simulation for
//        double PPM2GT = 2.123;
//		double S=5;
//		int years = 51;
//              int MAX_YEARS 1000; 

	public double[] CarbonAfModel(double C0, int years, double [] S){ 
                	
                double af = 0.439; // percentage airborne 
                                   // fraction from LeQuere (2009) Nature Geosciences

		double [] Ma = new double [carbonConstants.MAX_YEARS]; 
		
		Ma[0]=C0*carbonConstants.PPM2GT;   // Convert to GtC.
		
		for (int i=0;i<years-1;i++){		 
	//		System.out.format("%d\t%6.2f\t%6.2f\n",i+1959,Ma[i],Ma[i]/2.1);
			Ma[i+1]=Ma[i]+S[i]*af;		 
		 }
		
		for (int i=0;i<years;i++){	 
			// Convert back to PPM.
			Ma[i]=Ma[i]/carbonConstants.PPM2GT;
		}
			
		return Ma;	
	}
}
