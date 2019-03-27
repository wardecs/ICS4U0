import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @author Daniel Voznyy
 * @version 1 03.29.19
 */
public class LayoutApp extends JFrame {

    public LayoutApp() {
        super("Layouts");
        add(new GridBagLayoutDanielVoznyy());

        //add menu items that will remove the current layout, then add their respective layout to the frame
        JMenuItem gridBag = new JMenuItem("GridBagLayout");
        gridBag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                add(new GridBagLayoutDanielVoznyy());
                validate();
            }
        });

        JMenuItem spring = new JMenuItem("SpringLayout");
        spring.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                add(new SpringLayoutDanielVoznyy());
                validate();
            }
        });

        JMenu layouts = new JMenu("Set Layout");
        layouts.add(gridBag);
        layouts.add(spring);

        JMenuBar menu = new JMenuBar();
        menu.add(layouts);

        setJMenuBar(menu);

        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * Description of main(String [] args)
     * This method calls the layout's constructor to
     * create the application.
     *
     * @param args [ ]  String array that allows command line
     *             parameters to be used when executing the program.
     */
    public static void main(String[] args) {
        new LayoutApp();
    }
}
