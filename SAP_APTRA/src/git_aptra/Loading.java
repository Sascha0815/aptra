package git_aptra;

import java.awt.Color;
import java.awt.EventQueue;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Loading extends JPanel implements Runnable{
	public static JDialog dialogLoading = new JDialog(Oberflaeche.frame);
	static boolean first = true;
	public void run() {
		try {
			start();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void start() throws MalformedURLException
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                if (first == true) {
                	first = false;
                	dialogLoading.setLocationRelativeTo(Oberflaeche.frame);
                	dialogLoading.setUndecorated(true);
                    

                    Loading imagePanel = new Loading();
                    JPanel jp = null;
                    
                    try
                    {
                        jp = imagePanel.loadingPanel();
                        Oberflaeche.frame.add(imagePanel);
                        
                    }
                    catch (MalformedURLException ex)
                    {
                        Logger.getLogger(Loading.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    dialogLoading.add(jp);
                    dialogLoading.setBackground(new Color(0, 0, 0, 0)); 
                    dialogLoading.pack();                   	
				}
                	dialogLoading.setVisible(true);	
                
                	dialogLoading.setLocationRelativeTo(Oberflaeche.frame);
                
            }
        });
    }
	
    private JPanel loadingPanel() throws MalformedURLException
    {
        JPanel panel = new JPanel();
        BoxLayout layoutMgr = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
        panel.setLayout(layoutMgr);
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("resources/loading.gif"));
        JLabel iconLabel = new JLabel();
        iconLabel.setIcon(imageIcon);
        imageIcon.setImageObserver(iconLabel);

       
        panel.add(iconLabel);
       
        panel.setOpaque(false);
        return panel;
    }

    


}