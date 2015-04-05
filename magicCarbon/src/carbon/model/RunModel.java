package carbon.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import carbon.plot.PlotTimeSeries;
//import carbon.plot.DisplayImage;

/**
 * 
 * @author will Grey
 * 
 *  @version 3/4/2015 
 *
 */

public class RunModel  extends PlotTimeSeries{

	//Running fixed emission scenarios
	
	double endCarbon;
	double endCarbonGtC;
	int yearEnd;
	double radiativeForcing; 
	double endTemperature; 
	double errorRMSE=-99.0; 
	
	private static final long serialVersionUID = 1L;

	public void fixed_emissions(int model, double sen, double C0, int startYear, int years, String outputfile, String chartOutput){
		 
		PrintWriter out = createDataFile(outputfile);
		 
		 double [] C = new double [CarbonConstants.MAX_YEARS]; 
		 
		 EmissionScenarios s = new EmissionScenarios();
		 double [] co2e=s.senario(sen);
		 
		 C=selModel(C0,years,co2e,model);
		 
		  for(int t1=0;t1<years-1;t1++){
		  
	//	     System.out.format("%d\t%4.2f\t%4.2f\n",t1 + startYear, C[t1], co2e[t1]); 
		     out.format("%d\t%4.2f\t%4.2f\n",t1 + startYear, C[t1], co2e[t1]);
		  
		  } 
		  
		  calcSummaryData(C0, startYear, years, C[years-2]);
		  createPlot(startYear, years, chartOutput, out, C); 
		   
	}


	// Testing model against observations
	 
	 public void testModel(int model, String outputfile, String chartOutput){
		  
		 
		 PrintWriter out = createDataFile(outputfile);
		 
		 double C0=315.97;       // Atmospheric CO2 in 1959
		 int startYear=1959;
		 int years=51; 
		 double [] C = new double [CarbonConstants.MAX_YEARS]; 
		 errorRMSE=0.0;
		 C=selModel(C0,years,CarbonConstants.co2EmissionsGTPerY,model);
		 
		  for(int t1=0;t1<years-1;t1++){
		  
	//	     System.out.format("%d\t%4.2f\t%4.2f\n",t1 + startYear, C[t1], CarbonConstants.co2AtmosConcentrationInPPM[t1]);
		     out.format("%d\t%4.2f\t%4.2f\n",t1 + startYear, C[t1], CarbonConstants.co2AtmosConcentrationInPPM[t1]);
		     errorRMSE=errorRMSE+Math.abs(C[t1]-CarbonConstants.co2AtmosConcentrationInPPM[t1]);
		   
		  } 
		  
	//	  System.out.format("\nRMSE:\t%6.4f\n",Math.sqrt(errorRMSE/(years-1))); 
		  errorRMSE=Math.sqrt(errorRMSE/(years-1));
		  out.format("\nRMSE:\t%6.4f\n",errorRMSE); 	
		  calcSummaryData(C0, startYear, years, C[years-2]);  
          createPlot(startYear, years, chartOutput, out, C); 
	 }
	 
	// Running IPCC scenarios

	 public void ipcc(int model, int sen, String outputfile, String chartOutput){
		 
		 PrintWriter out = createDataFile(outputfile);  
		 
		  double C0=354.35;       // Atmospheric CO2 in 1990
		 int startYear=1990;
		 int years=111; 
		 double [] C = new double [CarbonConstants.MAX_YEARS]; 
		
		 EmissionScenarios s = new EmissionScenarios();
		 double [] co2e=s.senario(sen);
		 
		 C=selModel(C0,years,co2e,model);
		 
		  for(int t1=0;t1<years-1;t1++){
		  
	//		  System.out.format("%d\t%4.2f\t%4.2f\n",t1 + startYear, C[t1], co2e[t1]);  
			  out.format("%d\t%4.2f\t%4.2f\n",t1 + startYear, C[t1], co2e[t1]);   
		  }
		  calcSummaryData(C0, startYear, years, C[years-2]);  
		  createPlot(startYear, years, chartOutput, out, C); 
	 }
	 
	 // Selecting which Carbon model to run
	 
	 public static double [] selModel(double C0, int years, double [] co2e, int model){
		   		
		 double [] C = new double [CarbonConstants.MAX_YEARS]; 
		
		 switch(model){
			case 1: AirborneFractionModel afm = new AirborneFractionModel();
			 		C = afm.CarbonAfModel(C0,years,co2e);
					break;
			case 2: FourBoxModel fbm = new FourBoxModel();
	 				C = fbm.boxModel(C0,years,co2e);
	 				break;
			case 3: MassBalance mb = new MassBalance();
				    C = mb.massbalanceModel(C0,years,co2e);
				    break;		
			case 4: ImpulseResponseFunction irf = new ImpulseResponseFunction();
				    C = irf.irf(C0,years,co2e);
				    break;		
		}
		 return C;	  	  
	 }
	
	 private void createPlot(int start_year, int years, String chartOutput,
				PrintWriter out, double[] C) {
				out.close(); 
				File plot = new File(chartOutput);
				 
				 if (plot != null){
					 plot.delete();
					} 
				 
				PlotTS(start_year,C,years,chartOutput);
//				 new DisplayImage(chartOutput);
			}

	private PrintWriter createDataFile(String outputfile) {
				PrintWriter out=null; 
				  try {
						out = new PrintWriter(new FileWriter(outputfile));
						
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				return out;
			}
	
	private void calcSummaryData(double c0, int startYear, int years, double c) {
		 yearEnd = years-2 + startYear;
		  endCarbon =c;
		  endCarbonGtC=(c-c0) *  CarbonConstants.PPM2GT;
		  radiativeForcing = 5.35 * Math.log(c/c0);
		  endTemperature=radiativeForcing*CarbonConstants.LAMBDA_CLIMATIC_SENSITIVITY;
	}
	
	public double getYearEnd(){
	 return 	yearEnd;
	}
	
	public double getEndCarbon(){
		 return 	endCarbon; 
	 }
	
	public double getAddedCarbon(){
		 return 	endCarbonGtC; 
	 }
	
	public double getRadiativeForcing(){
		 return 	radiativeForcing; 
	 }
	
	public double getEndTemperature(){
		 return endTemperature	; 
	 }
	
	public double getError(){
		 return errorRMSE	; 
	 }
}
