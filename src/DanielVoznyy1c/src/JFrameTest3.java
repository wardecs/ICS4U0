import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The JFrameTest3 class creates the application window,
 * TextTest object, menu bar, File and Help menus, and the Quit, Help,
 * and About menu items. The TextTest object contains the contents
 * of this window, and allows a user to calculate the square of a number.
 * It then adds the Quit item to the File menu, then the Help and About items in the
 * Help menu, then both menus to the menu bar. Help and About show a dialog box
 * when clicked, which contains a button that closes them. About shows a message
 * about me.
 * It also ensures that the window will close if the user clicks the 'x' button.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @author Daniel Voznyy
 * @version 1 03.20.19
 */
public class JFrameTest3 extends JFrame implements ActionListener {
    /**
     * The class constructor passes a String title when it creates
     * the superclass object. It then creates the application window, TextTest object
     * menu bar, two menus, one labelled "File", one labelled "Help,
     * three menu items, one labelled "Quit", one "Help", one "About".
     * It then adds the Quit menu item to the File menu, the Help and About
     * items to the Help menu, and both menus to the menu bar.
     * It sets the size of the Frame to 400x400, and ensures it will be visible.
     * It shows dialog boxes when Help or About is clicked,
     * which close when the button inside them is pressed. It also ensures that the
     * window will close if the user clicks the 'x' button,
     * and that pressing the Quit menu item will quite the program.
     */
    public JFrameTest3() {
        super("JFrame Test");
        TextTest t = new TextTest();
        add(t);

        JMenuItem quitItem = new JMenuItem("Quit");
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(quitItem);

        JMenuItem helpItem = new JMenuItem("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        JMenu helpMenu = new JMenu("Help");
        helpMenu.add(helpItem);
        helpMenu.add(aboutItem);

        JMenuBar myMenus = new JMenuBar();

        myMenus.add(fileMenu);
        myMenus.add(helpMenu);

        setJMenuBar(myMenus);


        setSize(400, 400);
        setVisible(true);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        helpItem.addActionListener(this);
        aboutItem.addActionListener(this);
        quitItem.addActionListener(this);
    }

    /**
     * Called when Help is clicked.
     * Closes when button inside is pressed.
     */
    public void helpDialog() {
        JDialog myDialog = new JDialog(this, "Help me");
        myDialog.setSize(100, 100);
        myDialog.setResizable(false);
        myDialog.setLayout(new FlowLayout());

        JLabel label = new JLabel("Help me!");

        JButton close = new JButton("Close");
        close.addActionListener(new ActionListener() {
            /**
             * Action event listener that closes dialog when the button is pressed.
             *
             * @param e The action event performed.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                myDialog.dispose();
            }
        });

        myDialog.add(label);
        myDialog.add(close);

        myDialog.setLocationRelativeTo(this);
        myDialog.setVisible(true);
    }

    /**
     * Called when About is clicked, creates a window containing info about me.
     * Closes when button inside is pressed.
     */
    public void aboutDialog() {
        JDialog myDialog = new JDialog(this, "About me");
        myDialog.setSize(650, 100);
        myDialog.setResizable(false);
        myDialog.setLayout(new FlowLayout());

        JLabel label = new JLabel("I did a competition where I made a game in 3 days last summer. I hadn't worked that much until MyCreation");


        JButton close = new JButton("Close");
        close.addActionListener(new ActionListener() {
            /**
             * Action event listener that closes dialog when the button is pressed.
             *
             * @param e The action event performed.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                myDialog.dispose();
            }
        });

        myDialog.add(label);
        myDialog.add(close);

        myDialog.setLocationRelativeTo(this);
        myDialog.setVisible(true);
    }

    /**
     * Action event listener for each menu item.
     *
     * @param ae The action event performed.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Quit"))
            dispose();
        else if (ae.getActionCommand().equals("Help"))
            helpDialog();
        else if (ae.getActionCommand().equals("About"))
            aboutDialog();
    }
}
