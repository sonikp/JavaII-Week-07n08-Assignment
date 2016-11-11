import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

// imported from Assignment 04

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
			  //System.out.println(value.getRed() + " " + value.getGreen() + " " + value.getBlue());
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