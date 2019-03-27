import javax.swing.*;
import java.awt.*;

/**
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @author Daniel Voznyy
 * @version 1 03.29.19
 */

public class CardLayoutApp extends JFrame {
    private JPanel cards;

    public CardLayoutApp() {
        super("All the layouts");
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel gridBag = new GridBagLayoutDanielVoznyy();
        JPanel spring = new SpringLayoutDanielVoznyy();

        tabbedPane.addTab("Grid Bag Layout", gridBag);
        tabbedPane.addTab("Spring Layout", spring);

        add(tabbedPane, BorderLayout.CENTER);


        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        new CardLayoutApp();
    }
}
