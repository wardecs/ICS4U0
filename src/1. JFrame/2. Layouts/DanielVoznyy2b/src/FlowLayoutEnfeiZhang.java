/**
 * The FlowLayoutEnfeiZhang class allows you to test multiple FlowLayout methods and demonstrates how to use it.
 *
 * <h2>Course Info</h2>
 * ICS4U0 with Krasteva V.
 *
 * @version 19.03.29
 * @author Enfei Zhang
 *
 * <b>Global Variables</b>
 * <p>
 * <b>layout</b> Creates an instance of the FlowLayout class.
 * <p>
 * <b>directionButton</b> Creates an instance of the JButton class called "Alignments".
 * <p>
 * <b>gapButton</b> Creates an instance of the JButton class called "gapbutton".
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlowLayoutEnfeiZhang extends JPanel implements ActionListener {

    private FlowLayout layout;
    private JButton directionButton, gapButton;

    /**
     * This is the constructor for the FlowLayoutEnfeiZhang class.
     */
    public FlowLayoutEnfeiZhang(){
        layout = new FlowLayout(FlowLayout.CENTER);
        setLayout(layout);

        directionButton = new JButton("Alignments");
        gapButton = new JButton("Change Gap");

        directionButton.addActionListener(this);
        gapButton.addActionListener(this);

        add(directionButton);
        add(gapButton);
    }

    /**
     * This is the method that will decide what will happen based on the action.
     * @param e is the action that is being performed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Alignments")){
            alignment();
        }
        else if (e.getActionCommand().equals("Change Gap")){
            changeGaps();
        }
        else if (e.getActionCommand().equals("Back")){
            removeAll();
            repaint();
            add(directionButton);
            add(gapButton);
        }
        else if (e.getActionCommand().equals("Right")){
            layout.setAlignment(FlowLayout.RIGHT);
        }
        else if (e.getActionCommand().equals("Left")){
            layout.setAlignment(FlowLayout.LEFT);
        }
        else if (e.getActionCommand().equals("Center")){
            layout.setAlignment(FlowLayout.CENTER);
        }
        else if (e.getActionCommand().equals("Trailing")){
            layout.setAlignment(FlowLayout.TRAILING);
        }
        else if (e.getActionCommand().equals("leading")){
            layout.setAlignment(FlowLayout.LEADING);
        }
        else if (e.getActionCommand().equals("VGap+")){
            layout.setVgap(layout.getVgap()+1);
        }
        else if (e.getActionCommand().equals("VGap-")){
            layout.setVgap(layout.getVgap()-1);
        }
        else if (e.getActionCommand().equals("HGap+")){
            layout.setHgap(layout.getHgap()+1);
        }
        else if (e.getActionCommand().equals("HGap-")){
            layout.setHgap(layout.getHgap()-1);
        }
        revalidate();
    }

    /**
     * This is the method that allows the user to choose how to align the screen.
     *
     * <b>Local Variables</b>
     * <p>
     * <b>backButton</b> This is an instance of the JButton class called "Back" that allows the user to go back to the previous screen.
     * <p>
     * <b>rightButton</b> This is an instance of the JButton class called "Right" that moves the items of the menu to the right.
     * <p>
     * <b>leftButton</b> This is an instance of the JButton class called "Left" that moves the items of the menu to the left.
     * <p>
     * <b>trialingButton</b> This is an instance of the JButton class called "Trailing" that sets the items of the menu to trailing.
     * <p>
     * <b>leadingButton</b> This is an instance of the JButton class called "Leading" that sets the items of the menu to trailing.
     * <p>
     * <b>centerButton</b> This is an instance of the JButton class called "Center" that sets the items of the menu to the center.
     * <p>
     * <b>message</b> This is an instance of the JLabel class that contains the instructions on what the buttons do.
     */
    private void alignment (){
        removeAll();
        JButton backButton = new JButton("Back");
        JButton rightButton = new JButton("Right");
        JButton leftButton = new JButton("Left");
        JButton trailingButton = new JButton("Trailing");
        JButton leadingButton = new JButton("Leading");
        JButton centerButton = new JButton("Center");

        backButton.addActionListener(this);
        rightButton.addActionListener(this);
        leftButton.addActionListener(this);
        trailingButton.addActionListener(this);
        leadingButton.addActionListener(this);
        centerButton.addActionListener(this);

        JLabel message = new JLabel("To align the buttons in a direction select one of the buttons.");

        add(backButton);
        add(rightButton);
        add(leftButton);
        add(trailingButton);
        add(leadingButton);
        add(centerButton);
        add(message);
    }

    /**
     * This is the method that allows the user to change the gaps of the screen
     *
     * <b>Local Variables</b>
     * <p>
     * <b>backButton</b> Creates an instance of the JButton class called "Back" that allows the user to go back to the previous screen.
     * <p>
     * <b>increaseVGap</b> Creates an instance of the JButton class called "VGap+" which allows the user to increase the vertical gap
     * <p>
     * <b>decreaseVGap</b> Creates an instance of the JButton class called "VGap-" which allows the user to decrease the vertical gap
     * <p>
     * <b>increaseHGap</b> Creates an instance of the JButton class called "HGap+" which allows the user to increase the horizontal gap
     * <p>
     * <b>decreaseHGap</b> Creates an instance of the JButton class called "HGap-" which allows the user to decrease the horizontal gap
     * <p>
     * <b>message</b> Creates an instance of the JLabel class containing a part of the instructions for the user
     * <p>
     * <b>messageP2</b> Creates an instance of the JLabel class containing the other part of the instructions for the user
     */
    private void changeGaps(){
        removeAll();
        JButton backButton = new JButton("Back");
        JButton increaseVGap = new JButton("VGap+");
        JButton decreaseVGap = new JButton("VGap-");
        JButton increaseHGap = new JButton("HGap+");
        JButton decreaseHGap = new JButton("HGap-");

        backButton.addActionListener(this);
        increaseVGap.addActionListener(this);
        decreaseVGap.addActionListener(this);
        increaseHGap.addActionListener(this);
        decreaseHGap.addActionListener(this);

        JLabel message = new JLabel("Increase, decrease or get the gap distance");
        JLabel messageP2 = new JLabel("by selecting one of the buttons.");

        add(backButton);
        add(increaseVGap);
        add(decreaseVGap);
        add(increaseHGap);
        add(decreaseHGap);
        add(message);
        add(messageP2);
    }
}