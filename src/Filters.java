import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Filters {

	private ImageIcon img;
	private BufferedImage image;
	private String path;

	public Filters(String path) {
		this.path = path;
		img = new ImageIcon(path);
		image = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.drawImage(img.getImage(), 0, 0, null);

	}

	public ImageIcon getIcon() {
		return img;
	}

	public void blues() {
		System.out.println("blues");
		for (int x = 0; x < image.getWidth(); x++)
		{
			for (int y = 0; y < image.getHeight(); y++)
			{
				Color color = new Color(image.getRGB(x, y)); // Grabs the color of the pixel at x,y
				color = new Color(0, 0, 0);
				image.setRGB(x, y, color.getRGB()); // sets x,y to new color
			}
		}
		img = new ImageIcon(image); // makes image equal to the new edited version
	}

	public void darken()
	{
		System.out.println("Darken");
	}

	public void brighter()
	{
		System.out.println("Bright");

	}

	public void blackAndWhite()
	{
		System.out.println("Black and White");
	}

	public void sepia()
	{
		System.out.println("Sepia Tone");
	}

	public void sketch() 
	{
		System.out.println("Sketch");
	}

	public void negative()
	{
		System.out.println("Negative");
	}

	public void custom()
	{
		System.out.println("Custom");
	}

}
