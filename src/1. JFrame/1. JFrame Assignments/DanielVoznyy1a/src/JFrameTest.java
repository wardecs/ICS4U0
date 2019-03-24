import javax.swing.*;

/**
 * The JFrameTest class creates the application window,
 * menu bar, File and Help menus and the Quit and Help menu items. It then adds
 * the menu items to the File, then Help menus respectively, then both menus to the
 * menu bar. It also ensures that the window will close if the user clicks the 'x' button.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @version 1 03.20.19
 * @author Daniel Voznyy
 */
public class JFrameTest extends JFrame {
    /**
     * The class constructor passes a String title when it creates
     * the superclass object. It then creates the application window,
     * menu bar, two menus, one labelled "File", one labelled "Help,
     * two menu items, one labelled "Quit", one labelled "Help".
     * It then adds the Quit menu item to the File menu, the Help
     * item to the Help menu, and both menus to the menu bar.
     * It sets the size of the Frame to 400x400, and
     * ensures it will be visible. It also ensures that the window
     * will close if the user clicks the 'x' button.
     */
    public JFrameTest() {
        super("JFrame Test");
        int test = 0;
        JMenuItem quitItem = new JMenuItem("Quit");
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(quitItem);

        JMenuItem helpItem = new JMenuItem("Help");
        JMenu helpMenu = new JMenu("Help");
        helpMenu.add(helpItem);

        JMenuBar myMenus = new JMenuBar();

        myMenus.add(fileMenu);
        myMenus.add(helpMenu);

        setJMenuBar(myMenus);

        setSize(400, 400);
        setVisible(true);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
