package git_aptra;

import java.awt.Color;
import java.awt.EventQueue;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Loading extends JPanel
{
    private JPanel loadingPanel() throws MalformedURLException
    {
        JPanel panel = new JPanel();
        BoxLayout layoutMgr = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
        panel.setLayout(layoutMgr);

        ImageIcon imageIcon = new ImageIcon("C:/Users/Fabi/git/aptra/SAP_APTRA/src/loading.gif");
        JLabel iconLabel = new JLabel();
        iconLabel.setIcon(imageIcon);
        imageIcon.setImageObserver(iconLabel);

       
        panel.add(iconLabel);
       
        panel.setOpaque(false);
        return panel;
    }

    public static void start() throws MalformedURLException
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JDialog f = new JDialog(Oberflaeche.frame);
                f.setLocationRelativeTo(null);
                f.setUndecorated(true);

                //AWTUtilities.setWindowOpacity(f, 0.6f);
                //f.setOpacity(0.4f);

                Loading imagePanel = new Loading();
                JPanel jp = null;
                try
                {
                    jp = imagePanel.loadingPanel();
                }
                catch (MalformedURLException ex)
                {
                    Logger.getLogger(Loading.class.getName()).log(Level.SEVERE, null, ex);
                }

                f.setContentPane(jp);
                f.setBackground(new Color(0, 0, 0, 0)); //<-- THIS CAUSES FLICKERING
                f.pack();
                f.setVisible(true);
            }
        });
    }
}