/**
 * The GroupLayoutEnfeiZhang demonstrates how the GroupLayout works with some examples that allow you to use the methods.
 *
 * <h2>Course Info</h2>
 * ICS4U0 with Krasteva V.
 *
 * @version 19.03.29
 * @author Enfei Zhang
 *
 * <b>Global Variables</b>
 * <p>
 * <b>layout</b> Creates an instance of the GroupLayout class.
 * <p>
 * <b>setGroup</b> Creates an instance of the JButton class called "Set Group".
 * <p>
 * <b>addGaps</b> Creates an instance of the JButton class called "Add Gaps".
 * <p>
 * <b>replaceMe</b> Creates an instance of the JButton class called "Replace Me"
 * <p>
 * <b>backButton</b> Creates an instance of the JButton class called "Back".
 * <p>
 * <b>parallel</b> Creates an instance of the JButton class called "Horizontal Parallel".
 * <p>
 * <b>sequential</b> Creates an instance of the JButton class called "Vertical Sequential".
 * <p>
 * <b>horizontal</b> Creates an instance of the JButton class called "Horizontal Sequential"
 * <p>
 * <b>vertical</b> Creates an instance of the JButton class called "Vertical Parallel".
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GroupLayoutEnfeiZhang extends JPanel implements ActionListener {

    private GroupLayout layout;
    private JButton setGroup, addGaps, replaceMe, backButton, parallel, sequential, horizontal, vertical;

    /**
     * This is the constructor for the GroupLayoutEnfeiZhang class.
     */
    public GroupLayoutEnfeiZhang(){
        layout = new GroupLayout(this);
        setLayout(layout);

        setGroup = new JButton("Set Group");
        addGaps = new JButton("Add Gaps");
        replaceMe = new JButton("Replace Me");

        layout.setHorizontalGroup(layout.createParallelGroup().addComponent(replaceMe).addComponent(setGroup).addComponent(addGaps));
        layout.setVerticalGroup(layout.createSequentialGroup().addComponent(replaceMe).addComponent(setGroup).addComponent(addGaps));

        setGroup.addActionListener(this);
        addGaps.addActionListener(this);
        replaceMe.addActionListener(this);

        add(setGroup);
        add(addGaps);
        add(replaceMe);
    }

    /**
     * This is the method that checks what to do based on the action performed.
     * @param e is the action that is being performed.
     */
    @Override
    public void actionPerformed (ActionEvent e){
        if (e.getActionCommand().equals("Set Group")){
            setGroup();
        }
        else if (e.getActionCommand().equals("Add Gaps")){
            if (!layout.getAutoCreateGaps())
                layout.setAutoCreateGaps(true);
            else
                layout.setAutoCreateGaps(false);
        }
        else if (e.getActionCommand().equals("Replace Me")) {
            JLabel message = new JLabel("Goodbye");
            layout.replace(replaceMe, message);
        }
        else if (e.getActionCommand().equals("Back")){
            removeAll();
            repaint();
            layout.setHorizontalGroup(layout.createParallelGroup().addComponent(replaceMe).addComponent(setGroup).addComponent(addGaps));
            layout.setVerticalGroup(layout.createSequentialGroup().addComponent(replaceMe).addComponent(setGroup).addComponent(addGaps));
        }
        else if ((e.getActionCommand().equals("Horizontal Parallel"))){
            layout.setHorizontalGroup(layout.createParallelGroup().addComponent(backButton).addComponent(parallel).addComponent(sequential).addComponent(horizontal).addComponent(vertical));
        }
        else if ((e.getActionCommand().equals("Vertical Sequential"))){
            layout.setVerticalGroup(layout.createSequentialGroup().addComponent(backButton).addComponent(parallel).addComponent(sequential).addComponent(horizontal).addComponent(vertical));
        }
        else if ((e.getActionCommand().equals("Horizontal Sequential"))){
            layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(backButton).addComponent(parallel).addComponent(sequential).addComponent(horizontal).addComponent(vertical));
        }
        else if ((e.getActionCommand().equals("Vertical Parallel"))){
            layout.setVerticalGroup(layout.createParallelGroup().addComponent(backButton).addComponent(parallel).addComponent(sequential).addComponent(horizontal).addComponent(vertical));
        }
        revalidate();
    }

    /**
     * This is the method that adds all the buttons for the different groups that can be made.
     *
     * <b>Local Variables</b>
     * <p>
     * <b>message</b> This creates an instance of the JLabel class, that explains what to do.
     */
    private void setGroup(){
        backButton = new JButton( ("Back"));
        parallel = new JButton("Horizontal Parallel");
        sequential = new JButton("Vertical Sequential");
        horizontal = new JButton("Horizontal Sequential");
        vertical = new JButton("Vertical Parallel");

        layout.setHorizontalGroup(layout.createParallelGroup().addComponent(backButton).addComponent(parallel).addComponent(sequential).addComponent(horizontal).addComponent(vertical));
        layout.setVerticalGroup(layout.createSequentialGroup().addComponent(backButton).addComponent(parallel).addComponent(sequential).addComponent(horizontal).addComponent(vertical));

        removeAll();
        repaint();

        backButton.addActionListener(this);
        parallel.addActionListener(this);
        sequential.addActionListener(this);
        horizontal.addActionListener(this);
        vertical.addActionListener(this);

        JLabel message = new JLabel("Select the group by pressing the button corresponding with it");

        add(backButton);
        add(parallel);
        add(sequential);
        add(horizontal);
        add(vertical);
        add(message);
    }
}