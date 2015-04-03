
/**
*
* magicCarbon (Model of Global AtmospherIc Carbon)
*
*
* @author William Grey
*
* @version 2014-08-22
*
*/

package carbon.plot;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import carbon.model.runModel;


public class WindowSetUp extends menuBarSepUp implements ActionListener {
 
 private static final long serialVersionUID = 1L;
	
 public final JTextField SIn = new JTextField (7);
 public final JTextField C0In = new JTextField (7);
 public final JTextField startYearIn = new JTextField (7);
 public final JTextField YearsIn = new JTextField (7); 

 public final JTextField CarbonEnd = new JTextField (7);
 public final JTextField CarbonGtCEnd = new JTextField (7);
 public final JTextField YearEnd = new JTextField (7);
 public final JTextField RF = new JTextField (7); 
 public final JTextField Temperature = new JTextField (7); 
 public final JTextField RMSE = new JTextField (7); 
 
 public final JTextField dfile = new JTextField (15); 
 public final JTextField pfile = new JTextField (15); 
 
 JRadioButton TestButton = new JRadioButton("Test Against Observations (1959-2008)");
 JRadioButton FeButton = new JRadioButton("Fixed Emissions");
 JRadioButton SresButton = new JRadioButton("IPCC SRES (1990-2100)"); 
 
 final JButton openJPGButton = new JButton("New plot file");
 final JButton openDataButton = new JButton("New data file");
 
 JRadioButton SimButton = new JRadioButton("Simple Model");
 JRadioButton BoxButton = new JRadioButton("Four Box Model");
 JRadioButton IRFButton = new JRadioButton("Impulse Response Function"); 
 JRadioButton mbButton = new JRadioButton("Mass Balance Model"); 
 
 JRadioButton A1Button = new JRadioButton("A1 AIM");
 JRadioButton A1GButton = new JRadioButton("A1G MINICAM");
 JRadioButton A1TButton = new JRadioButton("A1T MESSAGE");
 JRadioButton A2Button = new JRadioButton("A2 ASF");
 JRadioButton B1Button = new JRadioButton("B1 IMAGE");
 JRadioButton B2Button = new JRadioButton("B2 MESSAGE"); 
 
 int sim = 1;
 int model = 1;
 int scenario = 1;
 
 JFileChooser fc= new JFileChooser();
 
 // public final String CarbonEnd = "";
 // public final String CarbonGtCEnd = "";
 // public final String YearEnd = "";
 // public final JLabel carbonLabel = new JLabel (CarbonEnd);
 // public final JLabel carbonGtCLabel = new JLabel (CarbonGtCEnd);
 // public final JLabel yearLabel = new JLabel (YearEnd);

 public WindowSetUp(){
	  
  super("Model of Global Atmospheric Carbon");
  
  SIn.setText("10.0");
  C0In.setText("354.35");
  startYearIn.setText("1990");
  YearsIn.setText("100");
  pfile.setText("chart-output.jpg");
  dfile.setText("outputfile.txt");
   
  final JPanel radioPanel1 = simInput();
  final JPanel radioPanel2 = modInput();
  final JPanel radioPanel3 = sresInput();
  
  final JPanel fePanel = fe();
  final JPanel outPanel = outputModel();
  final JPanel butPanel = but();
  
  final JPanel radioPanela = new JPanel(new BorderLayout());
  radioPanela.add(radioPanel1,BorderLayout.NORTH);
  radioPanela.add(radioPanel2,BorderLayout.SOUTH);
  
  final JPanel radioPanel = new JPanel(new BorderLayout());
  radioPanel.add(radioPanela,BorderLayout.NORTH);
  radioPanel.add(radioPanel3,BorderLayout.SOUTH);
  
  final JPanel displayPanel = new JPanel(new BorderLayout());
  displayPanel.add(fePanel,BorderLayout.NORTH);
  displayPanel.add(butPanel,BorderLayout.SOUTH);
  
  final JPanel displayPanel2 = new JPanel(new BorderLayout());
  displayPanel2.add(displayPanel,BorderLayout.NORTH);
  displayPanel2.add(outPanel,BorderLayout.SOUTH);
  
  final JButton button = new JButton ("Calculate");
  
  button.addActionListener(this);
	 
  final JPanel buttonPanel = new JPanel();
  buttonPanel.add(button);
//  button.setEnabled(false); 
  final JPanel backPanel = new JPanel (new BorderLayout());
  backPanel.add(radioPanel,BorderLayout.NORTH);
  backPanel.add (displayPanel2, BorderLayout.CENTER);
  backPanel.add (buttonPanel, BorderLayout.SOUTH);
  backPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
  add(backPanel);
  
  
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  pack();
  setResizable(false);
  setVisible(true);
  
  JMenuBar menuBar = menuSetUp();
  setJMenuBar(menuBar);
  
  setEnabledAll(radioPanel3,false);
  setEnabledAll(fePanel,false);
  
  openJPGButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
    	  fc.showOpenDialog(WindowSetUp.this);
    	  File file = fc.getSelectedFile();
    	  pfile.setText(file.getName());	 
     }
  });
  
  openDataButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
    	  fc.showOpenDialog(WindowSetUp.this);
    	  File file = fc.getSelectedFile();
    	  dfile.setText(file.getName());
     }
  });
  
  TestButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
    	  setEnabledAll(radioPanel3,false);
    	  setEnabledAll(fePanel,false);
    	  sim=1;
     }
  });
  
  FeButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
    	  setEnabledAll(radioPanel3,false);
    	  setEnabledAll(fePanel,true);
    	  sim=2;
     }
  });
  
  SresButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
    	  setEnabledAll(radioPanel3,true);
    	  setEnabledAll(fePanel,false);
    	  sim=3;
     }
  });
  
  SimButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
    	  model=1;
     }
  });
  
  BoxButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
    	  model=2;
     }
  });
  
  IRFButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
    	  model=3;
     }
  });
  
  mbButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
    	  model=4;
     }
  });
  
  A1Button.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
    	  scenario=1;
     }
  });
  
  A1GButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
    	  scenario=2;
     }
  });
  
  A1TButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
    	  scenario=3;
     }
  });
  
  A2Button.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
    	  scenario=4;
     }
  });
  
  B1Button.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
    	  scenario=5;
     }
  });
  
  B2Button.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
    	  scenario=6;
     }
  });
  
 }

