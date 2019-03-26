import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The JFrameTest class creates the application window,
 * menu bar, File and Help menus and the Quit and Help menu items. It then adds
 * the menu items to the File, then Help menus respectively, then both menus to the
 * menu bar. It also ensures that the window will close if the user
 * clicks the 'x' button.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @author Daniel Voznyy
 * @version 1 03.29.19
 */
public class SpringLayoutDanielVoznyy extends JPanel {
    /**
     * The class constructor passes a String title when it creates
     * the superclass object. It then creates the application window,
     * menu bar, two menus, one labelled "File", one labelled "Help,
     * two menu items, one labelled "Quit", one labelled "Help".
     * It then adds the Quit menu item to the File menu, the Help
     * item to the Help menu, and both menus to the menu bar.
     * It sets the size of the Frame to 400x400, and
     * ensures it will be visible. It also ensures that the
     * window will close if the user clicks the 'x' button,
     * and that pressing the Quit menu item will quite the program.
     */
    public SpringLayoutDanielVoznyy() {
        SpringLayout layout = new SpringLayout();
        setLayout(layout);

//        JPanel panel = new JPanel(new BorderLayout());
//        panel.setBackground(Color.black);

//        JButton north = new JButton("NORTH");
//        JButton west = new JButton("WEST");
//        JButton east = new JButton("EAST");
//        JButton south = new JButton("SOUTH");
//
//        panel.add(north, BorderLayout.NORTH);
//        panel.add(west, BorderLayout.WEST);
//        panel.add(east, BorderLayout.EAST);
//        panel.add(south, BorderLayout.SOUTH);
//
//        add(panel);

        JButton a = new JButton("A");
        JButton b = new JButton("B");

        add(a);
        add(b);

//        layout.putConstraint(SpringLayout.WEST, a, 6, SpringLayout.WEST, this);
//        layout.putConstraint(SpringLayout.NORTH, a, 6, SpringLayout.NORTH, this);
//        layout.putConstraint(SpringLayout.NORTH, b, 50, SpringLayout.NORTH, this);
//        layout.putConstraint(SpringLayout.EAST, b, 150, SpringLayout.EAST, this);

//        layout.putConstraint(SpringLayout.SOUTH, a, 6, SpringLayout.NORTH, b);
        layout.putConstraint(SpringLayout.NORTH, b, 6, SpringLayout.SOUTH, a);


//        layout.putConstraint(SpringLayout.EAST, getContentPane(), 6, SpringLayout.EAST, b);
//        layout.putConstraint(SpringLayout.SOUTH, getContentPane(), 6, SpringLayout.SOUTH, b);
    }
}
