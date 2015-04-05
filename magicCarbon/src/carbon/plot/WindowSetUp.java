package carbon.plot;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;

import java.util.*;
import java.io.File;
import java.awt.event.*;

import carbon.JPanelTools.*;
import carbon.model.RunModel;

public class WindowSetUp extends MenuBarSepUp implements ActionListener  {
 
	private static final long serialVersionUID = 1L;
	
	 public final JTextField SIn = new JTextField (7);
	 public final JTextField C0In = new JTextField (7);
	 public final JTextField startYearIn = new JTextField (7);
	 public final JTextField YearsIn = new JTextField (7); 

	 public final JTextField endCarbon = new JTextField (7);
	 public final JTextField addedCarbon = new JTextField (7);
	 public final JTextField endYear = new JTextField (7);
	 public final JTextField radiativeForcing = new JTextField (7); 
	 public final JTextField endTemperature = new JTextField (7); 
	 public final JTextField errorRMSE = new JTextField (7); 
	 
	 public final JTextField dataFile = new JTextField (15); 
	 public final JTextField plotFile = new JTextField (15); 
	
	 JButton openJPGButton = new JButton("New plot file");
	 JButton openDataButton = new JButton("New data file");
	  
	 String outputCarbonChart="chart-output.jpg";
	 String outputCarbonData="outputfile.txt";
	 
	 List<JRadioButton> modelRadioButtons = new ArrayList<JRadioButton>();
     List<JRadioButton> simulationRadioButtons = new ArrayList<JRadioButton>();	
	 List<JRadioButton> scenarioRadioButtons = new ArrayList<JRadioButton>();	
	 
	 int sim = 1;
	 int model = 1;
	 int scenario = 1;
	 
	 JFileChooser fc= new JFileChooser();
	 
	public WindowSetUp(){
     
	super("Model of Global Atmospheric Carbon");
	
	 setDefaultValues();
	
	 final List<JPanel> panel = createPanelList();
	 JMergePanel mergePanel = new  JMergePanel();
	 createFrame(panel, mergePanel);
	 
	 JMenuBar menuBar = menuSetUp();
	  setJMenuBar(menuBar);
	  
	  setEnabledAll(panel.get(2),false);
	  setEnabledAll(panel.get(3),false);
	  
	  buttonOutputResponse();
	  buttonSimulationResponse(panel);
	  buttonModelResponse(panel);
	  buttonScenarioResponse(panel);
	  
	}

	private void buttonOutputResponse(){
	
	 openJPGButton.addActionListener(new ActionListener(){
	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  fc.showOpenDialog(WindowSetUp.this);
	    	  File file = fc.getSelectedFile();
	    	  
	    	  if (file == null) {
	    		   plotFile.setText(outputCarbonChart);	
	    		}
	    	  
	    	  else if (file.exists()) {
	    		  int responseFileExist = JOptionPane.showConfirmDialog(WindowSetUp.this,
	    		          "The file " + file.getName() + 
	    		          " already exists. Do you want to replace the existing file?",
	    		          "Ovewrite file", JOptionPane.YES_NO_OPTION,
	    		          JOptionPane.WARNING_MESSAGE);
	    		        if (responseFileExist != JOptionPane.YES_OPTION)
	    		          return;
	    		      } 
	          
	    	  else{
	    	  plotFile.setText(file.getAbsolutePath());
	    	  }
	     }
	  });
	  
