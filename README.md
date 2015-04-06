# magic-carbon
Model of Global Atmospheric Carbon

MODELS 
MagicCarbon is a simple carbon budget simulator that estimates atmospheric carbon concentrations based on different anthropogenic emission scenarios. The tool is aimed at sixth form students on enrichment programmes and first year undergraduates for teaching and learning purposes. There are four models to choose from: a simple airborne fraction model, mass balance model, box model and an impulse response function.

Simple airborne fraction model - The simple airborne fraction model is based on the idea that approximately half of emitted carbon remains in the atmosphere and the remaining half is absorbed by the terrestrial biosphere and ocean. More precisely both (1) and through numerical minimisation against observations of atmospheric CO2 it has been shown that the average annual fraction of emitted carbon that remains in the atmosphere is 43 per cent. Thus: Catm[t1] = Catm[t]  Cemitted[t] * 0.43.

Mass balance model - Mass balance model for atmospheric carbon. delta C = [ S - (C0  tau) ] delta t, where residence time of atmopheric carbon, tau is set to 200 years (2). 

Box model - This is the classic 1D carbon box model with fluxes between the sources and sinks. This version has four boxes: atmosphere, terrestrial biosphere, ocean and deep ocean (3). 

Impulse Response function - A simple carbon budget model that uses impulse response function (IRF) based on (4) and (5). 

DATASETS AND MODEL TESTING 
There exists concurrent datasets on atmospheric observations and anthropogenic emissions between 1959 and the present.  These datasets allow us to test the models against observations. The two datasets are: CO2 concentration in ppm between 1959 and 2014 from the NOAA Mauna Loa observatory record from (6), and CO2 anthropogenic emissions in Gty between 1959 and 2009 from (7).

IPCC SRES 
Values for different IPCC special report emission scenarios (SRES) for carbon are from (8) where emissions are in GtC per year.  There are four families of scenarios: A1, A2, B1 and B2 representing a range of story lines. 
A1 - Rapid economic growth, population peaks 2050, introduction of efficient technologies 
A2 - Continuously growing population, slow introduction of efficient technologies 
B1 - Population peaks 2050, rapid adoption of efficient technologies 
B2 - Continuously growing population, regional development 

RUNNING THE MODEL
(a) Selecting simulation:
   -Test against obsevations over the period (1959-2008) 
   -Fixed emission can be run over any period
   -Runs using the IPCC scenarios over the period (1990-2100)
(b) Model - One of the four models discussed above can be run.
(c) IPCC SRES -  One of 6 scenarios can be run.  There are 3 A1 scenarios, and 1 scenario from each of the other 3 families.
(d) Fixed emissions -  Fixed emissions scenarios allow the greates flexibility and any period can be selected.
(e) Outputs - Plots and datasets are output.  A summary of the output is also given.

REFERENCES 
(1) LeQuere (2009) Nature Geosciences
(2) Mackay et al http:www.atmosedu.comphysletsGlobalPollutionCO2assign.htm 
(3) Rodhe (1979) Tellus
(4) Boucher et al, (2008) Climatic Change
(5) Joos and Bruno (1997) Phys. and Chem. of the Earth
(6) http:co2now.orgCurrent-CO2CO2-Nownoaa-mauna-loa-co2-data.html
(7) http:co2now.org 
(8) http:sres.ciesin.orgfinal_data.html;

REQUIREMENTS
https://github.com/jfree/jfreechart-fse

Will Grey
April 2015
