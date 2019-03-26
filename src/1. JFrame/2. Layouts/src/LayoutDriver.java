import javax.swing.*;
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
public class LayoutDriver {
    /**
     * Description of main(String [] args)
     * This method calls the layout's constructor to
     * create the application.
     *
     * @param args [ ]  String array that allows command line
     *             parameters to be used when executing the program.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new GridBagLayoutDanielVoznyy());

        //add menu items that will remove the current layout, then add their respective layout to the frame
        JMenuItem gridBag = new JMenuItem("GridBagLayout");
        gridBag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(new GridBagLayoutDanielVoznyy());
                frame.validate();
            }
        });

        JMenuItem spring = new JMenuItem("SpringLayout");
        spring.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(new SpringLayoutDanielVoznyy());
                frame.validate();
            }
        });

        JMenu layouts = new JMenu("Set Layout");
        layouts.add(gridBag);
        layouts.add(spring);

        JMenuBar menu = new JMenuBar();
        menu.add(layouts);

        frame.setJMenuBar(menu);

        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
