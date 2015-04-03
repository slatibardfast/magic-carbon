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

public class fourBoxModel {

	public double [] fbModel(double c0, int years, double [] Ff){ 
		  
    // Model parameters		           		
	//	  double years = 100;    // Total Simulation time (in years) 	  
	//	  int years = 51;  
    //    double PPM2GT = 2.123;   
	//	  double c0=315.97    // Starting in 1959
		  double dt=1.0;         // Step Time (dt)       
    
   // Initial values (Gt) of reservoir stores
		  
		  //double Ma0 = 700.0;    // atmosphere		  
		  double Ma0 = c0*carbonConstants.PPM2GT;   // Convert to GtC
		  double Ms = 1000.0; 	// surface ocean
		  double Mt = 3000.0;   // terrestrial biosphere
		  double Md = 35000.0;  // deep ocean 	  
		  double[] Ma = new double[carbonConstants.MAX_YEARS];
		  Ma[0]=Ma0;
		 
		  // Initial values of fluxes (Gt/yr)
		  
		  //co2Emissions co2e = new co2Emissions();
		  //double [] Ff=co2e.co2Emissions();

	//	  double Ff = 5.0;                          // fossil fuel burning   
		  double Fas = Ma[0] * 0.15;                  // Ocean uptake of Carbon
		  double Fsa = 1e-25 * Math.pow(Ms,9.0);    // ocean degassing
		  double Fat = 16.4 * Math.pow(Ma[0],0.2);     // Photosynthesis 
		  double Fta = 0.019 * Mt;                   // respiration
		  double Fds = 0.00129 * Md;                // upwelling and biopump 
		  double Fsd = 0.0450 * Ms;                  // downwelling
		  
		  
//		  System.out.format("Year \t Ocean uptake \t upwelling \t downwelling \t degassing \t photosynthesis \t respiration \t atm c \t atm C ppm %n");
		  
		  
		 for (int i=0;i<years-1;i++){
		  
		//  System.out.println( i + "\t" + Fas + "\t" + Fds + "\t" + 
		//Fsd + "\t" + Fsa + "\t" + Fat + "\t" + Fta + "\t" + Ma + "\t" + Ma*2.1);


		//  System.out.format("%d\t%6.2f\t%6.2f\t%6.2f\t%6.2f\t%6.2f\t%6.2f\t%6.2f\t%6.2f\t%6.2f\t%6.2f\t%6.2f%n",i+1959,Fas,Fds,Fsd,Fsa,Fat,Fta,Ma[i],Ma[i]/2.1,Ms,Md,Mt);


		  Ma[i+1] = Ma[i] + (Fta + Fsa + Ff[i] - Fat - Fas) * dt;
		  Ms = Ms + (Fas + Fds - Fsa - Fsd) * dt;
		  Md = Md + (Fsd - Fds) * dt;
		  Mt = Mt + (Fat - Fta) * dt;
		  
		  Fas = Ma[i] * 0.15;             
		  Fsa = 1e-25 * Math.pow(Ms,9.0);          
		  Fat = 16.4 * Math.pow(Ma[i],0.2);           
		  Fta = 0.019 * Mt;                
		  Fds = 0.00129 * Md;             
		  Fsd = 0.0450 * Ms;              
		  
		 }
		 
		 for (int i=0;i<years;i++){	 
		  // Convert back to PPM.
		  Ma[i]=Ma[i]/carbonConstants.PPM2GT;
	         }
		 
		 return Ma;
		 
		 }
	
}
