package git_aptra;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Loading {
  private final static MouseAdapter mouseAdapter = 
    new MouseAdapter() {};

  
  public static void startWaitCursor(JComponent component) { 
    RootPaneContainer root =
      ((RootPaneContainer) component.getTopLevelAncestor()); 
    root.getGlassPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    root.getGlassPane().addMouseListener(mouseAdapter);
    root.getGlassPane().setVisible(true);
  }

  public static void stopWaitCursor(JComponent component) { 
    RootPaneContainer root =
      ((RootPaneContainer) component.getTopLevelAncestor()); 
    root.getGlassPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    root.getGlassPane().removeMouseListener(mouseAdapter);
    root.getGlassPane().setVisible(false);
  }
}