package carbon.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import carbon.plot.PlotTimeSeries;
import carbon.plot.DisplayImage;

/**
 * 
 * @author will Grey
 * 
 *  @version 3/4/2015 
 *
 */

public class RunModel  extends PlotTimeSeries{

	//Running fixed emission scenarios
	
	private static final long serialVersionUID = 1L;

	public void fixed_emissions(int model, double sen, double C0, int start_year, int years, String outputfile, String chartOutput){
		 
		PrintWriter out = createDataFile(outputfile);
		 
		 double [] C = new double [CarbonConstants.MAX_YEARS]; 
		 
		 EmissionScenarios s = new EmissionScenarios();
		 double [] co2e=s.senario(sen);
		 
		 C=selModel(C0,years,co2e,model);
		 
		  for(int t1=0;t1<years-1;t1++){
		  
		     System.out.format("%d\t%4.2f\t%4.2f\n",t1 + start_year, C[t1], co2e[t1]); 
		     out.format("%d\t%4.2f\t%4.2f\n",t1 + start_year, C[t1], co2e[t1]);
		  
		  } 
		  
		  createPlot(start_year, years, chartOutput, out, C); 
		 	  
	}

	
	 
	// Testing model against observations
	 
	 public void testModel(int model, String outputfile, String chartOutput){
		  
		 
		 PrintWriter out = createDataFile(outputfile);
		 
		 double C0=315.97;       // Atmospheric CO2 in 1959
		 int start_year=1959;
		 int years=51; 
		 double [] C = new double [CarbonConstants.MAX_YEARS]; 
		 double RMSE=0; 
		 
		 C=selModel(C0,years,CarbonConstants.co2EmissionsGTPerY,model);
		 
		  for(int t1=0;t1<years-1;t1++){
		  
		     System.out.format("%d\t%4.2f\t%4.2f\n",t1 + start_year, C[t1], CarbonConstants.co2AtmosConcentrationInPPM[t1]);
		     out.format("%d\t%4.2f\t%4.2f\n",t1 + start_year, C[t1], CarbonConstants.co2AtmosConcentrationInPPM[t1]);
		     RMSE=RMSE+Math.abs(C[t1]-CarbonConstants.co2AtmosConcentrationInPPM[t1]);
		   
		  } 
		  
		  System.out.format("\nRMSE:\t%6.4f\n",Math.sqrt(RMSE/(years-1))); 
		  out.format("\nRMSE:\t%6.4f\n",Math.sqrt(RMSE/(years-1))); 	  
          createPlot(start_year, years, chartOutput, out, C); 
	 }
	 
	// Running IPCC scenarios

	 public void ipcc(int model, int sen, String outputfile, String chartOutput){
		 
		 PrintWriter out = createDataFile(outputfile);  
		 
		  double C0=354.35;       // Atmospheric CO2 in 1990
		 int start_year=1990;
		 int years=111; 
		 double [] C = new double [CarbonConstants.MAX_YEARS]; 
		
		 EmissionScenarios s = new EmissionScenarios();
		 double [] co2e=s.senario(sen);
		 
		 C=selModel(C0,years,co2e,model);
		 
		  for(int t1=0;t1<years-1;t1++){
		  
			  System.out.format("%d\t%4.2f\t%4.2f\n",t1 + start_year, C[t1], co2e[t1]);  
			  out.format("%d\t%4.2f\t%4.2f\n",t1 + start_year, C[t1], co2e[t1]);   
		  } 
		  createPlot(start_year, years, chartOutput, out, C); 
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
				PlotTS(start_year,C,years,chartOutput);
				 new DisplayImage(chartOutput);
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
	 
}