	  openDataButton.addActionListener(new ActionListener(){
	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  fc.showOpenDialog(WindowSetUp.this);
	    	  File file = fc.getSelectedFile ();
	    	  if (file == null) {
	    		   dataFile.setText(outputCarbonData);	
	    		}
	    	  else{
	    	  dataFile.setText(file.getAbsolutePath());
	    	  }
	     }
	  });
}
	private void buttonScenarioResponse(final List<JPanel> panel) {
	
		scenarioRadioButtons.get(0).addActionListener(new ActionListener(){
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  scenario=1;
		     }
		  });
		  
		scenarioRadioButtons.get(1).addActionListener(new ActionListener(){
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  scenario=2;
		     }
		  });
		  
		scenarioRadioButtons.get(2).addActionListener(new ActionListener(){
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  scenario=3;
		     }
		  });
		  
		scenarioRadioButtons.get(3).addActionListener(new ActionListener(){
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  scenario=4;
		     }
		  });
		  
		scenarioRadioButtons.get(4).addActionListener(new ActionListener(){
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  scenario=5;
		     }
		  });
		  
		scenarioRadioButtons.get(5).addActionListener(new ActionListener(){
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  scenario=6;
		     }
		  });	
		
	}
	
	
	private void buttonSimulationResponse(final List<JPanel> panel) {
		simulationRadioButtons.get(0).addActionListener(new ActionListener(){
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  setEnabledAll(panel.get(2),false);
		    	  setEnabledAll(panel.get(3),false);
		    	  sim=1;
		     }
		  });
		  
		  simulationRadioButtons.get(1).addActionListener(new ActionListener(){
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  setEnabledAll(panel.get(2),false);
		    	  setEnabledAll(panel.get(3),true);
		    	  sim=2;
		     }
		  });
		  
		  simulationRadioButtons.get(2).addActionListener(new ActionListener(){
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  setEnabledAll(panel.get(2),true);
		    	  setEnabledAll(panel.get(3),false);
		    	  sim=3;
		     }
		  });
	}
	
	private void buttonModelResponse(final List<JPanel> panel) {
		modelRadioButtons.get(0).addActionListener(new ActionListener(){
	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  model=1;
	     }
	  });
	  
		modelRadioButtons.get(1).addActionListener(new ActionListener(){
	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  model=2;
	     }
	  });
	  
		modelRadioButtons.get(2).addActionListener(new ActionListener(){
	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  model=3;
	     }
	  });
	  
		modelRadioButtons.get(3).addActionListener(new ActionListener(){
	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  model=4;
	     }
	  });
	}	
	
	private void setDefaultValues() {
		SIn.setText("10.0");
		  C0In.setText("354.35");
		  startYearIn.setText("1990");
		  YearsIn.setText("100");
		  plotFile.setText("chart-output.jpg");
		  dataFile.setText("outputfile.txt");
	}

	private List<JPanel> createPanelList() {
		List<JPanel> panel = new  ArrayList<JPanel>();	

		panel.add(createSimulationPanel());
		panel.add(createModelPanel());
		panel.add(createScenariosPanel());
		panel.add( createFixedEmissionsPanel());
		panel.add(createFilePanel());
		panel.add(createOutputPanel());
		panel.add(createButtonPanel());
		
		return panel;
	}

	private void createFrame(List<JPanel> panel, JMergePanel mergePanel) {
	     add(mergePanel. createMergedPanel(panel));
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 pack();
		 setResizable(false);
		 setVisible(true);
	}

	private JPanel createButtonPanel() {
		final JButton button = new JButton ("Calculate");
		 final JPanel buttonPanel = new JPanel(new GridLayout(2,1));  
		 button.addActionListener(this);
		 buttonPanel.add(new JLabel(""));
		 buttonPanel.add(button);
	
		 return buttonPanel;
	}

	private JPanel createFilePanel() {
		
		  plotFile.setEditable(false);
		  dataFile.setEditable(false);
		 
		  final JPanel leftPanel = new JPanel(new GridLayout(2,3));
		  leftPanel.add(new JLabel("SELECT OUTPUT FILES"));
		  leftPanel.add(new JLabel(""));
		  leftPanel.add(openJPGButton);
		  leftPanel.add(openDataButton);
		  
		  final JPanel rightPanel = new JPanel(new GridLayout(5,1));
		  rightPanel.add(new JLabel("Plot File"));
		  rightPanel.add(plotFile);
		  rightPanel.add(new JLabel("Data File"));
		  rightPanel.add(dataFile); 
		  
		  JCatPanel panel = new JCatPanel();
		  JPanel outPanel = new JPanel();
		  outPanel=panel.catPanel(leftPanel,rightPanel);
		  outPanel.setBorder(BorderFactory.createEtchedBorder());
		  
		  return outPanel;
	}

	private JPanel createOutputPanel() {
		
		endCarbon.setEditable(false);
		  addedCarbon.setEditable(false);
		  endYear.setEditable(false);
		  radiativeForcing.setEditable(false);
		  endTemperature.setEditable(false);
		  errorRMSE.setEditable(false);
		
		final JPanel leftPanel = new JPanel ( new GridLayout(8,1));
		  leftPanel.add(new JLabel("SUMMARY OUTPUTS"));
		  leftPanel.add(new JLabel(" End year "));
		  leftPanel.add(new JLabel(" CO2 concentration end (ppm) "));
		  leftPanel.add(new JLabel(" Additional atm C over period (GtC) "));
		  leftPanel.add(new JLabel(" Radiative forcing (w/m2) "));
		  leftPanel.add(new JLabel(" Temperature increase (deg C) "));
		  leftPanel.add(new JLabel(" RMSE (Test only) "));
		  leftPanel.add(new JLabel(""));
		  
		  final JPanel rightPanel = new JPanel ( new GridLayout(8,1));
		  rightPanel.add(new JLabel(""));
		  rightPanel.add(endYear);
		  rightPanel.add(endCarbon);
		  rightPanel.add(addedCarbon);
		  rightPanel.add(radiativeForcing);
		  rightPanel.add(endTemperature);
		  rightPanel.add(errorRMSE);
		  rightPanel.add(new JLabel(" "));
		  JSideCatPanel panel = new JSideCatPanel();
		  return panel.sideCatPanel(leftPanel,rightPanel);
		  
	}

	private JPanel createFixedEmissionsPanel() {
		final JPanel leftPanel = new JPanel ( new GridLayout(5,1));
		  leftPanel.add(new JLabel(" FIXED EMISSIONS"));
		  leftPanel.add(new JLabel(" Emissions per year (GtC) "));
		  leftPanel.add(new JLabel(" CO2 concentration start (ppm) "));
		  leftPanel.add(new JLabel(" Start year "));
		  leftPanel.add(new JLabel(" Years run "));
		  
		  final JPanel rightPanel = new JPanel ( new GridLayout(5,1));
		  rightPanel.add(new JLabel(""));
		  rightPanel.add(SIn);
		  rightPanel.add(C0In);
		  rightPanel.add(startYearIn);
		  rightPanel.add(YearsIn);
		 
		  JSideCatPanel panel = new JSideCatPanel();
		  return panel.sideCatPanel(leftPanel,rightPanel);
	}
	
	private JPanel createModelPanel() {
			
		modelRadioButtons.add(new JRadioButton("Airborne Fraction Model"));
		 modelRadioButtons.add(new JRadioButton("Four Box Model"));
		 modelRadioButtons.add(new JRadioButton("Impulse Response Function"));
		 modelRadioButtons.add(new JRadioButton("Mass Balance Model"));
		 String title="MODEL";
	 
		 JRadioPanelGroup radioPanel = new JRadioPanelGroup();
		return radioPanel.createRadioButtonPanel(modelRadioButtons, title);
		
	}
  
 private JPanel createSimulationPanel() {
		
		simulationRadioButtons.add(new JRadioButton("Test Against Observations (1959-2008)"));
		 simulationRadioButtons.add(new JRadioButton("Fixed Emissions"));
		 simulationRadioButtons.add(new JRadioButton("IPCC SRES (1990-2100)"));
		 String title="SIMULATION";
		
		 JRadioPanelGroup radioPanel = new JRadioPanelGroup();
		return radioPanel.createRadioButtonPanel(simulationRadioButtons, title);
		
	}
 
 private JPanel createScenariosPanel() {
		
		 scenarioRadioButtons.add(new JRadioButton("A1 AIM"));
		 scenarioRadioButtons.add(new JRadioButton("A1G MINICAM"));
		 scenarioRadioButtons.add(new JRadioButton("A1T MESSAGE"));
		 scenarioRadioButtons.add(new JRadioButton("A2 ASF"));
		 scenarioRadioButtons.add(new JRadioButton("B1 IMAGE"));
		 scenarioRadioButtons.add(new JRadioButton("B2 MESSAGE"));		 
		 String title="IPCC SCENARIO";
		
		 JRadioPanelGroup radioPanel = new JRadioPanelGroup();
		return radioPanel.createRadioButtonPanel(scenarioRadioButtons, title);
		
	}
 
