package carbon.plot;

/**
 * 
 * Help text.
 * 
 * This is horrible.
 * There is probably a better way of doing this.
 * 
 * @author will Grey
 * 
 * @version  28/3/2015
 * 
 * This is free and unencumbered software released into the public domain.
 *  For more information, please refer to <http://unlicense.org/>
 */

public class HelpFile {

	public static final String text1 = "MagicCarbon (Model of Global AtmospherIc Carbon)\n\n" +
	"MODELS\n" +
	"MagicCarbon is a simple carbon budget simulator" +
	" that estimates atmospheric carbon concentrations based on different anthropogenic emission scenarios." +
	" The tool is aimed at sixth form students on enrichment programmes and first year " +
	" undergraduates for teaching and learning purposes." +
	" There are four " +
	"models: a simple airborne fraction model, mass balance model, box model and an" +
	" impulse response function.\n\n" +
	"Simple airborne fraction model - " +
	"The simple airborne fraction model is based on the idea that approximately half of emitted " +
	"carbon remains in the atmosphere and the remaining half is absorbed by the terrestrial " +
	"biosphere and oceans. More precisely both (1) and through numerical " +
	"minimisation against observations of atmospheric CO2 it has been shown " +
	"that the average annual fraction of emitted carbon that " +
	"remains in the atmosphere is 43 per cent. Thus: " +
	"Catm[t+1] = Catm[t] + Cemitted[t] * 0.43.\n\n" +			
	"Mass balance model - Mass balance model for atmospheric carbon. " +
	"delta C = [ S - (C0 / tau) ] delta t, where residence time of atmopheric" +
	" carbon, tau is set to 200 years (2).\n\n" +
	"Box model - This is the classic 1D carbon box model with fluxes " +
	"between the sources and sinks. This version has four boxes: " +
	"atmosphere, terrestrial biosphere, ocean and deep ocean (3).\n\n" +
	"Impulse Response function - " +
	"A simple carbon budget model that uses impulse response " +
	"function (IRF) based on (4) and (5).\n\n" +
	"DATASETS AND MODEL TESTING\n" +
	"There exists concurrent datasets on atmospheric observations and " +
	"anthropogenic emissions between 1959 and the present.  These datasets " +
	"allow us to test the models against observations. The two datasets are: CO2 " +
	"concentration in ppm between 1959 and 2014 from the NOAA Mauna Loa observatory " +
	"record from (6), and CO2 anthropogenic emissions in Gt/y between 1959 and 2009 from (7).\n\n" +
	"IPCC SRES\n" +
	"Values for different IPCC special report emission scenarios (SRES) for " +
	"carbon are from (8) where emissions are in GtC per year.  There are four families" +
	" of scenarios: A1, A2, B1 and B2 representing a range of story lines. \n\n" +
	"A1 - Rapid economic growth, population peaks 2050, introduction of efficient technologies\n" +
	"A2 - Continuously growing population, slow introduction of efficient technologies\n" +
	"B1 - Population peaks 2050, rapid adoption of efficient technologies\n" +
	"B2 - Continuously growing population, regional development\n\n" +
	"RUNNING THE MODEL\n" +
	"(1) Selecting simulation:\n" +
	"   -Test against obsevations over the period (1959-2008)\n" +
	"   -Fixed emission can be run over any period\n" +
	"   -Runs using the IPCC scenarios over the period (1990-2100)\n" +
	"(2) Model - One of the four models discussed above can be run.\n" +
	"(3) IPCC SRES - " +
	"One of 6 scenarios can be run.  There are 3 A1 scenarios, and 1 " +
	"scenario from each of the other 3 families.\n" +
	"(4) Fixed emissions - " +
	"Fixed emissions scenarios allow the greates flexibility and any period can be selected.\n" +
	"(5) Outputs - Plots and datasets are output.  A summary of the output is also given.\n\n" +
	"REFERENCES\n" +
	"(1) LeQuere (2009) Nature Geosciences\n" +
	"(2) Mackay et al http://www.atmosedu.com/physlets/GlobalPollution/CO2assign.htm\n" +
	"(3) Rodhe (1979) Tellus\n" +
	"(4) Boucher et al, (2008) Climatic Change\n" +
	"(5) Joos and Bruno (1997) Phys. and Chem. of the Earth\n" +
	"(6) http://co2now.org/Current-CO2/CO2-Now/noaa-mauna-loa-co2-data.html\n" +
	"(7) http://co2now.org\n" +
	"(8) http://sres.ciesin.org/final_data.html";
	
}