private JPanel but() {
	
	  pfile.setEditable(false);
	  dfile.setEditable(false);
	
	  
	  final JPanel buttonPanel1 = new JPanel(new GridLayout(2,3));
	  buttonPanel1.add(new JLabel("SELECT OUTPUT FILES"));
	  buttonPanel1.add(new JLabel(""));
	  buttonPanel1.add(openJPGButton);
	  buttonPanel1.add(openDataButton);
	  
	  
	  final JPanel buttonPanel2 = new JPanel(new GridLayout(5,1));
	  buttonPanel2.add(new JLabel("Plot File"));
	  buttonPanel2.add(pfile);
	  buttonPanel2.add(new JLabel("Data File"));
	  buttonPanel2.add(dfile); 
	  buttonPanel2.add(new JLabel(""));
	  
	  final JPanel buttonPanel = new JPanel(new BorderLayout());
	  buttonPanel.add(buttonPanel1,BorderLayout.NORTH);
	  buttonPanel.add(buttonPanel2,BorderLayout.SOUTH); 
	  buttonPanel.setBorder(BorderFactory.createEtchedBorder());
	  return buttonPanel;
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
 
private JPanel outputModel() {
	
	CarbonEnd.setEditable(false);
	  CarbonGtCEnd.setEditable(false);
	  YearEnd.setEditable(false);
	  RF.setEditable(false);
	  Temperature.setEditable(false);
	  RMSE.setEditable(false);
	
	final JPanel lPanel = new JPanel ( new GridLayout(9,1));
	  lPanel.add(new JLabel(""));
	  lPanel.add(new JLabel(" OUTPUTS"));
	  lPanel.add(new JLabel(" End year "));
	  lPanel.add(new JLabel(" CO2 concentration end (ppm) "));
	  lPanel.add(new JLabel(" Additional atm C over period (GtC) "));
	  lPanel.add(new JLabel(" Radiative forcing (w/m2) "));
	  lPanel.add(new JLabel(" Temperature (deg C) "));
	  lPanel.add(new JLabel(" RMSE (Test only): "));
	 
	  
	  final JPanel ioPanel = new JPanel ( new GridLayout(9,1));
	  ioPanel.add(new JLabel(""));
	  ioPanel.add(new JLabel(""));
	  ioPanel.add(CarbonEnd);
	  ioPanel.add(CarbonGtCEnd);
	  ioPanel.add(YearEnd);
	  ioPanel.add(RF);
	  ioPanel.add(Temperature);
	  ioPanel.add(RMSE);
	  
	  final JPanel outPanel = new JPanel(new BorderLayout());
	  outPanel.add(lPanel,BorderLayout.WEST);
	  outPanel.add(ioPanel,BorderLayout.CENTER); 
	  outPanel.setBorder(BorderFactory.createEtchedBorder());
	return outPanel;
}

private JPanel fe() {
	final JPanel lPanel = new JPanel ( new GridLayout(5,1));
	  lPanel.add(new JLabel(" FIXED EMISSIONS"));
	  lPanel.add(new JLabel(" Emissions per year (GtC) "));
	  lPanel.add(new JLabel(" CO2 concentration start (ppm) "));
	  lPanel.add(new JLabel(" Start year "));
	  lPanel.add(new JLabel(" Years run "));
	  
	  final JPanel ioPanel = new JPanel ( new GridLayout(5,1));
	  ioPanel.add(new JLabel(""));
	  ioPanel.add(SIn);
	  ioPanel.add(C0In);
	  ioPanel.add(startYearIn);
	  ioPanel.add(YearsIn);
	 
	  final JPanel displayPanel = new JPanel(new BorderLayout());
	  displayPanel.add(lPanel,BorderLayout.WEST);
	  displayPanel.add(ioPanel,BorderLayout.CENTER); 
	  displayPanel.setBorder(BorderFactory.createEtchedBorder());
	return displayPanel;
}

private JPanel simInput() {
	  
	  TestButton.setSelected(true); 
	  
	  ButtonGroup group = new ButtonGroup();
	  group.add(FeButton);
	  group.add(TestButton);
	  group.add(SresButton);
	  
	  JPanel radioPanel = new JPanel(new GridLayout(0, 1));
	  radioPanel.add(new JLabel("SIMULATION"));
	  radioPanel.add(TestButton);
	  radioPanel.add(FeButton);
	  radioPanel.add(SresButton);
	  radioPanel.setBorder(BorderFactory.createEtchedBorder());
	  return radioPanel;
}

private JPanel modInput() {
	  
	  SimButton.setSelected(true);
	  
	  ButtonGroup group = new ButtonGroup();
	  group.add(SimButton);
	  group.add(BoxButton);
	  group.add(IRFButton);
	  group.add(mbButton);
	  
	  JPanel radioPanel = new JPanel(new GridLayout(0, 1));
	  radioPanel.add(new JLabel("MODEL"));
	  radioPanel.add(SimButton);
	  radioPanel.add(BoxButton);
	  radioPanel.add(IRFButton);
	  radioPanel.add(mbButton);
	  radioPanel.setBorder(BorderFactory.createEtchedBorder());
	  return radioPanel;
}

private JPanel sresInput() {
	  
	  A1Button.setSelected(true); 
	  ButtonGroup group = new ButtonGroup();
	  group.add(A1Button);
	  group.add(A1GButton);
	  group.add(A1TButton);
	  group.add(A2Button);
	  group.add(B1Button);
	  group.add(B2Button);
	  
//	  A1Button.setEnabled(false); 
//	  A1GButton.setEnabled(false);
//	  A1TButton.setEnabled(false); 
//	  A2Button.setEnabled(false);
//	  B1Button.setEnabled(false);
//	  B2Button.setEnabled(false);
	  
	  JPanel radioPanel = new JPanel(new GridLayout(0, 1));
	  radioPanel.add(new JLabel("IPCC SRES"));
	  radioPanel.add(A1Button);
	  radioPanel.add(A1GButton);
	  radioPanel.add(A1TButton);
	  radioPanel.add(A2Button);
	  radioPanel.add(B1Button);
	  radioPanel.add(B2Button);
	  radioPanel.setBorder(BorderFactory.createEtchedBorder());
	  return radioPanel;
}

public void actionPerformed( final ActionEvent ae){ 
    
	double S=10.0;
	double C0=354.35;
	int startYear=1990;
	int Years=100;
	
	String outputCarbonChart="chart-output.jpg";
	String outputCarbonData="outputfile.txt";
	
	if (dfile != null && !"".equals(dfile.getText())){
		outputCarbonData=dfile.getText();
	}
		
	if (C0In != null && !"".equals(C0In.getText())){
		outputCarbonChart=pfile.getText();
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
    
	runModel rm = new runModel();
	
    if (sim==1){
    	rm.testModel(1,  outputCarbonData, outputCarbonChart);
//    	CarbonEnd.setText(String.valueOf(String.format("%.2f", rm.Ctl));
//   	CarbonGtCEnd.setText(String.valueOf(String.format("%.2f", rm.Ctl));
//    	YearEnd.setText(String.valueOf(String.format("%.2f", rm.Ctl));
//    	RF.setText(String.valueOf(String.format("%.2f", rm.Ctl));
//    	Temperature.setText(String.valueOf(String.format("%.2f", rm.Ctl));
//    	RMSE.setText(String.valueOf(String.format("%.2f", rm.Ctl));
    }
    else if (sim==2){
    	 rm.fixed_emissions(model, S, C0, startYear, Years, outputCarbonData, outputCarbonChart); 
    }
    else if (sim==3){
    	rm.ipcc(model, scenario, outputCarbonData, outputCarbonChart);	
    }
    
    
    
	
//	 	 
//	  

//	 ImpulseResponseFunction IRF = new ImpulseResponseFunction(C0, Years, S);

//	 carbonLabel.setText(String.valueOf(String.format("%.2f", IRF.Ctl)));
//	 yearLabel.setText(String.valueOf(IRF.endYear));
//	 carbonGtCLabel.setText(String.valueOf(String.format("%.2f", IRF.addedC)));
 //    SOutput.setText(String.valueOf(IRF.Ctl));
	 
	}
   
}