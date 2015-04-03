
package carbon.plot;

import org.jfree.chart.*;
import org.jfree.data.time.*;
import java.io.*;

public class PlotTimeSeries extends Year {
	
	
	private static final long serialVersionUID = 1L;

	public static void PlotTS(int yr, double[] ppm, int years, String chartOutput){
			
		TimeSeries carbon = new TimeSeries("Carbon");
		for (int i=0;i<years;i++){
		 carbon.add(new Year(yr+i), ppm[i]);
		}
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(carbon);
		JFreeChart chart = ChartFactory.createTimeSeriesChart(
		"Atmospheric CO2 concentration", "Year", "CO2 (ppm)", 
		dataset, false, true, true);
		try {
		 ChartUtilities.saveChartAsJPEG(new File(chartOutput), chart, 500, 300);
		 } catch (IOException e) {
		  System.err.println("Problem occurred creating chart.");
		}
		}

}
