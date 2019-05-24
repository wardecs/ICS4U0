import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a JFrame which contains the GridBagLayout, and a menu that lets the user switch between it and my
 * SpringLayout.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @author Daniel Voznyy
 * @version 1 03.29.19
 */
public class LayoutApp extends JFrame implements ActionListener {

    /**
     * Creates a new JFrame, and adds my GridBagLayout to it. Creates two JMenuItems with ActionListeners attached to
     * them, which will switch the frame's contents to their specified layout. Then it adds a JMenu called 'Set Layout',
     * and adds the two JMenuItems to it. Then it creates a JMenuBar, adds the menu to it, and adds it to the JFrame.
     * Finally, it sets a minimum window size and allows the window to properly close when the 'X' button is pressed.
     */
    public LayoutApp() {
        super("Layouts");
        add(new GridBagLayoutDanielVoznyy());

        //add menu items that will remove the current layout, then add their respective layout to the frame
        JMenuItem gridBag = new JMenuItem("GridBagLayout");
        gridBag.addActionListener(this);

        JMenuItem spring = new JMenuItem("SpringLayout");
        spring.addActionListener(this);

        JMenu layouts = new JMenu("Set Layout");
        layouts.add(gridBag);
        layouts.add(spring);

        JMenuBar menu = new JMenuBar();
        menu.add(layouts);

        setJMenuBar(menu);

        setMinimumSize(new Dimension(900, 900));
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method calls the layout's constructor to create the application.
     *
     * @param args [ ]  String array that allows command line parameters to be used when executing the program.
     */
    public static void main(String[] args) {
        new LayoutApp();
    }

    /**
     * Runs when a button is pressed. If the button's name contains 'Layout', it removes all content in the Content
     * Pane, then proceeds to check which layout the button is referring to, and adds a new layout accordingly. Finally,
     * it validates the frame to allow the buttons to be clickable again.
     *
     * @param e the action performed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();
        if (name.contains("Layout")) {
            getContentPane().removeAll();
            if (name.equals("GridBagLayout"))
                add(new GridBagLayoutDanielVoznyy());
            else if (name.equals("SpringLayout"))
                add(new SpringLayoutDanielVoznyy());
            validate();
        }
    }
}
