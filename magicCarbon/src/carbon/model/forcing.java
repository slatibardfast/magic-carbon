package carbon.model;

/****************
*
* magicarbon (Model of Global AtmospherIc Carbon)
*
* A simple carbon budget model 
*
* @author William Grey
*
* @version 2014-08-22
*
******************/

public class forcing{

 double mmc = 12.0;      // Molecular mass of Carbon (g/mol)
 double mmco2 = 44.0;    // Molecular mass of co2    (g/mol)

 double PPM2GT = 2.1;    // 1 ppmv of CO2 = 2.1 Gt of Carbon
 double c0     = 280.0;  // Pre-industrial CO2 concentrations (ppmv)
// double c   = 365.0;     // 2007 CO2 concentrations (ppmv)
 double lambda = 0.8;    // climatic sensitivity (K/wm^2) given in IPCC, TAR.

 double RF=0.0;          // radiative forcing
 double T=0.0;           // temperature deg C.
 double cgt=0.0;         // carbon in gigatonnes 
 double co2=0.0;

 double c2deg=0.0;       // carbon concentrations required for 2 degrees warming
 double RF2deg=0.0;      // radiative forcing required for 2 degrees warming 

 public double atmForcing(double c){

  // The equation is from the 
  // IPCC, First assessment report
  // and is okay up to 1000 ppmv.
 
  RF = 5.35 * Math.log(c/c0);
//  T = RF * lambda;
  return RF;
/*  cgt=c*PPM2GT;
  co2=c*(mmco2/mmc);
  RF2deg=2.0/lambda;
  c2deg=c0*Math.exp(RF2deg/5.35);
   
  System.out.format("%3.2f\tCarbon (ppm)\n",c);
  System.out.format("%3.2f\tCarbon (Gt)\n",cgt);
  System.out.format("%3.2f\tCO2 (Gt)\n",co2);
  System.out.format("%3.2f\tRadiative forcing (w/m^2)\n",RF); 
  System.out.format("%3.2f\tTemperature (deg C)\n",T); 
  System.out.format("%3.2f\tCarbon (ppm) required for 2 degrees\n",c2deg); 
  System.out.format("%3.2f\tRadiative forcing (w/m^2)\n",RF2deg);  */

 } 
 
 public double atmTemp(double c){

	  // The equation is from the 
	  // IPCC, First assessment report
	  // and is okay up to 1000 ppmv.
	 
	  RF = 5.35 * Math.log(c/c0);
	  T = RF * lambda;
	  return RF;
	  
	 } 

}
