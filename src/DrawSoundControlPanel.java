import java.io.*;


public class DrawSoundControlPanel extends Sound
{
	
	
	 /////////////// constructors ////////////////////////////////////
	/**
	   * Constructor that takes a file name
	   * @param fileName the name of the file to read the sound from
	   */
	  public DrawSoundControlPanel(String fileName)
	  {
	    // let the parent class handle setting the file name
	    super(fileName);
	  }
	  
	  /**
	   * Constructor that takes the number of samples in
	   * the sound
	   * @param numSamples the number of samples desired
	   */
	  public DrawSoundControlPanel (int numSamples)
	  {
	    // let the parent class handle this
	    super(numSamples);
	  }
	  
	  /**
	   * Constructor that takes the number of samples that this
	   * sound will have and the sample rate
	   * @param numSamples the number of samples desired
	   * @param sampleRate the number of samples per second
	   */
	  public DrawSoundControlPanel (int numSamples, int sampleRate)
	  {
	    // let the parent class handle this
	    super(numSamples,sampleRate);
	  }
	  
	  /**
	   * Constructor that takes a sound to copy
	   */
	  public DrawSoundControlPanel (Sound copySound)
	  {
	    // let the parent class handle this
	    super(copySound);
	  }
	  ///////////////////methods/////////////////////// Week 4/5 Notes/////////
	  
		public void echo(int delay)
		{
			// make a copy of the original sound
			Sound s = new Sound(this.getFileName());
			int value = 0;
			
			// loop from delay to end of sound
			for ( int i = delay; i < this.getLength(); i++)
			{
				// get the value back by delay samples from the copy of the sound and make it fainter
				value = (int)(s.getSampleValueAt(i - delay) * 0.6);
				
				// set the value at the current index to the sum of the current value and the echo
				this.setSampleValueAt(i, this.getSampleValueAt(i) + value);
			}
		}
		
		
		public void doubleFreq()
		{
			// make a copy of the original sound
			Sound s = new Sound(this.getFileName());
			
			// loop through the sound and increment target index by one but source index by 2 and set target value to the copy of the original sound
			for ( int sourceIndex = 0, targetIndex = 0; sourceIndex < this.getLength(); sourceIndex = sourceIndex + 2, targetIndex++)
			{
				this.setSampleValueAt(targetIndex,  s.getSampleValueAt(sourceIndex));
			}
			
			// clear out the rest of the sound
			for (int i = this.getLength() / 2; i < this.getLength(); i++)
			{
				this.setSampleValueAt(i, 0);
			}
					
		}
		
		
		public void mirror()
		{
			int length = this.getLength(); 		// save the length
			int mirrorPoint = length / 2;		// mirror around this point
			int value = 0;						// hold the current value
			
			// loop from 0 to mirrorPoint
			for ( int i = 0; i < mirrorPoint; i++)
			{
				value = this.getSampleValueAt(i);
				this.setSampleValueAt(length - 1 - i, value);
			}
		}
		
		public void reverse()
		{
			Sound orig = new Sound(this.getFileName());
			int length = this.getLength();
			
			// loop through the samples
			for (int targetIndex = 0, sourceIndex = length - 1; targetIndex < length && sourceIndex > 0;
					targetIndex++, sourceIndex--)
			{
				this.setSampleValueAt(targetIndex, orig.getSampleValueAt(sourceIndex));
			}
		}
}