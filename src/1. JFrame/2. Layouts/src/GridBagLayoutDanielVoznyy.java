import javax.swing.*;
import java.awt.*;
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
public class GridBagLayoutDanielVoznyy extends JPanel {
    public GridBagLayoutDanielVoznyy() {
        setLayout(new GridBagLayout());
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.weightx = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 1;
        gbc.ipady = 20;


        JButton a = new JButton("A");
        add(a, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        JButton b = new JButton("B");
        add(b, gbc);

        gbc.gridx = 2;
        JButton d = new JButton("Add");
        add(d, gbc);

        JButton ee = new JButton("Add Down");
        d.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gbc.gridx = 3;
                gbc.gridy = 0;
                d.setText("Added");
                add(ee, gbc);
                d.removeActionListener(this); //stops someone from pressing the button and calling this method again
            }
        });

        ee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gbc.gridwidth = 4;
                gbc.weighty = 10;
                gbc.gridx = 0;
                gbc.ipady = 1;
                gbc.gridy++;
                ee.setText("Added " + gbc.gridy);
                add(new JButton("Button" + gbc.gridy), gbc);
            }
        });
    }
}
