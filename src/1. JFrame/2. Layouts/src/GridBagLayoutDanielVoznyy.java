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
public class GridBagLayoutDanielVoznyy extends JPanel {
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
    public GridBagLayoutDanielVoznyy() {
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 0;

        JButton a = new JButton("A");
        add(a, c);


        c.weightx = 0.5;
        c.gridx = 1;
        JButton b = new JButton("B");
        add(b, c);

        c.gridx = 2;
        JButton d = new JButton("Add");
        add(d, c);

        JButton ee = new JButton("E");
        d.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                c.ipady = 40;      //make this component tall
//                c.weightx = 0.0;
//                c.gridwidth = 3;
                c.gridx = 3;
                c.gridy = 0;
                d.setText("Added");
                add(ee, c);
            }
        });
    }
}
