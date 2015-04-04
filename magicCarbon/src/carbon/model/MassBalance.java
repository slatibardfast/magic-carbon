package carbon.model;

/**************
*
* magicarbon (Model of Global AtmospherIc Carbon)
*
* A simple carbon budget model 
* Very simple mass balance model 
* for atmospheric carbon:
* delta C = [ S - (C0 /  tau) ] delta t 
* from Mackay et al
* http://www.atmosedu.com/physlets/GlobalPollution/CO2assign.htm
* 
* @author William Grey
*
* @version 2014-08-22
*
**************/

public class MassBalance{
 
 double tauLifetimeAtmosCarbon=200.0;       // Lifetime of CO2 in the atmosphere (years)  originally set at 120.0
 double[] atmosCarbonConcentration = new double[CarbonConstants.MAX_YEARS];
 
 public double[] massbalanceModel(double initialAtmosCarbon, int years, double [] carbonEmissions){
  
  atmosCarbonConcentration[0]=initialAtmosCarbon;
  
  for(int i=0;i<years-1;i++){
	  
   atmosCarbonConcentration[i+1]=atmosCarbonConcentration[i]+(carbonEmissions[i]/CarbonConstants.PPM2GT)
		   -(atmosCarbonConcentration[i]/tauLifetimeAtmosCarbon);
   
  }
  return atmosCarbonConcentration;
 }
}
