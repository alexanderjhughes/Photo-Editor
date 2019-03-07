import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class PhotoApp {

	private static JMenuBar menuBar;
	private static JMenu fileMenu, filterMenu;
	private static JMenuItem  menuLoad, menuSave, menuBlues, menuBright,
	menuDarken, menuBaW, menuSepia, menuNegative,menuSketch,menuCustom;
	private static JLabel label; 
	private static JFrame frame; 
	private static LoadAction action;
	

	//Constructor
	public PhotoApp() {
		
	}

	public static void main(String[] args) 
	{
		createFrame();
		new PhotoApp();
		
		//Waiting for Click
		action = new LoadAction();
		menuDarken.addActionListener(action);
		menuBaW.addActionListener(action);
		menuBlues.addActionListener(action);
		menuSepia.addActionListener(action);
		menuSketch.addActionListener(action);
		menuLoad.addActionListener(action);	
		menuSave.addActionListener(action);
		menuNegative.addActionListener(action);
		menuBright.addActionListener(action);
		menuCustom.addActionListener(action);
	}
	
	/**
	 * @param image
	 * Adds the selected Image to the JFrame
	 */
	public static void addImage(Filters filter)
	{
		if(label!=null)
		{
		frame.remove(label);
		}
		
		scale(filter);
		label= new JLabel(filter.getIcon());
		frame.add(label);
		frame.setVisible(true);
	}
	
	/**
	 * @param image
	 * Checks if the image is too big and if it is scales it
	 */
	public static void scale(Filters filter)
	{
		int picWidth = filter.getIcon().getIconWidth();
		int picHeight = filter.getIcon().getIconHeight();
		int frameWidth = frame.getWidth();
		int frameHeight = frame.getHeight();
		Image img = filter.getIcon().getImage().getScaledInstance(picWidth, picHeight, Image.SCALE_DEFAULT);
	    filter.getIcon().setImage(img);
		 
	}

	public static void createFrame() {
		frame = new JFrame(); 
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//MENU ITEMS
		menuBar = new JMenuBar(); 
		
		fileMenu = new JMenu("File");
		filterMenu = new JMenu("Filters");
		
		menuBar.add(fileMenu);
		menuBar.add(filterMenu);
		
		//Creating and naming Menu Items
		menuLoad = new JMenuItem("Open...");
		menuSave = new JMenuItem("Save As...");
		
		menuBlues = new JMenuItem("Blues");
		menuBright = new JMenuItem("Brighter");
		menuDarken = new JMenuItem("Darken");
		menuBaW = new JMenuItem("Black and White");
		menuSepia = new JMenuItem("Sepia");
		menuNegative = new JMenuItem("Negative");
		menuSketch = new JMenuItem("Sketch");
		menuCustom = new JMenuItem("Custom");
		//Adding shortcuts
		menuSave.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		menuLoad.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		
		//Add Menu Items to correct Menu
		fileMenu.add(menuLoad);
		fileMenu.add(menuSave);
		filterMenu.add(menuBlues);
		filterMenu.add(menuBright);
		filterMenu.add(menuDarken);
		filterMenu.add(menuBaW);
		filterMenu.add(menuSepia);
		filterMenu.add(menuSketch);
		filterMenu.add(menuNegative);
		filterMenu.add(menuCustom);
		frame.setJMenuBar(menuBar);
		
		frame.setVisible(true);
	}




	



}
