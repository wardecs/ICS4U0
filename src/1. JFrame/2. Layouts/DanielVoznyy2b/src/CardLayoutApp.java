import javax.swing.*;
import java.awt.*;

/**
 * <p>This class creates a JFrame which contains a JTabbedPane that will allow the user to tab between six cards</p>
 * <p>Card 1: The GridBagLayout</p>
 * <p>Card 2: The SpringLayout</p>
 * <p>Card 3: Both layouts on one page</p>
 * <p>Card 4: Enfei's FlowLayout</p>
 * <p>Card 5: Enfei's GroupLayout</p>
 * <p>Card 6: All four layouts arranged within a BorderLayout</p>
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @author Daniel Voznyy
 * @version 1 03.29.19
 */

public class CardLayoutApp extends JFrame {
    private JPanel cards;

    /**
     * Creates a JTabbedPane that will contain the 6 cards listed above. Creates a JPanel using a 1x2 GridLayout, adds
     * my two layouts to it to be used as card 2. Creates a JPanel using a Borderlayout, then adds my SpringLayout
     * NORTH, A list of the layouts and their creators in CENTER, GridBagLayout WEST, GroupLayout EAST, and FlowLayout
     * SOUTH, setting prefered sizes for each Layout so they can properly fit. Then adds cards to the JTabbedPane for
     * our four layouts, my combined two layouts, and the combination of all these layouts as explained above. Finally,
     * it sets a minimum window size and allows the window to properly close when the 'X' button is pressed.
     */
    public CardLayoutApp() {
        super("All the layouts");
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel bothDaniel = new JPanel(new GridLayout(1, 2));
        bothDaniel.add(new GridBagLayoutDanielVoznyy());
        bothDaniel.add(new SpringLayoutDanielVoznyy());

        JPanel all = new JPanel(new BorderLayout());

        JPanel allSpring = new SpringLayoutDanielVoznyy();
        allSpring.setPreferredSize(new Dimension(100, 250));
        all.add(allSpring, BorderLayout.NORTH);

        JPanel allList = new JPanel(new GridLayout(4, 1));
        allList.add(new JLabel("GridBagLayout - Daniel"));
        allList.add(new JLabel("SpringLayout - Daniel"));
        allList.add(new JLabel("FlowLayout - Enfei"));
        allList.add(new JLabel("GroupLayout - Enfei"));
        allList.setPreferredSize(new Dimension(0, 50));
        all.add(allList, BorderLayout.CENTER);

        JPanel allGrid = new GridBagLayoutDanielVoznyy();
        allGrid.setPreferredSize(new Dimension(400, 50));
        all.add(allGrid, BorderLayout.WEST);

        JPanel allGroup = new GroupLayoutEnfeiZhang();
        allGroup.setPreferredSize(new Dimension(250, 50));
        all.add(allGroup, BorderLayout.EAST);

        JPanel allFlow = new FlowLayoutEnfeiZhang();
        allFlow.setPreferredSize(new Dimension(100, 100)); //TODO set proper dimensions
        all.add(allFlow, BorderLayout.SOUTH);

        tabbedPane.addTab("Grid Bag Layout", new GridBagLayoutDanielVoznyy());
        tabbedPane.addTab("Spring Layout", new SpringLayoutDanielVoznyy());
        tabbedPane.addTab("Flow Layout", new FlowLayoutEnfeiZhang());
        tabbedPane.addTab("Group Layout", new GroupLayoutEnfeiZhang());
        tabbedPane.addTab("Both", bothDaniel);
        tabbedPane.addTab("All", all);

        add(tabbedPane, BorderLayout.CENTER);

        setMinimumSize(new Dimension(800, 800));
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method calls the layout's constructor to create the application.
     *
     * @param args [ ]  String array that allows command line parameters to be used when executing the program.
     */
    public static void main(String[] args) {
        new CardLayoutApp();
    }
}
