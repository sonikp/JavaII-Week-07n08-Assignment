// ControlFrame.java
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class ControlFrame extends JFrame
{ 
  private JPanel mainPanel;
  private final JPanel calcPanel;
  private final JPanel soundPanel;
  private JSlider widthJSlider;
  private JTextField xValTextField;
  private JTextField yValTextField;
  private JLabel calcJLabel;
  private JButton calcJButton;
  private JLabel soundJLabel;
  private JButton soundJButton;
  private JButton soundJButton1;
  private JButton soundJButton2;
  private JButton soundJButton3;
  
  private String xStr;
  private String yStr;
  
  public ControlFrame(String title)
  {
    super( title );
    mainPanel = new JPanel( new BorderLayout() );
    mainPanel.setSize(200, 250);    
    
    calcPanel = new JPanel( new FlowLayout() );    
    calcPanel.setSize(200, 200);    
    
    soundPanel = new JPanel( new FlowLayout() );    
    soundPanel.setSize(200, 200);

    final DrawControlPanel drawPanel = new DrawControlPanel();
    drawPanel.setSize(200, 200);    
    
    this.setContentPane( mainPanel );
    
    JMenu fileMenu = new JMenu( "File" );
    fileMenu.setMnemonic( 'F' );
    JMenuItem aboutItem = new JMenuItem( "About..." );
    aboutItem.setMnemonic( 'A' );
    fileMenu.add( aboutItem );
    aboutItem.addActionListener(
      new ActionListener()  // Beginning of anonymous inner class
      {
        public void actionPerformed( ActionEvent event )
        {
        	mainPanel.removeAll();          
        	JOptionPane.showMessageDialog( ControlFrame.this,
                                      "This application provides enhanced\n control over multimedia projects.",
                                      "About", JOptionPane.PLAIN_MESSAGE );
        	// ***still shows remains of "Show Picture" image. Not clean
        }
     }  // End of anonymous inner class
    );
      
    final JMenuBar bar = new JMenuBar();  // Create a JMenuBar so we can attach menus to it.
    setJMenuBar( bar );  // Attach the JMenuBar to the ControlFrame.
    bar.add( fileMenu );  // Add the file menu to the JMenuBar.
  
    final JMenu colorMenu = new JMenu( "Color" );
    colorMenu.setMnemonic( 'C' );
    
    final JMenu imageMenu = new JMenu( "Image" );
    imageMenu.setMnemonic( 'I' );
    
    final JMenu soundMenu = new JMenu( "Sound" );
    soundMenu.setMnemonic( 'S' );
    

    
 
    
    JMenuItem redItem = new JMenuItem( "Red" );
    colorMenu.add( redItem );
    redItem.addActionListener(
      new ActionListener()  // Beginning of anonymous inner class
      {
        public void actionPerformed( ActionEvent event )
        {
          drawPanel.setFillColor( Color.RED );
          repaint();
        }
     }  // End of anonymous inner class
    );
    
    JMenuItem blueItem = new JMenuItem( "Blue" );
    colorMenu.add( blueItem );
    blueItem.addActionListener(
      new ActionListener()  // Beginning of anonymous inner class
      {
        public void actionPerformed( ActionEvent event )
        {
          drawPanel.setFillColor( Color.BLUE );
          repaint();
        }
     }  // End of anonymous inner class
    );
    
    JMenuItem magentaItem = new JMenuItem( "Magenta" );
    colorMenu.add( magentaItem );
    magentaItem.addActionListener(
      new ActionListener()  // Beginning of anonymous inner class
      {
        public void actionPerformed( ActionEvent event )
        {
          drawPanel.setFillColor( Color.MAGENTA );
          repaint();
        }
     }  // End of anonymous inner class
    );
    
    JMenuItem cyanItem = new JMenuItem( "Cyan" );
    colorMenu.add( cyanItem );
    cyanItem.addActionListener(
      new ActionListener()  // Beginning of anonymous inner class
      {
        public void actionPerformed( ActionEvent event )
        {
          drawPanel.setFillColor( Color.CYAN );
          repaint();
        }
     }  // End of anonymous inner class
    );
     
    JMenuItem calcPanelItem = new JMenuItem( "Calculate" );
    calcPanelItem.setMnemonic( 'C' );
    fileMenu.add( calcPanelItem );
    calcPanelItem.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          bar.remove( colorMenu );
          mainPanel.removeAll();
          mainPanel.remove( drawPanel );
          mainPanel.remove( imageMenu );
          mainPanel.remove( widthJSlider );
          xValTextField.setText("");
          yValTextField.setText("");
          calcJLabel.setText( "" );
          mainPanel.add( calcPanel, BorderLayout.CENTER );
          validate();
          repaint();
        }
      }
    );
    
    JMenuItem drawPanelItem = new JMenuItem( "DrawPanel" );
    drawPanelItem.setMnemonic( 'D' );
    fileMenu.add( drawPanelItem );
    drawPanelItem.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          bar.add( colorMenu );  
          bar.remove( imageMenu );
          mainPanel.removeAll();
          //mainPanel.remove( calcPanel );
          drawPanel.setBackground( Color.WHITE );
          mainPanel.add( drawPanel, BorderLayout.CENTER );
          mainPanel.add( widthJSlider, BorderLayout.SOUTH );          
          validate();
          repaint();
        }
      }
    );
    
    // Task 1: 
    JMenuItem showImage = new JMenuItem( "ShowImage..." );
    showImage.setMnemonic( 'I' );
    fileMenu.add( showImage );
    showImage.addActionListener(
      new ActionListener()  // Beginning of anonymous inner class
      {
        public void actionPerformed( ActionEvent event )
        {
            mainPanel.remove( drawPanel );
            mainPanel.remove( widthJSlider );
            bar.remove( colorMenu ); 
            bar.remove( soundMenu ); 
        	mainPanel.removeAll();
        	bar.add( imageMenu );
        	
        	String sname = "/Users/Shared/Java-Libraries/CourseCD/mediasources/arch.jpg";
            

        	ImageIcon imgIcon = new ImageIcon(sname);
        	Image imageFile = imgIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        	JLabel picLabel = new JLabel(new ImageIcon(imageFile));


        	mainPanel.add(picLabel, BorderLayout.CENTER);
        	mainPanel.revalidate(); //ADD THIS AS WELL
            mainPanel.repaint();  //ADD THIS AS WELL
        	
			


        }
     }  // End of anonymous inner class
     );
    
    JMenuItem filterItemOne = new JMenuItem( "Filter One" );
    filterItemOne.setMnemonic( 'O' );
    imageMenu.add(filterItemOne);
    filterItemOne.addActionListener(
  	  new ActionListener()  // Beginning of anonymous inner class
  	  {
  	        public void actionPerformed( ActionEvent event )
  	        {

  	        	mainPanel.remove( showImage );
  	        	mainPanel.removeAll();
  	        	String sname = "/Users/Shared/Java-Libraries/CourseCD/mediasources/arch.jpg";


  	        	DrawImageControlPanel filteredPic = new DrawImageControlPanel(sname);
  	        	//filteredPic.clearBlue();
  	        	filteredPic.mirrorVertical();
  	        	BufferedImage buff = filteredPic.getBufferedImage();
  	        	
  	        	ImageIcon imgIcon = new ImageIcon(buff);
  	        	Image imageFile = imgIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
  	        	JLabel picLabel = new JLabel(new ImageIcon(imageFile));

  	        	mainPanel.add(picLabel, BorderLayout.CENTER);
  	        	mainPanel.revalidate(); //ADD THIS AS WELL
                mainPanel.repaint();  //ADD THIS AS WELL


  	        }
  	     }  // End of anonymous inner class
  	     );
    
    JMenuItem filterItemTwo = new JMenuItem( "Filter Two" );
    filterItemTwo.setMnemonic( 'T' );	// *** shows first t, want second
    imageMenu.add(filterItemTwo);   
    filterItemTwo.addActionListener(
    	  new ActionListener()  // Beginning of anonymous inner class
    	  {
    	        public void actionPerformed( ActionEvent event )
    	        {

    	        	mainPanel.remove( showImage );
    	        	mainPanel.removeAll();
    	        	String sname = "/Users/Shared/Java-Libraries/CourseCD/mediasources/arch.jpg";


    	        	DrawImageControlPanel filteredPic = new DrawImageControlPanel(sname);
    	        	filteredPic.clearBlue();
    	        	//filteredPic.mirrorVertical();
    	        	BufferedImage buff = filteredPic.getBufferedImage();
    	        	
    	        	ImageIcon imgIcon = new ImageIcon(buff);
    	        	Image imageFile = imgIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
    	        	JLabel picLabel = new JLabel(new ImageIcon(imageFile));

    	        	mainPanel.add(picLabel, BorderLayout.CENTER);
    	        	mainPanel.revalidate(); //ADD THIS AS WELL
    	        	mainPanel.repaint();  //ADD THIS AS WELL


    	        }
    	   }  // End of anonymous inner class
    	   );
    
    
    // Task 1: 
    JMenuItem soundImage = new JMenuItem( "ShowSound..." );
    soundImage.setMnemonic( 'I' );
    fileMenu.add( soundImage );
    soundImage.addActionListener(
      new ActionListener()  // Beginning of anonymous inner class
      {
        public void actionPerformed( ActionEvent event )
        {
        	bar.remove( imageMenu );
        	mainPanel.remove( drawPanel );
            mainPanel.remove( widthJSlider );
            bar.remove( colorMenu ); 
        	mainPanel.removeAll();
        	bar.add( soundMenu );
        	mainPanel.add( soundPanel, BorderLayout.CENTER );
        	//mainPanel.removeAll();
        	// http://www.developer.com/java/other/article.php/2173111/Java-Sound-Playing-Back-Audio-Files-using-Java.htm
        	
        	String soundFile = "/Users/Shared/Java-Libraries/CourseCD/mediasources/thisisatest.wav";
        	DrawSoundControlPanel newSound = new DrawSoundControlPanel(soundFile);
        	//newSound.explore();
        	//newSound.doubleFreq();
        	//newSound.mirror();
        	//newSound.echo(10);
        	newSound.reverse();
        	//newSound.play();
        	//mainPanel.add(picLabel, BorderLayout.CENTER);
        	mainPanel.revalidate(); //ADD THIS AS WELL
        	mainPanel.repaint();  //ADD THIS AS WELL
        	
        	/*
        	String sname = "/Users/Shared/Java-Libraries/CourseCD/mediasources/arch.jpg";
            

        	ImageIcon imgIcon = new ImageIcon(sname);
        	Image imageFile = imgIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        	JLabel picLabel = new JLabel(new ImageIcon(imageFile));


        	mainPanel.add(picLabel, BorderLayout.CENTER);
        	mainPanel.revalidate(); //ADD THIS AS WELL
            mainPanel.repaint();  //ADD THIS AS WELL
        	*/
			


        }
     }  // End of anonymous inner class
     );
    
    
    
    
    JMenuItem exitItem = new JMenuItem( "Exit" );
    exitItem.setMnemonic( 'x' );
    fileMenu.add( exitItem );
    exitItem.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          System.exit( 0 );
        }
      }
    );
    
    widthJSlider = new JSlider( SwingConstants.HORIZONTAL, 0, 100, drawPanel.getOvalWidth() );
    widthJSlider.setMajorTickSpacing( 10 );
    widthJSlider.setPaintTicks( true );
    
    widthJSlider.addChangeListener(
      new ChangeListener()
      {
        public void stateChanged( ChangeEvent e )
        {
          drawPanel.setOvalWidth( widthJSlider.getValue() );
          repaint();
        }
      }
    );
        
    xValTextField = new JTextField( 3 );
    xValTextField.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          xStr = event.getActionCommand();
        }
      }
    );                                                                       

    calcPanel.add( xValTextField );

    yValTextField = new JTextField( 3 );
    yValTextField.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          yStr = event.getActionCommand();
        }
      }
    );     

    calcPanel.add( yValTextField );
    ///////////////////////
    soundJButton = new JButton( "PlaySound0" );   
    soundJButton.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
        	
        	bar.remove( imageMenu );
        	mainPanel.remove( drawPanel );
            mainPanel.remove( widthJSlider );
            bar.remove( colorMenu ); 
        	mainPanel.removeAll();
        	bar.add( soundMenu );
        	mainPanel.add( soundPanel, BorderLayout.CENTER );
        	//mainPanel.removeAll();
        	// http://www.developer.com/java/other/article.php/2173111/Java-Sound-Playing-Back-Audio-Files-using-Java.htm
        	
        	String soundFile = "/Users/Shared/Java-Libraries/CourseCD/mediasources/thisisatest.wav";
        	DrawSoundControlPanel newSound = new DrawSoundControlPanel(soundFile);
        	//newSound.explore();
        	//newSound.doubleFreq();
        	//newSound.mirror();
        	//newSound.echo(10);
        	//newSound.reverse();
        	newSound.play();
        	//mainPanel.add(picLabel, BorderLayout.CENTER);
        	mainPanel.revalidate(); //ADD THIS AS WELL
        	mainPanel.repaint();  //ADD THIS AS WELL
        	
        	
        	
        	/*
          try {       
            int x = Integer.parseInt( xStr );
            int y = Integer.parseInt( yStr );
            int result = x + y;
            calcJLabel.setText(xStr + " + " + yStr + " = " + result);
          }
          catch (NumberFormatException e) {
            JOptionPane.showMessageDialog( ControlFrame.this, "You must enter a valid number and then <ENTER> for each textbox!", "Invalid Input", JOptionPane.ERROR_MESSAGE );
            e.printStackTrace();
          }
          */
        }
      }
    );
    soundPanel.add( soundJButton );
    
    soundJButton1 = new JButton( "PlaySound1" );   
    soundJButton1.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
        	
        	bar.remove( imageMenu );
        	mainPanel.remove( drawPanel );
            mainPanel.remove( widthJSlider );
            bar.remove( colorMenu ); 
        	mainPanel.removeAll();
        	bar.add( soundMenu );
        	mainPanel.add( soundPanel, BorderLayout.CENTER );
        	//mainPanel.removeAll();
        	// http://www.developer.com/java/other/article.php/2173111/Java-Sound-Playing-Back-Audio-Files-using-Java.htm
        	
        	String soundFile = "/Users/Shared/Java-Libraries/CourseCD/mediasources/thisisatest.wav";
        	DrawSoundControlPanel newSound = new DrawSoundControlPanel(soundFile);
        	//newSound.explore();
        	//newSound.doubleFreq();
        	newSound.mirror();
        	//newSound.echo(10);
        	//newSound.reverse();
        	newSound.play();
        	//mainPanel.add(picLabel, BorderLayout.CENTER);
        	mainPanel.revalidate(); //ADD THIS AS WELL
        	mainPanel.repaint();  //ADD THIS AS WELL
        	
        	/*
          try {       
            int x = Integer.parseInt( xStr );
            int y = Integer.parseInt( yStr );
            int result = x + y;
            calcJLabel.setText(xStr + " + " + yStr + " = " + result);
          }
          catch (NumberFormatException e) {
            JOptionPane.showMessageDialog( ControlFrame.this, "You must enter a valid number and then <ENTER> for each textbox!", "Invalid Input", JOptionPane.ERROR_MESSAGE );
            e.printStackTrace();
            
          }
          */
        }
      }
    );
    soundPanel.add( soundJButton1 );
    
    soundJButton2 = new JButton( "PlaySound2" );   
    soundJButton2.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
        	
        	bar.remove( imageMenu );
        	mainPanel.remove( drawPanel );
            mainPanel.remove( widthJSlider );
            bar.remove( colorMenu ); 
        	mainPanel.removeAll();
        	bar.add( soundMenu );
        	mainPanel.add( soundPanel, BorderLayout.CENTER );
        	//mainPanel.removeAll();
        	// http://www.developer.com/java/other/article.php/2173111/Java-Sound-Playing-Back-Audio-Files-using-Java.htm
        	
        	String soundFile = "/Users/Shared/Java-Libraries/CourseCD/mediasources/thisisatest.wav";
        	DrawSoundControlPanel newSound = new DrawSoundControlPanel(soundFile);
        	//newSound.explore();
        	newSound.doubleFreq();
        	//newSound.mirror();
        	//newSound.echo(10);
        	//wSound.reverse();
        	newSound.play();
        	//mainPanel.add(picLabel, BorderLayout.CENTER);
        	mainPanel.revalidate(); //ADD THIS AS WELL
        	mainPanel.repaint();  //ADD THIS AS WELL
        	
        	
        	/*
          try {       
            int x = Integer.parseInt( xStr );
            int y = Integer.parseInt( yStr );
            int result = x + y;
            calcJLabel.setText(xStr + " + " + yStr + " = " + result);
          }
          catch (NumberFormatException e) {
            JOptionPane.showMessageDialog( ControlFrame.this, "You must enter a valid number and then <ENTER> for each textbox!", "Invalid Input", JOptionPane.ERROR_MESSAGE );
            e.printStackTrace();
            
          }
          */
        }
      }
    );
    soundPanel.add( soundJButton2 );
    
    soundJLabel = new JLabel();
    soundPanel.add( soundJLabel, BorderLayout.CENTER );
    
    soundJButton3 = new JButton( "PlaySound3" );   
    soundJButton3.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
        	bar.remove( imageMenu );
        	mainPanel.remove( drawPanel );
            mainPanel.remove( widthJSlider );
            bar.remove( colorMenu ); 
        	mainPanel.removeAll();
        	bar.add( soundMenu );
        	mainPanel.add( soundPanel, BorderLayout.CENTER );
        	//mainPanel.removeAll();
        	// http://www.developer.com/java/other/article.php/2173111/Java-Sound-Playing-Back-Audio-Files-using-Java.htm
        	
        	String soundFile = "/Users/Shared/Java-Libraries/CourseCD/mediasources/thisisatest.wav";
        	DrawSoundControlPanel newSound = new DrawSoundControlPanel(soundFile);
        	//newSound.explore();
        	//newSound.doubleFreq();
        	//newSound.mirror();
        	//newSound.echo(10);
        	newSound.reverse();
        	newSound.play();
        	//mainPanel.add(picLabel, BorderLayout.CENTER);
        	mainPanel.revalidate(); //ADD THIS AS WELL
        	mainPanel.repaint();  //ADD THIS AS WELL
        	
        	/*
          try {       
            int x = Integer.parseInt( xStr );
            int y = Integer.parseInt( yStr );
            int result = x + y;
            calcJLabel.setText(xStr + " + " + yStr + " = " + result);
          }
          catch (NumberFormatException e) {
            JOptionPane.showMessageDialog( ControlFrame.this, "You must enter a valid number and then <ENTER> for each textbox!", "Invalid Input", JOptionPane.ERROR_MESSAGE );
            e.printStackTrace();
            
          }
          */
        }
      }
    );
    soundPanel.add( soundJButton3 );
    
    soundJLabel = new JLabel();
    soundPanel.add( soundJLabel, BorderLayout.CENTER );    
    
    
    ///////////////////
    calcJButton = new JButton( "Calculate" );   
    calcJButton.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          try {       
            int x = Integer.parseInt( xStr );
            int y = Integer.parseInt( yStr );
            int result = x + y;
            calcJLabel.setText(xStr + " + " + yStr + " = " + result);
          }
          catch (NumberFormatException e) {
            JOptionPane.showMessageDialog( ControlFrame.this, "You must enter a valid number and then <ENTER> for each textbox!", "Invalid Input", JOptionPane.ERROR_MESSAGE );
            e.printStackTrace();
          }
        }
      }
    );
    calcPanel.add( calcJButton );
    
    calcJLabel = new JLabel();
    calcPanel.add( calcJLabel, BorderLayout.CENTER );
    
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    setSize( 200, 250 );
    setVisible( true );
    validate();
  }
}  