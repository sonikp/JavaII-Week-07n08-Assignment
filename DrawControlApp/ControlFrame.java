// ControlFrame.java
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class ControlFrame extends JFrame
{ 
  private JPanel mainPanel;
  private final JPanel calcPanel;
  private JSlider widthJSlider;
  private JTextField xValTextField;
  private JTextField yValTextField;
  private JLabel calcJLabel;
  private JButton calcJButton;
  
  private String xStr;
  private String yStr;
  
  public ControlFrame(String title)
  {
    super( title );
    mainPanel = new JPanel( new BorderLayout() );
    mainPanel.setSize(200, 250);    
    
    calcPanel = new JPanel( new FlowLayout() );    
    calcPanel.setSize(200, 200);    

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
          JOptionPane.showMessageDialog( ControlFrame.this,
                                      "This application provides enhanced\n control over multimedia projects.",
                                      "About", JOptionPane.PLAIN_MESSAGE );
        }
     }  // End of anonymous inner class
    );
      
    final JMenuBar bar = new JMenuBar();  // Create a JMenuBar so we can attach menus to it.
    setJMenuBar( bar );  // Attach the JMenuBar to the ControlFrame.
    bar.add( fileMenu );  // Add the file menu to the JMenuBar.
  
    final JMenu colorMenu = new JMenu( "Color" );
    colorMenu.setMnemonic( 'C' );
    
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
          mainPanel.remove( drawPanel );
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
          mainPanel.remove( calcPanel );
          drawPanel.setBackground( Color.WHITE );
          mainPanel.add( drawPanel, BorderLayout.CENTER );
          mainPanel.add( widthJSlider, BorderLayout.SOUTH );          
          validate();
          repaint();
        }
      }
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