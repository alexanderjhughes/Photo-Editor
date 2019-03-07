import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LoadAction extends PhotoApp implements ActionListener {

	private Filters image; 

	@Override
	public void actionPerformed(ActionEvent e) 
	{

		if(e.getActionCommand().equals("Open...")) //If they Clicked Load Picture
		{
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"JPG, GIF, And PNG Images", "jpg", "gif", "png","jpeg");
			chooser.setFileFilter(filter);
			chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
			int returnVal = chooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) 
			{
				image  = new Filters(chooser.getSelectedFile().getAbsolutePath());
				addImage(image);
			}
		}
		else if(e.getActionCommand().equals("Save As..."))//If they Clicked Save Image
		{
			JFileChooser chooser = new JFileChooser();
			//creates image size and color setting
			BufferedImage bi = new BufferedImage(
					image.getIcon().getIconWidth(),image.getIcon().getIconHeight(),BufferedImage.TYPE_INT_RGB);
			Graphics g = bi.getGraphics();
			//adds the image icon to the buffered image
			g.drawImage(image.getIcon().getImage(), 0,0, null);
			//opens save dialog with correct filter
			FileNameExtensionFilter jpgFilter = new FileNameExtensionFilter(
					"JPG Image", "jpg");
			FileNameExtensionFilter gifFilter = new FileNameExtensionFilter(
					"GIF Image", "gif");
			FileNameExtensionFilter pngFilter = new FileNameExtensionFilter(
					"PNG Image", "png");
			chooser.setFileFilter(jpgFilter);
			chooser.addChoosableFileFilter(gifFilter);
			chooser.addChoosableFileFilter(pngFilter);
			chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
			int returnVal = chooser.showSaveDialog(chooser);
			if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				try {
					//saves image to specified location
					File outputfile = new File(
							chooser.getSelectedFile().getPath()+"."+chooser.getFileFilter().getDescription().substring(0,3).toLowerCase());
					ImageIO.write(bi, "jpg", outputfile);

				} catch (Exception e1) {
					System.out.println("No Image Loaded");
				}
			}
		}
		else //Check what Filter they Pressed
		{
			try
			{

				if(e.getActionCommand().equals("Blues"))
				{
					image.blues();				
				}
				
				if(e.getActionCommand().equals("Darken"))
				{
					image.darken();					
				}
				if(e.getActionCommand().equals("Brighter"))
				{
					image.brighter();
				}
				if(e.getActionCommand().equals("Black and White"))
				{
					image.blackAndWhite();
				}
				
				if(e.getActionCommand().equals("Sepia"))
				{
					image.sepia();				
				}
				if(e.getActionCommand().equals("Negative"))
				{
					image.negative();
				}
				if(e.getActionCommand().equals("Sketch"))
				{
					image.sketch();					
				}
				
				if(e.getActionCommand().equals("Custom"))
				{
					image.custom();
				}
		
				addImage(image);

			}catch(Exception exception)
			{
				System.out.println("No Image Selected"); //Runs if no Image is found
			}
		}

	}


}

