import javax.swing.*;
import java.awt.event.*;
/**
 * The JFrameTest class creates the application window, 
 * menu bar, File menu and the Quit File menu ite. It then adds
 * the menu item to the File menu and the File menu to the
 * menubar. It also ensures that the window will close if the user 
 * clicks the 'x' button.
 *   
 * 
 * @author J Dyke 
 * @version 1 01.28.15
 */ 
public class JFrameTest extends JFrame implements ActionListener {
  /**
   * The class constructor passes a String title when it creates
   * the superclass object. It then creates the application window,
   * menu bar, two menus, one labelled "File", one labelled "Help,
   * two menu items, one labelled "Quit", one labelled "Help".
   * It then adds the "Quit" menu item to the "File" menu, the "Help"
   * item to the "Help menu, and both menus to the menu bar.
   * It sets the size of the Frame to 400x400, and
   * ensures it will be visible.  It also ensures that the
   * window will close if the user clicks the 'x' button.
   * <p>
   * <b>Local variables: </b>
   * <p>
   * <b>quitItem </b> This creates an instance of the JMenuItem class called "Quit".
   * <p>
   * <b>fileMenu </b> This creates an instance of the JMenu class called "File".
   * <p>
   * <b>helpItem </b> This creates an instance of the JMenuItem class called "Help".
   * <p>
   * <b>helpMenu </b> This creates an instance of the JMenu class called "Help".
   * <p>
   * <b>myMenus </b> This creates an instance of the JMenuBar class.
   */
  public JFrameTest() {
    super ("JFrame Test");

    JMenuItem quitItem = new JMenuItem ("Quit");
    JMenu fileMenu = new JMenu("File");
    fileMenu.add (quitItem);

    JMenuItem helpItem = new JMenuItem("Help");
    JMenu helpMenu = new JMenu("Help");
    helpMenu.add(helpItem);

    JMenuBar myMenus = new JMenuBar ();

    myMenus.add(fileMenu);
    myMenus.add(helpMenu);
    
    setJMenuBar (myMenus);

    setSize (400, 400);
    setVisible (true);

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    quitItem.addActionListener(this);
  }

  public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand().equals("Quit"));
      dispose();
  }
}
