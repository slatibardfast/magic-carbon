package carbon.model;

/*********************
*
* magicarbon (Model of Global AtmospherIc Carbon)
*
* Constants
*
* @author Will Grey
* 
* @version 2015-04-03
*
**********************/

 public class CarbonConstants{

 public static final int MAX_YEARS = 1000;     // For setting arrays, increase to run longer simulations
 public static final double PPM2GT = 2.123;  // Convert from PPM to GT Carbon
 public static final double LAMBDA_CLIMATIC_SENSITIVITY = 0.8; // Climatic sensitivity (K/wm^2) given in IPCC, TAR.
 
 /** CO2 concentration in ppm between 1959 and 2014
 * from NOAA Mauna Loa observatory record from:
 * http://co2now.org/Current-CO2/CO2-Now/noaa-mauna-loa-co2-data.html */

 public static final double [] co2AtmosConcentrationInPPM = new double []{
	315.97,316.91,317.64,318.45,318.99,319.62,320.04,321.38,322.16,323.04,
	324.62,325.68,326.32,327.45,329.68,330.18,331.08,332.05,333.78,335.41,
	336.78,338.68,340.10,341.44,343.03,344.58,346.04,347.39,349.16,351.56,
     353.07,354.35,355.57,356.38,357.07,358.82,360.80,362.59,363.71,366.65,
     368.33,369.52,371.13,373.22,375.77,377.49,379.80,381.90,383.76,385.59,
     387.37,389.85,391.63,393.82,396.48,398.55};
 
 
 /** CO2 anthropogenic emissions in Gt/y between 1959 and 2009
  from http://co2now.org */
 
 public static final double [] co2EmissionsGTPerY = new double []{
	 3.92,4.03,4.11,4.21,4.36,4.51,4.68,4.84,4.99,5.13,5.34,
	 5.61,5.63,5.72,5.94,5.93,5.91,6.20,6.37,6.38,6.62,
	 6.57,6.41,6.38,6.54,6.75,6.93,7.14,7.27,7.48,7.62,
	 7.60,7.89,7.82,7.69,7.77,7.89,8.00,8.11,8.08,7.98,
	 8.17,8.14,8.03,8.33,8.69,8.97,9.22,9.31,9.45,9.28}; 
 
}
