package git_aptra;

import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager;


public class Design {
	public static void standardLook() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		SwingUtilities.updateComponentTreeUI(Oberflaeche.frame);
	}
	
	public static void acrylLook() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		SwingUtilities.updateComponentTreeUI(Oberflaeche.frame);
	}
	
	public static void aeroLook() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
		SwingUtilities.updateComponentTreeUI(Oberflaeche.frame);
	}
	
	public static void aluminiumLook() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		SwingUtilities.updateComponentTreeUI(Oberflaeche.frame);
	}
	
	public static void bernsteinLook() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
		SwingUtilities.updateComponentTreeUI(Oberflaeche.frame);
	}
	
	public static void fastLook() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		SwingUtilities.updateComponentTreeUI(Oberflaeche.frame);
	}
	
	public static void graphiteLook() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		SwingUtilities.updateComponentTreeUI(Oberflaeche.frame);
	}
	
	public static void hifiLook() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		SwingUtilities.updateComponentTreeUI(Oberflaeche.frame);
	}
	
	public static void lunaLook() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
		SwingUtilities.updateComponentTreeUI(Oberflaeche.frame);
	}
	
	public static void McWinLook() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		SwingUtilities.updateComponentTreeUI(Oberflaeche.frame);
	}
	
	public static void mintLook() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		SwingUtilities.updateComponentTreeUI(Oberflaeche.frame);
	}
	
	public static void noireLook() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
		SwingUtilities.updateComponentTreeUI(Oberflaeche.frame);
	}
	
	public static void smartLook() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
		SwingUtilities.updateComponentTreeUI(Oberflaeche.frame);
	}
	
	public static void textureLook() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
		SwingUtilities.updateComponentTreeUI(Oberflaeche.frame);
	}
}
