package carbon.model;

/***************
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
 double[] alpha = {0.217,0.259,0.338,0.186};
 double[] beta = {0.0,172.9,18.51,0.186};

 double[] atmosCarbonConcentration = new double[CarbonConstants.MAX_YEARS];
 double[] impuseResponseFunction = new double[CarbonConstants.MAX_YEARS];
 double integral=0.0;
 double dt=1.0; 
 
 public double[] irf(double initialAtmosCarbon, int years, double [] carbonEmissions){

  calcCo2(initialAtmosCarbon, years);

	
  for(int t1=0;t1<years-1;t1++){
   
   integral=0.0;
   for(int t=0;t<t1;t++){
    integral = integral + (((carbonEmissions[t1]/CarbonConstants.PPM2GT) * impuseResponseFunction[t1-t]) / CarbonConstants.PPM2GT) * dt;
   }

   atmosCarbonConcentration[t1]=atmosCarbonConcentration[0]+integral;

   
  } 
  
  return atmosCarbonConcentration;
 }
 
 public void calcCo2(double initialAtmosCarbon, int years){

	  atmosCarbonConcentration[0]=initialAtmosCarbon;

	  for(int t=0;t<years;t++){
	   impuseResponseFunction[t]=alpha[0];
	   for(int i=1;i<4;i++){
	    impuseResponseFunction[t]=impuseResponseFunction[t]+alpha[i]*Math.exp(-1.0*t/beta[i]);
	   }
	  }
	 }
}
