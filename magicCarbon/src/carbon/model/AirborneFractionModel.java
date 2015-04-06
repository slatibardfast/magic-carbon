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
* This is free and unencumbered software released into the public domain.
*  For more information, please refer to <http://unlicense.org/>
 */



public class AirborneFractionModel {
	
	public double[] CarbonAfModel(double initialAtmosCarbon, int years, double [] carbonEmissions){ 
                	
        double AirborneFraction = 0.439;    // fraction from LeQuere (2009) Nature Geosciences

		double [] atmosCarbonConcentration = new double [CarbonConstants.MAX_YEARS]; 
		
		atmosCarbonConcentration[0]=initialAtmosCarbon*CarbonConstants.PPM2GT;   // Convert to GtC.
		
		for (int i=0;i<years-1;i++){		 
			atmosCarbonConcentration[i+1]=atmosCarbonConcentration[i]+carbonEmissions[i]*AirborneFraction;		 
		 }
		
		for (int i=0;i<years;i++){	 
			// Convert back to PPM.
			atmosCarbonConcentration[i]=atmosCarbonConcentration[i]/CarbonConstants.PPM2GT;
		}
			
		return atmosCarbonConcentration;	
	}
}
