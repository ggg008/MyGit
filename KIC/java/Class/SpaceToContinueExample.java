import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ij.IJ;
import ij.ImageJ;
import ij.ImagePlus;

public class SpaceToContinueExample implements KeyListener {

	final ImageJ ij;
	ImagePlus ip;
	
	public SpaceToContinueExample(  )
	{
		ij = IJ.getInstance();
		System.out.println( "ij: " + ij );
	}
	
	public SpaceToContinueExample( ImagePlus ip )
	{	
		this();
		this.ip = ip;
		ip.show();
		ip.getCanvas().addKeyListener(this);
	}
	
	public void processBefore()
	{
		ip = IJ.getImage();
		IJ.run("Gaussian Blur...", "sigma=2");
		IJ.getImage().show();
	}
	
	public void processAfter()
	{
		System.out.println("process after");	
		IJ.run("Measure");
		
		// remove this key listener to be safe
		ip.getCanvas().removeKeyListener(this);
	}
	
	public void run()
	{
		processBefore();
		// process After is called on keypress
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) { }

	@Override
	public void keyReleased(KeyEvent e) {
		if ( e.getKeyCode() == KeyEvent.VK_SPACE )
		{
			processAfter();
		}
	}
	
	public static void main(String[] args) {
		ImageJ ij = new ImageJ();
		IJ.run("Boats (356K)");
		SpaceToContinueExample obj = new SpaceToContinueExample( IJ.getImage() );
		obj.run();
	}
}
