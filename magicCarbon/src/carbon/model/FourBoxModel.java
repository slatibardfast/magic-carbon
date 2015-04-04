package carbon.model;

/*******************
*
*  This is the classic 1D Carbon box mode.
*  This version has four boxes:
*  (atmosphere,bosphere, ocean, deep ocean).
*  Rodhe, Tellus (1979)
*
* @author Will Grey
* 
* @version 2015-03-23
*
*********************/

public class FourBoxModel {

	public double [] boxModel(double initialAtmosCarbon, int years, double [] Ff){ 
		  
          // Model parameters		           		
		  double dt=1.0;         // Step Time (dt)       
    
          // Initial values (Gt) of Carbon reservoir stores
		  double atmosCarbonStoreStart =initialAtmosCarbon*CarbonConstants.PPM2GT;   
		  double surfaceOceanCarbonStore = 1000.0; 	
		  double terrestrialBiosphereCarbonStore = 3000.0;   
		  double deepOceanCarbonStore = 35000.0;  	  
		  double[] atmosCarbonStore = new double[CarbonConstants.MAX_YEARS];
		  atmosCarbonStore[0]=atmosCarbonStoreStart;
		 
		  // Flux coefficients
		  final double  atmosCarbonCoeff=0.15;
		  final double  oceanDegassingCoeff = 1e-25;
		  final  double oceanDegassingCoeffPow= 9.0;    
		  final double  photosynthesisCoeff = 16.4 ;
		  final double  oceabDegassingCoeffPow =0.2;   
		  final double  respirationCoeff = 0.019 ;                 
		  final double  upwellingAndBiopumpCoeff = 0.00129;               
		  final double  downwellingCoeff = 0.0450;              
		  
		  // Initial values of fluxes (Gt/yr)
		  double oceanCarbonUptakeFlux = atmosCarbonStore[0] *atmosCarbonCoeff;                 
		  double oceanDegassingFlux =  oceanDegassingCoeff * Math.pow(surfaceOceanCarbonStore, oceanDegassingCoeffPow);    
		  double photosynthesisFlux = photosynthesisCoeff  * Math.pow(atmosCarbonStore[0],oceabDegassingCoeffPow);    
		  double respirationFlux = respirationCoeff * terrestrialBiosphereCarbonStore;                   
		  double upwellingAndBiopumpFlux = upwellingAndBiopumpCoeff * deepOceanCarbonStore;               
		  double downwellingFlux = downwellingCoeff * surfaceOceanCarbonStore;                
		  
		 		  
		 for (int i=0;i<years-1;i++){
		  
		  atmosCarbonStore[i+1] = atmosCarbonStore[i] + (respirationFlux + oceanDegassingFlux + Ff[i] - 
		 photosynthesisFlux - oceanCarbonUptakeFlux) * dt;
		  surfaceOceanCarbonStore = surfaceOceanCarbonStore + (oceanCarbonUptakeFlux + upwellingAndBiopumpFlux
		  - oceanDegassingFlux -downwellingFlux) * dt;
		  deepOceanCarbonStore = deepOceanCarbonStore + (downwellingFlux - upwellingAndBiopumpFlux) * dt;
		  terrestrialBiosphereCarbonStore = terrestrialBiosphereCarbonStore + (photosynthesisFlux - respirationFlux) * dt;
		  
		  oceanCarbonUptakeFlux = atmosCarbonStore[i] * 0.15;             
		  oceanDegassingFlux = 1e-25 * Math.pow(surfaceOceanCarbonStore,9.0);          
		  photosynthesisFlux = 16.4 * Math.pow(atmosCarbonStore[i],0.2);           
		  respirationFlux = 0.019 *terrestrialBiosphereCarbonStore;                
		  upwellingAndBiopumpFlux = 0.00129 * deepOceanCarbonStore;             
		  downwellingFlux = 0.0450 * surfaceOceanCarbonStore;              
		  
		 }
		 
		 for (int i=0;i<years;i++){	 
		  // Convert back to PPM.
		  atmosCarbonStore[i]=atmosCarbonStore[i]/CarbonConstants.PPM2GT;
	         }
		 
		 return atmosCarbonStore;
		 
		 }
	
}
