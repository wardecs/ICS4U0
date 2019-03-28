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

        JPanel bothDaniel = new JPanel(new GridLayout(1, 2));
        bothDaniel.add(new GridBagLayoutDanielVoznyy());
        bothDaniel.add(new SpringLayoutDanielVoznyy());

        JPanel all = new JPanel(new BorderLayout());

        JPanel allSpring = new SpringLayoutDanielVoznyy();
        allSpring.setPreferredSize(new Dimension(100, 100));
        all.add(allSpring, BorderLayout.NORTH);

        JPanel allList = new JPanel(new GridLayout(4, 1));
        allList.add(new JLabel("GridBagLayout - Daniel"));
        allList.add(new JLabel("SpringLayout - Daniel"));
        allList.add(new JLabel("FlowLayout - Enfei"));
        allList.add(new JLabel("GroupLayout - Enfei"));
        allList.setPreferredSize(new Dimension(100, 100));
        all.add(allList, BorderLayout.CENTER);

        JPanel allGrid = new GridBagLayoutDanielVoznyy();
        allGrid.setPreferredSize(new Dimension(250, 100));
        all.add(allGrid, BorderLayout.WEST);

        JPanel allGroup = new GridBagLayoutDanielVoznyy();
        allGroup.setPreferredSize(new Dimension(250, 100));
        all.add(allGroup, BorderLayout.EAST);

        JPanel allFlow = new SpringLayoutDanielVoznyy();
        allFlow.setPreferredSize(new Dimension(100, 100)); //TODO set proper dimensions
        all.add(allFlow, BorderLayout.SOUTH);


        tabbedPane.addTab("Grid Bag Layout", gridBag);
        tabbedPane.addTab("Spring Layout", spring);
        tabbedPane.addTab("Both", bothDaniel);
        tabbedPane.addTab("All", all);

        add(tabbedPane, BorderLayout.CENTER);

        setMinimumSize(new Dimension(800, 800));
        setSize(800, 800);
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