public static void setEnabledAll(Container container, boolean enabled) {
	 
	 // http://www.java-forums.org/awt-swing/35369-disabling-jpanel.html  
	 
	 Component[] components = container.getComponents();
	   if (components.length > 0) {
	      for (Component component : components) {
	         component.setEnabled(enabled);
	         if (component instanceof Container) { // has to be a container to contain components
	            setEnabledAll((Container)component, enabled); // the recursive call
	         }
	      }
	   }
	} 
 
	public void actionPerformed( final ActionEvent ae){ 
		
		double S=10.0;
		double C0=354.35;
		int startYear=1990;
		int Years=100;
		
		if (dataFile != null && !"".equals(dataFile.getText())){
			outputCarbonData=dataFile.getText();
		}
			
		if (C0In != null && !"".equals(C0In.getText())){
			outputCarbonChart=plotFile.getText();
		}
		
		if (SIn != null && !"".equals(SIn.getText())){
		 S = Double.parseDouble(SIn.getText());
		}
		
		if (C0In != null && !"".equals(C0In.getText())){
		 C0 = Double.parseDouble(C0In.getText());
		}
		
		if (startYearIn != null && !"".equals(startYearIn.getText())){
		 startYear = Integer.parseInt(startYearIn.getText());
		}
		
		if (YearsIn != null && !"".equals(YearsIn.getText())){ 
		  Years = Integer.parseInt(YearsIn.getText());  
		}
	    
		RunModel rm = new RunModel();
		
	    if (sim==1){
	    	System.out.format("Test Model");
	    	rm.testModel(model,  outputCarbonData, outputCarbonChart);
	    	setSummaryData(rm);
	    }
	    else if (sim==2){
	    	System.out.format("Fixed Emission Scenarios"); 
	    	rm.fixed_emissions(model, S, C0, startYear, Years, outputCarbonData, outputCarbonChart); 
	    	 setSummaryData(rm);
	    	   
	    }
	    else if (sim==3){
	    	System.out.format("IPCC Emission Scenarios"); 
	    	rm.ipcc(model, scenario, outputCarbonData, outputCarbonChart);
	    	setSummaryData(rm);
	    	
	    }
	}

	private void setSummaryData(RunModel rm) {
		
		endCarbon.setText(String.valueOf(String.format("%.2f",rm.getEndCarbon())));
		addedCarbon.setText(String.valueOf(String.format("%.2f", rm.getAddedCarbon())));
		endYear.setText(String.valueOf(String.format("%.0f", rm.getYearEnd())));
		radiativeForcing.setText(String.valueOf(String.format("%.2f", rm.getRadiativeForcing())));
		endTemperature.setText(String.valueOf(String.format("%.2f", rm.getEndTemperature())));
		
		if (rm.getError() != -99.0){
		 errorRMSE.setText(String.valueOf(String.format("%.2f", rm.getError())));
		}
		else{
		  errorRMSE.setText("N/A");
		}
	}
	
}
