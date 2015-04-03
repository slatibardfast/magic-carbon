package carbon.plot;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.BorderLayout;
//import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class menuBarSepUp extends JFrame {

	private static final long serialVersionUID = 1L;

	public menuBarSepUp(String title) throws HeadlessException {
		super(title);
	}

	protected JMenuBar menuSetUp() {
		  JMenuBar menuBar = new JMenuBar();
		 
		  JMenu filem = new JMenu("File");
		  JMenu helpm = new JMenu("Help");
		  JMenu runm = new JMenu("Run");
		  
		  menuBar.add(filem);
//		  menuBar.add(runm);
		  menuBar.add(Box.createHorizontalGlue());
		  menuBar.add(helpm);
		  
		  
		//  JMenuItem savem = new JMenuItem("Save"); 
		  JMenuItem exitm = new JMenuItem("Exit");
		  
		 // filem.add(savem);
		  filem.addSeparator();
		  filem.add(exitm);
		  
		  
		  JMenuItem simm = new JMenuItem("Run simulation");
		  runm.add(simm);
		  
		  JMenuItem help = new JMenuItem("Help");
		  JMenuItem aboutm = new JMenuItem("About");
		  
		  helpm.add(help);
		  helpm.add(aboutm);
		  
		  
		  
		  exitm.addActionListener(new ActionListener(){
		      @Override
		      public void actionPerformed(ActionEvent e) {
		          System.exit(0);
		     }
		  });
		  
		  
		  runm.addActionListener(new ActionListener(){
		      @Override
		      public void actionPerformed(ActionEvent e) {
		          System.exit(0);
		     }
		  });
		  
		  aboutm.addActionListener(new ActionListener(){
		  
		  public void actionPerformed(ActionEvent e) {
			    
			    JFrame gui = new JFrame();
			    
			    final JPanel Panel = new JPanel ( new GridLayout(2,2));
			    Panel.add(new JLabel(" MagicCarbon 2015"));
			    Panel.add(new JLabel(" Author: Will Grey"));
			    
			    gui.add(Panel);
	            gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	            gui.setSize(200, 70);
	            gui.setLocation(300, 300);
	            gui.setVisible(true);

	        }
		  
		  });
		  
		  
		  help.addActionListener(new ActionListener(){
			  
			  public void actionPerformed(ActionEvent e) {
				    
//				    JLabel label = new JLabel();
//				    label.setText(text);
//				    JPanel Panel = new JPanel ( new BorderLayout());
//		            Panel.add(label, BorderLayout.NORTH);
//		            Panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
//		            JScrollPane scrollPane = new JScrollPane(Panel);
		            
		            JTextArea textArea = new JTextArea(2, 20);
		            textArea.setText(helpFile.text1);
		            textArea.setWrapStyleWord(true);
		            textArea.setLineWrap(true);
		            textArea.setOpaque(false);
		            textArea.setEditable(false);
		            textArea.setFocusable(false);
		            
		            JScrollPane scrollPane = new JScrollPane(textArea);
//		            scrollPane.getViewport().setViewPosition(new Point(0, 0));
		            scrollPane.getVerticalScrollBar().setValue(0);
		            scrollPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
				    JFrame frame = new JFrame();
				    frame.add(scrollPane);
		            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		            frame.setSize(500, 500);
		            frame.setVisible(true);

		        }
			  
			  });
		  
		  
		return menuBar;
	}

	
	
}