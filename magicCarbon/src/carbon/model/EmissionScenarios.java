package carbon.model;

/**
*
* magicarbon (Model of Global AtmospherIc Carbon)
*
* Values for different IPCC
* special report emission 
* scenarios (SRES) for carbon from:
* http://sres.ciesin.org/final_data.html
* Emissions in GtC per year
*
* Four families of senarios A1, A2, B1, B2 representing a range of story lines.
*
* A1 - Rapid economic growth, population peaks 2050, introduction of efficient technologies
* A2 - Continuously growing population, slow introduction of efficient technologies
* B1 - Population peaks 2050, but rapid adoption of efficient technologies
* B2 - Continuously growing population, but regional development
*
* @author Will Grey
*
* @version 2014-08-22
* 
* This is free and unencumbered software released into the public domain.
*  For more information, please refer to <http://unlicense.org/>
*/

public class EmissionScenarios {
    
	// Emissions In GT are given for the following years: 
	// 1990,2000,2010,2020,2030,2040,2050,2060,2070,2080,2090,2100
	
	private	double A1_AIM_EMISSION_SCENARIO [] = new double[] {7.10,7.97,10.88,12.64,14.48,15.35,16.38,16.00,15.73,15.18,14.30,13.49};
	private	double A1G_MINICAM_EMISSION_SCENARIO  [] = new double[] {7.10,7.97,9.73,12.73,16.19,19.97,23.90,25.69,27.28,28.68,28.42,28.24};
	private	double A1T_MESSAGE_EMISSION_SCENARIO  [] = new double[] {7.10,7.97,9.38,10.26,12.38,12.65,12.26,11.38,9.87,8.02,6.26,4.32};
	private	double A2_ASF_EMISSION_SCENARIO  [] = new double[] {7.10,7.97,9.58,12.25,14.72,16.07,17.43,19.16,20.89,23.22,26.15,29.09};
	private	double B1_IMAGE_EMISSION_SCENARIO  [] = new double[] {7.10,7.97,9.28,10.63,11.11,11.72,11.29,9.74,8.18,6.70,5.32,4.23};
	private	double B2_MESSAGE_EMISSION_SCENARIO  [] = new double[] {7.10,7.97,8.78,9.05,9.90,10.69,11.01,11.49,11.62,12.15,12.79,13.32};
	
	private	int SCENARIO_LENGTH_YEARS = 111;
	private	int YEARS_INTERVAL = 10;
	private double YEARS_INTERVAL_DBL = YEARS_INTERVAL;
	private	int MODELLING_POINTS = 12;
	private	double fullEmissionsScenarioGT  [] = new double[ SCENARIO_LENGTH_YEARS];
	
	public double[] senario(double sen){ 
	
		for (int i=0;i<MODELLING_POINTS-1;i++){
			 for (int j=0;j<YEARS_INTERVAL;j++){ 
				 fullEmissionsScenarioGT[i*YEARS_INTERVAL+j]=sen;
			 } 
		 }
		
		return fullEmissionsScenarioGT;	
	}
	
	public double[] senario(int sen){ 
	
		switch(sen){
			case 1: fullEmissionsScenarioGT=interpEmissionsScenario(A1_AIM_EMISSION_SCENARIO );
			break;
			case 2: fullEmissionsScenarioGT=interpEmissionsScenario(A1G_MINICAM_EMISSION_SCENARIO );		
			break;
			case 3: fullEmissionsScenarioGT=interpEmissionsScenario(A1T_MESSAGE_EMISSION_SCENARIO );			
			break;
			case 4: fullEmissionsScenarioGT=interpEmissionsScenario(A2_ASF_EMISSION_SCENARIO );				
			break;
			case 5: fullEmissionsScenarioGT=interpEmissionsScenario(B1_IMAGE_EMISSION_SCENARIO );			
			break;
			case 6: fullEmissionsScenarioGT=interpEmissionsScenario(B2_MESSAGE_EMISSION_SCENARIO );
			break;	
		}
	
		 return  fullEmissionsScenarioGT;	
	   
	}  
	   
	public double[] interpEmissionsScenario(double [] co2){
		 		 
		 for (int i=0;i<MODELLING_POINTS-1;i++){
			 for (int j=0;j<YEARS_INTERVAL;j++){ 
				 fullEmissionsScenarioGT[i*YEARS_INTERVAL+j]=co2[i]*(1-(j/YEARS_INTERVAL_DBL))+co2[i+1]*(j/YEARS_INTERVAL_DBL);
			 }
			 
		 }
		 
	   return  fullEmissionsScenarioGT;
	 
	}
	
}
