package carbon.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import carbon.plot.PlotTimeSeries;
import carbon.plot.openImage;

public class runModel  extends PlotTimeSeries{

	
	//Running fixed emission scenarios
	
	private static final long serialVersionUID = 1L;

	public void fixed_emissions(int model, double sen, double C0, int start_year, int years, String outputfile, String chartOutput){
		 
		PrintWriter out=null; 
		  try {
				out = new PrintWriter(new FileWriter(outputfile));
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		 
		 double [] C = new double [carbonConstants.MAX_YEARS]; 
		 
		 sres s = new sres();
		 double [] co2e=s.senario(sen);
		 
		 C=selModel(C0,years,co2e,model);
		 
		  for(int t1=0;t1<years-1;t1++){
		  
		     System.out.format("%d\t%4.2f\t%4.2f\n",t1 + start_year, C[t1], co2e[t1]); 
		     out.format("%d\t%4.2f\t%4.2f\n",t1 + start_year, C[t1], co2e[t1]);
		  
		  } 
		  
		  out.close(); 
		  PlotTS(start_year,C,years,chartOutput);
		  new openImage(chartOutput); 
		  
		  	  
	}
	 
	// Testing model against observations
	 
	 public void testModel(int model, String outputfile, String chartOutput){
		  
		 
		 PrintWriter out=null; 
		  try {
				out = new PrintWriter(new FileWriter(outputfile));
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		 
		 double C0=315.97;       // Atmospheric CO2 in 1959
		 int start_year=1959;
		 int years=51; 
		 double [] C = new double [carbonConstants.MAX_YEARS]; 
		 double RMSE=0; 
		 
		 C=selModel(C0,years,co2Emissions.co2e,model);
		 
		  for(int t1=0;t1<years-1;t1++){
		  
		     System.out.format("%d\t%4.2f\t%4.2f\n",t1 + start_year, C[t1], co2Atm.co2e[t1]);
		     out.format("%d\t%4.2f\t%4.2f\n",t1 + start_year, C[t1], co2Atm.co2e[t1]);
		     RMSE=RMSE+Math.abs(C[t1]-co2Atm.co2e[t1]);
		   
		  } 
		  
		  System.out.format("\nRMSE:\t%6.4f\n",Math.sqrt(RMSE/(years-1))); 
		  out.format("\nRMSE:\t%6.4f\n",Math.sqrt(RMSE/(years-1))); 	  
//		  forcing f = new forcing();
//		  f.forcing(C[years-1]);
		  out.close();
		  PlotTS(start_year,C,years,chartOutput);
		  new openImage(chartOutput); 
	 }
	 
	// Running IPCC scenarios

	 public void ipcc(int model, int sen, String outputfile, String chartOutput){
		 
		 PrintWriter out=null; 
		  try {
				out = new PrintWriter(new FileWriter(outputfile));
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}  
		 
		  double C0=354.35;       // Atmospheric CO2 in 1990
		 int start_year=1990;
		 int years=111; 
		 double [] C = new double [carbonConstants.MAX_YEARS]; 
		
		 sres s = new sres();
		 double [] co2e=s.senario(sen);
		 
		 C=selModel(C0,years,co2e,model);
		 
		  for(int t1=0;t1<years-1;t1++){
		  
			  System.out.format("%d\t%4.2f\t%4.2f\n",t1 + start_year, C[t1], co2e[t1]);  
			  out.format("%d\t%4.2f\t%4.2f\n",t1 + start_year, C[t1], co2e[t1]);   
		  } 
		  out.close();
		  PlotTS(start_year,C,years,chartOutput);
		  new openImage(chartOutput); 
	 }
	 
	 
	 // Selecting which Carbon model to run
	 
	 public static double [] selModel(double C0, int years, double [] co2e, int model){
		   
		
		 double [] C = new double [carbonConstants.MAX_YEARS]; 
		
		 switch(model){
			case 1: simpleModel fbm = new simpleModel();
			 		C = fbm.CarbonAfModel(C0,years,co2e);
					break;
			case 2: fourBoxModel fbm1 = new fourBoxModel();
	 				C = fbm1.fbModel(C0,years,co2e);
	 				break;
			case 3: massBalance fbm2 = new massBalance();
				    C = fbm2.mbModel(C0,years,co2e);
				    break;		
			case 4: ImpulseResponseFunction fbm3 = new ImpulseResponseFunction();
				    C = fbm3.irf(C0,years,co2e);
				    break;		
		}
		 return C;	  	  
	 }
	
}
