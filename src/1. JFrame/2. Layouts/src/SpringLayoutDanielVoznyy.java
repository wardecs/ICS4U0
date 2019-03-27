import javax.swing.*;

/**
 *
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @author Daniel Voznyy
 * @version 1 03.29.19
 */
public class SpringLayoutDanielVoznyy extends JPanel {
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
