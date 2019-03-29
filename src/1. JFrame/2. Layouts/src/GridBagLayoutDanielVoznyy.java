import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class showcases the powers of GirdBagLayout. It creates a top bar containing 3 buttons. The first two increase
 * and decrease the bar's height respectively, the third adds a fourth button which, when clicked, will add a button
 * under the top bar. There is no specified limit to how many buttons can be added.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @author Daniel Voznyy
 * @version 1 03.29.19
 */
public class GridBagLayoutDanielVoznyy extends JPanel implements ActionListener {
    GridBagLayout layout;
    GridBagConstraints gbc;
    JPanel topBar;

    /**
     * This constructor creates a JLabel and sets its layout to a new GirdBagLayout. It then creates a
     * GridBagConstraints object, 'gbc', and sets its fill to HORIZONTAL, anchor to NORTH, with some other constraints. It
     * creates a topBar JPanel, which follows these constraints. Next it adds an 'increaseHeight', 'decreaseHeight', and
     * 'addButton' button, changing the gridX parameter in 'gbc' by 1 as it adds the buttons to stack them horizontally.
     * It sets action listeners for all of these buttons. Then it creates a separate JPanel, 'buttons', into which
     * 'addDown' will later add buttons stacked vertically.
     */
    public GridBagLayoutDanielVoznyy() {
        setLayout(new GridBagLayout());
        layout = new GridBagLayout();
        setLayout(layout);

        topBar = new JPanel(new GridBagLayout());
        //define constraints
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.0001; //value cannot be 0 to set anchor to north, but large values cause unnecessary padding
        gbc.ipady = 0;
        add(topBar, gbc); //passing gbc while adding acts as adding and doing layout.setConstraints(component, gbc);


        JButton increaseHeight = new JButton("Click to Increase Height");
        //Contained inside topBar so we change the contents to fill up the entire space in the bar
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipady = 0;
        gbc.weighty = 1;
        topBar.add(increaseHeight, gbc);
        increaseHeight.addActionListener(this);


        JButton decreaseHeight = new JButton("Decrease Height");
        gbc.gridx = 1;
        topBar.add(decreaseHeight, gbc);
        decreaseHeight.addActionListener(this);


        JButton addButton = new JButton("Add");
        gbc.gridx = 2;
        topBar.add(addButton, gbc);
        JButton addDown = new JButton("Add Down");


        addButton.addActionListener(new ActionListener() {
            /**
             * Adds a fourth button to topBar when called, 'addDown' and grays out 'addButton'.
             *
             * @param e the action performed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                gbc.gridx = 3;
                gbc.gridy = 0;
                addButton.setText("Added");
                addButton.setEnabled(false);
                topBar.add(addDown, gbc);
                addButton.removeActionListener(this); //stops someone from pressing the button and calling this method again
            }
        });

        /*Separate JPanel for buttons so they do not affect size of top panel as items are added into what would
        otherwise be the JFrame*/
        gbc.gridx = 0;
        gbc.gridy = 1;
        JPanel buttons = new JPanel(new GridBagLayout());
        add(buttons, gbc);

        addDown.addActionListener(new ActionListener() {
            /**
             * Adds buttons stacked vertically into 'buttons'. It increments the gridy value of 'gbc' every time the
             * it is called to allow for this. It also sets the new button's name to gridy, and renames the current
             * button to 'Added: {gridy}'.
             *
             * @param e the action performed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                gbc.fill = GridBagConstraints.BOTH; //fill the entire space available
                gbc.gridwidth = 4;
                gbc.gridx = 0;
                gbc.gridy++;
                addDown.setText("Added " + gbc.gridy);
                buttons.add(new JButton("Button" + gbc.gridy), gbc);
                revalidate();
                repaint();
            }
        });
    }

    /**
     * Runs when a button is pressed. If the button's name contains 'Height', it will setup a new GridBagConstraints
     * object, then depending on whether the button contains 'Increase' or 'Decrease', it will add or remove padding
     * to the newly configured GridBagConstraints, then will apply these constraints to the topBar, effectively
     * changing its height.
     *
     * @param e the action performed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();
        if (name.contains("Height")) {
            //create a separate set of constraints so we do not affect buttons that are added later
            GridBagConstraints aConstraints = new GridBagConstraints();
            aConstraints.fill = GridBagConstraints.HORIZONTAL;
            aConstraints.anchor = GridBagConstraints.NORTH;
            aConstraints.gridx = 0;
            aConstraints.gridy = 0;
            aConstraints.weighty = 0.0001;
            aConstraints.ipady = layout.getConstraints(topBar).ipady;
            if (name.contains("Increase") && aConstraints.ipady < 50)
                aConstraints.ipady += 10;
            else if (name.contains("Decrease") && aConstraints.ipady > 5)
                aConstraints.ipady -= 10;

            //change constraint of topBar to change its padding
            layout.setConstraints(topBar, aConstraints);
            revalidate();
            repaint();
        }

    }
}
