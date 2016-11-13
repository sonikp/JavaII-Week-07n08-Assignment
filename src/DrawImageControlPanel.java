import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * Image methods for DrawControlApp. Assignment week 07
 * @author sonikp
 *
 */

public class DrawImageControlPanel extends Picture
{
		
	// constructors
	public DrawImageControlPanel() 
	{
		super();
	}
	
	public DrawImageControlPanel(String fileName)
	{
	    // let the parent class handle this fileName
	    super(fileName);
	}
	
	public DrawImageControlPanel(int width, int height)
	{
	    // let the parent class handle this width and height
	    super(width,height);
	}
	
	 public DrawImageControlPanel(Picture copyPicture)
	  {
	    // let the parent class do the copy
	    super(copyPicture);
	  }
	  
	  public DrawImageControlPanel(BufferedImage image)
	  {
	    super(image);
	  }
	  
	  // methods
	  
	  public void clearBlue()
	  {
		  Pixel[] pixelArray = this.getPixels();
			  
		  for ( Pixel value : pixelArray)
		  {
			  value.setBlue(0);
		  }
	  }
	  
	  public void mirrorVertical()
	  {
		  int width = this.getWidth();
		  int mirrorPoint = width / 2;
		  Pixel leftPixel = null;
		  Pixel rightPixel = null;
		  
		  // loop through all the rows
		  for (int y = 0; y < getHeight(); y++)
		  {
			  // loop through all the columns
			  for (int x = 0; x < mirrorPoint; x++)
			  {
				  leftPixel = getPixel(x,y);
				  rightPixel = getPixel(width - 1 - x, y);
				  rightPixel.setColor(leftPixel.getColor());
			  }
			  
			  
		  }
	  }

	  
	  public void edgeDetection(int amount)
	  {
		  Pixel topPixel = null;
		  Pixel bottomPixel = null;
		  double topAverage = 0.0;
		  double bottomAverage = 0.0;
		  int endY = this.getHeight() - 1;
		  
		  // loop through y values from 0 to height - 1, (since compare to below pixel)
		  for ( int y = 0; y < endY; y++)
		  {
			  // loop through the x values from 0 to width
			  for ( int x = 0; x < this.getWidth(); x++)
			  {
				  // get the top and bottom pixels
				  topPixel = this.getPixel(x, y);
				  bottomPixel = this.getPixel(x, y + 1);
				  
				  // get the color average for the two pixels
				  topAverage = topPixel.getAverage();
				  bottomAverage = bottomPixel.getAverage();
				  
				  // check if absolute value of the difference is less than the amount
				  if ( Math.abs(topAverage - bottomAverage) < amount)
				  {
					  topPixel.setColor(Color.WHITE);
				  }
				  else
				  {
					  topPixel.setColor(Color.BLACK);
				  }
			  }
		  }
	  }

	  
	  
	  
	  /**
	   * Method to return a string with information about this picture.
	   * @return a string with information about the picture such as fileName,
	   * height and width.
	   */
	  public String toString()
	  {
	    String output = "Picture, filename " + getFileName() + 
	      " height " + getHeight() 
	      + " width " + getWidth();
	    return output;
	    
	  }
	
}