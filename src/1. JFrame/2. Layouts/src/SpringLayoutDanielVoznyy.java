import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class showcases the powers of SpringLayout. It creates 4 anchor buttons and a group of 4 buttons to play with
 * constraints, the basis of SpringLayout. The 4 buttons are arranged in a grid, with the top two being buttons to add
 * or decrease the padding between the group's WEST side, and the Padding Anchor's EAST side. On the bottom right is a
 * text field, which allows users to choose an anchor they wish to create a NORTH - SOUTH constraint. Typing in an
 * invalid anchor name will show an error.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @author Daniel Voznyy
 * @version 1 03.29.19
 */
public class SpringLayoutDanielVoznyy extends JPanel implements ActionListener {
    int pad = 100;
    SpringLayout layout;
    JButton anchor;
    JPanel moveButtons;
    JTextField input;

    /**
     * This constructor creates a JLabel and sets its layout to a new SpringLayout. It then creates a Padding Anchor,
     * then a JPanel called 'moveButtons' with 3 buttons, and 1 text field arranged in a 2x2 GridLayout.
     * It also adds action listeners to the group's increase/decrease y padding buttons, and the 'Set X Constraint'
     * button. It then adds the 'moveButtons' JPanel to the main JPanel. Then, it puts an EAST-WEST constraint between
     * the 'moveButtons' and Padding Anchor. Lastly it adds three more Anchor buttons with varying constraints with the
     * main panel's walls.
     */
    public SpringLayoutDanielVoznyy() {
        layout = new SpringLayout();
        setLayout(layout);

        anchor = new JButton("Padding Anchor");
        add(anchor);

        //JPanel that contains buttons to play with constraints
        moveButtons = new JPanel(new GridLayout(2, 2));

        JButton increase = new JButton("Increase Y Padding");
        increase.addActionListener(this);

        JButton decrease = new JButton("Decrease Y Padding");
        decrease.addActionListener(this);

        input = new JTextField("Enter Anchor Name");

        JButton setAnchor = new JButton("Set X Constraint");
        setAnchor.addActionListener(this);

        moveButtons.add(decrease);
        moveButtons.add(increase);
        moveButtons.add(input);
        moveButtons.add(setAnchor);
        add(moveButtons);
        layout.putConstraint(SpringLayout.WEST, moveButtons, pad, SpringLayout.EAST, anchor);

        //more anchors
        JButton anchor2 = new JButton("Anchor2");
        layout.putConstraint(SpringLayout.NORTH, anchor2, 100, SpringLayout.NORTH, this);
        add(anchor2);

        JButton anchor3 = new JButton("Anchor3");
        layout.putConstraint(SpringLayout.NORTH, anchor3, 150, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, anchor3, 150, SpringLayout.WEST, this);
        add(anchor3);

        JButton anchor4 = new JButton("Anchor4");
        layout.putConstraint(SpringLayout.NORTH, anchor4, 150, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, anchor4, 0, SpringLayout.EAST, this);
        add(anchor4);
    }

    /**
     * <p>Runs when a button is pressed. If the button's name is 'Set X Constraint', it will go through all components in
     * the JPanel, and see if any buttons match by name to the user's input in the input box. If not, an error message
     * is displayed inside the box.</p>
     * <p>Additionally, if the button's name contains 'Padding' it will increase or decrease the padding between the
     * 'moveButtons' JPanel and the Padding Anchor.</p>
     *
     * @param e the action performed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();
        if (name.equals("Set X Constraint")) {
            if (input.getText().equals("Enter Anchor Name")) //if user has not typed anything
                return;
            boolean succeccfullyAnchored = false;
            for (Component component : getComponents()) { //go through every component
                if (component instanceof JButton) { //check if the object is a button
                    if (((JButton) component).getText().equals(input.getText())) { //if the button's text matches user's input
                        layout.putConstraint(SpringLayout.NORTH, moveButtons, 0, SpringLayout.SOUTH, component);
                        succeccfullyAnchored = true; //would be easier to return here but putConstraints doesn't like it
                        break;
                    }
                }
            }
            if (!succeccfullyAnchored)
                input.setText("Anchor not found");
        } else if (name.contains("Padding")) {
            if (name.contains("Increase"))
                pad += 50;
            else if (name.contains("Decrease") && pad > 0)
                pad -= 50;
            layout.putConstraint(SpringLayout.WEST, moveButtons, pad, SpringLayout.EAST, anchor);
        }
        revalidate();
        repaint();
    }
}
