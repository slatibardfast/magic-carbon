package carbon.model;

/***********
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
* @author William Grey
*
* @version 2014-08-22
*
************/

public class sres {
    
	int year [] = new int[] {1990,2000,2010,2020,2030,2040,2050,2060,2070,2080,2090,2100};
	private	double A1_AIM [] = new double[] {7.10,7.97,10.88,12.64,14.48,15.35,16.38,16.00,15.73,15.18,14.30,13.49};
	private	double A1G_MINICAM [] = new double[] {7.10,7.97,9.73,12.73,16.19,19.97,23.90,25.69,27.28,28.68,28.42,28.24};
	private	double A1T_MESSAGE [] = new double[] {7.10,7.97,9.38,10.26,12.38,12.65,12.26,11.38,9.87,8.02,6.26,4.32};
	private	double A2_ASF [] = new double[] {7.10,7.97,9.58,12.25,14.72,16.07,17.43,19.16,20.89,23.22,26.15,29.09};
	private	double B1_IMAGE [] = new double[] {7.10,7.97,9.28,10.63,11.11,11.72,11.29,9.74,8.18,6.70,5.32,4.23};
	private	double B2_MESSAGE [] = new double[] {7.10,7.97,8.78,9.05,9.90,10.69,11.01,11.49,11.62,12.15,12.79,13.32};
	private	double interpArr [] = new double[120];
		
	public double[] senario(double sen){ 
		
		double ConstantEmissions [] = new double[120];
		
		for (int i=0;i<12-1;i++){
			 for (int j=0;j<10;j++){ 
				 ConstantEmissions[i*10+j]=sen;
			 } 
		 }
		
		return ConstantEmissions;	
	}
	
	public double[] senario(int sen){ 
	
		switch(sen){
			case 1: interpArr=interpArray(A1_AIM);
					break;
			case 2: interpArr=interpArray(A1G_MINICAM);
					break;
			case 3: interpArr=interpArray(A1T_MESSAGE);
					break;
			case 4: interpArr=interpArray(A2_ASF);
					break;
			case 5: interpArr=interpArray(B1_IMAGE);
					break;
			case 6: interpArr=interpArray(B2_MESSAGE);
					break;
		}
		
		
		
		 return interpArr;	
	   
	}  
	   
	public double[] interpArray(double [] co2){
		 
		 
		 for (int i=0;i<12-1;i++){
			 for (int j=0;j<10;j++){ 
				 interpArr[i*10+j]=co2[i]*(1-(j/10.0))+co2[i+1]*(j/10.0);
	//			 System.out.format("%d\t%6.2f\n",i*10+j+1990,interpArr[i*10+j]);
			 }
			 
		 }
		 
	   return interpArr;
	 
	}
	
}
