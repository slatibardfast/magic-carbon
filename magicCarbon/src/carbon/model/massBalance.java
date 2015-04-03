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

public class massBalance{
 
 //co2Emissions co2e = new co2Emissions();
 // double [] S=co2e.co2Emissions();
 // double S=5.0;           // Emissions per year (ppm)
 //double C0=315.97;        // Concentration of Carbon (ppm) 
 //int start_year=1959;
 //int years=51;           // Number of years to run the simulation for

 double tau=200.0;       // Lifetime of CO2 in the atmosphere (years) 
                         // originally set at 120.0
// double PPM2GT = 2.123;
// int MAX_YEARS 1000; 
 double[] C = new double[carbonConstants.MAX_YEARS];
 
 public double[] mbModel(double C0, int years, double [] S){
  
  C[0]=C0;
  
  for(int i=0;i<years-1;i++){
 //  System.out.format("%d\t%4.2f\n",i + start_year, C[i]); 
   C[i+1]=C[i]+(S[i]/carbonConstants.PPM2GT)-(C[i]/tau);
   
  }
  return C;
 }
}
