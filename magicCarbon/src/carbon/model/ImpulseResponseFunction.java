package carbon.model;

/***************
*
* magicarbon (Model of Global AtmospherIc Carbon)
*
* A simple carbon budget model that 
* uses impulse response function (IRF)
*
* This is based on the papers of:
* Boucher et al, (2008) Climatic Change, DOI 10.1007/s10584-008-9489-7
* Joos and Bruno (1997) Phys. and Chem. of the Earth
*
* @author William Grey
*
* @version 2014-08-22
*
****************/



public class ImpulseResponseFunction{

 // Paramemers of the impulse response function
 double[] a = {0.217,0.259,0.338,0.186};
 double[] b = {0.0,172.9,18.51,0.186};
 
// double S=5.0;           // Emissions per year (ppm) 
// double C0=315.97;       // Atmospheric CO2 in 1959
// int start_year=1959;
// int years=51;           // Number of years to run the simulation for
// int MAX_YEARS 1000;
// double PPM2GT = 2.123;

 double[] C = new double[carbonConstants.MAX_YEARS];
 double[] f = new double[carbonConstants.MAX_YEARS];
 double ft=0.0; 
 double integral=0.0;
 double dt=1.0; 
 
 public double[] irf(double C0, int years, double [] S){

  calcCo2(C0, years);
//  co2Emissions co2e = new co2Emissions();
//  double [] S=co2e.co2Emissions();
//  double RMSE=0;
	
// co2Atm co2 = new co2Atm();
//  double [] carbon=co2.co2Atm();
  
  
    //	for (int i=0;i<51;i++){
    //  System.out.println(C[i]);
   //	  }	  
	
  for(int t1=0;t1<years-1;t1++){
   
   integral=0.0;
   for(int t=0;t<t1;t++){
    integral = integral + (((S[t1]/carbonConstants.PPM2GT) * f[t1-t]) / carbonConstants.PPM2GT) * dt;
   }

   C[t1]=C[0]+integral;
//   System.out.format("%d\t%4.2f\t%4.2f\n",t1 + start_year, C[t1],carbon[t1]); 
//     System.out.format("%d\t%4.2f\n",t1 + start_year, C[t1]); 
   
//   RMSE=RMSE+Math.abs(C[t1]-carbon[t1]);
   
  } 
  
//  System.out.format("\nRMSE:\t%4.2f\n",Math.sqrt(RMSE/years-1));
  return C;
 }
 
 public void calcCo2(double C0, int years){

	  C[0]=C0;

	  for(int t=0;t<years;t++){
	   f[t]=a[0];
	   for(int i=1;i<4;i++){
	    f[t]=f[t]+a[i]*Math.exp(-1.0*t/b[i]);
	   }
	  }
	 }
}
